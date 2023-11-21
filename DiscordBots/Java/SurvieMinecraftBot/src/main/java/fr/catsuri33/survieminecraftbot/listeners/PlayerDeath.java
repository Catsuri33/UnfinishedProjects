package fr.catsuri33.survieminecraftbot.listeners;

import fr.catsuri33.survieminecraftbot.SurvieMinecraftBot;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerDeath implements Listener {

    private final SurvieMinecraftBot main;

    public PlayerDeath(SurvieMinecraftBot main){

        this.main = main;

    }

    @EventHandler
    public void onPlayerDeath(EntityDeathEvent e){

        Entity ent = e.getEntity();
        EntityDamageEvent entDamageE = ent.getLastDamageCause();
        EntityDamageEvent.DamageCause dc = entDamageE.getCause();

        if(ent instanceof Player && dc == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION){

            Player p = (Player) ent;

            main.sendMessageToDiscord(p.getPlayer(), p.getPlayer().getName() + " a été tué par une explosion !");

        }

        if(ent instanceof Player && dc == EntityDamageEvent.DamageCause.CRAMMING){

            Player p = (Player) ent;

            main.sendMessageToDiscord(p.getPlayer(), p.getPlayer().getName() + " a été tué brulé !");

        }

        if(ent instanceof Player && dc == EntityDamageEvent.DamageCause.DROWNING){

            Player p = (Player) ent;

            main.sendMessageToDiscord(p.getPlayer(), p.getPlayer().getName() + " s'est noyé !");

        }

        if(ent instanceof Player && dc == EntityDamageEvent.DamageCause.FALL){

            Player p = (Player) ent;

            main.sendMessageToDiscord(p.getPlayer(), p.getPlayer().getName() + " est mort de chute !");

        }

        if(ent instanceof Player && dc == EntityDamageEvent.DamageCause.LAVA){

            Player p = (Player) ent;

            main.sendMessageToDiscord(p.getPlayer(), p.getPlayer().getName() + " est mort dans la lave !");

        }

        if(ent instanceof Player && dc == EntityDamageEvent.DamageCause.SUFFOCATION){

            Player p = (Player) ent;

            main.sendMessageToDiscord(p.getPlayer(), p.getPlayer().getName() + " a suffoqué !");

        }

        if(ent instanceof Player && dc == EntityDamageEvent.DamageCause.VOID){

            Player p = (Player) ent;

            main.sendMessageToDiscord(p.getPlayer(), p.getPlayer().getName() + " est tombé dans le vide !");

        }

        if(ent instanceof Player && dc == EntityDamageEvent.DamageCause.ENTITY_ATTACK){

            Player p = (Player) ent;

            main.sendMessageToDiscord(p.getPlayer(), p.getPlayer().getName() + " a été tué par " + p.getKiller() + " !");

        }

    }

}
