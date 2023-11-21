package fr.funblock;

import fr.funblock.commands.HeadsCommands;
import fr.funblock.config.ConfigManager;
import fr.funblock.core.tasks.TablistRunnable;
import fr.funblock.listeners.PlayerChat;
import fr.funblock.listeners.PlayerInteract;
import fr.funblock.listeners.PlayerJoin;
import fr.funblock.listeners.PlayerQuit;
import fr.funblock.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class FunBlock extends JavaPlugin {

    public static FunBlock instance;
    public String prefix;
    public static ConfigManager configManager;
    public HashMap<UUID, PermissionAttachment> playerPerms = new HashMap<>();

    @Override
    public void onEnable() {

        instance = this;
        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("options.prefix"));

        registerListeners();
        registerCommands();
        loadConfigManager();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        ConfigurationSection playersUUIDSection = FunBlock.configManager.getPlayersConfig().getConfigurationSection("players");
        ConfigurationSection headsSection = FunBlock.configManager.getHeadsConfig().getConfigurationSection("heads");

        for(String uuid : playersUUIDSection.getKeys(false)) {

            for(String heads : headsSection.getKeys(false)){

                for(int i = 0; i < uuid.length(); i++){

                    configManager.getPlayersConfig().set("players." + uuid + ".heads", null);

                    configManager.savePlayersConfig();
                    configManager.reloadPlayerConfig();

                    if(FunBlock.configManager.getPlayersConfig().get("players." + uuid + ".heads." + heads) == null){

                        if(!FunBlock.configManager.getPlayersConfig().getBoolean("players." + uuid + ".heads." + heads)){

                            FunBlock.configManager.getPlayersConfig().set("players." + uuid + ".heads." + heads, false);

                        } else {

                            FunBlock.configManager.getPlayersConfig().set("players." + uuid + ".heads." + heads, true);

                        }

                        FunBlock.configManager.savePlayersConfig();
                        FunBlock.configManager.reloadPlayerConfig();

                    }

                }

            }

        }

        if(FunBlock.configManager.getHeadsConfig().get("heads.0") != null){

            for (String heads : headsSection.getKeys(false)) {

                configManager.getHeadsConfig().set("count", Integer.parseInt(heads) + 1);

                configManager.saveHeadsConfig();
                configManager.reloadHeadsConfig();

            }

        } else {

            configManager.getHeadsConfig().set("count", 0);

            configManager.saveHeadsConfig();
            configManager.reloadHeadsConfig();

        }

        TablistRunnable.run();

        Logger.info("Plugin enabled !");

        super.onEnable();

    }

    @Override
    public void onDisable() {

        playerPerms.clear();

        Logger.info("Plugin disabled !");

        super.onDisable();

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerInteract(), this);
        pm.registerEvents(new PlayerChat(), this);

    }

    public void registerCommands(){

        getCommand("heads").setExecutor(new HeadsCommands());

    }

    public static FunBlock getInstance(){

        return instance;

    }

    public void loadConfigManager(){

        configManager = new ConfigManager();
        configManager.setupConfigurations();

        // Players Config
        configManager.getPlayersConfig().addDefault("players", "");

        configManager.getPlayersConfig().options().copyDefaults(true);
        configManager.savePlayersConfig();
        configManager.reloadPlayerConfig();

        // Heads Config
        configManager.getHeadsConfig().addDefault("heads", "");
        configManager.getHeadsConfig().addDefault("count", 0);

        configManager.getHeadsConfig().options().copyDefaults(true);
        configManager.saveHeadsConfig();
        configManager.reloadHeadsConfig();

        // Ranks Config
        configManager.getRanksConfig().options().copyDefaults(true);
        configManager.saveRanksConfig();
        configManager.reloadRanksConfig();

    }

}
