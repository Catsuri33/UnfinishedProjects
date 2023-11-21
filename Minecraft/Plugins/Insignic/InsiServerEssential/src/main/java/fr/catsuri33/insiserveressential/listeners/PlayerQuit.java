package fr.catsuri33.insiserveressential.listeners;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();
        int playersOnline = Bukkit.getServer().getOnlinePlayers().size();
        String playersOnlineString = Integer.toString(playersOnline);
        int playersMax = Bukkit.getServer().getMaxPlayers();
        String playersMaxString = Integer.toString(playersMax);

        String messageStartColor = InsiServerEssential.getInstance().getConfig().getString("server.events.quit.quit-message");
        String messageEndColor = ChatColor.translateAlternateColorCodes('&', messageStartColor);

        String messageWithPlayer = messageEndColor.replace("%player%", p.getName());
        String messageWithPlayersOnline = messageWithPlayer.replace("%players%", playersOnlineString);
        String messageWithPlayersMax = messageWithPlayersOnline.replace("%players-max%", playersMaxString);

        e.setQuitMessage(messageWithPlayersMax);

    }

}
