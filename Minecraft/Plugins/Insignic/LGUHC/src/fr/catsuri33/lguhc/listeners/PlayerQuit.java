package fr.catsuri33.lguhc.listeners;

import fr.catsuri33.lguhc.LGUHC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * LGUHC
 * Create the 10/07/2019
 *
 * @author Catsuri33
 * @version 1.0.0
 */

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        e.setQuitMessage("§8[§c-§8] §e" + player.getName() + " §7(§e" + Bukkit.getOnlinePlayers().size() + "§7/§e" + Bukkit.getMaxPlayers() + "§7)");

        for(Player pls : Bukkit.getOnlinePlayers()){

            LGUHC.getInstance().sendScoreboard(player);

        }

    }

}
