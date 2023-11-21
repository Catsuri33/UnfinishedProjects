package fr.catsuri33.chomcraftproxy.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import com.velocitypowered.api.proxy.Player;
import fr.catsuri33.chomcraftproxy.Proxy;
import net.kyori.adventure.text.Component;

public class PlayerQuit {

    @Subscribe
    public void onPlayerQuit(DisconnectEvent event) {

        Player p = event.getPlayer();

        for(Player players : Proxy.getInstance().server.getAllPlayers()){

            players.sendMessage(Component.text("§7[§c-§7] " + p.getUsername()));

        }

    }

}
