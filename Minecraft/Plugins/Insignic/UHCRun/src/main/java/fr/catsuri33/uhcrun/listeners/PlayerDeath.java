package fr.catsuri33.uhcrun.listeners;

import fr.catsuri33.uhcrun.UHCRun;
import fr.catsuri33.uhcrun.game.GameStates;
import fr.catsuri33.uhcrun.lang.Messages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeathByEntity(EntityDamageByEntityEvent e){

        if(!GameStates.isState(GameStates.LOBBY) || GameStates.isState(GameStates.GAME)){

            if(e.getEntity() instanceof Player){

                fakeDeath(e.getEntity(), e.getDamage());

            }

        } else {

            e.setCancelled(true);

        }

    }

    @EventHandler
    public void onPlayerDeathByDamage(EntityDamageEvent e){

        if(!GameStates.isState(GameStates.LOBBY) || GameStates.isState(GameStates.GAME)){

            if(e.getEntity() instanceof Player){

                fakeDeath(e.getEntity(), e.getDamage());

            }

        } else {

            e.setCancelled(true);

        }

    }

    public void fakeDeath(Entity entity, double damages) {

        Player p = (Player)entity;

        double health = p.getHealth();

        if(damages >= health){

            p.setGameMode(GameMode.SPECTATOR);

            if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("en")){

                Bukkit.broadcastMessage(Messages.PREFIX.getMessage() + "§e" + p.getName() + " was killed !");
                UHCRun.getInstance().playersInGame.remove(p);

            }

            if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("fr")){

                Bukkit.broadcastMessage(Messages.PREFIX.getMessage() + "§e" + p.getName() + " a été tué !");
                UHCRun.getInstance().playersInGame.remove(p);

            }

        }

    }

}
