package com.insignic.insiads.listeners;

import com.insignic.insiads.InsiAds;
import com.insignic.insiads.database.DatabaseManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(p.isOp()){

            if(DatabaseManager.instance.getOwnerUUID(InsiAds.getInstance().getConfig().getString("server.id")).equals("")){

                DatabaseManager.instance.setOwnerUUID(InsiAds.getInstance().getConfig().getString("server.id"), p.getUniqueId().toString());
                p.sendMessage(InsiAds.getInstance().prefix + "Your Minecraft account has been registered as the owner of the server.");

            }

        }

    }

}
