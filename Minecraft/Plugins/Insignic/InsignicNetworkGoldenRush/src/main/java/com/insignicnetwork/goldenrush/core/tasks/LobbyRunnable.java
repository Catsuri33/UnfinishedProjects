package com.insignicnetwork.goldenrush.core.tasks;

import com.insignicnetwork.goldenrush.GoldenRush;
import com.insignicnetwork.goldenrush.game.GameStates;
import com.insignicnetwork.goldenrush.managers.GameManager;
import com.insignicnetwork.goldenrush.managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LobbyRunnable extends BukkitRunnable {

    //public static int timer = 121;
    public static int timer = 10;
    public static boolean start = false;

    @Override
    public void run() {

        timer--;

        if(Bukkit.getOnlinePlayers().size() < 1 && (GameStates.isState(GameStates.LOBBY))){

            for(Player players : Bukkit.getOnlinePlayers()){

                players.sendMessage(GoldenRush.instance.prefix + "§cPas assez de joueur pour lancer la partie, arrêt du timer !");

            }

            timer = 121;
            start = false;

            this.cancel();
            return;

        }

        if(Bukkit.getOnlinePlayers().size() >= 2 && timer > 61){

            timer = 61;

        }

        if(Bukkit.getOnlinePlayers().size() >= 12 && timer > 31){

            timer = 31;

        }

        if(Bukkit.getOnlinePlayers().size() >= 20 && timer > 31){

            timer = 31;

        }

        if((timer == 120) || (timer == 90) || (timer == 60) || (timer == 30) || (timer == 15) || (timer == 10) || (timer == 5) || (timer == 4) || (timer == 3) || (timer == 2) || (timer == 1)){

            for(Player players : Bukkit.getOnlinePlayers()){

                players.sendMessage(GoldenRush.instance.prefix + "§eLa partie commence dans §c" + timer + " " + getSecond(timer) + "§e.");
                players.playSound(players.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

            }

        }

        setLevel();

        if(timer == 0){

            timer = 121;
            this.cancel();

            ScoreboardManager.removeScoreboardLobby();
            ScoreboardManager.removeScoreboardMine();

            for(Player players : Bukkit.getOnlinePlayers()){

                new GameManager().loadGame(players);
                ScoreboardManager.loadScoreboardMine(players);

            }

            new GameMineRunnable().runTaskTimer(GoldenRush.instance, 0L, 20L);

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

            if(GameStates.isState(GameStates.LOBBY)){

                ScoreboardManager.removeScoreboardLobby();
                ScoreboardManager.loadScoreboardLobby(players);

            }

        }

    }

}
