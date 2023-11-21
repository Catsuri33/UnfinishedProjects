package fr.insignicevents.lobby.utils;

import fr.insignicevents.lobby.database.players.PlayersTable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardUtils {

    public static void createScoreboard(String name, String displayName, Player p){

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective(name, "dummy", displayName);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score8 = objective.getScore("§7§m                              §r");
        score8.setScore(8);
        Score score7 = objective.getScore("  §fPseudo: §e" + p.getName());
        score7.setScore(7);
        Score score6 = objective.getScore("  §fCoéquipier: §a");
        score6.setScore(6);
        if(PlayersTable.getPlayerTeam(p.getUniqueId()).equals("")){

            Score score5 = objective.getScore("  §fEquipe: §cN/A");
            score5.setScore(5);

        } else {

            Score score5 = objective.getScore("  §fEquipe: " + PlayersTable.getPlayerTeam(p.getUniqueId()));
            score5.setScore(5);

        }
        Score score4 = objective.getScore("§7§m                              §r§r");
        score4.setScore(4);
        Score score3 = objective.getScore("  §fVos Points: §a" + PlayersTable.getPlayerPoints(p.getUniqueId()));
        score3.setScore(3);
        Score score2 = objective.getScore("  §fPoints d'Equipe: §a0");
        score2.setScore(2);
        Score score1 = objective.getScore("  §fInsiPoints: §b"  + PlayersTable.getPlayerCoins(p.getUniqueId()));
        score1.setScore(1);
        Score score0 = objective.getScore("§7§m                              §r§r§r");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

}
