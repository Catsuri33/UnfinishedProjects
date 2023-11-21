package fr.catsuri33.uhc.bungeecord;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.catsuri33.uhc.UHC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BungeecordManager {

    private UHC instance;

    public BungeecordManager(UHC instance) {

        this.instance = instance;
        Bukkit.getMessenger().registerOutgoingPluginChannel(instance, "BungeeCord");

    }

    public void changeServer(Player player, String server) {

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        player.sendPluginMessage(this.instance, "BungeeCord", out.toByteArray());

    }

}
