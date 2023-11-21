package com.insignicnetwork.bungeecord.listeners;

import com.insignicnetwork.bungeecord.mysql.FriendsMySQL;
import com.insignicnetwork.bungeecord.mysql.PlayersMySQL;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPostLogin(PlayerDisconnectEvent e){

        ProxiedPlayer p = e.getPlayer();

        PlayersMySQL.setPlayerState(p.getUniqueId(), 0);

        for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()){

            if(new FriendsMySQL().isFriendWith(p.getName(), players.getName())){

                if(!players.getName().equalsIgnoreCase(p.getName())){

                    players.sendMessage(new TextComponent("§c[❤] §e" + p.getName() + " §cvient de se déconnecter !"));

                }

            }

        }

    }

}
