package fr.insignicevents.global.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ServerManagement {

    public static void kickAllNonOpForMaintenance(){

        for(Player players : Bukkit.getOnlinePlayers()){

            if(!players.isOp()){

                players.kickPlayer("§b§lInsignic §r§fEvents\n \n§cLe serveur entre en maintenance !\n§cPlus d'informations sur le Twitter: §6@InsignicEvents");

            }

        }

    }

}
