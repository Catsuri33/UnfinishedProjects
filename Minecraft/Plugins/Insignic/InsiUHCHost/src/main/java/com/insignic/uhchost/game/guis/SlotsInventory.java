package com.insignic.uhchost.game.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SlotsInventory {

    public static Inventory inv;
    public static boolean spectator = true;

    public static void createInventory() {

        inv = Bukkit.createInventory(null, 27, "§8Configurer les Slots");

        ItemStack is = new ItemStack(Material.BEDROCK);
        ItemMeta im = is.getItemMeta();

        // Slots Item
        is.setType(Material.PLAYER_HEAD);
        im.setDisplayName("§eSlots");
        List<String> lore = new ArrayList<>();
        lore.add("§7» Cliquez pour configurer");
        lore.add("§7les slots.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(12, is);

        // Spectator Item
        is.setType(Material.ARMOR_STAND);
        im.setDisplayName("§eSpectateurs");
        lore.clear();

        if(spectator){

            lore.add("§7» Statut: §eActivés");

        } else {

            lore.add("§7» Statut: §eDésactivés");

        }

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(14, is);

        // Slots Item
        is.setType(Material.ARROW);
        im.setDisplayName("§eRetour");
        lore.clear();

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(22, is);

    }

}
