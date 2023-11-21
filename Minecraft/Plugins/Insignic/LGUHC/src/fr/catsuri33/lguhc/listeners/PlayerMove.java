package fr.catsuri33.lguhc.listeners;

import fr.catsuri33.lguhc.LGUHC;
import fr.catsuri33.lguhc.game.Gamestates;
import fr.catsuri33.lguhc.tools.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * LGUHC
 * Create the 10/07/2019
 *
 * @author Catsuri33
 * @version 1.0.0
 */

public class PlayerMove implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {

        Player player = e.getPlayer();

        if (Gamestates.isState(Gamestates.LOBBY) && e.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getType() == Material.WHITE_STAINED_GLASS) {

            final Block b = e.getPlayer().getLocation().subtract(0, 1, 0).getBlock();
            b.setType(Material.BLACK_STAINED_GLASS);

            Bukkit.getScheduler().scheduleSyncDelayedTask(LGUHC.getInstance(), () -> Bukkit.getOnlinePlayers().forEach(p -> {

                b.setType(Material.WHITE_STAINED_GLASS);

            }), 50);

        }

    }

}
