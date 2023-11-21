package fr.catsuri33.sc.listeners;

import fr.catsuri33.sc.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerTakeDamage implements Listener {

    @EventHandler
    public void onPlayerTakeDamage(EntityDamageEvent e){

        if(e.getEntity() instanceof Player){

            Player p = (Player) e.getEntity();

            if(p.getWorld().getName().equals(Main.configManager.getServerConfiguration().getString("server.spawn-location.world-name"))){

                e.setCancelled(true);

            }

        }

    }

}
