package fr.catsuri33.insiuhc.listeners;

import fr.catsuri33.insiuhc.InsiUHC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(InsiUHC.getInstance().hosts.contains(p.getUniqueId())){

            p.setDisplayName("§c[Host] " + p.getName() + "§r");
            p.setPlayerListName("§c[Host] " + p.getName() + "§r");

        }

        ScoreboardManager sm = Bukkit.getScoreboardManager();
        Scoreboard uhc_wait = sm.getNewScoreboard();

        Objective o = uhc_wait.registerNewObjective("uhc_wait", "dummy", "§bINSI§fUHC");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score zero = o.getScore("§r");
        zero.setScore(0);
        Score one = o.getScore("§fPlayers : §a" + Bukkit.getOnlinePlayers().size() + "§2/" + Bukkit.getMaxPlayers());
        one.setScore(1);
        Score two = o.getScore("§r ");
        two.setScore(2);

        p.setScoreboard(uhc_wait);

        for(Player players : Bukkit.getOnlinePlayers()){

            players.setScoreboard(uhc_wait);

        }

    }

}
