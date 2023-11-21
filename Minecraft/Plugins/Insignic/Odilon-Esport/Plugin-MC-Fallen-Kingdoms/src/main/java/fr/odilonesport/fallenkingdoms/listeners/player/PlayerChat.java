package fr.odilonesport.fallenkingdoms.listeners.player;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.guis.TeamGui;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        Player p = e.getPlayer();
        String message = e.getMessage();

        String playerTeam = TeamGui.getPlayersTeam().get(p.getUniqueId());

        if(playerTeam != null){

            String teamName = playerTeam.toLowerCase();
            String teamColor = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("game.teams." + teamName + ".color"));

            e.setFormat(teamColor + "%1$s §f» " + message);

        } else {

            e.setFormat("%1$s §f» " + message);

        }

    }

}
