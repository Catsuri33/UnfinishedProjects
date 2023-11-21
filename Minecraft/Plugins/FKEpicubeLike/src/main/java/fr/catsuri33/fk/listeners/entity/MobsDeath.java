package fr.catsuri33.fk.listeners.entity;

import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class MobsDeath implements Listener {

    @EventHandler
    public void onCreatureDie(EntityDeathEvent e){

        if(e.getEntity() instanceof Creeper){

            Creeper creeper = (Creeper) e.getEntity();

            if(creeper.isPowered()){

                creeper.getWorld().dropItem(creeper.getLocation(), new ItemStack(Material.TNT, 1));

            }

        }

        if(e.getEntity() instanceof Zombie){

            Zombie zombie = (Zombie) e.getEntity();

            zombie.getWorld().dropItem(zombie.getLocation(), new ItemStack(Material.SAND, 2));

        }

        if(e.getEntity() instanceof Enderman){

            Enderman enderman = (Enderman) e.getEntity();

            if((Math.random() * 100) <= 30){

                enderman.getWorld().dropItem(enderman.getLocation(), new ItemStack(Material.DIAMOND, 2));

            } else {

                enderman.getWorld().dropItem(enderman.getLocation(), new ItemStack(Material.GOLDEN_APPLE, 1));

            }

        }

    }

}
