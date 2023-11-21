package fr.catsuri33.lguhc.listeners;

import fr.catsuri33.lguhc.game.Gamestates;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * LGUHC
 * Create the 10/07/2019
 *
 * @author Catsuri33
 * @version 1.0.0
 */

public class BreakBlock implements Listener {

    public void onBlockBreak(BlockBreakEvent e){

        if(Gamestates.isState(Gamestates.LOBBY)){

            e.setCancelled(true);

        }

    }

}
