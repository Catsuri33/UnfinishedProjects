package fr.insignic.practice.listeners;

import fr.insignic.practice.Practice;
import fr.insignic.practice.game.Arenas;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(EntityDeathEvent e){

        if(e.getEntity() instanceof Player){

            Player victim = (Player) e.getEntity();
            Player killer = victim.getKiller();
            Arenas arena = Practice.getInstance().getArenasManager().getArenasByPlayer(killer);

            if(arena != null){

                arena.eliminate(victim);

            }

        }

    }

}
