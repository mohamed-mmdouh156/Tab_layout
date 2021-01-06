package com.example.review11_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class Call extends AppCompatActivity {

   private EditText phone_number ;
   private Button call ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        phone_number = findViewById(R.id.phone_et);
        call = findViewById(R.id.call_btn);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = phone_number.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:"+number);
                intent.setData(uri);
                startActivity(intent);

            }
        });


    }
}