package com.example.implicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class rect_activity extends AppCompatActivity {
    EditText length , width ;
    Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect_activity);

        length = findViewById(R.id.rect_length_et);
        width = findViewById(R.id.rect_width_et);
        calculate = findViewById(R.id.rect_calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double l = Double.parseDouble(length.getText().toString());
                double w = Double.parseDouble(width.getText().toString());

                double area = l * w ;

                Intent r_intent = new Intent();
                r_intent.putExtra("rect_area" , area);
                setResult(1 ,r_intent);
                finish();

            }
        });
    }
}