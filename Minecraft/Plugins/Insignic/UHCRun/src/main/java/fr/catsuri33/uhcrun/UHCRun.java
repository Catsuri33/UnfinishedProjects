package fr.catsuri33.uhcrun;

import fr.catsuri33.uhcrun.game.GameStates;
import fr.catsuri33.uhcrun.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.UUID;

public class UHCRun extends JavaPlugin {

    public static UHCRun instance;

    public ArrayList<UUID> playersInGame = new ArrayList<>();

    @Override
    public void onEnable() {

        instance = this;

        setupSlots();
        registerListeners();
        registerCommands();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        GameStates.setState(GameStates.LOBBY);
        Bukkit.getWorld("world").setPVP(false);

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static UHCRun getInstance() {

        return instance;

    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerFallDamage(), this);
        pm.registerEvents(new PlayerCraftUpgrade(), this);
        pm.registerEvents(new BlockDrops(), this);
        pm.registerEvents(new PlayerDeath(), this);

    }

    private void registerCommands(){



    }

    public static void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ UHCRun ] " + message);

    }

    private void setupSlots(){

        try {

            this.changeSlots(getConfig().getInt("player-max"));

        } catch(ReflectiveOperationException e) {

            e.printStackTrace();

        }

    }

    public void changeSlots(int slots) throws ReflectiveOperationException {

        Method serverGetHandle = getServer().getClass().getDeclaredMethod("getHandle");

        Object playerList = serverGetHandle.invoke(getServer());
        Field maxPlayersField = playerList.getClass().getSuperclass().getDeclaredField("maxPlayers");

        maxPlayersField.setAccessible(true);
        maxPlayersField.set(playerList, slots);

    }

}
