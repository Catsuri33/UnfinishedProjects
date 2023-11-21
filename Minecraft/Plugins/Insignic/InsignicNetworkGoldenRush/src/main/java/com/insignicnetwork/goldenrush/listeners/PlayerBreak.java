package com.insignicnetwork.goldenrush.listeners;

import com.insignicnetwork.goldenrush.game.GameStates;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerBreak implements Listener {

    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent e){

        Player p = e.getPlayer();
        Block b = e.getBlock();

        if(!p.getGameMode().equals(GameMode.CREATIVE) && !GameStates.isState(GameStates.GAME_MINE)){

            e.setCancelled(true);

        }

        if(GameStates.isState(GameStates.GAME_MINE)){

            if(p.getGameMode().equals(GameMode.CREATIVE)){

                e.setCancelled(false);

            } else {

                e.setCancelled(true);

            }

            if(b.getType().equals(Material.GOLD_ORE)){

                b.setType(Material.BEDROCK);
                p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));

            }

            if(b.getType().equals(Material.DIAMOND_ORE)){

                b.setType(Material.BEDROCK);
                p.getInventory().addItem(new ItemStack(Material.DIAMOND));

            }

        }

    }

}
