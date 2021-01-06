package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class myadapter extends BaseAdapter {
    Context context;
    ArrayList <menu_item> data;
    int resource ;

    myadapter(Context c ,int resource , ArrayList<menu_item> data) {

        this.context = c;
        this.data = data;
        this.resource = resource;
    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view ;

        if (v == null)
        {
            v = LayoutInflater.from(context).inflate(resource ,null , false);
        }

      //  ImageView image = v.findViewById();



        return v;
    }
}
