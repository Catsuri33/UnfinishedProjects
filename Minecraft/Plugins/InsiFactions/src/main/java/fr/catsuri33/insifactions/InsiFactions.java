package fr.catsuri33.insifactions;

import fr.catsuri33.insifactions.commands.*;
import fr.catsuri33.insifactions.config.ConfigManager;
import fr.catsuri33.insifactions.core.Mines;
import fr.catsuri33.insifactions.core.tasks.MinesRunnable;
import fr.catsuri33.insifactions.guis.GuiManager;
import fr.catsuri33.insifactions.listeners.*;
import fr.catsuri33.insifactions.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class InsiFactions extends JavaPlugin {

    public static InsiFactions instance;
    public static ConfigManager configManager;
    public static String prefix;
    public static List<Mines> mines = new ArrayList<>();
    public HashMap<UUID, PermissionAttachment> playerPerms = new HashMap<>();
    public static int timerMines = 0;

    @Override
    public void onEnable() {

        instance = this;
        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix-plugin"));

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        loadConfigManager();

        registerListeners();
        registerCommands();

        ConfigurationSection minesSection = configManager.getMinesConfiguration().getConfigurationSection("mines");

        try {

            for(String minesName : minesSection.getKeys(false)){

                final int timerHours = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".reset-time.hours") * 3600;
                final int timerMinutes = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".reset-time.minutes") * 60;
                final int timerSeconds = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".reset-time.seconds");
                final int x1 = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".x1");
                final int y1 = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".y1");
                final int z1 = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".z1");
                final int x2 = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".x2");
                final int y2 = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".y2");
                final int z2 = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".z2");
                final int coalAmount = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".minerals.coal-amount");
                final int ironAmount = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".minerals.iron-amount");
                final int goldAmount = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".minerals.gold-amount");
                final int redstoneAmount = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".minerals.redstone-amount");
                final int lapizAmount = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".minerals.lapis-amount");
                final int emeraldAmount = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".minerals.emerald-amount");
                final int diamondAmount = configManager.getMinesConfiguration().getInt("mines." + minesName  + ".minerals.diamond-amount");

                timerMines = timerHours + timerMinutes + timerSeconds;

                mines.add(new Mines(minesName, timerMines, x1, y1, z1, x2, y2, z2, coalAmount, ironAmount, goldAmount, redstoneAmount, lapizAmount, emeraldAmount, diamondAmount));
                new MinesRunnable().runTaskTimer(this, 0L, 20L);

            }

        } catch(NullPointerException e){



        }

        // Init Guis
        GuiManager.createFactionInv();

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
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerDeath(), this);
        pm.registerEvents(new SignChange(), this);

    }

    public void registerCommands(){

        getCommand("setmine").setExecutor(new MinesCommands());
        getCommand("money").setExecutor(new EconomyCommands());
        getCommand("rank").setExecutor(new RankCommands());
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("faction").setExecutor(new FactionCommands());
        getCommand("maintenance").setExecutor(new MaintenanceCommands());

    }

    public static InsiFactions getInstance(){

        return instance;

    }

    public static List<Mines> getMines(){

        return mines;

    }

    public void loadConfigManager(){

        configManager = new ConfigManager();
        configManager.setupConfigurations();

        // Mines Config
        configManager.getMinesConfiguration().addDefault("mines", "");

        configManager.getMinesConfiguration().options().copyDefaults(true);
        configManager.saveMinesConfiguration();
        configManager.reloadMinesConfiguration();

        // Players Config
        configManager.getPlayersConfig().addDefault("players", "");

        configManager.getPlayersConfig().options().copyDefaults(true);
        configManager.savePlayersConfig();
        configManager.reloadPlayerConfig();

        // Ranks Config
        configManager.getRanksConfig().set("ranks.admin.name", "Admin");
        configManager.getRanksConfig().set("ranks.admin.prefix", "§c[Admin] ");
        configManager.getRanksConfig().set("ranks.admin.suffix", "");
        configManager.getRanksConfig().set("ranks.admin.permissions", "");

        configManager.getRanksConfig().addDefault("ranks", "");
        configManager.getRanksConfig().set("ranks.player.name", "Player");
        configManager.getRanksConfig().set("ranks.player.prefix", "§7[Player] ");
        configManager.getRanksConfig().set("ranks.player.suffix", "");
        configManager.getRanksConfig().set("ranks.player.permissions", "");

        configManager.getRanksConfig().options().copyDefaults(true);
        configManager.saveRanksConfig();
        configManager.reloadRanksConfig();

        // Factions Config
        configManager.getFactionsConfig().addDefault("factions", "");

        configManager.getFactionsConfig().options().copyDefaults(true);
        configManager.saveFactionsConfig();
        configManager.reloadFactionsConfig();

        // Maintenance Config
        configManager.getMaintenanceConfig().addDefault("maintenance", "");
        configManager.getMaintenanceConfig().set("maintenance.enabled", "false");

        configManager.getMaintenanceConfig().options().copyDefaults(true);
        configManager.saveMaintenanceConfig();
        configManager.reloadMaintenanceConfig();

    }

}
