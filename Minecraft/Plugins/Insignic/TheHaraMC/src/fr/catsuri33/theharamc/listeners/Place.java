/*                              */
/*       TheHaraMC-UHC          */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 12/08/2019       */
/*    Updated: 12/08/2019       */
/*    Name: Place               */
/*                              */

package fr.catsuri33.theharamc.listeners;

import fr.catsuri33.theharamc.game.Gamestates;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Place implements Listener {

    @EventHandler
    public void onBlockBreak(BlockPlaceEvent e){

        if(Gamestates.isState(Gamestates.LOBBY) || Gamestates.isState(Gamestates.END)){

            e.setCancelled(true);

        }

    }

}
