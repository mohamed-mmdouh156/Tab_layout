package com.example.error_section1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   private Button login , sign ;
   private EditText username , password ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username_et);
        password = findViewById(R.id.password_et);
        login = findViewById(R.id.login_btn);
        sign = findViewById(R.id.sign_btn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = login.getText().toString();

                Intent to_second = new Intent(MainActivity.this , Second.class);

                to_second.putExtra("name" , name);

                startActivity(to_second);
            }
        });


    }
}