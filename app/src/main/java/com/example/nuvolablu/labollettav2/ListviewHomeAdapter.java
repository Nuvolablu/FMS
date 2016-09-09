package com.example.nuvolablu.labollettav2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListviewHomeAdapter extends BaseAdapter {
    private   ArrayList<HomeList> listContact;

    private LayoutInflater mInflater;

    public ListviewHomeAdapter(Context photosFragment, ArrayList<HomeList> results){
        listContact = results;
        mInflater = LayoutInflater.from(photosFragment);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listContact.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return listContact.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.adapter_home, null);
            holder = new ViewHolder();
            holder.text_home = (TextView) convertView.findViewById(R.id.text_home_adapter);
            holder.img_home = (ImageView) convertView.findViewById(R.id.img_home_adapter);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text_home.setText(listContact.get(position).getName());
        holder.img_home.setImageResource(listContact.get(position).getImg());

        return convertView;
    }

    static class ViewHolder{
        TextView text_home;
        ImageView img_home;
    }
}
