package fr.epicgiant.hub.listeners;

import fr.epicgiant.hub.database.Account;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        Player player = e.getPlayer();
        Account.getAccount(player).delete();

    }
}
