package fr.funblock.utils;

public class VerifyVar {

    public static boolean isLong(String s) {

        try {

            Long.parseLong(s);

        } catch (NumberFormatException nfe) {

            return false;

        }

        return true;

    }

    public static boolean isInt(String s) {

        try {

            Integer.parseInt(s);

        } catch (NumberFormatException nfe) {

            return false;

        }

        return true;

    }

    public static boolean isFloat(String s) {

        try {

            Float.parseFloat(s);

        } catch (NumberFormatException nfe) {

            return false;

        }

        return true;

    }

}
