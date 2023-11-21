package com.epicgiant.hub.listeners;

import com.epicgiant.hub.EpicGiant;
import com.epicgiant.hub.network.Servers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){

        Player player = e.getPlayer();
        Action action = e.getAction();
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){

            if(itemStack.getType().equals(EpicGiant.gamesItem.getType())){

                if(itemStack.hasItemMeta()){

                    if(itemStack.getItemMeta().getDisplayName().equals(EpicGiant.gamesItem.getItemMeta().getDisplayName())){

                        Inventory menu = Bukkit.createInventory(player, InventoryType.CHEST, "§a§lMenu des Jeux");

                        for(Servers servers : Servers.values()){

                            menu.addItem(servers.getItemStack());

                        }

                        player.openInventory(menu);

                    }

                }

            }

        }

    }

}
