package com.example.nuvolablu.labollettav2;

/**
 * Created by Marco on 06/09/16.
 */
public class Sqadra {
    private String nome;
    private int cod_squadra;

    public Sqadra(String nome, int cod_squadra){
        this.nome = nome;
        this.cod_squadra = cod_squadra;
    }


    public String getNome(){
        return  this.nome;
    }
    public int getCod(){
        return this.cod_squadra;
    }
}
