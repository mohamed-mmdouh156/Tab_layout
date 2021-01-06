package com.example.ieee_task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class call extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        list = findViewById(R.id.num_list);

        final ArrayList <String> numbers = new ArrayList<>();

        numbers.add("01111111");
        numbers.add("012222222");
        numbers.add("013333333");
        numbers.add("014444444");
        numbers.add("015555555");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 ,numbers);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0 :
                    String num1 = numbers.get(0);
                    Intent intent1 = new Intent(Intent.ACTION_DIAL);
                    Uri uri1 = Uri.parse("tel:"+num1);
                    intent1.setData(uri1);
                    startActivity(intent1);

                    break;

                    case 1 :
                        String num2 = numbers.get(1);
                        Intent intent2 = new Intent(Intent.ACTION_DIAL);
                        Uri uri2 = Uri.parse("tel:"+num2);
                        intent2.setData(uri2);
                        startActivity(intent2);

                        break;

                    case 2 :
                        String num3 = numbers.get(2);
                        Intent intent3 = new Intent(Intent.ACTION_DIAL);
                        Uri uri3 = Uri.parse("tel:"+num3);
                        intent3.setData(uri3);
                        startActivity(intent3);
                        break;

                    case 3:
                        String num4 = numbers.get(3);
                        Intent intent4 = new Intent(Intent.ACTION_DIAL);
                        Uri uri4 = Uri.parse("tel:"+num4);
                        intent4.setData(uri4);
                        startActivity(intent4);
                        break;

                    case 4:
                        String num5 = numbers.get(4);
                        Intent intent5 = new Intent(Intent.ACTION_DIAL);
                        Uri uri5 = Uri.parse("tel:"+num5);
                        intent5.setData(uri5);
                        startActivity(intent5);
                        break;

                }


            }
        });

    }
}