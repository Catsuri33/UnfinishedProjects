package com.insignicnetwork.lobbyctf.core.scoreboard;

import com.insignicnetwork.lobbyctf.mysql.CTFMySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {

    public static void createScoreboardLobby(Player p){

        org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = sm.getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("CTFLobby", "dummy", "§cCapture §fThe §9Flag");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score4 = obj.getScore("§r ");
        score4.setScore(4);
        Score score3 = obj.getScore("§fDivision: " + CTFMySQL.getPlayerDivision(p.getUniqueId()).getPrefix());
        score3.setScore(3);
        Score score2 = obj.getScore("§fElo: §a" + CTFMySQL.getPlayerElo(p.getUniqueId()));
        score2.setScore(2);
        Score score1 = obj.getScore("§r");
        score1.setScore(1);
        Score score0 = obj.getScore("§6play.insignic.com");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

}
