package com.insignic.bot.config;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigManager {

    private static final Dotenv dotEnv = Dotenv.load();

    public static String get(String key){

        return dotEnv.get(key);

    }

}
