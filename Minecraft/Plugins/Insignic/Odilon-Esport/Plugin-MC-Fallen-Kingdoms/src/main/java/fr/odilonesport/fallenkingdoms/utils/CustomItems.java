package fr.odilonesport.fallenkingdoms.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CustomItems {

    public static ItemStack giveTeamItemStart(){

        ItemStack is = new ItemStack(Material.WHITE_BANNER);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§6Choisir une équipe §7(Clic-droit)");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Choisissez votre équipe.");
        im.setLore(lore);
        is.setItemMeta(im);

        return is;

    }

    public static ItemStack giveTeamItem(String teamColor){

        ItemStack is = new ItemStack(BannerColor.getBanner(teamColor));
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§6Choisir une équipe §7(Clic-droit)");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Choisissez votre équipe.");
        im.setLore(lore);
        is.setItemMeta(im);

        return is;

    }

}
