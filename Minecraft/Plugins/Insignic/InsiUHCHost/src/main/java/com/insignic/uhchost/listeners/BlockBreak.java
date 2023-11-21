package com.insignic.uhchost.listeners;

import com.insignic.uhchost.game.GameStates;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.LOBBY) || GameStates.isState(GameStates.END)){

            if(!p.getGameMode().equals(GameMode.CREATIVE)){

                e.setCancelled(true);

            }

        }

    }

}
