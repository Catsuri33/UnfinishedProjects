package fr.insignic.practice.listeners;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        Player p = e.getPlayer();

        TextComponent txtcReport = new TextComponent("§cReport§r️");
        txtcReport.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cFonctionnalité indisponible !").create()));
        e.setFormat(txtcReport.getText() + " §7%1$s : %2$s");

    }

}
