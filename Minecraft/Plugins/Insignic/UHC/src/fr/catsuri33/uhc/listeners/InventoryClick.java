package fr.catsuri33.uhc.listeners;

import fr.catsuri33.uhc.ui.HostUI;
import fr.catsuri33.uhc.ui.SlotsUI;
import fr.catsuri33.uhc.ui.TeamUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){

        String title = e.getView().getTitle();

        if(title.equalsIgnoreCase(HostUI.inventoryName)){

            e.setCancelled(true);

            if(e.getCurrentItem() == null){

                return;

            }

            if(title.equalsIgnoreCase(HostUI.inventoryName)){

                HostUI.onClicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());

            }

        }

        if(title.equalsIgnoreCase(SlotsUI.inventoryName)){

            e.setCancelled(true);

            if(e.getCurrentItem() == null){

                return;

            }

            if(title.equalsIgnoreCase(SlotsUI.inventoryName)){

                SlotsUI.onClicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());

            }

        }

        if(title.equalsIgnoreCase(TeamUI.inventoryName)){

            e.setCancelled(true);

            if(e.getCurrentItem() == null){

                return;

            }

            if(title.equalsIgnoreCase(TeamUI.inventoryName)){

                TeamUI.onClicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());

            }

        }

    }

}
