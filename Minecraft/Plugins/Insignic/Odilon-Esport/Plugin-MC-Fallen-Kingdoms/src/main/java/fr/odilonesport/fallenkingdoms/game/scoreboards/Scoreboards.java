package fr.odilonesport.fallenkingdoms.game.scoreboards;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.guis.TeamGui;
import fr.odilonesport.fallenkingdoms.game.player.GamePlayer;
import fr.odilonesport.fallenkingdoms.game.runnables.GameRunnable;
import fr.odilonesport.fallenkingdoms.game.runnables.LobbyRunnable;
import fr.odilonesport.fallenkingdoms.utils.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Scoreboards {

    public static String pvpState = "§c✖";
    public static String netherState = "§c✖";
    public static String assaultsState = "§c✖";
    public static String endState = "§c✖";

    public void createLobbyBoard(Player p){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String gameTimer = new SimpleDateFormat("mm:ss").format(new Date(LobbyRunnable.timer * 1000));
        String teamName = TeamGui.getPlayersTeam().get(p.getUniqueId());

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("FK", "dummy", "§8- §6FALLENKINGDOMS §8-");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score6 = objective.getScore("§8» §7" + dtf.format(now));
        score6.setScore(6);
        Score score5 = objective.getScore("§f§f§f");
        score5.setScore(5);
        Score score4 = objective.getScore("§8» §6Début dans §8: §e" + gameTimer);
        score4.setScore(4);
        if(!TeamGui.getPlayersTeam().containsKey(p.getUniqueId())){

            Score score3 = objective.getScore("§8» §6Equipe §8: §ePas d'Equipe");
            score3.setScore(3);

        } else {

            String teamColor = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("game.teams." + teamName.toLowerCase() + ".color"));
            Score score3 = objective.getScore("§8» §6Equipe §8: §e" + teamColor + teamName);
            score3.setScore(3);

        }
        Score score2 = objective.getScore("§8» §6Joueurs §8: §a" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
        score2.setScore(2);
        Score score1 = objective.getScore("§f§f");
        score1.setScore(1);
        Score score0 = objective.getScore("§8≫ §eOdilon Esport");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

    public void createGameBoard(Player p){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String gameTimer = new SimpleDateFormat("mm:ss").format(new Date(GameRunnable.timer * 1000));
        Integer days = GameRunnable.days;
        GamePlayer gamePlayer = GamePlayer.gamePlayers.get(p.getName());

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("FK", "dummy", "§8- §6FALLENKINGDOMS §8-");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score13 = objective.getScore("§8» §7" + dtf.format(now));
        score13.setScore(13);
        Score score12 = objective.getScore("§f§f§f§f§f");
        score12.setScore(12);
        Score score11 = objective.getScore("§8» §6Jour §8: §e" + days);
        score11.setScore(11);
        Score score10 = objective.getScore("§8» §6Temps §8: §e" + gameTimer);
        score10.setScore(10);
        Score score9 = objective.getScore("§f§f§f§f");
        score9.setScore(9);
        Score score8 = objective.getScore("§8» §6PvP §8: " + pvpState);
        score8.setScore(8);
        Score score7 = objective.getScore("§8» §6Nether §8: " + netherState);
        score7.setScore(7);
        Score score6 = objective.getScore("§8» §6Assauts §8: " + assaultsState);
        score6.setScore(6);
        Score score5 = objective.getScore("§8» §6End §8: " + endState);
        score5.setScore(5);
        Score score4 = objective.getScore("§f§f§f");
        score4.setScore(4);
        Score score3 = objective.getScore("§8» §6Morts §8: §e" + gamePlayer.getDeathCount());
        score3.setScore(3);
        Score score2 = objective.getScore("§8» §6Kills §8: §e" + gamePlayer.getKillCount());
        score2.setScore(2);
        Score score1 = objective.getScore("§f§f");
        score1.setScore(1);
        Score score0 = objective.getScore("§8≫ §eOdilon Esport");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

    public void setState(Integer state){

        if(state.equals(-1)){

            return;

        }

        if(state.equals(0)){

            GameRunnable.nextState = 1;
            pvpState = "§a✔";

        }

        if(state.equals(1)){

            GameRunnable.nextState = 2;
            netherState = "§a✔";

        }

        if(state.equals(2)){

            GameRunnable.nextState = 3;
            GameStates.setState(GameStates.ASSAULTS);
            assaultsState = "§a✔";

        }

        if(state.equals(3)){

            GameRunnable.nextState = -1;
            endState = "§a✔";

        }

    }

}
