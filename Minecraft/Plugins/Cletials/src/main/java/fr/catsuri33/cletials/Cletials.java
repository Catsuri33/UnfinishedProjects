package fr.catsuri33.cletials;

import fr.catsuri33.cletials.database.MySQLServer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Cletials extends JavaPlugin {

    public static Cletials INSTANCE;

    @Override
    public void onEnable() {

        INSTANCE = this;

        registerListeners();
        registerCommands();

        MySQLServer.mysqlServerSetup();
        OnInit.createServer();

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

    }

    public static void registerCommands(){



    }

}
