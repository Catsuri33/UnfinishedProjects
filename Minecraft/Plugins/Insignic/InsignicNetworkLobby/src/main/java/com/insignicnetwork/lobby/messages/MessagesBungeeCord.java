package com.insignicnetwork.lobby.messages;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.insignicnetwork.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.HashMap;
import java.util.Map;

public class MessagesBungeeCord implements PluginMessageListener {

    public static final Map<String, Integer> players = new HashMap<>();
    public static Object playerCount = 0;

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {

        if (!channel.equals("BungeeCord")) {

            return;

        }

        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();

        if (subchannel.equals("PlayerCount")) {

            String server = in.readUTF();
            int playercount = in.readInt();
            players.put(server, playercount);

            playerCount = playercount;

        }

    }

    public static void requestPlayerCount(String server) {

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF(server);
        Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
        Lobby.getInstance().getServer().sendPluginMessage(Lobby.instance, "BungeeCord", out.toByteArray());

    }

    public static int getCachedPlayerCount(String name) {

        return players.get(name);

    }

}
