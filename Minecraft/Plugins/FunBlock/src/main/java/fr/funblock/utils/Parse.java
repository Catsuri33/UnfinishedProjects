package fr.funblock.utils;

public class Parse {

    public static Double stringToDouble(String string){

        double doubleFinal;

        try {

            doubleFinal = Double.parseDouble(string);
            return doubleFinal;

        } catch (NumberFormatException e){

            doubleFinal = 0;
            return doubleFinal;

        }

    }

}
