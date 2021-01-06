package com.example.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class third extends AppCompatActivity {

    ImageView image3 ;
    TextView text3 ;
    Button button3 ;
    final static public  int MAIN = 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        image3 = findViewById(R.id.image3);
        text3 = findViewById(R.id.text3);
        button3 = findViewById(R.id.button3);

       Intent back = new Intent();









    }
}