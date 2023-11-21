package com.insignicnetwork.goldenrush.core.tasks;

import com.insignicnetwork.goldenrush.GoldenRush;
import com.insignicnetwork.goldenrush.game.GameStates;
import com.insignicnetwork.goldenrush.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GamePvPRunnable extends BukkitRunnable {

    public static int timer = 0;

    @Override
    public void run() {

        timer++;

        if(Bukkit.getOnlinePlayers().size() < 1){

            for(Player players : Bukkit.getOnlinePlayers()){

                players.sendMessage(GoldenRush.instance.prefix + "§cPlus assez de joueur, fin de partie !");

            }

            timer = 0;

            this.cancel();
            return;

        }

        for(Player players : Bukkit.getOnlinePlayers()){

            if(GameStates.isState(GameStates.GAME_PVP)){

                ScoreboardManager.removeScoreboardPvp();
                ScoreboardManager.loadScoreboardPvp(players);

            }

        }

    }

}
