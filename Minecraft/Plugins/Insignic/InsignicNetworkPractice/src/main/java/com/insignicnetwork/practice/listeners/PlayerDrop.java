package com.insignicnetwork.practice.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDrop implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e){

        final Player p = e.getPlayer();

        e.setCancelled(true);


    }

}
