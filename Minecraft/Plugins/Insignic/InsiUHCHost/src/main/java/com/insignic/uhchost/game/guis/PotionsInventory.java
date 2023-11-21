package com.insignic.uhchost.game.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class PotionsInventory {

    public static Inventory inv;
    public static boolean night_vision_1_potion = true;

    public static void createInventory() {

        inv = Bukkit.createInventory(null, 27, "§8Configurer les Potions");

        ItemStack is = new ItemStack(Material.BEDROCK);
        ItemMeta im = is.getItemMeta();
        ItemStack isPotion = new ItemStack(Material.POTION);
        PotionMeta imPotion = (PotionMeta) isPotion.getItemMeta();

        // Night Vision Potion Item
        isPotion.setType(Material.POTION);
        imPotion.setDisplayName("§eNight Vision I");
        List<String> lore = new ArrayList<>();

        if(night_vision_1_potion){

            lore.add("§7» Statut: §eActivé");

        } else {

            lore.add("§7» Statut: §eDésactivé");

        }

        imPotion.setBasePotionData(new PotionData(PotionType.NIGHT_VISION, false, false));

        imPotion.setLore(lore);
        isPotion.setItemMeta(imPotion);

        inv.setItem(0, isPotion);

        // Return Item
        is.setType(Material.ARROW);
        im.setDisplayName("§eRetour");
        lore.clear();

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(22, is);

    }

}
