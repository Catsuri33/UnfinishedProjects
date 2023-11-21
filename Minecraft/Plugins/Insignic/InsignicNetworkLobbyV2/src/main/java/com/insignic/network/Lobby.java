package com.insignic.network;

import com.insignic.network.commands.AccountCommand;
import com.insignic.network.commands.ILoginCommand;
import com.insignic.network.database.MongoDb;
import com.insignic.network.listeners.PlayerJoin;
import com.insignic.network.listeners.PlayerQuit;
import com.insignic.network.utils.ConsoleColors;
import com.insignic.network.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Lobby extends JavaPlugin {

    public static Lobby instance;
    public static String prefix = "§9InsignicNetwork §f§l»";

    @Override
    public void onEnable() {

        long timeStarted = System.currentTimeMillis();

        registerCommands();
        registerListeners();

        MongoDb mongoDB = new MongoDb();
        Logger.info(ConsoleColors.ANSI_CYAN + "[ INFO ][ DATABASE ]" + ConsoleColors.ANSI_BLUE + " Connected to the database '" + MongoDb.mongoDatabaseInsignicNetwork.getName() + "' !");
        Logger.info(ConsoleColors.ANSI_CYAN + "[ INFO ][ DATABASE ]" + ConsoleColors.ANSI_BLUE + " Connected to the database '" + MongoDb.mongoDatabaseInsignicAccounts.getName() + "' !");

        long timeEnded = System.currentTimeMillis();
        Logger.info("Plugin enabled in " + (timeEnded - timeStarted) + "ms !");

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);

    }

    public void registerCommands(){

        getCommand("account").setExecutor(new AccountCommand());
        getCommand("ilogin").setExecutor(new ILoginCommand());

    }

    public static Lobby getInstance(){

        return instance;

    }

}
