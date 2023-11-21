package fr.catsuri33.uhc.scoreboard;

import fr.catsuri33.uhc.UHC;
import fr.catsuri33.uhc.tool.ScoreboardSign;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScoreboardManager {

    public static void sendScoreboardLobby(Player player){

        ScoreboardSign scoreboard = new ScoreboardSign(player, "§6UHC");
        scoreboard.create();
        scoreboard.setLine(0, "§7§m                    §r");
        scoreboard.setLine(1, "   ");
        scoreboard.setLine(2, "§7» §eJoueurs: §f" + Bukkit.getOnlinePlayers().size() + "§7/§e" + Bukkit.getMaxPlayers());
        scoreboard.setLine(3, "§7» §eÉquipe: §7");
        scoreboard.setLine(4, "  ");
        scoreboard.setLine(5, "§7§m                    ");
        scoreboard.setLine(6, " ");

        UHC.getInstance().boards.put(player, scoreboard);

    }

    public static void updateSlotsScoreboardLobby(Player player){

        if(UHC.getInstance().boards.containsKey(player)){

            UHC.getInstance().boards.get(player).setLine(2, "§eJoueurs: §f" + Bukkit.getOnlinePlayers().size() + "§7/§e" + Bukkit.getMaxPlayers());

        }

    }

}
