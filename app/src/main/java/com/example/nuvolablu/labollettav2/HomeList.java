package com.example.nuvolablu.labollettav2;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;



public class HomeList {

    private int img;
    private String name;

    public HomeList(int img, String name){
        this.img= img;
        this.name = name;
    }

    public int getImg(){
        return  img;
    }

    public String getName(){
        return name;
    }


}
