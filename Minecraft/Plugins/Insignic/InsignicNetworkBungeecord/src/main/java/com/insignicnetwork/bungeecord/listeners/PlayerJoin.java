package com.insignicnetwork.bungeecord.listeners;

import com.insignicnetwork.bungeecord.Bungeecord;
import com.insignicnetwork.bungeecord.mysql.CTFMySQL;
import com.insignicnetwork.bungeecord.mysql.FriendsMySQL;
import com.insignicnetwork.bungeecord.mysql.PlayersMySQL;
import com.insignicnetwork.bungeecord.mysql.PracticeMySQL;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPostLogin(PostLoginEvent e){

        ProxiedPlayer p = e.getPlayer();

        Bungeecord.getInstance().mySQL.createAccount(p.getUniqueId());
        CTFMySQL.createAccount(p.getUniqueId());
        PracticeMySQL.createAccount(p.getUniqueId());
        PlayersMySQL.setPlayerState(p.getUniqueId(), 1);

        for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()){

            if(new FriendsMySQL().isFriendWith(p.getName(), players.getName())){

                if(!players.getName().equalsIgnoreCase(p.getName())){

                    players.sendMessage(new TextComponent("§a[❤] §e" + p.getName() + " §avient de se connecter !"));

                }

            }

        }

    }

}
