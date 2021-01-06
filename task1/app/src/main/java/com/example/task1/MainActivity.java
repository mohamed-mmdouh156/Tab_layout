package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView image ;
    TextView text1 , text2 , text3 , text4 , text5 , text6 , text7 ,text8 ;
    Button served;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id();

        served.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast t = Toast.makeText(getApplicationContext() ,"Served Saved" ,Toast.LENGTH_LONG);

                t.setGravity(Gravity.BOTTOM |Gravity.RIGHT,0 , 0);
                t.show();

            }
        });

    }

    public void id ()
    {
        image = findViewById(R.id.imageView2);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);
        text7 = findViewById(R.id.text7);
        text8 = findViewById(R.id.text8);
        served = findViewById(R.id.bottom);
    }
}