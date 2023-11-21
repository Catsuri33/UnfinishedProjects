package com.epicgiant.hub.listeners;

import com.epicgiant.hub.EpicGiant;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();
        Inventory inventory = player.getInventory();
        ItemStack[] itemStacks = inventory.getContents();

        for(ItemStack itemStack : itemStacks){

            if(itemStack.getType() == EpicGiant.gamesItem.getType()){

                if(itemStack.hasItemMeta()){

                    if(itemStack.getItemMeta().getDisplayName().equals(EpicGiant.gamesItem.getItemMeta().getDisplayName())){

                        return;

                    }

                }

            }

        }

        inventory.addItem(EpicGiant.gamesItem);

    }

}
