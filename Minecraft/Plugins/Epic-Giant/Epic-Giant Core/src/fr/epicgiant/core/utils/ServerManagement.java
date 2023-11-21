package fr.epicgiant.core.utils;

import fr.epicgiant.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ServerManagement {

    public static void kickAllNotAllowedMaintenance(){

        for(Player player : Bukkit.getOnlinePlayers()){

            if(player.isOp() || Main.getAuthorizedMaintenance().contains(player.getUniqueId())){
                continue;
            } else {

                player.kickPlayer("§r §6§lEpic-Giant\n §cThe server enter in maintenance !");

            }

        }

    }

    public static void kickAll(){

        for(Player player : Bukkit.getOnlinePlayers()){

            if(player.isOp() || Main.getAuthorizedMaintenance().contains(player.getUniqueId())){
                continue;
            } else {

                player.kickPlayer("§r §6§lEpic-Giant\n §CYou have been kicked by an Administrator !");

            }

        }

    }

}
