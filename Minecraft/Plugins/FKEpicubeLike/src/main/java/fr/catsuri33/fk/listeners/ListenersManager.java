package fr.catsuri33.fk.listeners;

import fr.catsuri33.fk.listeners.entity.MobsDeath;
import fr.catsuri33.fk.listeners.entity.MobsSpawn;
import fr.catsuri33.fk.listeners.item.InventoryClick;
import fr.catsuri33.fk.listeners.player.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {

    public Plugin plugin;
    public PluginManager pluginManager;

    public ListenersManager(Plugin plugin){

        this.plugin = plugin;
        this.pluginManager = Bukkit.getPluginManager();

        registerListeners();

    }

    public void registerListeners(){

        pluginManager.registerEvents(new PlayerJoin(), this.plugin);
        pluginManager.registerEvents(new PlayerQuit(), this.plugin);
        pluginManager.registerEvents(new PlayerDrop(), this.plugin);
        pluginManager.registerEvents(new PlayerPlace(), this.plugin);
        pluginManager.registerEvents(new PlayerBreak(), this.plugin);
        pluginManager.registerEvents(new PlayerMove(), this.plugin);
        pluginManager.registerEvents(new PlayerInteract(), this.plugin);
        pluginManager.registerEvents(new PlayerTookDamage(), this.plugin);
        pluginManager.registerEvents(new FurnaceProperty(), this.plugin);

        // Guis
        pluginManager.registerEvents(new InventoryClick(), this.plugin);

        // Mobs
        pluginManager.registerEvents(new MobsSpawn(), this.plugin);
        pluginManager.registerEvents(new MobsDeath(), this.plugin);

    }

}
