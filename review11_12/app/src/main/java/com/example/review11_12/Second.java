package com.example.review11_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    CheckBox box1 , box2 , box3 , box4;
    Button ok ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        box1 = findViewById(R.id.item1_cb);
        box2 = findViewById(R.id.item2_cb);
        box3 = findViewById(R.id.item3_cb);
        box4 = findViewById(R.id.item4_cb);
        ok = findViewById(R.id.ok_btn);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder builder = new StringBuilder();

                if (box1.isChecked())
                {
                    builder.append(box1.getText().toString() + "\n");
                }
                if (box2.isChecked())
                {
                    builder.append(box2.getText().toString() + "\n");
                }
                if (box3.isChecked())
                {
                    builder.append(box3.getText().toString() + "\n");
                }
                if (box4.isChecked()) {
                    builder.append(box4.getText().toString() + "\n");
                }

                String result = builder.toString() ;


                Intent to_main = new Intent(Second.this , MainActivity.class);
                to_main.putExtra("check_box" ,result);
                startActivity(to_main);

            }
        });


    }
}