package com.example.review11_12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context context ;
    ArrayList<item_obj> items ;


    public Adapter(Context context, ArrayList<item_obj> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public item_obj getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null)
        {
            v = LayoutInflater.from(context).inflate(R.layout.list_item , null , false);
        }

        ImageView image = v.findViewById(R.id.item_img);
        TextView title = v.findViewById(R.id.item_title);

        item_obj item = getItem(position);

        image.setImageResource(item.getImg());
        title.setText(item.getTitle());

        return v;
    }
}
