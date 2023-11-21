package com.insignic.uhchost.listeners;

import com.insignic.uhchost.game.guis.PotionsInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.potion.PotionEffect;

public class PlayerPotion implements Listener {

    @EventHandler
    public static void onPlayerPotion(EntityPotionEffectEvent e){

        if(e.getEntity() instanceof Player){

            Player p = (Player) e.getEntity();
            EntityPotionEffectEvent.Action action = e.getAction();

            if(action.equals(EntityPotionEffectEvent.Action.ADDED)){

                if(PotionsInventory.night_vision_1_potion){

                    for (PotionEffect effect : p.getActivePotionEffects()){

                        p.removePotionEffect(effect.getType());

                    }

                }

            }

        }

    }

}
