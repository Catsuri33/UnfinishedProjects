package fr.epicgiant.api.bungeecord.listeners;

import fr.epicgiant.api.bukkit.utils.MessagesPreGenerated;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerSwitch implements Listener {

    @EventHandler
    public void switchServer(ServerSwitchEvent e){

        ProxiedPlayer p = e.getPlayer();
        p.sendMessage(new TextComponent(MessagesPreGenerated.SERVER_NAME.getMessage() + "§eVous rejoignez le serveur §6" + p.getServer().getInfo().getName()));

    }

}
