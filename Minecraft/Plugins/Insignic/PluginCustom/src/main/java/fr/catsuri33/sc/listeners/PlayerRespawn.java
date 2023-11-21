package fr.catsuri33.sc.listeners;

import fr.catsuri33.sc.Main;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){

        Player p = e.getPlayer();
        World world = Main.worldOfDeath.get(p.getUniqueId());

        e.setRespawnLocation(world.getSpawnLocation());

        Main.worldOfDeath.remove(p.getUniqueId());

    }

}
