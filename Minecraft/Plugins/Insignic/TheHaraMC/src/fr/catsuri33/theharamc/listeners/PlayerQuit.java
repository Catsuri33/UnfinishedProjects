/*                              */
/*       TheHaraMC-UHC          */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 12/08/2019       */
/*    Updated: 12/08/2019       */
/*    Name: PlayerQuit          */
/*                              */

package fr.catsuri33.theharamc.listeners;

import fr.catsuri33.theharamc.UHC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player player = e.getPlayer();

        UHC.getInstance().playerInGame.remove(player.getUniqueId());

    }

}
