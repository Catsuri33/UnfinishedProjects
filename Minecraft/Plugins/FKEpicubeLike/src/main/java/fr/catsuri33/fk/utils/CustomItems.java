package fr.catsuri33.fk.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CustomItems {

    public static ItemStack giveKitsItem(){

        ItemStack is = new ItemStack(Material.NAME_TAG);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§6Choisir un kit §7(Clic-droit)");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Choisissez votre kit de départ.");
        im.setLore(lore);
        is.setItemMeta(im);

        return is;

    }

}
