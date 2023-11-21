package com.insignic.uhchost.listeners;

import com.insignic.uhchost.UHCHost;
import com.insignic.uhchost.game.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.LOBBY)){

            if(p.getLocation().getY() < 180){

                p.teleport(new Location(Bukkit.getWorld("world"), 0, 201, 0));
                p.sendMessage(UHCHost.prefix + "§cAttention à ne pas tomber !");

            }

        }

    }

}
