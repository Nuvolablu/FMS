package com.example.nuvolablu.labollettav2;

/**
 * Created by Marco on 08/09/16.
 */
public class Nazione {

    private String nome;
    private int codice_nazione;
    public Nazione(String nome, int codice_nazione){
        this.nome = nome;
        this.codice_nazione = codice_nazione;
    }


    public String getNome(){
        return this.nome;
    }

    public int getCodice_nazione(){
        return this.codice_nazione;
    }
}
