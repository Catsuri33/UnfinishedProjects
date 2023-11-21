package com.insignicnetwork.practice.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreak implements Listener {

    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent e){

        final Player p = e.getPlayer();

        if(!p.getGameMode().equals(GameMode.CREATIVE)){

            e.setCancelled(true);

        }

    }

}
