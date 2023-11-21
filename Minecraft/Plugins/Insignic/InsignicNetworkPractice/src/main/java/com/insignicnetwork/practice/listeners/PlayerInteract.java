package com.insignicnetwork.practice.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack is = e.getItem();

        if(is == null){

            return;

        }

        e.setCancelled(true);

    }

}
