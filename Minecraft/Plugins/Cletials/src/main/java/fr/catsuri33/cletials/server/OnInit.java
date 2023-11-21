package fr.catsuri33.cletials.server;

import org.bukkit.Bukkit;

public class OnInit {

    public static void createServer(){

        String serverName = Bukkit.getServer().getName();
        String serverIP = Bukkit.getServer().getIp();
        int serverPort = Bukkit.getServer().getPort();
        String serverVersion = Bukkit.getServer().getVersion();

        System.out.println(serverName + " | " + serverIP + " | " + serverPort + " | " + serverVersion);

    }

}
