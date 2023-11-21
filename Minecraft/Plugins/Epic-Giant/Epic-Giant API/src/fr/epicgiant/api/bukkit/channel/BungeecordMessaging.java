package fr.epicgiant.api.bukkit.channel;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.epicgiant.api.bukkit.EpicGiantBukkitAPI;
import org.bukkit.entity.Player;

public class BungeecordMessaging {

    public static void sendToServer(Player p, String serverName){

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);
        p.sendPluginMessage(EpicGiantBukkitAPI.getInstance(), "BungeeCord", out.toByteArray());

    }

}
