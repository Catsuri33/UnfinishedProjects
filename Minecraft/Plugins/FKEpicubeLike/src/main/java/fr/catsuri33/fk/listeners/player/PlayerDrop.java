package fr.catsuri33.fk.listeners.player;

import fr.catsuri33.fk.utils.GameStates;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDrop implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.WAITING) && !p.getGameMode().equals(GameMode.CREATIVE)){

            e.setCancelled(true);

        }

    }

}
