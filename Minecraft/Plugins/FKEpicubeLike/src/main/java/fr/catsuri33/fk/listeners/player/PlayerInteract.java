package fr.catsuri33.fk.listeners.player;

import fr.catsuri33.fk.game.guis.KitsGui;
import fr.catsuri33.fk.game.player.GamePlayer;
import fr.catsuri33.fk.utils.GameStates;
import org.bukkit.GameMode;
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
        GamePlayer gamePlayer = GamePlayer.gamePlayers.get(p.getName());
        KitsGui kitsGui = new KitsGui(p);

        if(!gamePlayer.isInBase){

            if((p.getItemInHand().getType().equals(Material.WATER_BUCKET) || p.getItemInHand().getType().equals(Material.LAVA_BUCKET) || p.getItemInHand().getType().equals(Material.OAK_FENCE_GATE) || p.getItemInHand().getType().equals(Material.OAK_DOOR) || p.getItemInHand().getType().equals(Material.OAK_BUTTON) || p.getItemInHand().getType().equals(Material.LEVER)) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && !p.getGameMode().equals(GameMode.CREATIVE)){

                e.setCancelled(true);
                return;

            }

        }

        if(GameStates.isState(GameStates.WAITING)){

            if ((e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))){

                ItemStack is = e.getItem();

                if (is != null && is.getType().equals(Material.NAME_TAG)){

                    kitsGui.openInventory(p);

                }

            }

        }

    }

}
