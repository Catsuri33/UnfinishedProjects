package fr.insignicevents.skywars.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreak implements Listener {

    @EventHandler
    public void onPlayerBreak(BlockBreakEvent e){

        Player p = e.getPlayer();

        if(!p.isOp()){

            e.setCancelled(true);

        }

    }

}
