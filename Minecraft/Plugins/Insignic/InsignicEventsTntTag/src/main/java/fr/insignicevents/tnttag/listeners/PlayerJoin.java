package fr.insignicevents.tnttag.listeners;

import fr.insignicevents.tnttag.TntTag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        UUID uuid = p.getUniqueId();

        TntTag.getInstance().playerManager.put(uuid, new PlayerManager(uuid, false, false));

    }

}
