package fr.catsuri33.sc.listeners;

import fr.catsuri33.sc.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){

        Player p= e.getPlayer();

        if(e.getBlockPlaced().getWorld().getName().equalsIgnoreCase(Main.configManager.getServerConfiguration().getString("server.spawn-location.world-name"))){

            if(!p.isOp() || !p.hasPermission("spawn.place")){

                e.setCancelled(true);

            }

        }

    }

}
