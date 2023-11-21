package com.insignicnetwork.essentials.listeners;

import com.insignicnetwork.essentials.Essentials;
import com.insignicnetwork.essentials.mysql.PlayersMySQL;
import com.insignicnetwork.essentials.mysql.ranks.RanksList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerChat implements Listener {

    private final List<Player> chatCooldown = new ArrayList<>();

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        Player p = e.getPlayer();

        if(chatCooldown.contains(p)){

            e.setCancelled(true);
            p.sendMessage("§cVeuillez patienter entre chaque messages !");
            return;

        }

        if(!PlayersMySQL.getPlayerRank(p.getUniqueId()).getName().equals(RanksList.PLAYER.getName())){

            String messageColors = e.getMessage().replace("&", "§");
            e.setFormat("%1$s §f» " + messageColors);

        } else {

            e.setFormat("%1$s » %2$s");
            chatCooldown.add(p);

            Bukkit.getScheduler().runTaskLater(Essentials.getInstance(), () -> {

                chatCooldown.remove(p);

            }, 2 * 20L);

        }

    }

}
