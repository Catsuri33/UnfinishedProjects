package com.insignic.uhchost;

import com.insignic.uhchost.config.ConfigManager;
import com.insignic.uhchost.game.GameStates;
import com.insignic.uhchost.game.Gamerules;
import com.insignic.uhchost.game.guis.*;
import com.insignic.uhchost.game.lobby.FloorRunnable;
import com.insignic.uhchost.listeners.*;
import com.insignic.uhchost.utils.Cuboid;
import com.insignic.uhchost.utils.Logger;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class UHCHost extends JavaPlugin {

    private static UHCHost instance;
    public static ConfigManager configManager;
    public static String prefix = "§6InsiUHCHost §l» §r";
    public static List<Player> hostList = new ArrayList<>();

    @Override
    public void onEnable() {

        instance = this;

        long timeStart = System.currentTimeMillis();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        loadConfigManager();

        configManager.getSettingsConfiguration().set("settings.server.gamemode", "FFA");

        registerListeners();
        registerCommands();

        GameStates.setState(GameStates.LOBBY);
        Gamerules.setGamerulesLobby();
        Bukkit.getWorld("world").setDifficulty(Difficulty.HARD);

        // Generate Spawn Platform
        Cuboid cuboid1 = new Cuboid(new Location(Bukkit.getWorld("world"), 20, 200, -20), new Location(Bukkit.getWorld("world"), -20, 200, 20));
        for(Block blocks : cuboid1){

            blocks.setType(Material.WHITE_STAINED_GLASS);

        }

        Cuboid cuboid2 = new Cuboid(new Location(Bukkit.getWorld("world"), 20, 201, -20), new Location(Bukkit.getWorld("world"), -20, 204, 20));
        for(Block blocks : cuboid2){

            blocks.setType(Material.WHITE_STAINED_GLASS_PANE);

        }

        Cuboid cuboid3 = new Cuboid(new Location(Bukkit.getWorld("world"), 19, 201, -19), new Location(Bukkit.getWorld("world"), -19, 204, 19));
        for(Block blocks : cuboid3){

            blocks.setType(Material.AIR);

        }

        WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
        wb.setCenter(0, 0);
        wb.setDamageAmount(1.0);
        wb.setSize(1000);

        if(Bukkit.getOnlinePlayers().size() == 1){

            new FloorRunnable().runTaskTimer(UHCHost.getInstance(), 0L, 5L);

        }

        for(Player players : Bukkit.getOnlinePlayers()){

            if(players.isOp() || players.hasPermission("insiuhc.host")){

                UHCHost.hostList.add(players);

                players.setDisplayName("§c[Host] " + players.getName() + "§r");
                players.setPlayerListName("§c[Host] " + players.getName() + "§r");

            } else {

                players.setDisplayName(players.getName() + "§r");
                players.setPlayerListName(players.getName() + "§r");

            }

        }

        // Guis
        HostCustomisationInventory.createInventory();
        SettingsInventory.createInventory();
        BorderInventory.createInventory();
        BorderSizeStartInventory.createInventory();
        BorderSizeEndInventory.createInventory();
        BorderTimeBegunInventory.createInventory();
        BorderDamageInventory.createInventory();
        BorderTimeCenterInventory.createInventory();
        SlotsInventory.createInventory();
        SlotsConfigurationInventory.createInventory();
        NetherInventory.createInventory();
        PotionsInventory.createInventory();
        PvPInventory.createInventory();
        PvPTimeInventory.createInventory();

        BorderSizeEndInventory.borderEnd = 50;
        BorderTimeBegunInventory.timeBorderBegun = 3600;
        BorderTimeCenterInventory.timeBorderCenter = 1800;
        SlotsInventory.spectator = true;
        SlotsConfigurationInventory.slotsNumber = 24;
        NetherInventory.netherState = true;
        PvPInventory.isPvPClassic = true;
        PvPTimeInventory.pvpTime = 1800;

        Logger.success("Plugin enabled in " + (System.currentTimeMillis() - timeStart) + "ms !");

        super.onEnable();

    }

    @Override
    public void onDisable() {

        for(Player players : Bukkit.getOnlinePlayers()){

            if(players.isOp() || players.hasPermission("insiuhc.host")){

                UHCHost.hostList.remove(players);

            }

        }

        Logger.success("Plugin disabled !");

        super.onDisable();

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerMove(), this);
        pm.registerEvents(new PlayerDamage(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerInteract(), this);
        pm.registerEvents(new PlayerClick(), this);
        pm.registerEvents(new PlayerDrop(), this);
        pm.registerEvents(new PlayerCreatePortal(), this);
        pm.registerEvents(new PlayerPotion(), this);

        pm.registerEvents(new BlockPlace(), this);
        pm.registerEvents(new BlockBreak(), this);

    }

    public void registerCommands(){



    }

    public static UHCHost getInstance(){

        return instance;

    }

    public void loadConfigManager(){

        configManager = new ConfigManager();
        configManager.setupConfigurations();

        // Settings Config
        configManager.getSettingsConfiguration().addDefault("settings", "");
        configManager.getSettingsConfiguration().addDefault("settings.lobby-floor", "All");
        configManager.getSettingsConfiguration().addDefault("settings.server.name", "Null");
        configManager.getSettingsConfiguration().addDefault("settings.server.ip", "Null");
        configManager.getSettingsConfiguration().addDefault("settings.server.gamemode", "FFA");

        configManager.getSettingsConfiguration().options().copyDefaults(true);
        configManager.saveSettingsConfiguration();
        configManager.reloadSettingsConfiguration();

    }

}
