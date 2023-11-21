package fr.catsuri33.uhc.config;

import fr.catsuri33.uhc.UHC;

public class Configuration {

    public static void loadConfigurations(){

        UHC.getInstance().getConfig();
        UHC.getInstance().saveDefaultConfig();

    }

}
