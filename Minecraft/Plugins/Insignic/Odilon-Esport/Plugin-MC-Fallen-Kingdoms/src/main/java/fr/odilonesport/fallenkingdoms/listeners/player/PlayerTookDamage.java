package fr.odilonesport.fallenkingdoms.listeners.player;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.runnables.GameRunnable;
import fr.odilonesport.fallenkingdoms.utils.GameStates;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerTookDamage implements Listener {

    @EventHandler
    public void onPlayerTookDamage(EntityDamageEvent e){

        if(e.getEntity() instanceof Player){

            Player p = (Player) e.getEntity();

            if(GameStates.isState(GameStates.WAITING) || GameStates.isState(GameStates.END)){

                e.setCancelled(true);

            }

            if(GameStates.isState(GameStates.GAME) || GameStates.isState(GameStates.ASSAULTS)){

                if(e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK) && e.getEntity().getLastDamageCause().getEntity() instanceof Player){

                    if(GameRunnable.days <= Main.getInstance().getConfig().getInt("game.timers.pvp")){

                        e.setCancelled(true);

                    }

                }

            }

        }

    }

}
