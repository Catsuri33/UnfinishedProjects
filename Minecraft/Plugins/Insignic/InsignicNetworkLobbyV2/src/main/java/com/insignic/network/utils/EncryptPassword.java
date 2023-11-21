package com.insignic.network.utils;

public class EncryptPassword {

    private static int key = 8;

    public static String encryptString(String stringToEncrypt){

        char[] chars = stringToEncrypt.toCharArray();
        String encryptedString = "";

        for(char c : chars){

            c += key;
            encryptedString = encryptedString + c;

        }

        return encryptedString;

    }

    public static String decryptString(String stringToDecrypt){

        char[] chars = stringToDecrypt.toCharArray();
        String decryptedString = "";

        for(char c : chars){

            c -= key;
            decryptedString = decryptedString + c;

        }

        return decryptedString;

    }

}
