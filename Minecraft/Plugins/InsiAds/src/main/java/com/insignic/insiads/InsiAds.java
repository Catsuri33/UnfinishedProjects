package com.insignic.insiads;

import com.insignic.insiads.core.tasks.AdsRunnable;
import com.insignic.insiads.database.DatabaseManager;
import com.insignic.insiads.listeners.PlayerJoin;
import com.insignic.insiads.utils.RandomString;
import com.insignic.insiads.utils.RequestAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsiAds extends JavaPlugin {

    private static InsiAds instance;

    public String prefix = "§9InsignicAds §f§l» §r";
    public static HashMap<UUID, Long> lastAdtoUserMap = new HashMap<>();

    @Override
    public void onEnable() {

        instance = this;

        registerListeners();
        registerCommands();

        saveDefaultConfig();

        // Disable MongoDB Logger
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        if(!DatabaseManager.instance.isServerCreated(getConfig().getString("server.id"))){

            String serverID = "";

            for(int i = 0; i < 4; i++){

                String randomString = RandomString.getAlphaNumericString(4);
                if(i!= 0){

                    serverID = serverID + "-" + randomString;

                } else {

                    serverID = serverID + randomString;

                }

            }

            DatabaseManager.instance.createServer(serverID);
            getConfig().set("server.id", serverID);
            saveConfig();

        }

        DatabaseManager.instance.changeServerState(getConfig().getString("server.id"), "online");
        new AdsRunnable().runTaskTimer(this, 0L, 20L);

        System.out.println("[InsignicAds] There are currently " + DatabaseManager.instance.getTotalAdCampaignAvaible() + " advertising campaigns available.");

        System.out.println(RequestAPI.getCurrencyExchangeRate("USD", "EUR"));

        super.onEnable();

    }

    @Override
    public void onDisable() {

        lastAdtoUserMap.clear();
        DatabaseManager.instance.changeServerState(getConfig().getString("server.id"), "offline");

        super.onDisable();

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);

    }

    public void registerCommands(){



    }

    public static InsiAds getInstance(){

        return instance;

    }

}
