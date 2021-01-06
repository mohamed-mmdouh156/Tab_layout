package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ImageView image1 ;
    TextView text1 ;
    Button button1 ;

    final static public int Rc = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.image1);
        text1 = findViewById(R.id.text1);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_end = new Intent(MainActivity.this , third.class);
                to_end.putExtra("image_one" , R.drawable.facebook);
                to_end.putExtra("text_main" , text1.getText().toString());
                setResult(1);
                startActivity(to_end);
            }
        });

    }
}



