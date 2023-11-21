package fr.catsuri33.uhc.listeners;

import fr.catsuri33.uhc.game.Gamestates;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){

        if(Gamestates.isState(Gamestates.LOBBY) || Gamestates.isState(Gamestates.END)){

            e.setCancelled(true);

        }

    }

}
