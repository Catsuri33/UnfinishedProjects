package fr.catsuri33.chomcraftproxy.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import com.velocitypowered.api.proxy.Player;
import fr.catsuri33.chomcraftproxy.Proxy;
import net.kyori.adventure.text.Component;

public class PlayerChat {

    @Subscribe
    public void onPlayerChat(PlayerChatEvent event) {

        Player p = event.getPlayer();
        String message = event.getMessage();

        for(Player players : Proxy.getInstance().server.getAllPlayers()){

            if(players != p && p.getCurrentServer() != players.getCurrentServer()){

                players.sendMessage(Component.text(p.getUsername() + " » " + message));

            }

        }

    }

}
