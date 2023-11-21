package fr.catsuri33.fk.listeners.entity;

import org.bukkit.Bukkit;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MobsSpawn implements Listener {

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e){

        if(e.getEntityType() == EntityType.CREEPER){

            if((Math.random() * 100) <= 50){

                Creeper creeper = (Creeper) Bukkit.getWorlds().get(0).spawnEntity(e.getEntity().getLocation(), EntityType.CREEPER);
                creeper.setPowered(true);

                e.getEntity().remove();

            }

        }

    }

}
