package com.example.pixartinstitute.Adapter;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixartinstitute.Model.ModelSignUp;
import com.example.pixartinstitute.R;

import java.util.List;

public class ProfileAdapterRecyclerView extends RecyclerView.Adapter<ProfileAdapterRecyclerView.MyViewHolder> {

    Context context;
    List<ModelSignUp> list;

    public ProfileAdapterRecyclerView(Context context, List<ModelSignUp> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.layout_profile, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView_id.setText(list.get(position).getId());
        holder.textView_name.setText(list.get(position).getName());
        holder.textView_email.setText(list.get(position).getEmail());
        holder.textView_phone.setText(list.get(position).getMobile());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView_id;
        TextView textView_name;
        TextView textView_email;
        TextView textView_phone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_id = (TextView) itemView.findViewById(R.id.txt_id);
            textView_name = (TextView) itemView.findViewById(R.id.txt_name);
            textView_email = (TextView) itemView.findViewById(R.id.txt_email);
            textView_phone = (TextView) itemView.findViewById(R.id.txt_mobile);

        }
    }
}
