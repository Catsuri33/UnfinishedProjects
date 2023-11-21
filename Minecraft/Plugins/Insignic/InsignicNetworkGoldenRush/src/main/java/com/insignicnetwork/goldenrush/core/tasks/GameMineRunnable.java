package com.insignicnetwork.goldenrush.core.tasks;

import com.insignicnetwork.goldenrush.GoldenRush;
import com.insignicnetwork.goldenrush.game.GameStates;
import com.insignicnetwork.goldenrush.managers.GameManager;
import com.insignicnetwork.goldenrush.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameMineRunnable extends BukkitRunnable {

    //public static int timer = 301;
    public static int timer = 30;

    @Override
    public void run() {

        timer--;

        if(Bukkit.getOnlinePlayers().size() < 1){

            for(Player players : Bukkit.getOnlinePlayers()){

                players.sendMessage(GoldenRush.instance.prefix + "§cPlus assez de joueur, fin de partie !");

            }

            timer = 301;

            this.cancel();
            return;

        }

        if((timer == 300) || (timer == 240) || (timer == 180) || (timer == 120) || (timer == 60) || (timer == 30) || (timer == 10) || (timer == 5) || (timer == 4) || (timer == 3) || (timer == 2) || (timer == 1)){

            for(Player players : Bukkit.getOnlinePlayers()){

                players.sendMessage(GoldenRush.instance.prefix + "§eLa phase de minage se termine dans §c" + timer + " " + getSecond(timer) + " §e!");
                players.playSound(players.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

            }

        }

        setLevel();

        if(timer == 0){

            timer = 301;
            this.cancel();

            for(Player players : Bukkit.getOnlinePlayers()){

                ScoreboardManager.removeScoreboardMine();
                ScoreboardManager.removeScoreboardShop();
                ScoreboardManager.loadScoreboardShop(players);
                new GameManager().loadShop(players);

            }

            new GameShopRunnable().runTaskTimer(GoldenRush.instance, 0L, 20L);

        }

    }

    private String getSecond(int time) {

        if(time == 1){

            return "seconde";

        }

        return "secondes";

    }

    private void setLevel(){

        for(Player players : Bukkit.getOnlinePlayers()){

            players.setLevel(timer);

            if(GameStates.isState(GameStates.GAME_MINE)){

                ScoreboardManager.removeScoreboardMine();
                ScoreboardManager.loadScoreboardMine(players);

            }

        }

    }

}
