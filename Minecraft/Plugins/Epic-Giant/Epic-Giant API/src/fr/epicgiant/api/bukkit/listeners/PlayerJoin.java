package fr.epicgiant.api.bukkit.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler

    /**
     * Player join the server
     */
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

    }

}
