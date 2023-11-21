package com.insignicnetwork.essentials.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ReportGui {

    public static Inventory reportInv;

    public static void createInventory(Player p, Player target){

        reportInv = Bukkit.createInventory(null, 27, "§8Report: §e" + target.getName());

        // SpamBow Item
        ItemStack spamBowItem = new ItemStack(Material.BOW);
        ItemMeta spamBowItemMeta = spamBowItem.getItemMeta();

        spamBowItemMeta.setDisplayName("§cSpamBow");
        spamBowItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> spamBowLore = new ArrayList<>();
        spamBowLore.add("§7» Cliquez pour report pour SpamBow.");
        spamBowItemMeta.setLore(spamBowLore);
        spamBowItem.setItemMeta(spamBowItemMeta);

        reportInv.setItem(0, spamBowItem);

        // KillAura Item
        ItemStack killAuraItem = new ItemStack(Material.IRON_SWORD);
        ItemMeta killAuraItemMeta = killAuraItem.getItemMeta();

        killAuraItemMeta.setDisplayName("§cKillAura");
        killAuraItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> killAuraLore = new ArrayList<>();
        killAuraLore.add("§7» Cliquez pour report pour KillAura.");
        killAuraItemMeta.setLore(spamBowLore);
        killAuraItem.setItemMeta(killAuraItemMeta);

        reportInv.setItem(1, killAuraItem);

    }

}
