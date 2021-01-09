package com.example.simplechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    MaterialEditText Username , Email , Password ;
    Button Register ;

    FirebaseAuth auth ;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Username = findViewById(R.id.register_username);
        Email = findViewById(R.id.register_email);
        Password = findViewById(R.id.register_password);
        Register = findViewById(R.id.register_register_btn);

        auth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username_txt = Username.getText().toString();
                String email_txt = Email.getText().toString();
                String password_txt = Password.getText().toString();

                if(TextUtils.isEmpty(username_txt) || TextUtils.isEmpty(email_txt)  || TextUtils.isEmpty(password_txt) )
                {
                    Toast.makeText(RegisterActivity.this, "All fields required" ,Toast.LENGTH_LONG).show();
                }
                else if(password_txt.length() < 6)
                {
                    Toast.makeText(RegisterActivity.this, "password must be at least 6 character" ,Toast.LENGTH_SHORT).show();
                }
                else
                {
                    register(username_txt , email_txt , password_txt);
                }

            }
        });



    }


    private void register(final String username , final String email , final String password)
    {
        auth.createUserWithEmailAndPassword(email ,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            assert firebaseUser != null;
                            String userid = firebaseUser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                            HashMap<String , String> hashMap = new HashMap<>();

                            hashMap.put("userid" , userid);
                            hashMap.put("username" , username);
                            hashMap.put("email" , email);
                            hashMap.put("imageURL" ,"default");


                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Intent intent = new Intent(RegisterActivity.this , MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "you can't register with this email or password" ,Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }



}