package fr.catsuri33.survieminecraftbot.listeners;

import fr.catsuri33.survieminecraftbot.SurvieMinecraftBot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    private final SurvieMinecraftBot main;

    public PlayerQuit(SurvieMinecraftBot main){

        this.main = main;

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        e.setQuitMessage("§6" + p.getName() + " §aa quitté le serveur !");
        main.sendMessageToDiscord(e.getPlayer(), e.getPlayer() + " a quitté le serveur !");

    }

}
