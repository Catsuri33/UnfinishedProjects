package fr.insignicevents.bungeecord;

import fr.insignicevents.bungeecord.database.servers.ServersTable;
import fr.insignicevents.bungeecord.listeners.ProxyPing;
import net.md_5.bungee.api.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bungeecord extends Plugin {

    public static Bungeecord instance;

    public Connection connection;
    public static String host, database, username, password, table;
    public static int port;

    @Override
    public void onEnable() {

        instance = this;

        mysqlSetup();

        getProxy().getPluginManager().registerListener(this, new ProxyPing());

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static Bungeecord getInstance() {

        return instance;

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
