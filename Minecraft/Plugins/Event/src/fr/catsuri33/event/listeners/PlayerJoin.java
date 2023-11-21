package fr.catsuri33.event.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if(!player.hasPlayedBefore()){

            e.setJoinMessage("§eBienvenue §f" + player.getName() + " §esur §6§lEvent §e!");

        } else {

            e.setJoinMessage("§7[§2+§7] " + player.getName());

        }

    }

}
