package com.example.simplechat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    Button Login , Register;

    FirebaseUser firebaseUser;


    @Override
    protected void onStart() {
        super.onStart();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        // Check if user is not exist in firebase or not have account
        if (firebaseUser != null)
        {
            Intent to_home = new Intent(StartActivity.this , MainActivity.class);
            startActivity(to_home);
            finish();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Login = findViewById(R.id.start_Login_btn);
        Register = findViewById(R.id.start_register_btn);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent to_login = new Intent(StartActivity.this , LoginActivity.class);
                startActivity(to_login);

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent to_register = new Intent(StartActivity.this , RegisterActivity.class);
                startActivity(to_register);

            }
        });


    }
}