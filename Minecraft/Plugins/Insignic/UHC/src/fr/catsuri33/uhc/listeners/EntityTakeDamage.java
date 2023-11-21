package fr.catsuri33.uhc.listeners;

import fr.catsuri33.uhc.game.Gamestates;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityTakeDamage implements Listener {

    @EventHandler
    public void onEntityTakeDamage(EntityDamageEvent e){

        if(Gamestates.isState(Gamestates.LOBBY) || Gamestates.isState(Gamestates.END)){

            e.setCancelled(true);

        }

    }

}
