package com.insignic.uhchost.game.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class NetherInventory {

    public static Inventory inv;
    public static boolean netherState = true;

    public static void createInventory() {

        inv = Bukkit.createInventory(null, 27, "§8Configurer les Slots");

        ItemStack is = new ItemStack(Material.BEDROCK);
        ItemMeta im = is.getItemMeta();

        // Nether State Item
        is.setType(Material.OBSIDIAN);
        im.setDisplayName("§eNether");
        List<String> lore = new ArrayList<>();

        if(netherState){

            lore.add("§7» Statut: §eActivé");

        } else {

            lore.add("§7» Statut: §eDésactivé");

        }

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(12, is);

        // Potions Item
        is.setType(Material.POTION);
        im.setDisplayName("§ePotions");
        lore.clear();
        lore.add("§7» Cliquez pour configurer");
        lore.add("§7les potions.");

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
