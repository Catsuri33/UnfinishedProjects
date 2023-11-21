package fr.catsuri33.chomcraftplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        Player p = e.getPlayer();
        String message = e.getMessage();

        e.setFormat(p.getDisplayName() + " » " + message);

    }

}
