package com.example.ieee_task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class second extends AppCompatActivity {

    TextView tv1 , tv2 ,tv3 ,tv4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        id();

        Bundle get_data = getIntent().getExtras();

        String text1 = get_data.getString("t1");
        String text2 = get_data.getString("t2");
        String text3 = get_data.getString("t3");
        String text4 = get_data.getString("t4");

        tv1.setText(text1);
        tv2.setText(text2);
        tv3.setText(text3);
        tv4.setText(text4);


    }

    private void id()
    {

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);

    }
}