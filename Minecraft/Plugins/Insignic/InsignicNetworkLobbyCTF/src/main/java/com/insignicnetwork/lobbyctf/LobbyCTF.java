package com.insignicnetwork.lobbyctf;

import com.insignicnetwork.lobbyctf.core.Gamerules;
import com.insignicnetwork.lobbyctf.core.divisions.DivisionsManager;
import com.insignicnetwork.lobbyctf.core.scoreboard.ScoreboardManager;
import com.insignicnetwork.lobbyctf.listeners.PlayerJoin;
import com.insignicnetwork.lobbyctf.mysql.PlayersMySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.sql.Statement;

public class LobbyCTF extends JavaPlugin {

    public static LobbyCTF instance;
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

        if(!Bukkit.getOnlinePlayers().isEmpty()){

            for(Player players : Bukkit.getOnlinePlayers()){

                DivisionsManager.checkDivisions(players.getUniqueId());
                ScoreboardManager.createScoreboardLobby(players);

            }

        }

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

    public static LobbyCTF getInstance() {

        return instance;

    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);

    }

    private void registerCommands(){

    }

    public static void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ InsignicNetworkLobbyCTF ] " + message);

    }

}
