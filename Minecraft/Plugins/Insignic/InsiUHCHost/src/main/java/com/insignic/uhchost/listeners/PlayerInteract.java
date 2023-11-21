package com.insignic.uhchost.listeners;

import com.insignic.uhchost.game.guis.HostCustomisationInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack item = e.getItem();

        if(item == null) return;

        if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)){

            if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§eHost") && item.getType().equals(Material.CHEST)){

                p.openInventory(HostCustomisationInventory.inv);

            }

        }

    }

}
