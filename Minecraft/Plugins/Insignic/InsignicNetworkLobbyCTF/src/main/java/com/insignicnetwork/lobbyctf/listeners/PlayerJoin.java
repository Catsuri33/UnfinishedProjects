package com.insignicnetwork.lobbyctf.listeners;

import com.insignicnetwork.lobbyctf.core.divisions.DivisionsManager;
import com.insignicnetwork.lobbyctf.core.scoreboard.ScoreboardManager;
import com.insignicnetwork.lobbyctf.mysql.CTFMySQL;
import com.insignicnetwork.lobbyctf.mysql.PlayersMySQL;
import com.insignicnetwork.lobbyctf.mysql.ranks.RanksList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        DivisionsManager.checkDivisions(p.getUniqueId());

        if(!PlayersMySQL.getPlayerRank(p.getUniqueId()).getName().equals(RanksList.PLAYER.getName())){

            e.setJoinMessage(CTFMySQL.getPlayerDivision(p.getUniqueId()).getPrefix() + PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix() + p.getName() + " §ea rejoint le lobby !");

        } else {

            e.setJoinMessage(null);

        }

        ScoreboardManager.createScoreboardLobby(p);

    }

}
