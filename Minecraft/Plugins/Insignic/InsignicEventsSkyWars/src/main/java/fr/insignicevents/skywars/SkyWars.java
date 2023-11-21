package fr.insignicevents.skywars;

import fr.insignicevents.skywars.game.GameStates;
import fr.insignicevents.skywars.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class SkyWars extends JavaPlugin {

    public static SkyWars instance;

    public ArrayList<Player> playerList = new ArrayList<>();

    @Override
    public void onEnable() {

        instance = this;

        registerListeners();
        registerCommands();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        GameStates.setState(GameStates.LOBBY);

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static SkyWars getInstance() {

        return instance;

    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerDamages(), this);
        pm.registerEvents(new PlayerBreak(), this);
        pm.registerEvents(new PlayerPlace(), this);
        pm.registerEvents(new PlayerDrop(), this);

    }

    private void registerCommands(){



    }

    public static void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ InsignicEventsSkyWars ] " + message);

    }

}
