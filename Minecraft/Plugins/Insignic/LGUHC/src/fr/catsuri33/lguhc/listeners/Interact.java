package fr.catsuri33.lguhc.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * LGUHC
 * Create the 10/07/2019
 *
 * @author Catsuri33
 * @version 1.0.0
 */

public class Interact implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){

        Player player = e.getPlayer();
        Action action = e.getAction();
        ItemStack it = e.getItem();

        if(it == null){

            return;

        }

    }

}
