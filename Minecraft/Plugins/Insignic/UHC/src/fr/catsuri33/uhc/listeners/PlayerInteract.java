package fr.catsuri33.uhc.listeners;

import fr.catsuri33.uhc.ui.HostUI;
import fr.catsuri33.uhc.ui.TeamUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){

        Player player = e.getPlayer();
        Action action = e.getAction();
        ItemStack it = e.getItem();

        if(it == null) return;

        if(it.getType() == Material.COMPARATOR && it.hasItemMeta() && it.getItemMeta().hasDisplayName()){

            player.openInventory(HostUI.Gui(player));

        }

        if(it.getType() == Material.WHITE_BANNER && it.hasItemMeta() && it.getItemMeta().hasDisplayName()){

            player.openInventory(TeamUI.Gui(player));

        }

    }

}
