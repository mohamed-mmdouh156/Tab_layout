package com.example.implicitintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_result extends AppCompatActivity {

Button tri;
Button rect;
EditText result;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);
        tri = findViewById(R.id.triangle);
        rect = findViewById(R.id.rectangle);
        result = findViewById(R.id.result_tv);

        tri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tri_intent = new Intent(getBaseContext() , tri_activity.class);
                startActivityForResult(tri_intent , 1);
            }
        });

        rect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rect_intent = new Intent(getBaseContext() , rect_activity.class);
                startActivityForResult(rect_intent , 2);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1)
        {
            double area = data.getDoubleExtra("rect_area" , 0);
            result.setText(area +"\n");
        }

    }
}