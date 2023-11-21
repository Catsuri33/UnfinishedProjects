package com.insignic.uhchost.listeners;

import com.insignic.uhchost.UHCHost;
import com.insignic.uhchost.game.guis.NetherInventory;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

public class PlayerCreatePortal implements Listener {

    @EventHandler
    public void onPlayerCreatePortal(PortalCreateEvent e){

        if(e.getEntity() instanceof Player){

            Player p = (Player) e.getEntity();

            if(!NetherInventory.netherState){

                p.sendMessage(UHCHost.prefix + "§cLe nether est désactivé durant cette partie !");

                for(BlockState blocks : e.getBlocks()){

                    if(blocks.getBlock().getType().equals(Material.OBSIDIAN)){

                        blocks.getBlock().setType(Material.AIR);

                    }

                }

            }

        }

    }

}
