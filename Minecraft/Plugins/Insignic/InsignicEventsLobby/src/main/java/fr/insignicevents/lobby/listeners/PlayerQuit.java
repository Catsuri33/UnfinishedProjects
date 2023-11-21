package fr.insignicevents.lobby.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        e.setQuitMessage("§7(§c-§7) §f" + p.getName());

    }

}
