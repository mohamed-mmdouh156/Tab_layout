package com.example.task3_inception;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class navigation_drawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


         drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow ,R.id.share_item , R.id.send_item)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
/*
        switch (item.getItemId())
        {
            case R.id.share_item:
                Toast.makeText(getApplicationContext(),"Share Item" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.send_item:
                Toast.makeText(getApplicationContext(),"Send Item" , Toast.LENGTH_LONG).show();
                return true;

        }
*/

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus , menu);

        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.item1 :
                Toast.makeText(this, "Call" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.item2 :
                Toast.makeText(this , "item2" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.item3 :
                Toast.makeText(this , "item3" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.sub_item1 :
                Toast.makeText(this, "sub item1" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.sub_item2 :
                Toast.makeText(this , "sub item2" , Toast.LENGTH_LONG).show();
                return true;
        }

        return false ;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}