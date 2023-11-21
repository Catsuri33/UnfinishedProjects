package fr.catsuri33.sc.listeners;

import fr.catsuri33.sc.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(!Main.configManager.getPlayersConfig().contains("players." + p.getUniqueId())){

            Main.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".pseudo", p.getName());
            Main.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".money", 0);
            Main.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".kill-count", 0);
            Main.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".death-count", 0);
            Main.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".ratio", 0.00);
            Main.configManager.savePlayersConfig();

        }

        String playersCount = Integer.toString(Bukkit.getOnlinePlayers().size());
        String playersMax = Integer.toString(Bukkit.getMaxPlayers());

        String messageStart = Main.getInstance().getConfig().getString("messages.join-message");
        String messagePlayer = messageStart.replace("%player%", p.getName());
        String messagePlayersCount = messagePlayer.replace("%players-count%", playersCount);
        String messagePlayersMax = messagePlayersCount.replace("%players-max%", playersMax);
        String messageColor = messagePlayersMax.replace("&", "§");

        e.setJoinMessage(messageColor);

        p.setGameMode(GameMode.SURVIVAL);

    }

}
