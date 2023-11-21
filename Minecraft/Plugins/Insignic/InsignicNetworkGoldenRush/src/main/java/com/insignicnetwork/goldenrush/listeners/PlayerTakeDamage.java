package com.insignicnetwork.goldenrush.listeners;

import com.insignicnetwork.goldenrush.game.GameStates;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerTakeDamage implements Listener {

    @EventHandler
    public void onPlayerTakeDamage(EntityDamageEvent e){

        if(e.getEntity() instanceof Player){

            Player p = (Player) e.getEntity();

            if(GameStates.isState(GameStates.LOBBY) || GameStates.isState(GameStates.GAME_MINE) || GameStates.isState(GameStates.GAME_SHOP)){

                e.setCancelled(true);

            }

        }

    }

}
