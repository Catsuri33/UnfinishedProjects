package com.insignicnetwork.goldenrush.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlace implements Listener {

    @EventHandler
    public void onPlayerPlaceBlock(BlockPlaceEvent e){

        Player p = e.getPlayer();

        if(!p.getGameMode().equals(GameMode.CREATIVE)){

            e.setCancelled(true);

        }

    }

}
