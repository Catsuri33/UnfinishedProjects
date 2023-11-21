package fr.catsuri33.sc.listeners;

import fr.catsuri33.sc.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        Player p = e.getPlayer();

        if(e.getBlock().getWorld().getName().equalsIgnoreCase(Main.configManager.getServerConfiguration().getString("server.spawn-location.world-name"))){

            if(!p.isOp() || !p.hasPermission("spawn.break")){

                e.setCancelled(true);

            }

        }

    }

}
