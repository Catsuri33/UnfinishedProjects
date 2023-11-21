package com.insignic.uhchost.game.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PvPInventory {

    public static Inventory inv;
    public static boolean isPvPClassic = true;

    public static void createInventory() {

        inv = Bukkit.createInventory(null, 27, "§8Configurer le PvP");

        ItemStack is = new ItemStack(Material.BEDROCK);
        ItemMeta im = is.getItemMeta();

        // PvP Type Item
        is.setType(Material.DIAMOND_SWORD);
        im.setDisplayName("§ePvP");
        List<String> lore = new ArrayList<>();

        if(isPvPClassic){

            lore.add("§7» Statut: §e1.9");

        } else {

            lore.add("§7» Statut: §e1.8");

        }

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(12, is);

        // PvP Timer Item
        is.setType(Material.BLUE_STAINED_GLASS_PANE);
        im.setDisplayName("§eTemps avant PvP");
        lore.clear();
        lore.add("§7» Cliquez pour configurer le temps");
        lore.add("§7avant activation du PvP.");

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(14, is);

        // Return Item
        is.setType(Material.ARROW);
        im.setDisplayName("§eRetour");
        lore.clear();

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(22, is);

    }

}
