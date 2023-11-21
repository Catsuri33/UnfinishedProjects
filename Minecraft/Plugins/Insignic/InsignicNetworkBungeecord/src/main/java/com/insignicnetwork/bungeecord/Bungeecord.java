package com.insignicnetwork.bungeecord;

import com.insignicnetwork.bungeecord.commands.FriendCommands;
import com.insignicnetwork.bungeecord.listeners.PlayerJoin;
import com.insignicnetwork.bungeecord.listeners.PlayerQuit;
import com.insignicnetwork.bungeecord.listeners.ProxyPing;
import com.insignicnetwork.bungeecord.mysql.PlayersMySQL;
import com.insignicnetwork.bungeecord.servers.Servers;
import com.insignicnetwork.bungeecord.servers.ServersCommon;
import com.insignicnetwork.bungeecord.servers.ServersType;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;

public class Bungeecord extends Plugin {

    public static Bungeecord instance;
    public PlayersMySQL mySQL;

    public HashMap<ServersType, String[]> path;
    public HashMap<String, Servers> servers;

    @Override
    public void onEnable() {

        instance = this;

        path = new HashMap<ServersType, String[]>(){{

            this.put(ServersType.LOBBY, new String[]{ "/home/pi/Desktop/InsignicNetwork/Serveurs/Lobby0%id%".replace('/', File.separatorChar) });

        }};

        servers = new HashMap<>();
        this.addServer(ServersType.LOBBY, "Lobby01", 25566);

        mySQL = new PlayersMySQL("jdbc:mysql://", "localhost", "insignic_network", "root", "password");
        mySQL.connect();

        //this.getProxy().getScheduler().schedule(this, new ServersRunnable(), 1, 5, TimeUnit.SECONDS);

        getProxy().getPluginManager().registerListener(this, new ProxyPing());
        getProxy().getPluginManager().registerListener(this, new PlayerJoin());
        getProxy().getPluginManager().registerListener(this, new PlayerQuit());

        ProxyServer.getInstance().getPluginManager().registerCommand(this, new FriendCommands());

        this.getProxy().getScheduler().runAsync(this, new Runnable() {

            @Override
            public void run() {

                try {

                    PlayersMySQL.openConnection();
                    Statement statement = PlayersMySQL.getConnection().createStatement();

                } catch(ClassNotFoundException | SQLException e) {

                    e.printStackTrace();

                }

            }

        });

        super.onEnable();

    }

    @Override
    public void onDisable() {

        mySQL.disconnect();

        super.onDisable();

    }

    public static Bungeecord getInstance() {

        return instance;

    }

    public void log(String message){

        ProxyServer.getInstance().getLogger().log(Level.INFO, "[ InsignicNetworkEssentials ] " + message);

    }

    public  void addServer(ServersType serverType, String name, int port){

        servers.put(name, new Servers(serverType, new ServersCommon(name), ProxyServer.getInstance().constructServerInfo(name, new InetSocketAddress("localhost", port), "", false)));

    }

}
