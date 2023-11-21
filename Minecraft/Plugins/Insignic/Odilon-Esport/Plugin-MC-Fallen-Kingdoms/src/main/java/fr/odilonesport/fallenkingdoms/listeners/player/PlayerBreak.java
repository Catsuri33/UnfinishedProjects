package fr.odilonesport.fallenkingdoms.listeners.player;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.guis.TeamGui;
import fr.odilonesport.fallenkingdoms.utils.GameStates;
import fr.odilonesport.fallenkingdoms.utils.RegionManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreak implements Listener {

    @EventHandler
    public void onPlayerBreak(BlockBreakEvent e){

        Player p = e.getPlayer();

        if(p.isOp() && p.getGameMode() == GameMode.CREATIVE){

            return;

        }

        if(GameStates.isState(GameStates.WAITING) || GameStates.isState(GameStates.END)){

            e.setCancelled(true);

        }

        Block block = e.getBlock();
        Material blockMaterial = block.getType();
        String playerTeamName = TeamGui.getPlayersTeam().get(p.getUniqueId()).toLowerCase();
        RegionManager playerBase = Main.getInstance().basesRegions.get(playerTeamName);

        for(RegionManager bases : Main.getInstance().basesRegions.values()){

            if(bases.isInArea(block.getLocation()) && bases != playerBase){

                if(blockMaterial.equals(Material.TNT) || blockMaterial.equals(Material.TNT_MINECART) || blockMaterial.equals(Material.WATER) || blockMaterial.equals(Material.LAVA) || blockMaterial.equals(Material.TORCH) || blockMaterial.equals(Material.REDSTONE_TORCH) || blockMaterial.equals(Material.LEVER) || blockMaterial.equals(Material.FIRE) || blockMaterial.equals(Material.CRAFTING_TABLE) || blockMaterial.equals(Material.FURNACE) || blockMaterial.equals(Material.FURNACE_MINECART) || blockMaterial.equals(Material.BLAST_FURNACE)){

                    return;

                }

                e.setCancelled(true);

            }

        }

    }

}
