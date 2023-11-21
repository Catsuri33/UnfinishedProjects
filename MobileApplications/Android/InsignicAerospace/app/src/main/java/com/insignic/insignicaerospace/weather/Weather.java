package com.insignic.insignicaerospace.weather;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... webURL){

        try {

            URL url = new URL(webURL[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int data = isr.read();
            String content = "";
            char ch;

            while(data != -1){

                ch = (char) data;
                content = content + ch;
                data = isr.read();

            }

            return content;

        } catch (IOException e) {

            e.printStackTrace();

        }

        return null;

    }

}
