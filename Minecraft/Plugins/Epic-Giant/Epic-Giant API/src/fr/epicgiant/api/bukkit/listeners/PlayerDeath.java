package fr.epicgiant.api.bukkit.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler

    /**
     * Player death.
     */
    public void onPlayerDeath(PlayerDeathEvent e){

        Player p = e.getEntity();

    }

}
