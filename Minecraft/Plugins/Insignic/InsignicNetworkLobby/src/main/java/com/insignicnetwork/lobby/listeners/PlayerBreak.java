package com.insignicnetwork.lobby.listeners;

import com.insignicnetwork.lobby.Lobby;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreak implements Listener {

    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent e){

        Player p = e.getPlayer();

        if(!p.getGameMode().equals(GameMode.CREATIVE)){

            e.setCancelled(true);

        }

        if(Lobby.waitingLogin.contains(p.getUniqueId())){

            e.setCancelled(true);

        }

    }

}
