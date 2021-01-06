package com.example.ieee_task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text1 , text2 ,text3 ,text4 ;
    Button send , call ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent(MainActivity.this , second.class);

                data.putExtra("t1",text1.getText().toString());
                data.putExtra("t2",text2.getText().toString());
                data.putExtra("t3",text3.getText().toString());
                data.putExtra("t4",text4.getText().toString());

                startActivity(data);

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent to_call = new Intent(MainActivity.this , call.class);
                startActivity(to_call);
            }
        });


    }

    private  void id()
    {
        text1 = findViewById(R.id.edit1);
        text2 = findViewById(R.id.edit2);
        text3 = findViewById(R.id.edit3);
        text4 = findViewById(R.id.edit4);
        send = findViewById(R.id.send_btn);
        call = findViewById(R.id.call_btn);
    }
}