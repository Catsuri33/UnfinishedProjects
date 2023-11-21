package com.insignicnetwork.lobby.listeners;

import com.insignicnetwork.lobby.Lobby;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){

        final Player p = e.getPlayer();
        final Location blockUnderPlayer = p.getLocation();

        blockUnderPlayer.setY(blockUnderPlayer.getY() - 1);

        if(p.getLocation().getBlock().getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE) && blockUnderPlayer.getBlock().getType().equals(Material.CLAY)){

            p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 3.0F, 3.0F);
            p.setVelocity(p.getLocation().getDirection().multiply(3).setY(2));

        }

        if(Lobby.waitingLogin.contains(p.getUniqueId())) {

            e.setCancelled(true);

        }

        if(p.getLocation().getY() <= 0){

            if(!p.getGameMode().equals(GameMode.CREATIVE)){

                p.sendMessage("§cFaites attention où vous mettez les pieds !");
                p.teleport(new Location(p.getWorld(), 0.5, 57, 0.5, 0, (float) 2.5));

            }

        }

    }

}
