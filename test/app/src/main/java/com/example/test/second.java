package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class second extends AppCompatActivity {

    ImageView image2 ;
    TextView text2 ;
    Button button2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        image2 = findViewById(R.id.image2);
        text2 = findViewById(R.id.text2);
        button2 = findViewById(R.id.button2);
    }
}