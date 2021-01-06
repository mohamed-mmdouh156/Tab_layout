package com.example.option_menu;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu ,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId())
       {
           case R.id.hello :
               Toast.makeText(getApplicationContext() ,"Hello" , Toast.LENGTH_SHORT).show();
               return true;

           case R.id.finish :
               Toast.makeText(getApplicationContext() ,"finish" , Toast.LENGTH_SHORT).show();
               return true;

       }
       return false;
    }
}
