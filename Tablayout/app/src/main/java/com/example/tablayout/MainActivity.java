package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tablayout.fragments.FirstFragment;
import com.example.tablayout.fragments.SecondFragment;
import com.example.tablayout.fragments.ThridFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout ;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tab Layout");

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.AddFragment(new FirstFragment() , "Tab1");
        viewPagerAdapter.AddFragment(new SecondFragment() , "Tab2");
        viewPagerAdapter.AddFragment(new ThridFragment(), "Tab3");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu , menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.menu_item1 :
                Toast.makeText(getBaseContext() ,"Item1",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_item2 :
                Toast.makeText(getBaseContext() ,"Item2",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_item3 :
                Toast.makeText(getBaseContext() ,"Item3",Toast.LENGTH_SHORT).show();
                return true;

        }


        return false;
    }
}