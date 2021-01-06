package com.example.ieee_task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class start_screen extends AppCompatActivity {

    Button go ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        go = findViewById(R.id.go_btn);

        Intent to_main = new Intent(start_screen.this , MainActivity.class);
        startActivity(to_main);

    }
}