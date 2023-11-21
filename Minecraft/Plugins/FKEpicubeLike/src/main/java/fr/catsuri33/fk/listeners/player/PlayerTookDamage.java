package fr.catsuri33.fk.listeners.player;

import fr.catsuri33.fk.utils.GameStates;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerTookDamage implements Listener {

    @EventHandler
    public void onPlayerTookDamage(EntityDamageEvent e){

        if(e.getEntity() instanceof Player){

            Player p = (Player) e.getEntity();

            if(GameStates.isState(GameStates.WAITING)){

                e.setCancelled(true);
                return;

            }

        }

    }

}
