package fr.odilonesport.fallenkingdoms.listeners.player;

import fr.odilonesport.fallenkingdoms.game.guis.TeamGui;
import fr.odilonesport.fallenkingdoms.utils.GameStates;
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

        Player p = e.getPlayer();
        TeamGui teamGui = new TeamGui(p);

        if(GameStates.isState(GameStates.WAITING)){

            if((e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))){

                ItemStack is = e.getItem();

                if (is != null && (is.getType().equals(Material.WHITE_BANNER) || is.getType().equals(Material.RED_BANNER) || is.getType().equals(Material.YELLOW_BANNER) || is.getType().equals(Material.GREEN_BANNER) || is.getType().equals(Material.LIGHT_BLUE_BANNER) || is.getType().equals(Material.PINK_BANNER) || is.getType().equals(Material.BLUE_BANNER))){

                    teamGui.openInventory(p);

                }

            }

        }

    }

}
