package com.example.error_tast1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class second extends AppCompatActivity {

   RecyclerView Rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Rv = findViewById(R.id.recycler_view);

        final ArrayList <row_obj > data = new ArrayList<>();
        data.add(new row_obj(R.drawable.ic_facebook ,"Facebook" , "an American online social media and social networking service"));
        data.add(new row_obj(R.drawable.ic_facebook ,"Facebook" , "an American online social media and social networking service"));

        recycler_adapter adapter = new recycler_adapter(data, new OnItemClickListener() {
            @Override
            public void OnItemClick(int row) {

                switch (row){
                    case 0 :
                        Toast.makeText(getApplicationContext() , "1" , Toast.LENGTH_LONG);
                        break;
                    case 1 :
                        Toast.makeText(getApplicationContext() , "2" , Toast.LENGTH_LONG);
                        break;
                }
            }
        });
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        Rv.setLayoutManager(lm);
        Rv.setAdapter(adapter);








/*
        ArrayList <row_obj > data = new ArrayList<>();
        data.add(new row_obj(R.drawable.ic_facebook ,"Facebook" , "an American online social media and social networking service"));

        row_adapter adapter = new row_adapter(this , R.layout.row ,data);

        list.setAdapter(adapter);
*/



    }
}