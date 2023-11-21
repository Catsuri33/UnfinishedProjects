package fr.epicgiant.api.bukkit.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler

    /**
     * Player quit the server
     */
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

    }

}
