package fr.insignic.practice.listeners;

import fr.insignic.practice.Practice;
import fr.insignic.practice.game.Arenas;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamage implements Listener {

    @EventHandler
    public void onPlayerTakeDamageByPlayer(EntityDamageByEntityEvent e){

        if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){

            Player victim = (Player) e.getEntity();
            Player damager = (Player) e.getDamager();

            Arenas victimArena = Practice.getInstance().getArenasManager().getArenasByPlayer(victim);

            if(victimArena == null || !victimArena.getPlayers().contains(damager)){

                e.setCancelled(true);

            }

        }

    }

}
