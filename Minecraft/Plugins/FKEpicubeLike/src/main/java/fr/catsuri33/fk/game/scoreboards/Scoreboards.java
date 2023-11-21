package fr.catsuri33.fk.game.scoreboards;

import fr.catsuri33.fk.Main;
import fr.catsuri33.fk.game.guis.KitsGui;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Scoreboards {

    public void createLobbyBoard(Player p){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String gameTimer = new SimpleDateFormat("mm:ss").format(new Date((Main.getInstance().lobbyRunnableTimer - 1) * 1000));

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("FK", "dummy", "§8- §6FALLENKINGDOMS §8-");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score8 = objective.getScore("§8» §7" + dtf.format(now));
        score8.setScore(8);
        Score score7 = objective.getScore("§f§f§f");
        score7.setScore(7);
        Score score6 = objective.getScore("§8» §6Début dans §8: §e" + gameTimer);
        score6.setScore(6);
        Score score5 = objective.getScore("§8» §6Joueurs §8: §a" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
        score5.setScore(5);
        Score score4 = objective.getScore("§f§f");
        score4.setScore(4);
        if(KitsGui.getPlayersKit().containsKey(p.getUniqueId())){

            Score score3 = objective.getScore("§8» §6Kit §8: §e" + KitsGui.getPlayersKit().get(p.getUniqueId()));
            score3.setScore(3);

        } else {

            Score score3 = objective.getScore("§8» §6Kit §8: §eAucun");
            score3.setScore(3);

        }
        Score score2 = objective.getScore("§8» §6Carte §8: §e" + Bukkit.getWorlds().get(0).getName());
        score2.setScore(2);
        Score score1 = objective.getScore("§f");
        score1.setScore(1);
        Score score0 = objective.getScore("§8≫ §eplay.yapasdip.fr");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

}
