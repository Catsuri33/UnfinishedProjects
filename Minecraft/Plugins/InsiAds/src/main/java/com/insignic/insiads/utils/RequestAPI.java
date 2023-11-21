package com.insignic.insiads.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestAPI {

    public static String getCurrencyExchangeRate(String currencyFrom, String currencyTo){

        String url = "https://api.exchangerate.host/convert?from=" + currencyFrom + "&to=" + currencyTo;

        try {

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            int responseCode = con.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = br.readLine()) != null){

                response.append(inputLine);

            }

            br.close();

            JsonNode node = Json.parse(response.toString());

            return node.get("result").asText();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return "";

    }

}
