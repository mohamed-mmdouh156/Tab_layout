package com.example.simplechat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.simplechat.fragments.ChatsFragment;
import com.example.simplechat.fragments.UserFragment;
import com.example.simplechat.model.User;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    CircleImageView profile_image;
    TextView username ;
    ViewPager viewPager;
    TabLayout tabLayout;


    FirebaseUser firebaseUser ;
    DatabaseReference databaseReference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        profile_image = findViewById(R.id.home_profile_image);
        username = findViewById(R.id.home_username);
        tabLayout = findViewById(R.id.home_tab_layout);
        viewPager = findViewById(R.id.home_view_pager);


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);

                username.setText(user.getUsername());

                String imageURL = user.getImageURL();

                if(imageURL.equals("default"))
                {
                    profile_image.setImageResource(R.mipmap.ic_launcher);
                }
                else {
                    Glide.with(MainActivity.this).load(user.getImageURL()).into(profile_image);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new ChatsFragment() , "Chats");
        viewPagerAdapter.addFragment(new UserFragment() , "Users");


        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu , menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_logout_item : {
                /*
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, StartActivity.class));
                finish();
                return true;

                 */

                Toast.makeText(MainActivity.this ,"logout",Toast.LENGTH_SHORT).show();
            }
        }

        return false;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        private ArrayList <Fragment> fragments ;
        private ArrayList <String> titles ;

        ViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
            this.fragments = new ArrayList<>();
            this.titles = new ArrayList<>();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragment(Fragment fragment , String title)
        {
            fragments.add(fragment);
            titles.add(title);

        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

    }



}