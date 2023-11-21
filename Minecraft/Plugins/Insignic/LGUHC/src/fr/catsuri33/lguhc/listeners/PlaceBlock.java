package fr.catsuri33.lguhc.listeners;

import fr.catsuri33.lguhc.game.Gamestates;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * LGUHC
 * Create the 10/07/2019
 *
 * @author Catsuri33
 * @version 1.0.0
 */

public class PlaceBlock implements Listener {

    public void onBlockPlace(BlockPlaceEvent e){

        if(Gamestates.isState(Gamestates.LOBBY)){

            e.setCancelled(true);

        }

    }

}
