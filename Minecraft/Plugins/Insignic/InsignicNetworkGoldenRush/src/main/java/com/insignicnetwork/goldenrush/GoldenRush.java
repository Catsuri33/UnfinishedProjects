package com.insignicnetwork.goldenrush;

import com.insignicnetwork.goldenrush.core.Gamerules;
import com.insignicnetwork.goldenrush.core.tasks.LobbyRunnable;
import com.insignicnetwork.goldenrush.game.GameStates;
import com.insignicnetwork.goldenrush.listeners.*;
import com.insignicnetwork.goldenrush.managers.ScoreboardManager;
import com.insignicnetwork.goldenrush.mysql.PlayersMySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Statement;

public class GoldenRush extends JavaPlugin {

    public static GoldenRush instance;
    public PlayersMySQL mySQL;
    public String prefix = "§7[§6GoldenRush§7] ";

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

        setupSlots(24);
        GameStates.setState(GameStates.LOBBY);

        super.onEnable();

    }

    @Override
    public void onDisable() {

        mySQL.disconnect();

        super.onDisable();

    }

    public static GoldenRush getInstance() {

        return instance;

    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerDrop(), this);
        pm.registerEvents(new PlayerBreak(), this);
        pm.registerEvents(new PlayerPlace(), this);
        pm.registerEvents(new PlayerTakeDamage(), this);

    }

    private void registerCommands(){



    }

    public static void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ InsignicNetworkGoldenRush ] " + message);

    }

    private void setupSlots(int slots){

        try {

            this.changeSlots(slots);

        } catch(ReflectiveOperationException e) {

            e.printStackTrace();

        }

    }

    public void changeSlots(int slots) throws ReflectiveOperationException {

        Method serverGetHandle = Bukkit.getServer().getClass().getDeclaredMethod("getHandle");

        Object playerList = serverGetHandle.invoke(Bukkit.getServer());
        Field maxPlayersField = playerList.getClass().getSuperclass().getDeclaredField("maxPlayers");

        maxPlayersField.setAccessible(true);
        maxPlayersField.set(playerList, slots);

    }

}
