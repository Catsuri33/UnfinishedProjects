package com.insignicnetwork.lobby.utils;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemStackUtils {

    public static ItemStack createItemStack(ItemStack item, String displayName, ArrayList<String> description){

        final ItemMeta im = item.getItemMeta();

        im.setDisplayName(displayName);
        im.setLore(description);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(im);

        return item;

    }

}
