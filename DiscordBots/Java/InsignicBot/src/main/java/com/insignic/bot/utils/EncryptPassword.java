package com.insignic.bot.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class EncryptPassword {

    public static String encryptString(String stringToEncrypt){

        String bcryptHashString = BCrypt.withDefaults().hashToString(12, stringToEncrypt.toCharArray());

        return bcryptHashString;

    }

}
