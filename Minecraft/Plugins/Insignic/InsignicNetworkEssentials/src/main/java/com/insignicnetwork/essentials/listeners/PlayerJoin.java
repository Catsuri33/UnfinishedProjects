package com.insignicnetwork.essentials.listeners;

import com.insignicnetwork.essentials.managers.PlayerManager;
import com.insignicnetwork.essentials.mysql.CTFMySQL;
import com.insignicnetwork.essentials.mysql.PlayersMySQL;
import com.insignicnetwork.essentials.mysql.ranks.RanksList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(PlayersMySQL.getPlayerState(p.getUniqueId()) == 3){

            PlayerManager pm = new PlayerManager(p);
            pm.init();
            p.setAllowFlight(true);
            pm.saveInventory();
            p.getInventory().clear();
            p.getActivePotionEffects().clear();
            p.sendMessage("§cAttention: Vous êtes toujours en mode modération !");

        }

        if(!PlayersMySQL.getPlayerRank(p.getUniqueId()).getName().equals(RanksList.PLAYER.getName())){

            p.setDisplayName(PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix() + p.getName());
            p.setPlayerListName(PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix() + p.getName());

            if(p.getWorld().getName().equalsIgnoreCase("CTFLobby01")){

                p.setDisplayName(CTFMySQL.getPlayerDivision(p.getUniqueId()).getPrefix() + PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix() + p.getName());
                p.setPlayerListName(CTFMySQL.getPlayerDivision(p.getUniqueId()).getPrefix() + PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix() + p.getName());

            }

        } else {

            p.setDisplayName(CTFMySQL.getPlayerDivision(p.getUniqueId()).getPrefix() + "§7" + p.getName());
            p.setPlayerListName(CTFMySQL.getPlayerDivision(p.getUniqueId()).getPrefix() + "§7" + p.getName());

            if(p.getWorld().getName().equalsIgnoreCase("CTFLobby01")){

                p.setDisplayName(CTFMySQL.getPlayerDivision(p.getUniqueId()).getPrefix() + "§7" + p.getName());
                p.setPlayerListName(CTFMySQL.getPlayerDivision(p.getUniqueId()).getPrefix() + "§7" + p.getName());

            }

        }

    }

}
