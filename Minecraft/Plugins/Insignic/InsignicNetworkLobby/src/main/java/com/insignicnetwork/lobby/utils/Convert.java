package com.insignicnetwork.lobby.utils;

public class Convert {

    public static Integer stringToInt(String string){

        int intFinal;

        try {

            intFinal = Integer.parseInt(string);
            return intFinal;

        } catch (NumberFormatException e){

            intFinal = 0;
            return intFinal;

        }

    }

}
