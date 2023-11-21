package fr.epicgiant.api.bungeecord.utils;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.UUID;

public class BungeecordPlayerUtils {

    public static void getPing(ProxiedPlayer p){

        p.getPing();

    }

    public static void getName(ProxiedPlayer p){

        p.getName();

    }

    public static void getServerNameWherePlayerIsLocated(ProxiedPlayer p){

        p.getServer().getInfo().getName();

    }

    public static void getDisplayName(ProxiedPlayer p){

        p.getDisplayName();

    }

    public static void kick(ProxiedPlayer p, String reason){

        p.disconnect(new TextComponent(reason));

    }

    public static void sendMessage(ProxiedPlayer p, String message){

        p.sendMessage(new TextComponent(message));

    }

    public static UUID getUUID(ProxiedPlayer p){

        return p.getUniqueId();

    }

    public static String getStringOfUUID(ProxiedPlayer p){

        return p.getUniqueId().toString();

    }

    public void isConnected(ProxiedPlayer p){

        p.isConnected();

    }

    public void hasPermission(ProxiedPlayer p, String permission){

        p.hasPermission(permission);

    }

    public static void connect(ProxiedPlayer p, ServerInfo server){

        p.connect(server);

    }

}
