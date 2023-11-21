package com.insignicnetwork.lobby.listeners;

import com.insignicnetwork.lobby.Lobby;
import com.insignicnetwork.lobby.guis.LobbyGuis;
import com.insignicnetwork.lobby.utils.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        if(Lobby.waitingLogin.contains(p.getUniqueId())){

            Lobby.waitingLogin.remove(p.getUniqueId());

        }

        for(Player players : Bukkit.getOnlinePlayers()){

            if(players != p){

                p.showPlayer(Lobby.instance, players);

            }

        }

        e.setQuitMessage(null);

    }

}
