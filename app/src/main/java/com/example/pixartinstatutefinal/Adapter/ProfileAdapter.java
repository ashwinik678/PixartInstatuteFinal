package com.example.pixartinstatutefinal.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pixartinstatutefinal.Model.ModelSignUp;
import com.example.pixartinstatutefinal.R;

import java.util.List;

public class ProfileAdapter extends ArrayAdapter {

    Activity context;
    List<ModelSignUp> list;

    public ProfileAdapter(Activity context, List<ModelSignUp> list) {
        super(context, R.layout.layout_profile, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.layout_profile, null, true);

        TextView id_ = (TextView) convertView.findViewById(R.id.txt_id);
        TextView name_ = (TextView) convertView.findViewById(R.id.txt_name);
        TextView email_ = (TextView) convertView.findViewById(R.id.txt_email);
        TextView mobile_ = (TextView) convertView.findViewById(R.id.txt_mobile);

        ModelSignUp user = list.get(position);

        id_.setText(user.getId());
        name_.setText(user.getName());
        email_.setText(user.getEmail());
        mobile_.setText(user.getMobile());

        return convertView;
    }
}
