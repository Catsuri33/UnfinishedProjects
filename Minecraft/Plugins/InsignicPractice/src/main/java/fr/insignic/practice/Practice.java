package fr.insignic.practice;

import fr.insignic.practice.commands.Broadcast;
import fr.insignic.practice.commands.Duel;
import fr.insignic.practice.game.Arenas;
import fr.insignic.practice.game.ArenasManager;
import fr.insignic.practice.listeners.PlayerChat;
import fr.insignic.practice.listeners.PlayerDamage;
import fr.insignic.practice.listeners.PlayerDeath;
import fr.insignic.practice.listeners.PlayerQuit;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Practice extends JavaPlugin {

    public static Practice instance;

    public Map<Player, Player> playersDuel = new HashMap<>();
    public ArenasManager arenasManager = new ArenasManager();
    private File arenasFile;
    private YamlConfiguration arenaConfig;

    @Override
    public void onEnable() {

        instance = this;

        registerListeners();
        registerCommands();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        if(!getDataFolder().exists()){

            getDataFolder().mkdir();

        }

        arenasFile = new File(getDataFolder() + File.separator + "arenas.yml");

        if(!arenasFile.exists()){

            try {

                arenasFile.createNewFile();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        arenaConfig = YamlConfiguration.loadConfiguration(arenasFile);

        ConfigurationSection arenasSection = arenaConfig.getConfigurationSection("arenas");

        for(String string : arenasSection.getKeys(false)){

            String loc1 = arenasSection.getString(string + ".loc1");
            String loc2 = arenasSection.getString(string + ".loc2");

            Arenas arena = new Arenas(parseStringToLoc(loc1), parseStringToLoc(loc2));
            arenasManager.addArena(arena);

        }

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static Practice getInstance() {

        return instance;

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerDamage(), this);
        pm.registerEvents(new PlayerDeath(), this);

    }

    public void registerCommands(){

        getCommand("broadcast").setExecutor(new Broadcast());
        getCommand("duel").setExecutor(new Duel());

    }

    public static void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ InsignicPractice ] " + message);

    }

    public ArenasManager getArenasManager(){

        return arenasManager;

    }

    public Location parseStringToLoc(String string){

        String[] parsedLoc = string.split(",");
        double x = Double.valueOf(parsedLoc[0]);
        double y = Double.valueOf(parsedLoc[1]);
        double z = Double.valueOf(parsedLoc[2]);

        return new Location(Bukkit.getWorld("world"), x, y, z);

    }

    public String unParseLocToString(Location loc){

        return loc.getX() + "," + loc.getY() + "," + loc.getZ();

    }

}
