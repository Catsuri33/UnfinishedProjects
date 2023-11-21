package fr.catsuri33.uhc.listeners;

import fr.catsuri33.uhc.game.Gamestates;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        if(Gamestates.isState(Gamestates.LOBBY) || Gamestates.isState(Gamestates.END)){

            e.setCancelled(true);

        }

    }

}
