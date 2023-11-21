package fr.epicgiant.core;

import fr.epicgiant.core.bans.BanManager;
import fr.epicgiant.core.commands.BanCommands;
import fr.epicgiant.core.commands.KickALL;
import fr.epicgiant.core.commands.Maintenance;
import fr.epicgiant.core.commands.NPCCommand;
import fr.epicgiant.core.infos.PlayerInfos;
import fr.epicgiant.core.listeners.MOTD;
import fr.epicgiant.core.listeners.PlayerJoin;
import fr.epicgiant.core.mysql.MYSQL;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Main extends JavaPlugin {

    private static Main instance;
    public MYSQL mysql = new MYSQL();
    public PlayerInfos playerInfos = new PlayerInfos();
    public BanManager banManager = new BanManager();

    private static Set<UUID> AUTHORIZED_MAINTENANCE = new HashSet<>();
    public static boolean Maintenance = false;
    private PluginManager pluginManager;

    public void onEnable(){

        instance = this;
        mysql.connect("db4free.net", 3306, "epic_giant", "username", "password");

        pluginManager = getServer().getPluginManager();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        pluginManager.registerEvents(new PlayerJoin(), this);
        pluginManager.registerEvents(new MOTD(), this);

        getCommand("maintenance").setExecutor(new Maintenance());
        getCommand("kickall").setExecutor(new KickALL());
        getCommand("ban").setExecutor(new BanCommands());
        getCommand("unban").setExecutor(new BanCommands());
        getCommand("npc").setExecutor(new NPCCommand());
    }

    public void onDisable(){

        mysql.disconnect();

    }

    public static Main getInstance(){
        return instance;
    }

    public static Set<UUID> getAuthorizedMaintenance(){

        return AUTHORIZED_MAINTENANCE;

    }

}
