package com.example.nuvolablu.labollettav2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Marco on 06/09/16.
 */
public class SquadreAdapter extends BaseAdapter{

    private static ArrayList<Sqadra> listaSquadre;
    private LayoutInflater mInflater;

    public SquadreAdapter(Context photosFragment, ArrayList<Sqadra> results){
        listaSquadre = results;
        mInflater = LayoutInflater.from(photosFragment);
    }
    @Override
    public int getCount() {
        return listaSquadre.size();
    }

    @Override
    public Object getItem(int position) {
        return listaSquadre.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.adapter_home, null);
            holder = new ViewHolder();
            holder.nome_squadra = (TextView) convertView.findViewById(R.id.text_home_adapter);
            //holder.img_squadra = (ImageView) convertView.findViewById(R.id.img_home_adapter);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nome_squadra.setText(listaSquadre.get(position).getNome());
        holder.nome_squadra.setTextColor(Color.BLACK);
        //holder.img_squadra.setImageResource(listaSquadre.get(position).getImg());

        return convertView;
    }


    static class ViewHolder{
        TextView nome_squadra;
        //ImageView img_squadra;
    }
}
