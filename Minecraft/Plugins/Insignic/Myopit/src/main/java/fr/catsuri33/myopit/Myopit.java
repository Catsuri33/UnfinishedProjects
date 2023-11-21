package fr.catsuri33.myopit;

import fr.catsuri33.myopit.utils.ConsoleColors;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Myopit extends JavaPlugin  {

    public static Myopit instance;

    @Override
    public void onEnable() {

        instance = this;

        long start = System.currentTimeMillis();

        registerListeners();

        log(ConsoleColors.GREEN + "Plugin loaded in " + (System.currentTimeMillis() - start) + "ms !" + ConsoleColors.RESET);

        super.onEnable();

    }

    @Override
    public void onDisable() {

        HandlerList.unregisterAll(this);

        super.onDisable();

    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

    }

    public void log(String message){

        Bukkit.getConsoleSender().sendMessage( ConsoleColors.YELLOW + "[ Myopit ] " + ConsoleColors.RESET + message);

    }

}
