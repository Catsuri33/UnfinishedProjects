package com.insignicnetwork.practice;

import com.insignicnetwork.practice.core.Gamerules;
import com.insignicnetwork.practice.listeners.*;
import com.insignicnetwork.practice.mysql.PlayersMySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.sql.Statement;

public class Practice extends JavaPlugin {

    public static Practice instance;
    public PlayersMySQL mySQL;

    @Override
    public void onEnable() {

        instance = this;

        registerListeners();
        registerCommands();

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        mySQL = new PlayersMySQL("jdbc:mysql://", "localhost", "insignic_network", "root", "password");
        mySQL.connect();

        Gamerules.setGamerules();

        BukkitRunnable databaseMaintener = new BukkitRunnable() {

            @Override
            public void run() {

                try {

                    PlayersMySQL.openConnection();
                    Statement statement = PlayersMySQL.getConnection().createStatement();

                } catch(ClassNotFoundException | SQLException e) {

                    e.printStackTrace();

                }

            }

        };

        databaseMaintener.runTaskAsynchronously(this);

        super.onEnable();

    }

    @Override
    public void onDisable() {

        mySQL.disconnect();

        super.onDisable();

    }

    public static Practice getInstance() {

        return instance;

    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new InventoryClick(), this);
        pm.registerEvents(new PlayerBreak(), this);
        pm.registerEvents(new PlayerDrop(), this);
        pm.registerEvents(new PlayerInteract(), this);
        pm.registerEvents(new PlayerPlace(), this);
        pm.registerEvents(new PlayerTakeDamage(), this);

    }

    private void registerCommands(){



    }

    public void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ InsignicNetworkPractice ] " + message);

    }

}
