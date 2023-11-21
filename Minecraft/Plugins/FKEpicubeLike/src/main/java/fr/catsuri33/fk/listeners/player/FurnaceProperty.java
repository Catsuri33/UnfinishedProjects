package fr.catsuri33.fk.listeners.player;

import fr.catsuri33.fk.Main;
import fr.catsuri33.fk.game.player.GamePlayer;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class FurnaceProperty implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){

        Player p = e.getPlayer();
        GamePlayer gamePlayer = GamePlayer.gamePlayers.get(p.getName());
        Block block = e.getBlock();

        switch(block.getType()){

            case FURNACE:
            case SMOKER:
            case BLAST_FURNACE:
                p.sendMessage(Main.prefix + "§aCe four vous appartient désormais !");
                gamePlayer.furnaces.add(e.getBlock());
                break;
            default:
                break;

        }

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        Player p = e.getPlayer();
        GamePlayer gamePlayer = GamePlayer.gamePlayers.get(p.getName());
        Block block = e.getBlock();

        switch(block.getType()){

            case FURNACE:
            case SMOKER:
            case BLAST_FURNACE:

                if(gamePlayer.furnaces.contains(e.getBlock())){

                    gamePlayer.furnaces.remove(e.getBlock());

                } else {

                    p.sendMessage(Main.prefix + "§cCe four ne vous appartient pas !");
                    e.setCancelled(true);

                }

                break;
            default:
                break;

        }

    }

    @EventHandler
    public void onFurnaceInteract(PlayerInteractEvent e){

        Player p = e.getPlayer();
        GamePlayer gamePlayer = GamePlayer.gamePlayers.get(p.getName());

        if(e.getClickedBlock() != null){

            if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

                switch(e.getClickedBlock().getType()){

                    case FURNACE:
                    case SMOKER:
                    case BLAST_FURNACE:

                        if(!gamePlayer.furnaces.contains(e.getClickedBlock())){

                            p.sendMessage(Main.prefix + "§cCe four ne vous appartient pas !");
                            e.setCancelled(true);

                        }

                        break;
                    default:
                        break;

                }

            }

        }

    }

}
