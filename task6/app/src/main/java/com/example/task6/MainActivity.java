package com.example.task6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list ;
    Button toast_btn;
    String title []={"camera" , "message" , "desktop"};
    String description []={"Facebook description" , "Twitter description" ,"Instagram description" , "Whatsapp description"};
    int image [] = {R.drawable.ic_baseline_camera_alt_24 , R.drawable.ic_baseline_chat_bubble_24 , R.drawable.ic_baseline_desktop_windows_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list_view);
        toast_btn = findViewById(R.id.button);

        adapter myadapter = new adapter(this ,title ,description ,image);

        list.setAdapter(myadapter);


    }

    public class adapter extends ArrayAdapter<String> {

        Context context ;
        String row_title[];
        String row_des[];
        int row_image [];

        public adapter(Context c , String title[] , String des[] , int image[])
        {
            super(c , R.layout.rows ,R.id.text1 ,title);
            this.context = c;
            this.row_title = title ;
            this.row_des = des;
            this.row_image = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = inflater.inflate(R.layout.rows ,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView titles = row.findViewById(R.id.text1);
            TextView des = row.findViewById(R.id.text2);


            images.setImageResource(row_image[position]);
            titles.setText(row_title[position]);
            des.setText(row_des[position]);

            return row;
        }
    }
}


