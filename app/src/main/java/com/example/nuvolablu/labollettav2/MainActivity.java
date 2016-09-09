package com.example.nuvolablu.labollettav2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_ALL = 123 ;
    private int permissions_ok = 0;





    //PERMESSI (PROVA)
    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
    public void CheckEvery5Seconds() {
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                if(!startDownload()) {
                    CheckEvery5Seconds();
                }
            }
        }.start();

    }

    public boolean startDownload() {
        boolean result = false;
        String[] PERMISSIONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

        if (!hasPermissions(this, PERMISSIONS)) {
            System.out.println("Do i permessi");
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }else{
            permissions_ok =2;
        }

        if(hasPermissions(this, PERMISSIONS)) {
            File folder = new File(Environment.getExternalStorageDirectory() +
                    File.separator + ".com.LaBolettav2");
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {
                System.out.println("SUCCESS");
                System.out.println("Starting zip download");
                result = true;
                String fileURL = DataManager.url;
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd");
                String formattedDate = df.format(c.getTime());

                DataManager.pathDB = "/sdcard/.com.LaBolettav2/";
                if(UpdateZipManager.UpdateOldZip(this, formattedDate)) {
                    System.out.println("Risultato updateZipManager: "+UpdateZipManager.UpdateOldZip(this, formattedDate));
                    new DownloadFileFromURL().execute(fileURL);
                }else{
                    Intent intent = new Intent(getBaseContext(), Finestra2.class);
                    startActivity(intent);

                }
            } else {
                // Do something else on failure
            }

        }

        return result;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.DEBUG) {
            UpdateZipManager.ResetZipPreference(this);
        }

        if (!startDownload()) {
            CheckEvery5Seconds();
        }
    }




    private void unpackZip() {
        String source = DataManager.pathzip;

        String destination = DataManager.pathDB;
        String password = DataManager.password;

        try {
            ZipFile zipFile = new ZipFile(source);
            if(zipFile != null) {
                System.out.println("zip exist");
                if (zipFile.isEncrypted()) {
                    zipFile.setPassword(password);
                }
                zipFile.extractAll(destination);
            }
            else {
                System.out.println("zip not exist");
                startDownload();
            }
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }



    /**
     * Background Async Task to download file
     */
    class DownloadFileFromURL extends AsyncTask<String, String, String> {
        /**
         * Downloading file in background thread
         */

        @Override
        protected String doInBackground(String... f_url) {
            int count;
            //DOPO AVER SCARICATO IL FILE ZIP

            try {
                URL url = new URL(f_url[0]);
                URLConnection conection = url.openConnection();
                conection.connect();

                // this will be useful so that you can show a tipical 0-100%
                // progress bar
                int lenghtOfFile = conection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(),
                        8192);

                // Output stream

                DataManager.pathzip = "/sdcard/.com.LaBolettav2/laBolletta.zip";
                OutputStream output = new FileOutputStream(DataManager.pathzip);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    // writing data to file
                    output.write(data, 0, count);
                }
                System.out.println("downloadfinito");
                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }



        /**
         * After completing background task
         * Dismiss the progress dialog
         * **/
        @Override
        protected void onPostExecute(String file_url) {
            //UNZIP

            File f = new File(DataManager.pathzip);
            if(f.exists()) {
                System.out.println("ZIP ESISTE");
            }
            else {
                System.out.println("ZIP NON ESISTE");
            }
            unpackZip();
            Intent intent = new Intent(getBaseContext(), Finestra2.class);
            startActivity(intent);

        }


    }
}
