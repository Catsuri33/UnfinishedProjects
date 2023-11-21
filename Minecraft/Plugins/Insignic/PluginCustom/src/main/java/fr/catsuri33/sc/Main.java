package fr.catsuri33.sc;

import fr.catsuri33.sc.commands.*;
import fr.catsuri33.sc.config.ConfigManager;
import fr.catsuri33.sc.core.tasks.TimerMoneyRunnable;
import fr.catsuri33.sc.listeners.*;
import fr.catsuri33.sc.utils.Logger;
import fr.catsuri33.sc.world.WorldsGenerator;
import org.bukkit.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static Main instance;
    public static ConfigManager configManager;
    public static String prefix;
    public static HashMap<UUID, World> worldOfDeath = new HashMap<>();

    @Override
    public void onEnable() {

        instance = this;
        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix-plugin"));

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        loadConfigManager();

        loadWorlds();

        registerListeners();
        registerCommands();

        new TimerMoneyRunnable().runTaskTimer(this, 0L, 200L);

        Logger.info("Plugin enabled !");

        super.onEnable();

    }

    @Override
    public void onDisable() {

        Logger.info("Plugin disabled !");

        super.onDisable();

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerRespawn(), this);
        pm.registerEvents(new PlayerDeath(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerTeleport(), this);
        pm.registerEvents(new PlayerTakeDamage(), this);
        pm.registerEvents(new BlockPlace(), this);
        pm.registerEvents(new BlockBreak(), this);

    }

    public void registerCommands(){

        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("wtp").setExecutor(new WorldTpCommand());
        getCommand("wcreate").setExecutor(new WorldCreateCommand());
        getCommand("msg").setExecutor(new MessagesCommands());
        getCommand("r").setExecutor(new MessagesCommands());
        getCommand("money").setExecutor(new EconomyCommands());
        getCommand("mtimer").setExecutor(new EconomyCommands());

    }

    public static Main getInstance(){

        return instance;

    }

    public void loadConfigManager(){

        configManager = new ConfigManager();
        configManager.setupConfigurations();

        // Server Config
        configManager.getServerConfiguration().addDefault("server", "");

        configManager.getServerConfiguration().options().copyDefaults(true);
        configManager.saveServerConfiguration();
        configManager.reloadServerConfiguration();

        // Players Config
        configManager.getPlayersConfig().addDefault("players", "");

        configManager.getPlayersConfig().options().copyDefaults(true);
        configManager.savePlayersConfig();
        configManager.reloadPlayerConfig();

    }

    public void loadWorlds(){

        ConfigurationSection worldsSection = configManager.getServerConfiguration().getConfigurationSection("server.worlds");

        if(worldsSection == null){

            return;

        }

        for(String worldName : worldsSection.getKeys(false)){

            final String worldType = configManager.getServerConfiguration().getString("server.worlds." + worldName + ".type");
            final boolean worldStructures = configManager.getServerConfiguration().getBoolean("server.worlds." + worldName + ".structures");

            if(worldType.equalsIgnoreCase("flat")){

                WorldsGenerator.crateWorld(worldName, WorldType.FLAT, worldStructures);

            }

            if(worldType.equalsIgnoreCase("normal")){

                WorldsGenerator.crateWorld(worldName, WorldType.NORMAL, worldStructures);

            }

            if(worldType.equalsIgnoreCase("amplified")){

                WorldsGenerator.crateWorld(worldName, WorldType.AMPLIFIED, worldStructures);

            }

            if(worldType.equalsIgnoreCase("large_biomes")){

                WorldsGenerator.crateWorld(worldName, WorldType.LARGE_BIOMES, worldStructures);

            }

        }

    }

}
