package com.insignic.uhchost.game.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BorderInventory {

    public static Inventory inv;

    public static void createInventory() {

        inv = Bukkit.createInventory(null, 27, "§8Configurer la Bordure");

        ItemStack is = new ItemStack(Material.BEDROCK);
        ItemMeta im = is.getItemMeta();

        // Worldborder Time Begun Item
        is.setType(Material.CLOCK);
        im.setDisplayName("§eTemps Avant Bordure");
        List<String> lore = new ArrayList<>();
        lore.add("§7» Cliquez pour configurer le temps");
        lore.add("§7avant que la bordure bouge.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(11, is);

        // Worldborder Size Begun Item
        is.setType(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        im.setDisplayName("§eTaille Début");
        lore.clear();
        lore.add("§7» Cliquez pour configurer");
        lore.add("§7la taille de la bordure du début.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(12, is);

        // Worldborder Damages Item
        is.setType(Material.IRON_SWORD);
        im.setDisplayName("§eDégâts de la Bordure");
        lore.clear();
        lore.add("§7» Cliquez pour configurer les dégâts");
        lore.add("§7aux joueurs par la bordure.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(13, is);

        // Worldborder Size End Item
        is.setType(Material.RED_STAINED_GLASS_PANE);
        im.setDisplayName("§eTaille Fin");
        lore.clear();
        lore.add("§7» Cliquez pour configurer");
        lore.add("§7la taille de fin de la bordure.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(14, is);

        // Worldborder Time Begun Item
        is.setType(Material.CLOCK);
        im.setDisplayName("§eTemps Avant Bordure au Centre");
        lore.clear();
        lore.add("§7» Cliquez pour configurer le temps");
        lore.add("§7avant que la bordure atteigne le centre.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(15, is);

        // Return Item
        is.setType(Material.ARROW);
        im.setDisplayName("§eRetour");
        lore.clear();

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(22, is);

    }

}
