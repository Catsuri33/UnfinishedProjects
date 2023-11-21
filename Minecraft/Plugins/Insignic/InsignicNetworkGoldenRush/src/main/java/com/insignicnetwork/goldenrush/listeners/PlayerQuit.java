package com.insignicnetwork.goldenrush.listeners;

import com.insignicnetwork.goldenrush.GoldenRush;
import com.insignicnetwork.goldenrush.game.GameStates;
import com.insignicnetwork.goldenrush.mysql.PlayersMySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.LOBBY)){

            e.setQuitMessage(GoldenRush.instance.prefix + PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix() + p.getName() + " §ea quitté la partie ! §c(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")");

        }

    }

}
