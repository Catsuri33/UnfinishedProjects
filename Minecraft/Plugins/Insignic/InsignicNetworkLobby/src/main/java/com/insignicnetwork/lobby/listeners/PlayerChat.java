package com.insignicnetwork.lobby.listeners;

import com.insignicnetwork.lobby.Lobby;
import com.insignicnetwork.lobby.mysql.PlayersMySQL;
import com.insignicnetwork.lobby.mysql.ranks.RanksList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerChat implements Listener {

    private List<Player> chatCooldown = new ArrayList<>();

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        Player p = e.getPlayer();

        if(Lobby.waitingLogin.contains(p.getUniqueId())){

            e.setCancelled(true);

        }

    }

}
