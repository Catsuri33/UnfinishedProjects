package fr.catsuri33.fk.listeners.player;

import fr.catsuri33.fk.Main;
import fr.catsuri33.fk.utils.GameStates;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlace implements Listener {

    @EventHandler
    public void onPlayerPlace(BlockPlaceEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.WAITING) && !p.getGameMode().equals(GameMode.CREATIVE)){

            e.setCancelled(true);
            return;

        }

        // Red
        if(Main.getInstance().redTeam.contains(p.getUniqueId()) && !p.getGameMode().equals(GameMode.CREATIVE)){

            if(!Main.getInstance().redBase.isInArea(e.getBlock().getLocation()) && !e.getBlock().getType().equals(Material.TNT) && !e.getBlock().getType().equals(Material.FIRE)){

                e.setCancelled(true);
                return;

            }

        }

        // Blue
        if(Main.getInstance().blueTeam.contains(p.getUniqueId()) && !p.getGameMode().equals(GameMode.CREATIVE)){

            if(!Main.getInstance().blueBase.isInArea(e.getBlock().getLocation()) && !e.getBlock().getType().equals(Material.TNT) && !e.getBlock().getType().equals(Material.FIRE)){

                e.setCancelled(true);
                return;

            }

        }

        if(e.getBlock().getType().equals(Material.TNT) && (!GameStates.isState(GameStates.ASSAULTS) || !GameStates.isState(GameStates.DEATHMATCH))){

            p.sendMessage(Main.prefix + "§cLes assauts ne sont pas encore activés !");
            e.setCancelled(true);
            return;

        }

    }

}
