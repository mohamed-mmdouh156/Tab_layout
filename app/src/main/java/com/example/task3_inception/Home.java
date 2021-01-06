package com.example.task3_inception;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    Button next ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        next = findViewById(R.id.next_btn);

       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent to_navigation = new Intent(Home.this , navigation_drawer.class);
               startActivity(to_navigation);
           }
       });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus , menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {

          case R.id.item1 :
               Toast.makeText(getApplicationContext() , "Call Item" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.item2 :
                Toast.makeText(getApplicationContext() , "item2" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.item3 :
                Toast.makeText(getApplicationContext() , "item3" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.sub_item1 :
                Toast.makeText(getApplicationContext() , "sub item1" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.sub_item2 :
                Toast.makeText(getApplicationContext() , "sub item2" , Toast.LENGTH_LONG).show();
                return true;


        }
        return false ;
    }
}