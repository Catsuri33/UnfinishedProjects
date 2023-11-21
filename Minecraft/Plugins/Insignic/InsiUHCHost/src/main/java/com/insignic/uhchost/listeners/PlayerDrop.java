package com.insignic.uhchost.listeners;

import com.insignic.uhchost.game.GameStates;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDrop implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e){

        Player p = e.getPlayer();
        ItemStack is = e.getItemDrop().getItemStack();

        if(GameStates.isState(GameStates.LOBBY) || GameStates.isState(GameStates.END)){

            e.setCancelled(true);

        }

    }

}
