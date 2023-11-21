package fr.catsuri33.uhc;

import fr.catsuri33.uhc.config.Configuration;
import fr.catsuri33.uhc.listener.LoadListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class UHC extends JavaPlugin {

    private static UHC instance;

    @Override
    public void onEnable(){

        Bukkit.getLogger().info("[ UHC ] Initialization du plugin en cours...");

        Configuration.loadConfigurations();
        LoadListeners.loadListeners();

    }

    public void onDisable(){



    }

    public static UHC getInstance(){

        return instance;

    }

}
