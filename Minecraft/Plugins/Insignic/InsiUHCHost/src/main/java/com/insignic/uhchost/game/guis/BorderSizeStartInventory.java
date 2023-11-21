package com.insignic.uhchost.game.guis;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.WorldBorder;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BorderSizeStartInventory {

    public static Inventory inv;

    public static void createInventory() {

        inv = Bukkit.createInventory(null, 27, "§8Taille de la Bordure de Début");

        ItemStack is = new ItemStack(Material.BARRIER);
        ItemMeta im = is.getItemMeta();
        ItemStack bannerIs = new ItemStack(Material.LIGHT_BLUE_BANNER);
        BannerMeta bannerMeta = (BannerMeta) bannerIs.getItemMeta();

        // Worldborder Banner -50
        bannerIs.setType(Material.RED_BANNER);
        bannerMeta.setDisplayName("§e-50");
        List<String> lore = new ArrayList<>();

        List<Pattern> patterns = new ArrayList<>();

        patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE));
        patterns.add(new Pattern(DyeColor.RED, PatternType.BORDER));
        patterns.add(new Pattern(DyeColor.RED, PatternType.STRIPE_BOTTOM));
        patterns.add(new Pattern(DyeColor.RED, PatternType.STRIPE_TOP));

        bannerMeta.setPatterns(patterns);

        bannerMeta.setLore(lore);
        bannerIs.setItemMeta(bannerMeta);

        inv.setItem(10, bannerIs);

        // Worldborder Banner -10
        bannerIs.setType(Material.ORANGE_BANNER);
        bannerMeta.setDisplayName("§e-10");
        lore.clear();

        patterns.clear();

        patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE));
        patterns.add(new Pattern(DyeColor.ORANGE, PatternType.BORDER));
        patterns.add(new Pattern(DyeColor.ORANGE, PatternType.STRIPE_BOTTOM));
        patterns.add(new Pattern(DyeColor.ORANGE, PatternType.STRIPE_TOP));

        bannerMeta.setPatterns(patterns);

        bannerMeta.setLore(lore);
        bannerIs.setItemMeta(bannerMeta);

        inv.setItem(11, bannerIs);

        // Worldborder Banner -5
        bannerIs.setType(Material.YELLOW_BANNER);
        bannerMeta.setDisplayName("§e-5");
        lore.clear();

        patterns.clear();

        patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE));
        patterns.add(new Pattern(DyeColor.YELLOW, PatternType.BORDER));
        patterns.add(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_BOTTOM));
        patterns.add(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_TOP));

        bannerMeta.setPatterns(patterns);

        bannerMeta.setLore(lore);
        bannerIs.setItemMeta(bannerMeta);

        inv.setItem(12, bannerIs);

        // Worldborder Size Item
        WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();

        is.setType(Material.BARRIER);
        im.setDisplayName("§eBordure");
        lore.clear();
        lore.add("§7» Taille: §e" + wb.getSize());

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(13, is);

        // Worldborder Banner +5
        bannerIs.setType(Material.LIME_BANNER);
        bannerMeta.setDisplayName("§e+5");
        lore.clear();

        patterns.clear();

        patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRAIGHT_CROSS));
        patterns.add(new Pattern(DyeColor.LIME, PatternType.BORDER));
        patterns.add(new Pattern(DyeColor.LIME, PatternType.STRIPE_BOTTOM));
        patterns.add(new Pattern(DyeColor.LIME, PatternType.STRIPE_TOP));

        bannerMeta.setPatterns(patterns);

        bannerMeta.setLore(lore);
        bannerIs.setItemMeta(bannerMeta);

        inv.setItem(14, bannerIs);

        // Worldborder Banner +10
        bannerIs.setType(Material.GREEN_BANNER);
        bannerMeta.setDisplayName("§e+10");
        lore.clear();

        patterns.clear();

        patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRAIGHT_CROSS));
        patterns.add(new Pattern(DyeColor.GREEN, PatternType.BORDER));
        patterns.add(new Pattern(DyeColor.GREEN, PatternType.STRIPE_BOTTOM));
        patterns.add(new Pattern(DyeColor.GREEN, PatternType.STRIPE_TOP));

        bannerMeta.setPatterns(patterns);

        bannerMeta.setLore(lore);
        bannerIs.setItemMeta(bannerMeta);

        inv.setItem(15, bannerIs);

        // Worldborder Banner +50
        bannerIs.setType(Material.LIGHT_BLUE_BANNER);
        bannerMeta.setDisplayName("§e+50");
        lore.clear();

        patterns.clear();

        patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRAIGHT_CROSS));
        patterns.add(new Pattern(DyeColor.LIGHT_BLUE, PatternType.BORDER));
        patterns.add(new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_BOTTOM));
        patterns.add(new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_TOP));

        bannerMeta.setPatterns(patterns);

        bannerMeta.setLore(lore);
        bannerIs.setItemMeta(bannerMeta);

        inv.setItem(16, bannerIs);

        // Return Item
        is.setType(Material.ARROW);
        im.setDisplayName("§eRetour");
        lore.clear();

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(22, is);

    }

}
