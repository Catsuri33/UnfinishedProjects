package fr.catsuri33.uhc.listener;

import fr.catsuri33.uhc.UHC;
import fr.catsuri33.uhc.listener.listeners.PlayerJoinAndQuit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class LoadListeners {

    public static void loadListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoinAndQuit(), UHC.getInstance());

    }

}
