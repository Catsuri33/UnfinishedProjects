package fr.insignicevents.tnttag;

import fr.insignicevents.tnttag.listeners.PlayerJoin;
import fr.insignicevents.tnttag.listeners.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class TntTag extends JavaPlugin {

    public static TntTag instance;

    public Connection connection;
    public static String host, database, username, password, table;
    public static int port;

    public HashMap<UUID, PlayerManager> playerManager = new HashMap<>();

    @Override
    public void onEnable() {

        instance = this;

        registerListeners();
        registerCommands();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        mysqlSetup();

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static TntTag getInstance() {

        return instance;

    }

    private void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);

    }

    private void registerCommands(){



    }

    public static void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ InsignicEventsTntTag ] " + message);

    }

    public void mysqlSetup(){

        host = "localhost";
        port = 3306;
        database = "insignic_events";
        username = "root";
        password = "password";
        table = "";

        try {

            if(getConnection() != null && !getConnection().isClosed()){

                return;

            }

            Class.forName("com.mysql.jdbc.Driver");
            setConnection(DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", username, password));

            TntTag.log("Connected to the database !");

        } catch(SQLException e) {

            e.printStackTrace();

        } catch(ClassNotFoundException e){

            e.printStackTrace();

        }

    }

    public Connection getConnection() {

        return connection;

    }

    public void setConnection(Connection connection) {

        this.connection = connection;

    }

}
