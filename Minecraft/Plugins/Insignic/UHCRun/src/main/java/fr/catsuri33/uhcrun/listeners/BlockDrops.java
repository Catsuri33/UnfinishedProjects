package fr.catsuri33.uhcrun.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockDrops implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        Location blockBreakLocation = e.getBlock().getLocation();

        switch(e.getBlock().getType()){

            case COAL_ORE:

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                blockBreakLocation.getWorld().dropItemNaturally(blockBreakLocation, new ItemStack(Material.TORCH, 4));

            break;

            case IRON_ORE:

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                blockBreakLocation.getWorld().dropItemNaturally(blockBreakLocation, new ItemStack(Material.IRON_INGOT, 2));

            break;

            case GOLD_ORE:

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                blockBreakLocation.getWorld().dropItemNaturally(blockBreakLocation, new ItemStack(Material.GOLD_INGOT, 2));

            break;

            case REDSTONE_ORE:

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                blockBreakLocation.getWorld().dropItemNaturally(blockBreakLocation, new ItemStack(Material.REDSTONE, 4));

            break;

            case EMERALD_ORE:

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                blockBreakLocation.getWorld().dropItemNaturally(blockBreakLocation, new ItemStack(Material.EMERALD, 2));

            break;

            case DIAMOND_ORE:

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                blockBreakLocation.getWorld().dropItemNaturally(blockBreakLocation, new ItemStack(Material.DIAMOND, 2));

            break;

            case GRAVEL:

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                blockBreakLocation.getWorld().dropItemNaturally(blockBreakLocation, new ItemStack(Material.ARROW, 2));

            break;

            case SAND:

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                blockBreakLocation.getWorld().dropItemNaturally(blockBreakLocation, new ItemStack(Material.GLASS, 1));

            break;

            case BROWN_MUSHROOM:

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                blockBreakLocation.getWorld().dropItemNaturally(blockBreakLocation, new ItemStack(Material.MUSHROOM_STEW, 2));

            break;

            case RED_MUSHROOM:

                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
                blockBreakLocation.getWorld().dropItemNaturally(blockBreakLocation, new ItemStack(Material.MUSHROOM_STEW, 2));

            break;

            default:
            break;

        }

    }

}
