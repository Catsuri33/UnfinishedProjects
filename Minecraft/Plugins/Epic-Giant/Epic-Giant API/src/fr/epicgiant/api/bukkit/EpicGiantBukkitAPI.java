package fr.epicgiant.api.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EpicGiantBukkitAPI extends JavaPlugin {

    static EpicGiantBukkitAPI instance;

    public void onEnable(){

        instance = this;
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    }

    @Override
    public void onDisable() {



    }

    public static EpicGiantBukkitAPI getInstance(){

        return instance;

    }
}
