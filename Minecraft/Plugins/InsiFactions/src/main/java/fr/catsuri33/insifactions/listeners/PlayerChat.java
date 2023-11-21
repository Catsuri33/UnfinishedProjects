package fr.catsuri33.insifactions.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        Player p = e.getPlayer();

        String messageStart = e.getMessage();
        String messageEnd = e.getMessage();

        if(p.isOp() || p.hasPermission("insifactions.chatcolor")){

            messageEnd = messageStart.replace("&", "§");

        }

        e.setFormat("%1$s §f» " + messageEnd);

    }

}
