package fr.catsuri33.aoe.listeners;

import fr.catsuri33.aoe.items.ItemsList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerClick implements Listener {

    @EventHandler
    public void onPlayerClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getCurrentItem() == null){

            return;

        }

        if(e.getInventory().equals(ItemsList.inv)){

            if(e.getSlot() == 10){

                // Red team
                p.setDisplayName("§c" + p.getName());
                p.setPlayerListName("§c" + p.getName());
                p.closeInventory();
                p.sendMessage("§6AgeOfEmpires §l» §r§aVous avez rejoins l'équipe §cRouge §a!");

            }

            if(e.getSlot() == 11){

                // Blue Team
                p.setDisplayName("§9" + p.getName());
                p.setPlayerListName("§9" + p.getName());
                p.closeInventory();
                p.sendMessage("§6AgeOfEmpires §l» §r§aVous avez rejoins l'équipe §9Bleu §a!");

            }

            if(e.getSlot() == 22){

                // Close Button
                p.closeInventory();

            }

        }

        e.setCancelled(true);

    }

}
