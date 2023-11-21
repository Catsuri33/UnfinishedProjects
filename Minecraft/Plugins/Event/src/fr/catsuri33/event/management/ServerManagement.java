package fr.catsuri33.event.management;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ServerManagement {

    public static void kickAll(){

        for(Player player : Bukkit.getOnlinePlayers()){

            if(player.isOp()){
                continue;
            } else {

                player.kickPlayer("§cVous avez été kick par un Administrateur !\n§f(KickAll)");

            }

        }

    }

    public static void kickOnShutdown(){

        for(Player player : Bukkit.getOnlinePlayers()){

            player.kickPlayer("§cVous avez été kick ! \n§f(Restart du Serveur)");

        }

    }

}
