package com.insignicnetwork.lobby;

import com.insignicnetwork.lobby.commands.AuthCommands;
import com.insignicnetwork.lobby.commands.ImageToMapCommand;
import com.insignicnetwork.lobby.core.Gamerules;
import com.insignicnetwork.lobby.listeners.*;
import com.insignicnetwork.lobby.messages.MessagesBungeeCord;
import com.insignicnetwork.lobby.mysql.PlayersMySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Lobby extends JavaPlugin {

    public static Lobby instance;
    public PlayersMySQL mySQL;

    public static File imagesDir;
    public static File imagesMapDir;
    public static List<UUID> waitingLogin = new ArrayList<>();

    @Override
    public void onEnable() {

        instance = this;
        imagesDir = new File(getDataFolder(), "images");
        imagesMapDir = new File(getDataFolder(), "maps");

        registerListeners();
        registerCommands();

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new MessagesBungeeCord());

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

    public static Lobby getInstance() {

        return instance;

    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerMove(), this);
        pm.registerEvents(new PlayerDrop(), this);
        pm.registerEvents(new PlayerBreak(), this);
        pm.registerEvents(new PlayerPlace(), this);
        pm.registerEvents(new PlayerTakeDamage(), this);
        pm.registerEvents(new InventoryClick(), this);
        pm.registerEvents(new PlayerInteract(), this);
        pm.registerEvents(new PlayerChat(), this);

    }

    private void registerCommands(){

        getCommand("map").setExecutor(new ImageToMapCommand());
        getCommand("register").setExecutor(new AuthCommands());
        getCommand("login").setExecutor(new AuthCommands());
        getCommand("password").setExecutor(new AuthCommands());

    }

    public static void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ InsignicNetworkLobby ] " + message);

    }

}
