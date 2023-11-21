package fr.catsuri33.theharamc.listeners;

import fr.catsuri33.theharamc.UHC;
import fr.catsuri33.theharamc.game.Gamestates;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Pvp implements Listener {

    @EventHandler
    public void fakeDeath(EntityDamageByEntityEvent e){

        if(e.getEntity() instanceof Player){

            fakeDeath(e.getEntity(), e.getDamage());

        }

    }

    private void fakeDeath(Entity entity, double damage){

        Player player = (Player) entity;
        double health = player.getHealth();

        if(damage >= health){

            player.setGameMode(GameMode.SPECTATOR);
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§b[§6UHC§b] §6" + player.getName() + " §ea été tué §e!");
            Bukkit.broadcastMessage("");

            UHC.getInstance().playerInGame.remove(player.getUniqueId());

        }

    }

    @EventHandler
    public void fakeDamageDeath(EntityDamageByEntityEvent e){

        if(!Gamestates.isState(Gamestates.LOBBY) || !Gamestates.isState(Gamestates.GAME)){

            if(e.getCause() == EntityDamageEvent.DamageCause.FALL){

                if(e.getEntity() instanceof Player){

                    fakeDeath(e.getEntity(), e.getDamage());

                } else {

                    e.setCancelled(true);

                }

            }

        }

    }

}
