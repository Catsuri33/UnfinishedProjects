package fr.catsuri33.uhc.listeners;

import fr.catsuri33.uhc.game.Gamestates;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDrop implements Listener {

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e){

        Player player = e.getPlayer();

        if(Gamestates.isState(Gamestates.LOBBY) || Gamestates.isState(Gamestates.END)){

            e.setCancelled(true);

        }

    }

}
