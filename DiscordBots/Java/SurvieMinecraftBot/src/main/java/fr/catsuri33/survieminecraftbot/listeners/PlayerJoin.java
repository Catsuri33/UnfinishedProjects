package fr.catsuri33.survieminecraftbot.listeners;

import fr.catsuri33.survieminecraftbot.SurvieMinecraftBot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private final SurvieMinecraftBot main;

    public PlayerJoin(SurvieMinecraftBot main){

        this.main = main;

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        e.setJoinMessage("§6" + p.getName() + " §ea rejoin le serveur !");
        main.sendMessageToDiscord(e.getPlayer(), e.getPlayer() + " a rejoin le serveur !");

    }

}
