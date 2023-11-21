package fr.odilonesport.fallenkingdoms.listeners.player;

import fr.odilonesport.fallenkingdoms.utils.GameStates;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDrop implements Listener {

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e){

        Player p = e.getPlayer();

        if(p.isOp() && p.getGameMode() == GameMode.CREATIVE){

            return;

        }

        if(GameStates.isState(GameStates.WAITING) || GameStates.isState(GameStates.END)){

            e.setCancelled(true);

        }

    }

}
