package fr.catsuri33.fk.listeners.player;

import fr.catsuri33.fk.Main;
import fr.catsuri33.fk.utils.GameStates;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreak implements Listener {

    @EventHandler
    public void onPlayerBreak(BlockBreakEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.WAITING) && !p.getGameMode().equals(GameMode.CREATIVE)){

            e.setCancelled(true);
            return;

        }

        // Rouge
        if(!Main.getInstance().redTeam.contains(p.getUniqueId())){

            if(Main.getInstance().redBase.isInArea(e.getBlock().getLocation())){

                e.setCancelled(true);
                return;

            }

        }

        // Bleu
        if(!Main.getInstance().blueTeam.contains(p.getUniqueId())){

            if(Main.getInstance().blueBase.isInArea(e.getBlock().getLocation())){

                e.setCancelled(true);
                return;

            }

        }

    }

}
