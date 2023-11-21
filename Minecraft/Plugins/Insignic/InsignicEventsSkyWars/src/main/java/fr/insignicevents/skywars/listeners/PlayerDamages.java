package fr.insignicevents.skywars.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamages implements Listener {

    @EventHandler
    public void onPlayerTakeDamageByEntity(EntityDamageEvent e){

        if(e.getEntity() instanceof Player){

            Player p = (Player) e.getEntity();

            e.setCancelled(true);

        }

    }

}
