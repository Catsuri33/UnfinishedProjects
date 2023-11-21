package fr.insignic.practice.listeners;

import fr.insignic.practice.Practice;
import fr.insignic.practice.game.Arenas;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();
        Arenas arena = Practice.getInstance().getArenasManager().getArenasByPlayer(p);

        if(arena != null){

            arena.eliminate(p);

        }

    }

}
