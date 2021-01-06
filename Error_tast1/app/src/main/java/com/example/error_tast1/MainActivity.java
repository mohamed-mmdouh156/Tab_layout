package com.example.error_tast1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button go ;
    private EditText mail , pass;
    private AlertDialog.Builder alertdailog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go = findViewById(R.id.login_btn);
        mail = findViewById(R.id.email_et);
        pass = findViewById(R.id.password_et);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertdailog = new AlertDialog.Builder(MainActivity.this);
                alertdailog.setTitle("confirmation");
                alertdailog.setMessage("do you need leave login page.?");
                alertdailog.setCancelable(false);

                alertdailog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String email = mail.getText().toString();
                        String password = pass.getText().toString();



                        Intent to_second = new Intent(MainActivity.this, second.class);
                        startActivity(to_second);

                        if(email == "" && password == "")
                        {
                            Toast.makeText(getApplicationContext() ,"email or password Incorrect" , Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertdailog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = alertdailog.create();
                dialog.show();



            }
        });
    }
}