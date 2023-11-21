package fr.catsuri33.insiac;

import fr.catsuri33.insiac.commands.BanCommands;
import fr.catsuri33.insiac.listeners.PlayerJoin;
import fr.catsuri33.insiac.listeners.PlayerLogin;
import fr.catsuri33.insiac.mysql.PlayersMySQL;
import fr.catsuri33.insiac.mysql.ServersMySQL;
import fr.catsuri33.insiac.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class InsiAC extends JavaPlugin {

    private static InsiAC INSTANCE;
    public ServersMySQL mySQL;
    public PlayersMySQL playersMySQL = new PlayersMySQL();

    @Override
    public void onEnable() {

        INSTANCE = this;

        mySQL = new ServersMySQL("jdbc:mysql://", "IP:PORT", "insiac", "root", "password");
        mySQL.connect();

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        registerListeners();
        registerCommands();

        mySQL.addServer(InsiAC.getInstance().getConfig().getString("server-name"), InsiAC.getInstance().getConfig().getString("server-password"));

        if(mySQL.isPasswordCorrect(InsiAC.getInstance().getConfig().getString("server-name"))){

            if(!InsiAC.getInstance().getConfig().getString("server-name").equals("Default")){

                Logger.success("Server password correct, welcome back " + InsiAC.getInstance().getConfig().getString("server-name") + " !");

            } else {

                Logger.warn("Warning, you are currently using the 'Default' server, please change it in the config file with your server name and put a password !");

            }

        } else {

            Logger.error("Server password incorrect, please change it !");

        }

        if(mySQL.isPasswordCorrect(InsiAC.getInstance().getConfig().getString("server-name"))){

            mySQL.setServerState(InsiAC.getInstance().getConfig().getString("server-name"), "Online");

        }

        Logger.info("Plugin enabled !");

        super.onEnable();

    }

    @Override
    public void onDisable() {

        if(mySQL.isPasswordCorrect(InsiAC.getInstance().getConfig().getString("server-name"))){

            mySQL.setServerState(InsiAC.getInstance().getConfig().getString("server-name"), "Offline");

        }

        mySQL.disconnect();

        Logger.info("Plugin disabled !");

        super.onDisable();

    }

    public static InsiAC getInstance(){

        return INSTANCE;

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerLogin(), this);

    }

    public void registerCommands(){

        getCommand("ban").setExecutor(new BanCommands());
        getCommand("unban").setExecutor(new BanCommands());
        getCommand("check").setExecutor(new BanCommands());

    }

}
