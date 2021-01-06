package com.example.fragments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements first_fragment.OnFragmentListener {

    TextView name_tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_tv = findViewById(R.id.name_tv);


        /*
        first = findViewById(R.id.first_btn);
        second = findViewById(R.id.second_btn);


        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                first_fragment first_f = new first_fragment();

                ft.replace(R.id.fragment_container , first_f);
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                second_fragment first_s = new second_fragment();

                ft.replace(R.id.fragment_container , first_s);
                ft.addToBackStack(null);
                ft.commit();

            }
        });

          */

    }

    @Override
    public void FragmentInteraction(String name) {

        name_tv.setText(name);

    }


}