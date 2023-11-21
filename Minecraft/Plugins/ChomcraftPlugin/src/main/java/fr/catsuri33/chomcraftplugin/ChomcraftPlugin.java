package fr.catsuri33.chomcraftplugin;

import fr.catsuri33.chomcraftplugin.listeners.PlayerChat;
import fr.catsuri33.chomcraftplugin.listeners.PlayerJoin;
import fr.catsuri33.chomcraftplugin.listeners.PlayerQuit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ChomcraftPlugin extends JavaPlugin {

    private static ChomcraftPlugin INSTANCE;

    @Override
    public void onEnable() {

        registerListeners();
        registerCommands();

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static ChomcraftPlugin getInstance(){

        return INSTANCE;

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerChat(), this);

    }

    public void registerCommands(){



    }

}
