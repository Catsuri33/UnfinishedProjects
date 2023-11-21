package com.insignic.uhchost.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        Player p = e.getPlayer();

        if(p.isOp() || p.hasPermission("insiuhc.host")){

            e.setFormat("%1$s §r§e» §r%2$s");

        } else {

            e.setFormat("§7%1$s §8» §7%2$s");

        }

    }

}
