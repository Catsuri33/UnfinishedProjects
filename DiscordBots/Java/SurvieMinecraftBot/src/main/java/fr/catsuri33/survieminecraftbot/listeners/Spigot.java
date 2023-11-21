package fr.catsuri33.survieminecraftbot.listeners;

import fr.catsuri33.survieminecraftbot.SurvieMinecraftBot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Spigot implements Listener {

    private final SurvieMinecraftBot main;

    public Spigot(SurvieMinecraftBot main){

        this.main = main;

    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        main.sendMessageToDiscord(e.getPlayer(), e.getMessage());

    }

}
