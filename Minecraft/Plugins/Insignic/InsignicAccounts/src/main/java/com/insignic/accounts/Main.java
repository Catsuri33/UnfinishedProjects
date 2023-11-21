package com.insignic.accounts;

import com.insignic.accounts.commands.AccountCommand;
import com.insignic.accounts.commands.ILoginCommand;
import com.insignic.accounts.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;
    public static String prefix = "§9InsignicAccounts §f§l»";

    @Override
    public void onEnable() {

        long timeStarted = System.currentTimeMillis();

        registerCommands();
        registerListeners();

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

    }

    public void registerCommands(){

        getCommand("account").setExecutor(new AccountCommand());
        getCommand("ilogin").setExecutor(new ILoginCommand());

    }

    public static Main getInstance(){

        return instance;

    }

}
