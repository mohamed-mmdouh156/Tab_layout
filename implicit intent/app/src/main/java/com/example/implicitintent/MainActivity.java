package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

EditText phone ;
Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.phone_et);
        call = findViewById(R.id.call_btn);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = phone.getText().toString();

                Intent call_intent = new Intent();

                call_intent.setAction(call_intent.ACTION_DIAL);

                Uri uri = Uri.parse("tel:"+number);
                call_intent.setData(uri);

                startActivity(call_intent);
            }
        });


    }
}