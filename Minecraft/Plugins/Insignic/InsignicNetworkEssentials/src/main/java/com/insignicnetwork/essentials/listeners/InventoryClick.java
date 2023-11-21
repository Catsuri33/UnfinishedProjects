package com.insignicnetwork.essentials.listeners;

import com.insignicnetwork.essentials.guis.ReportGui;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getInventory().equals(ReportGui.reportInv) && e.getSlot() == 0){

            e.setCancelled(true);
            p.closeInventory();
            sendToModerators(e.getCurrentItem().getItemMeta().getDisplayName(), e.getView().getTitle().substring(12));
            p.sendMessage("§aVotre signalement a été envoyé à un §9Modérateur §a!");

        }

        if(e.getInventory().equals(ReportGui.reportInv) && e.getSlot() == 1){

            e.setCancelled(true);
            p.closeInventory();
            sendToModerators(e.getCurrentItem().getItemMeta().getDisplayName(), e.getView().getTitle().substring(12));
            p.sendMessage("§aVotre signalement a été envoyé à un §9Modérateur §a!");

        }

    }

    private void sendToModerators(String reason, String targetName){

        for(Player players : Bukkit.getOnlinePlayers()){

            if(players.isOp() || players.hasPermission("insignicnetwork.mod")){

                players.sendMessage("§7[§cREPORT§7] §cLe joueur §e" + targetName + " §ca été signalé pour: §e" + reason + " §c!");

            }

        }

    }

}
