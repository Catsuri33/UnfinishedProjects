package com.epicgiant.bungeecord.listeners;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyPing implements Listener {

    @EventHandler
    public void onProxyPing(ProxyPingEvent e){

        final ServerPing serverPing = e.getResponse();

        serverPing.setDescriptionComponent(new TextComponent("§6§lEpic-Giant"));
        serverPing.setVersion(new ServerPing.Protocol( "§a1.14.4", 498));

        e.setResponse(serverPing);

    }

}
