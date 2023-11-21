package fr.catsuri33.aoe.listeners;

import fr.catsuri33.aoe.items.ItemsList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack item = e.getItem();

        if(action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK) || action.equals(Action.RIGHT_CLICK_BLOCK)){

            if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§eÉquipe")){

                p.openInventory(ItemsList.inv);

            }

        }

    }

}
