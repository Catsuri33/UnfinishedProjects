package com.insignicnetwork.goldenrush.managers;

import com.insignicnetwork.goldenrush.core.tasks.GameMineRunnable;
import com.insignicnetwork.goldenrush.core.tasks.GamePvPRunnable;
import com.insignicnetwork.goldenrush.core.tasks.GameShopRunnable;
import com.insignicnetwork.goldenrush.core.tasks.LobbyRunnable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreboardManager {

    public Player p;
    public static org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
    public static org.bukkit.scoreboard.Scoreboard scoreboard = sm.getNewScoreboard();
    public static Objective objective = scoreboard.registerNewObjective("lobby", "dummy", "§bGoldenRush");
    public static Objective objectiveMine = scoreboard.registerNewObjective("mine", "dummy", "§bGoldenRush");
    public static Objective objectiveShop = scoreboard.registerNewObjective("shop", "dummy", "§bGoldenRush");
    public static Objective objectivePvp = scoreboard.registerNewObjective("pvp", "dummy", "§bGoldenRush");
    public static Score score8;
    public static Score score7;
    public static Score score6;
    public static Score score5;
    public static Score score4;
    public static Score score3;
    public static Score score2;
    public static Score score1;
    public static Score score0;

    public ScoreboardManager(Player p){

        this.p = p;

    }

    public static void loadScoreboardLobby(Player p){

        Objective objective = scoreboard.registerNewObjective("lobby", "dummy", "§bGoldenRush");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        score4 = objective.getScore("§r ");
        score4.setScore(4);
        score3 = objective.getScore("§fDébut dans: §a" + new SimpleDateFormat("mm:ss").format(new Date(LobbyRunnable.timer * 1000)));
        score3.setScore(3);
        score2 = objective.getScore("§fJoueurs: §a" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
        score2.setScore(2);
        score1 = objective.getScore("§r");
        score1.setScore(1);
        score0 = objective.getScore("§eplay.insignic.com");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

    public static void loadScoreboardMine(Player p){

        Objective objectiveMine = scoreboard.registerNewObjective("mine", "dummy", "§bGoldenRush");
        objectiveMine.setDisplaySlot(DisplaySlot.SIDEBAR);

        score6 = objectiveMine.getScore("§r  ");
        score6.setScore(6);
        score5 = objectiveMine.getScore("§fPhase: §aMinage");
        score5.setScore(5);
        score4 = objectiveMine.getScore("§fTemps Restant: §a" + new SimpleDateFormat("mm:ss").format(new Date(GameMineRunnable.timer * 1000)));
        score4.setScore(4);
        score3 = objectiveMine.getScore("§r ");
        score3.setScore(3);
        score2 = objectiveMine.getScore("§fJoueurs: §a" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
        score2.setScore(2);
        score1 = objectiveMine.getScore("§r");
        score1.setScore(1);
        score0 = objectiveMine.getScore("§eplay.insignic.com");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

    public static void loadScoreboardShop(Player p){

        Objective objectiveShop = scoreboard.registerNewObjective("shop", "dummy", "§bGoldenRush");
        objectiveShop.setDisplaySlot(DisplaySlot.SIDEBAR);

        score6 = objectiveShop.getScore("§r  ");
        score6.setScore(6);
        score5 = objectiveShop.getScore("§fPhase: §aAchats");
        score5.setScore(5);
        score4 = objectiveShop.getScore("§fTemps Restant: §a" + new SimpleDateFormat("mm:ss").format(new Date(GameShopRunnable.timer * 1000)));
        score4.setScore(4);
        score3 = objectiveShop.getScore("§r ");
        score3.setScore(3);
        score2 = objectiveShop.getScore("§fJoueurs: §a" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
        score2.setScore(2);
        score1 = objectiveShop.getScore("§r");
        score1.setScore(1);
        score0 = objectiveShop.getScore("§eplay.insignic.com");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

    public static void loadScoreboardPvp(Player p){

        Objective objectivePvp = scoreboard.registerNewObjective("pvp", "dummy", "§bGoldenRush");
        objectivePvp.setDisplaySlot(DisplaySlot.SIDEBAR);

        score8 = objectivePvp.getScore("§r   ");
        score8.setScore(8);
        score7 = objectivePvp.getScore("§fPhase: §aCombat");
        score7.setScore(7);
        score6 = objectivePvp.getScore("§fTemps Ecoulé: §a" + new SimpleDateFormat("mm:ss").format(new Date(GamePvPRunnable.timer * 1000)));
        score6.setScore(6);
        score5 = objectivePvp.getScore("§r  ");
        score5.setScore(5);
        score4 = objectivePvp.getScore("§fKill(s): §a");
        score4.setScore(4);
        score3 = objectivePvp.getScore("§r ");
        score3.setScore(3);
        score2 = objectivePvp.getScore("§fJoueurs: §a" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
        score2.setScore(2);
        score1 = objectivePvp.getScore("§r");
        score1.setScore(1);
        score0 = objectivePvp.getScore("§eplay.insignic.com");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

    public static void removeScoreboardLobby(){

        objective.unregister();

    }

    public static void removeScoreboardMine(){

        objectiveMine.unregister();

    }

    public static void removeScoreboardShop(){

        objectiveShop.unregister();

    }

    public static void removeScoreboardPvp(){

        objectivePvp.unregister();

    }

}
