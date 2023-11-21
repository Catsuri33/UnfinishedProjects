package com.insignicnetwork.essentials;

import com.insignicnetwork.essentials.commands.CoinsCommand;
import com.insignicnetwork.essentials.commands.InsiCoinsCommand;
import com.insignicnetwork.essentials.commands.Lobby;
import com.insignicnetwork.essentials.commands.ModerationCommands;
import com.insignicnetwork.essentials.listeners.InventoryClick;
import com.insignicnetwork.essentials.listeners.PlayerChat;
import com.insignicnetwork.essentials.listeners.PlayerJoin;
import com.insignicnetwork.essentials.managers.PlayerManager;
import com.insignicnetwork.essentials.mysql.PlayersMySQL;
import com.insignicnetwork.essentials.servers.ServersCommon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.UUID;

public class Essentials extends JavaPlugin {

    public static Essentials instance;
    public PlayersMySQL mySQL;
    public ServersCommon serversCommon;
    public HashMap<UUID, PlayerManager> players = new HashMap<>();

    @Override
    public void onEnable() {

        instance = this;

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        registerCommands();
        registerListeners();

        mySQL = new PlayersMySQL("jdbc:mysql://", "localhost", "insignic_network", "root", "password");
        mySQL.connect();

        serversCommon = new ServersCommon(Bukkit.getServer().getName());
        serversCommon.loadServer(Bukkit.getIp(), Bukkit.getPort());
        serversCommon.setState(1);

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

        serversCommon.setState(0);

        mySQL.disconnect();

        super.onDisable();

    }

    public static Essentials getInstance() {

        return instance;

    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new InventoryClick(), this);
        pm.registerEvents(new PlayerChat(), this);

    }

    private void registerCommands(){

        getCommand("coins").setExecutor(new CoinsCommand());
        getCommand("insicoins").setExecutor(new InsiCoinsCommand());
        getCommand("lobby").setExecutor(new Lobby());
        getCommand("mod").setExecutor(new ModerationCommands());
        getCommand("report").setExecutor(new ModerationCommands());

    }

    public void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ InsignicNetworkEssentials ] " + message);

    }

}
