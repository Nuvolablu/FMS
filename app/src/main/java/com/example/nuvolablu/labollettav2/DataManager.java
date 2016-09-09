package com.example.nuvolablu.labollettav2;

public final class DataManager {
    public static String url = "http://fsm.tips/webapp/laBollettaDb.db.zip";
    public static String password = "sD4s653d&?zet1n0_M3rdAAAAA+GH|13*46/5+;.-sDzEta";
    public static String pathzip ="";
    public static  String pathDB ="";
    public static String squadradelcuore="";

    public static String query_squadre = "Select s.nome, s._id from nazioni n, Squadre s, campionati c where c.idNazione = n._id and s.idCampionato = c._id and n.nome = '";
    public static String query_nazioni = "Select nome, _id from nazioni";
    public static String query_campionati = "Select categoria from nazioni, campionati where nazioni._id = campionati.idNazione and nazioni.nome = '";

}
