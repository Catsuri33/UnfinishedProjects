package com.insignic.uhchost.listeners;

import com.insignic.uhchost.game.GameStates;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamage implements Listener {

    @EventHandler
    public void onPlayerTakeDamage(EntityDamageEvent e){

        if(e.getEntity() instanceof Player){

            Player p = (Player) e.getEntity();

            if(GameStates.isState(GameStates.LOBBY) || GameStates.isState(GameStates.END)){

                e.setCancelled(true);

            }

        }

    }

}
