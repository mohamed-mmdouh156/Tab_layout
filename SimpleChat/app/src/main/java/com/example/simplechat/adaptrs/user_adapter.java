package com.example.simplechat.adaptrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.simplechat.MainActivity;
import com.example.simplechat.R;
import com.example.simplechat.model.User;

import java.util.ArrayList;

public class user_adapter extends RecyclerView.Adapter<user_adapter.view_holder> {

    Context context ;
    ArrayList <User> users ;

    public user_adapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item , parent ,false);

        return new user_adapter.view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {

        User user = users.get(position);
        holder.username.setText(user.getUsername());

        if(user.getImageURL().equals("default"))
        {
            holder.user_profile.setImageResource(R.mipmap.ic_launcher);
        }
        else {
            Glide.with(context).load(user.getImageURL()).into(holder.user_profile);
        }

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class view_holder extends RecyclerView.ViewHolder{

        public TextView username;
        public ImageView user_profile;


        public view_holder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.user_item_username);
            user_profile = itemView.findViewById(R.id.user_item_image);

        }
    }


}
