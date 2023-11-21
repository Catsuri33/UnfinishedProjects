package com.insignicnetwork.bungeecord.listeners;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProxyPing implements Listener {

    private DateFormat dateYear = new SimpleDateFormat("yyyy");
    private DateFormat dateMonth = new SimpleDateFormat("dd/MM");
    private Date date = new Date();

    @EventHandler
    public void onProxyPing(ProxyPingEvent e){

        final ServerPing serverPing = e.getResponse();

        if(dateMonth.format(date).equals("01/12") || dateMonth.format(date).equals("02/12") || dateMonth.format(date).equals("03/12") || dateMonth.format(date).equals("04/12") || dateMonth.format(date).equals("05/12") || dateMonth.format(date).equals("06/12") || dateMonth.format(date).equals("07/12") || dateMonth.format(date).equals("08/12") || dateMonth.format(date).equals("09/12") || dateMonth.format(date).equals("10/12") || dateMonth.format(date).equals("11/12") || dateMonth.format(date).equals("12/12") || dateMonth.format(date).equals("13/12") || dateMonth.format(date).equals("14/12") || dateMonth.format(date).equals("15/12") || dateMonth.format(date).equals("16/12") || dateMonth.format(date).equals("17/12") || dateMonth.format(date).equals("18/12") || dateMonth.format(date).equals("19/12") || dateMonth.format(date).equals("20/12") || dateMonth.format(date).equals("21/12") || dateMonth.format(date).equals("22/12") || dateMonth.format(date).equals("23/12") || dateMonth.format(date).equals("24/12") || dateMonth.format(date).equals("25/12") || dateMonth.format(date).equals("26/12") || dateMonth.format(date).equals("27/12") || dateMonth.format(date).equals("28/12") || dateMonth.format(date).equals("29/12") || dateMonth.format(date).equals("30/12") || dateMonth.format(date).equals("31/12")){

            serverPing.setDescriptionComponent(new TextComponent("               §b§lINSIGNIC §fNETWORK §r§c(1.15.2) \n     §b❄ §fBonnes Fêtes §8- §cPromo sur la Boutique §b❄"));

        } else {

            serverPing.setDescriptionComponent(new TextComponent("               §b§lINSIGNIC §fNETWORK §r§c(1.15.2) \n         §eNouveaux Jeux §cDisponibles §e!"));

        }

        serverPing.setVersion(new ServerPing.Protocol( "§c1.15.2 §7- " + serverPing.getPlayers().getOnline() + "§8/§7" + serverPing.getPlayers().getMax(), 578));

        e.setResponse(serverPing);

    }

}
