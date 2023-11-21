package fr.odilonesport.fallenkingdoms.utils;

public class ValuesCheck {

    public static boolean isInteger(String number){

        try {

            Integer intValue = Integer.parseInt(number);
            return true;

        } catch (NumberFormatException e) {

            return false;

        }

    }

}
