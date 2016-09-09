package com.example.nuvolablu.labollettav2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public final class UpdateZipManager {



    public static void UpdateZipData(Activity ctx, String data) {

        System.out.println("Modifico strings.xml");
        SharedPreferences sharedPref = ctx.getSharedPreferences("Mypref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("zipdata", data);
        editor.putString(ctx.getString(R.string.zipdata), data);
        editor.commit();
        System.out.println("Commit"+ editor.commit());

        Toast.makeText(ctx,"Thanks", Toast.LENGTH_LONG).show();
    }

    public static boolean UpdateOldZip(Activity ctx,  String newData) {
        SharedPreferences sharedPref = ctx.getSharedPreferences("Mypref", Context.MODE_PRIVATE);
        String data = sharedPref.getString("zipdata","0");

        if(!data.equals(newData)) {
            //cancella lo zip con nome "name"
            System.out.println("newdata e' diversa da data"+ newData+ " "+ data);
            UpdateZipData(ctx, newData);
            return true;
        }
        else {
            System.out.println("newdata e' uguale da data"+ newData+ " "+ data);
            return false;
        }
    }

    public static void ResetZipPreference(Activity ctx) {
        SharedPreferences sharedPref = ctx.getSharedPreferences("Mypref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("zipdata", "0");
        editor.putString(ctx.getString(R.string.zipdata), "0");
        editor.commit();
    }

    /*
    quando scarico lo zip
    if(UpdateZipManager.UpdateOldZip(this, datazipscaricato)) {
    operazioni su zip nuovo
    }
    else {
    passo a finestra 2
    }
     */
}
