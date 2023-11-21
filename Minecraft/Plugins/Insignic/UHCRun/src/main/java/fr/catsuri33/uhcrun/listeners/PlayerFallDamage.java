package fr.catsuri33.uhcrun.listeners;

import fr.catsuri33.uhcrun.game.GameStates;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerFallDamage implements Listener {

    @EventHandler
    public void onPlayerTakeDamageByFall(EntityDamageEvent e){

        if(e.getEntity() instanceof Player){

            if(GameStates.isState(GameStates.LOBBY) || GameStates.isState(GameStates.GAME)){

                if(e.getCause() == EntityDamageEvent.DamageCause.FALL){

                    e.setCancelled(true);

                }

            }

        }

    }

}
