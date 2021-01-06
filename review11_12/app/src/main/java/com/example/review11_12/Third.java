package com.example.review11_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Third extends AppCompatActivity {

    TextView display ;
    ListView list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        display = findViewById(R.id.choose_tv);
        list = findViewById(R.id.list_view);



      //  display.setText(result);

        ArrayList<item_obj> list_items = new ArrayList<>();
        list_items.add(new item_obj(R.drawable.twitter ,"Twitter"));
        list_items.add(new item_obj(R.drawable.twitter ,"Facebook"));
        list_items.add(new item_obj(R.drawable.twitter ,"Whatsapp"));
        list_items.add(new item_obj(R.drawable.twitter ,"Instagram"));
        list_items.add(new item_obj(R.drawable.twitter ,"Twitter"));
        list_items.add(new item_obj(R.drawable.twitter ,"Facebook"));
        list_items.add(new item_obj(R.drawable.twitter ,"Whatsapp"));
        list_items.add(new item_obj(R.drawable.twitter ,"Instagram"));

        Adapter list_adapter = new Adapter(this ,list_items);

        list.setAdapter(list_adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0 :

                        Intent to_main = new Intent();
                        to_main.putExtra("list_item1" ,"Twitter");
                        setResult(1 ,to_main);
                        finish();

                        break;

                    case 1 :

                        Intent to_main1 = new Intent();
                        to_main1.putExtra("list_item2" ,"Facebook");
                        setResult(2 ,to_main1);
                        finish();

                        break;

                    case 2 :

                        Intent to_main2 = new Intent();
                        to_main2.putExtra("list_item3" ,"Whatsapp");
                        setResult(3 ,to_main2);
                        finish();

                        break;

                }

            }
        });

        registerForContextMenu(list);


    }

        // context menu code

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu , menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.item1 :
                Intent to_call = new Intent(Third.this , Call.class);
                startActivity(to_call);
                return true;

            case R.id.item2 :
                Toast.makeText(getApplicationContext() , "item2" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.item3 :
                Toast.makeText(getApplicationContext() , "item3" , Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }


    // Option menu code

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu , menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {

            case R.id.item1 :
                Intent to_call = new Intent(Third.this , Call.class);
                startActivity(to_call);
                return true;

            case R.id.item2 :
                Toast.makeText(getApplicationContext() , "item2" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.item3 :
                Toast.makeText(getApplicationContext() , "item3" , Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }
}