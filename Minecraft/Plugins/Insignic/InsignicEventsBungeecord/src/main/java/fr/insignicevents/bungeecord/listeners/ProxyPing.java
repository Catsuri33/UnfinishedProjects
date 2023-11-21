package fr.insignicevents.bungeecord.listeners;

import fr.insignicevents.bungeecord.database.servers.ServersTable;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyPing implements Listener {

    @EventHandler
    public void onProxyPing(ProxyPingEvent e){

        final ServerPing serverPing = e.getResponse();

        if(ServersTable.getMaintenanceState().equalsIgnoreCase("true")){

            serverPing.setDescriptionComponent(new TextComponent("                   §b§lINSIGNIC §r§fEVENTS\n    §cMaintenance | Infos sur Twitter: §6@InsignicEvents"));

        } else {

            serverPing.setDescriptionComponent(new TextComponent("                   §b§lINSIGNIC §r§fEVENTS\n              §6Prochain Event §f[§cSAMEDI ??§f]"));

        }

        serverPing.setVersion(new ServerPing.Protocol( "§c1.15.2 §7- " + serverPing.getPlayers().getOnline() + "§8/§7" + serverPing.getPlayers().getMax(), 578));

        e.setResponse(serverPing);

    }

}
