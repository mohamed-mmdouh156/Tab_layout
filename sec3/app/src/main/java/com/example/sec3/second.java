package com.example.sec3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class second extends AppCompatActivity {
    TextView tv1 , tv2 , tv3 , tv4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        id();
        action();

    }

    private void id ()
    {
        tv1= findViewById(R.id.textView);
        tv2= findViewById(R.id.textView2);
        tv3= findViewById(R.id.textView3);
        tv4= findViewById(R.id.textView4);
    }

    private void action()
    {
        Intent intent = getIntent();
        String  t1 = intent.getStringExtra("text1");
        String  t2 =intent.getStringExtra("text2");
        String  t3 =  intent.getStringExtra("text3");
        String  t4 = intent.getStringExtra("text4");

        tv1.setText(t1);
        tv2.setText(t2);
        tv3.setText(t3);
        tv4.setText(t4);
        startActivity(intent);

    }
}