package com.insignic.uhchost.game.guis;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PvPTimeInventory {

    public static Inventory inv;
    public static long pvpTime = 1800;

    public static void createInventory() {

        inv = Bukkit.createInventory(null, 27, "§8Configurer le Temps avant PvP");

        ItemStack is = new ItemStack(Material.CLOCK);
        ItemMeta im = is.getItemMeta();
        ItemStack bannerIs = new ItemStack(Material.LIGHT_BLUE_BANNER);
        BannerMeta bannerMeta = (BannerMeta) bannerIs.getItemMeta();

        // Worldborder Banner -60
        bannerIs.setType(Material.RED_BANNER);
        bannerMeta.setDisplayName("§e-60");
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

        // Worldborder Time Item
        is.setType(Material.CLOCK);
        im.setDisplayName("§eTemps Avant PvP");
        lore.clear();
        lore.add("§7» Temps: §e" + pvpTime / 60 + "min");
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

        // Worldborder Banner +60
        bannerIs.setType(Material.LIGHT_BLUE_BANNER);
        bannerMeta.setDisplayName("§e+60");
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
