package fr.catsuri33.event;

import fr.catsuri33.event.commands.Nick;
import fr.catsuri33.event.commands.Restart;
import fr.catsuri33.event.listeners.PlayerJoin;
import fr.catsuri33.event.listeners.PlayerQuit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Event extends JavaPlugin {

    public static Event instance;

    private FileConfiguration dbNick;
    private File dFile;

    public static Event getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;

        registerListeners();
        registerCommands();
        setupFiles();

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);

    }

    private void registerCommands(){

        getCommand("restart").setExecutor(new Restart());
        getCommand("nick").setExecutor(new Nick());

    }

    private void setupFiles(){

        // Nick Command
        if(!instance.getDataFolder().exists()) instance.getDataFolder().mkdirs();

        dFile = new File(instance.getDataFolder(), "database.yml");

        if(!dFile.exists()){

            try{

                dFile.createNewFile();

            } catch(IOException e){

                Bukkit.getLogger().warning("[ Event ] Je ne peut pas créer le fichier 'database.yml' ! Plugin désactivé !");
                Bukkit.getPluginManager().disablePlugin(this);

            }

        }

        dbNick = YamlConfiguration.loadConfiguration(dFile);

    }

    public void save(){

        try{

            dbNick.save(dFile);

        } catch(IOException e){

            Bukkit.getLogger().warning("[ Event ] Je ne peut pas sauvegarder le fichier 'database.yml' ! Plugin désactivé !");
            Bukkit.getPluginManager().disablePlugin(this);

        }

    }

    public void setNick(Player player, String nick){

        dbNick.set(player.getUniqueId().toString(), nick);
        save();
        player.setDisplayName(nick);

    }

}
