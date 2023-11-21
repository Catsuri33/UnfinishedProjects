package fr.insignicevents.global.listeners;

import fr.insignicevents.global.database.servers.ServersTable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(ServersTable.getMaintenanceState().equalsIgnoreCase("true")){

            if(!p.isOp()){

                p.kickPlayer("§b§lInsignic §r§fEvents\n \n§cLe serveur est en maintenance !\n§cPlus d'informations sur le Twitter: §6@InsignicEvents");

            }

        }

    }

}
