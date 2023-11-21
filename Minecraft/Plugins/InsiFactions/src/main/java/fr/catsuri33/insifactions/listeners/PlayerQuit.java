package fr.catsuri33.insifactions.listeners;

import fr.catsuri33.insifactions.InsiFactions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        InsiFactions.getInstance().playerPerms.remove(p.getUniqueId());

        String playersCount = Integer.toString(Bukkit.getOnlinePlayers().size() - 1);
        String playersMax = Integer.toString(Bukkit.getMaxPlayers());

        String messageStart = InsiFactions.getInstance().getConfig().getString("messages.quit");
        String messagePlayer = messageStart.replace("%player%", p.getName());
        String messagePlayersCount = messagePlayer.replace("%players-count%", playersCount);
        String messagePlayersMax = messagePlayersCount.replace("%players-max%", playersMax);
        String messageColor = messagePlayersMax.replace("&", "§");

        e.setQuitMessage(messageColor);

    }

}
