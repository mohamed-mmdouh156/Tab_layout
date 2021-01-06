package com.example.error_tast1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class row_adapter extends BaseAdapter {

    Context c ;
    ArrayList <row_obj> data ;
    int resource ;

    public row_adapter(Context c , int resource , ArrayList<row_obj> data) {
        this.c = c;
        this.data = data;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public row_obj getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView ;

        if (v == null)
        {
            v = LayoutInflater.from(c).inflate(resource , null , false);
        }

        ImageView image = v.findViewById(R.id.row_img);
        TextView title = v.findViewById(R.id.row_title);
        TextView des = v.findViewById(R.id.row_des);

        row_obj item = getItem(position);

        image.setImageResource(item.getImage());
        title.setText(item.getTitle());
        des.setText(item.getDes());

        return v;

    }
}
