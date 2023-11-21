package fr.catsuri33.aoe;

import fr.catsuri33.aoe.game.GameStates;
import fr.catsuri33.aoe.items.ItemsList;
import fr.catsuri33.aoe.listeners.PlayerClick;
import fr.catsuri33.aoe.listeners.PlayerInteract;
import fr.catsuri33.aoe.listeners.PlayerJoin;
import fr.catsuri33.aoe.listeners.PlayerQuit;
import fr.catsuri33.aoe.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AgeOfEmpires extends JavaPlugin {

    public static AgeOfEmpires instance;

    @Override
    public void onEnable() {

        instance = this;

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        registerListeners();
        registerCommands();

        GameStates.setState(GameStates.LOBBY);

        ItemsList.createTeamInventory();

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
        pm.registerEvents(new PlayerInteract(), this);
        pm.registerEvents(new PlayerClick(), this);

    }

    public void registerCommands(){



    }

    public static AgeOfEmpires getInstance(){

        return instance;

    }

}
