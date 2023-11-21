package fr.insignicevents.skywars.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlace implements Listener {

    @EventHandler
    public void onPlayerPlace(BlockPlaceEvent e){

        Player p = e.getPlayer();

        if(!p.isOp()){

            e.setCancelled(true);

        }

    }

}
