package com.insignic.insignicaerospace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.insignic.insignicaerospace.weather.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class InsignicAerospace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.insignicaerospace_home);

        String content;
        Weather weather = new Weather();

        try {

            content = weather.execute("https://openweathermap.org/data/2.5/weather?q=London&appid=439d4b804bc8187953eb36d2a8c26a02").get();
            Log.i("Content", content);

            JSONObject jsonObject = new JSONObject(content);
            String weatherObj = jsonObject.getString("weather");
            Log.i("Weather Data", weatherObj);

            JSONArray jsonArray = new JSONArray(weatherObj);

            String main = "";
            String description = "";

            for(int i = 0; i < jsonArray.length(); i++){

                JSONObject weatherPart = jsonArray.getJSONObject(i);
                main = weatherPart.getString("main");
                description = weatherPart.getString("description");

            }

            Log.i("Main", main);
            Log.i("Description", description);

        } catch (ExecutionException | InterruptedException | JSONException e) {

            e.printStackTrace();

        }

    }

}