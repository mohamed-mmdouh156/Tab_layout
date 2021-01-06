package com.example.review11_12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button next;
    TextView radio_output;
    RadioGroup r_g ;
    RadioButton r_button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = findViewById(R.id.next_btn);
        radio_output = findViewById(R.id.output_tv);
        r_g = findViewById(R.id.radioGroup);



        Bundle extras = getIntent().getExtras();
        final String result = extras.getString("check_box");

        r_g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                r_button = findViewById(checkedId);

                switch (r_button.getId())
                {
                    case R.id.item1_rb :
                        radio_output.setText("Item1 \n" + result);
                        break;

                    case R.id.item2_rb:
                        radio_output.setText("Item2 \n" + result);
                        break;

                    case R.id.item3_rb:
                        radio_output.setText("Item3 \n" + result);
                        break;

                }

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent to_third = new Intent(MainActivity.this , Third.class);
                startActivityForResult(to_third , 1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1)
        {
            if(resultCode == 1)
            {
                String text = data.getStringExtra("list_item1");
                radio_output.setText(text);
            }
            else if (resultCode == 2)
            {
                String text = data.getStringExtra("list_item2");
                radio_output.setText(text);
            }
            else if (resultCode == 3)
            {
                String text = data.getStringExtra("list_item3");
                radio_output.setText(text);
            }
        }

    }
}