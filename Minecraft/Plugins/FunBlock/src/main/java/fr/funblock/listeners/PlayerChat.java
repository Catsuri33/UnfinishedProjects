package fr.funblock.listeners;

import fr.funblock.FunBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        Player p = e.getPlayer();
        String message = e.getMessage();

        String chatFormat = FunBlock.getInstance().getConfig().getString("options.chat.format");
        String chatFormatColors = chatFormat.replace("&", "§");
        String chatFormatPlayer = chatFormatColors.replace("%player%", p.getDisplayName());
        String chatFormatMessage = chatFormatPlayer.replace("%message%", message);

        e.setFormat(chatFormatMessage);

    }

}
