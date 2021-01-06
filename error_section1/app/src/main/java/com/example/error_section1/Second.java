package com.example.error_section1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    TextView username ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        username = findViewById(R.id.textView);


        Intent data = getIntent();

        String user_data =  data.getStringExtra("name");

        username.setText(user_data);
    }
}