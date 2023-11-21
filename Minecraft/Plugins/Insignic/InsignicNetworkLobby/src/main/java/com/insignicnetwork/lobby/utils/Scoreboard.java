package com.insignicnetwork.lobby.utils;

import com.insignicnetwork.lobby.messages.MessagesBungeeCord;
import com.insignicnetwork.lobby.mysql.PlayersMySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

public class Scoreboard {

    public static ScoreboardManager sm = Bukkit.getScoreboardManager();
    public static org.bukkit.scoreboard.Scoreboard scoreboard = sm.getNewScoreboard();
    public static Objective objective;
    public static Score score7;
    public static Score score6;
    public static Score score5;
    public static Score score4;
    public static Score score3;
    public static Score score2;
    public static Score score1;
    public static Score score0;

    public static void createLobbyScoreboard(Player p){

        objective = scoreboard.registerNewObjective("lobby", "dummy", "§bINSIGNIC §fNETWORK");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        score7 = objective.getScore("§r  ");
        score7.setScore(7);
        score6 = objective.getScore("§fGrade: " + PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix());
        score6.setScore(6);
        score5 = objective.getScore("§fNiveau: §a" + PlayersMySQL.getPlayerLevel(p.getUniqueId()));
        score5.setScore(5);
        score4 = objective.getScore("§r ");
        score4.setScore(4);
        score3 = objective.getScore("§fServeur: §aLobby01");
        score3.setScore(3);
        score2 = objective.getScore("§fJoueurs: §a" + MessagesBungeeCord.playerCount.toString());
        score2.setScore(2);
        score1 = objective.getScore("§r");
        score1.setScore(1);
        score0 = objective.getScore("§eplay.insignic.com");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

    public static void updatePlayers(){

        score2 = objective.getScore("§fJoueurs: §a" + MessagesBungeeCord.playerCount.toString());
        score2.setScore(2);

    }

}
