package com.example.error_tast1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler_adapter extends RecyclerView.Adapter<recycler_adapter.view_holder> {

    ArrayList<row_obj> recycler_array ;
    OnItemClickListener listener ;

    public recycler_adapter( ArrayList<row_obj> r_a , OnItemClickListener listener ) {

        this.recycler_array = r_a ;
        this.listener = listener ;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row , null , false) ;
        view_holder holder = new view_holder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {

        row_obj item = recycler_array.get(position);

        holder.row_img.setImageResource(item.getImage());
        holder.row_text1.setText(item.getTitle());
        holder.row_text2.setText(item.getDes());

    }

    @Override
    public int getItemCount() {

        return recycler_array.size();
    }




    class view_holder extends RecyclerView.ViewHolder
    {

       ImageView row_img;
       TextView row_text1  , row_text2;
       int row_item;

        public view_holder(@NonNull View itemView) {
            super(itemView);

            row_img = itemView.findViewById(R.id.row_img);
            row_text1 = itemView.findViewById(R.id.row_title);
            row_text2 = itemView.findViewById(R.id.row_des);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(row_item);
                }
            });

        }
    }
}
