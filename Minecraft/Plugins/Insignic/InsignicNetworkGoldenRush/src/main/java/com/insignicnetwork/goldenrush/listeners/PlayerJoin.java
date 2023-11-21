package com.insignicnetwork.goldenrush.listeners;

import com.insignicnetwork.goldenrush.GoldenRush;
import com.insignicnetwork.goldenrush.core.tasks.LobbyRunnable;
import com.insignicnetwork.goldenrush.game.GameStates;
import com.insignicnetwork.goldenrush.managers.ScoreboardManager;
import com.insignicnetwork.goldenrush.mysql.PlayersMySQL;
import com.insignicnetwork.goldenrush.utils.Title;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.LOBBY)){

            ScoreboardManager.removeScoreboardLobby();

            e.setJoinMessage(GoldenRush.instance.prefix + PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix() + p.getName() + " §ea rejoint la partie ! §a(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")");

            p.teleport(new Location(p.getWorld(), 6.5, 4, -2.5, 0, 0));
            p.getInventory().clear();
            p.getActivePotionEffects().clear();
            p.setFoodLevel(20);
            p.setHealth(20);
            p.setLevel(0);
            p.setExp(0);
            p.setGameMode(GameMode.SURVIVAL);

            new Title("§6GoldenRush", "§eBienvenue dans la partie §6" + p.getName() + " §e!").send(p, 2, 5, 2);

            ScoreboardManager.loadScoreboardLobby(p);

            for(Player players : Bukkit.getOnlinePlayers()){

                ScoreboardManager.removeScoreboardLobby();
                ScoreboardManager.loadScoreboardLobby(players);

            }

        } else {

            p.getInventory().clear();
            p.getActivePotionEffects().clear();
            p.setFoodLevel(20);
            p.setHealth(20);
            p.setLevel(0);
            p.setExp(0);
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage(GoldenRush.instance.prefix + "§cLa partie a déjà commencée, vous avez été mis en mode de jeu spectateur !");

        }

        if((!LobbyRunnable.start) && (GameStates.isState(GameStates.LOBBY))){

            new LobbyRunnable().runTaskTimer(GoldenRush.instance, 0L, 20L);
            LobbyRunnable.start = true;
            return;

        }

    }

}
