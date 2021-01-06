package com.example.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView names ;
    EditText edit;
    Button add;
    myadapter adapter;
    int position = -1 ;


    ArrayList<String> name = new ArrayList<> ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





















        /*
        names = findViewById(R.id.listview);
        edit = findViewById(R.id.edit1);
        add = findViewById(R.id.add_btn);


        name.add("mohamed");
        name.add("mmdouh");
        name.add("Ahmed");
        name.add("Ali");
        name.add("Adam");
        name.add("mahmoud");
        name.add("fady");

        adapter = new myadapter(this,android.R.layout.simple_list_item_1,name);

        names.setAdapter(adapter);

        names.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = name.get(i);
                position = i ;
               // Toast.makeText(getApplicationContext() ,item, Toast.LENGTH_LONG).show();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position >= 0)
                {
                    adapter.edit(position ,edit.getText().toString());
                    position = -1 ;
                }
                else {
                    adapter.add_name(edit.getText().toString());
                }

                adapter.notifyDataSetChanged();
            }
        });

         */


    }

}