package fr.catsuri33.sc.listeners;

import fr.catsuri33.sc.Main;
import fr.catsuri33.sc.world.MessagesManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        if(MessagesManager.messages.containsKey(p)){

            MessagesManager.messages.remove(p);

        }

        String playersCount = Integer.toString(Bukkit.getOnlinePlayers().size());
        String playersMax = Integer.toString(Bukkit.getMaxPlayers());

        String messageStart = Main.getInstance().getConfig().getString("messages.join-message");
        String messagePlayer = messageStart.replace("%player%", p.getName());
        String messagePlayersCount = messagePlayer.replace("%players-count%", playersCount);
        String messagePlayersMax = messagePlayersCount.replace("%players-max%", playersMax);
        String messageColor = messagePlayersMax.replace("&", "§");

        e.setQuitMessage(messageColor);

    }

}
