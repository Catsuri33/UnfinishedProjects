package fr.epicgiant.hub;

import fr.epicgiant.hub.commands.xp.XPCommand;
import fr.epicgiant.hub.database.Account;
import fr.epicgiant.hub.database.MYSQL;
import fr.epicgiant.hub.listeners.PlayerChat;
import fr.epicgiant.hub.listeners.PlayerJoin;
import fr.epicgiant.hub.listeners.PlayerQuit;
import org.apache.commons.dbcp2.BasicDataSource;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class EpicGiantHub extends JavaPlugin {

    public static EpicGiantHub instance;

    private BasicDataSource connectionPool;
    private MYSQL mysql;

    private List<Account> accounts;

    @Override
    public void onEnable(){

        instance = this;

        registerListeners();
        registerCommands();
        initConnection();

        accounts = new ArrayList<>();

        super.onEnable();
    }

    @Override
    public void onDisable(){

        super.onDisable();

    }

    public static EpicGiantHub getInstance() {
        return instance;
    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerChat(), this);

    }

    private void registerCommands(){

        getCommand("setxp").setExecutor(new XPCommand());

    }

    private void initConnection(){

        connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName("com.mysql.jdbc.Driver");
        connectionPool.setUsername("username");
        connectionPool.setPassword("password");
        connectionPool.setUrl("uri");
        connectionPool.setInitialSize(1);
        connectionPool.setMaxTotal(10);
        mysql = new MYSQL(connectionPool);
        mysql.createTables();

    }

    public MYSQL getMYSQL() {
        return mysql;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

}
