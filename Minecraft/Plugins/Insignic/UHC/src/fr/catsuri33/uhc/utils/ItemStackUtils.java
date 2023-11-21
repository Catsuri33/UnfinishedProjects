package fr.catsuri33.uhc.utils;

import org.bukkit.ChatColor;
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

public class ItemStackUtils {

    public static String chat(String s){

        return ChatColor.translateAlternateColorCodes('&', s);

    }

    public static ItemStack createItem(Inventory inv, String material, int amount, int invSlot, String displayName, String... loreString){

        ItemStack item;
        List<String> lore = new ArrayList();

        item = new ItemStack(Material.matchMaterial(material), amount);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ItemStackUtils.chat(displayName));

        for(String s : loreString){

            lore.add(ItemStackUtils.chat(s));

        }

        meta.setLore(lore);
        item.setItemMeta(meta);

        inv.setItem(invSlot - 1, item);
        return item;

    }

    @SuppressWarnings("deprecation")
    public static ItemStack createItemByte(Inventory inv, String material, int byteID, int amount, int invSlot, String displayName, String... loreString){

        ItemStack item;
        List<String> lore = new ArrayList();

        item = new ItemStack(Material.matchMaterial(material), amount, (short) byteID);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ItemStackUtils.chat(displayName));

        for(String s : loreString){

            lore.add(ItemStackUtils.chat(s));

        }

        meta.setLore(lore);
        item.setItemMeta(meta);

        inv.setItem(invSlot - 1, item);
        return item;

    }

    public static ItemStack createHeartBanner(Inventory inv, String material, int amount, int invSlot, String displayName, String... loreString){

        ItemStack item;
        List<String> lore = new ArrayList();

        item = new ItemStack(Material.matchMaterial(material), amount);

        BannerMeta meta = (BannerMeta)item.getItemMeta();
        meta.setDisplayName(ItemStackUtils.chat(displayName));

        for(String s : loreString){

            lore.add(ItemStackUtils.chat(s));

        }

        meta.setLore(lore);

        List<Pattern> patterns = new ArrayList<Pattern>();
        patterns.add(new Pattern(DyeColor.WHITE, PatternType.RHOMBUS_MIDDLE));

        if(material.equalsIgnoreCase("light_blue_banner")){

            patterns.add(new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLE_TOP));
            patterns.add(new Pattern(DyeColor.LIGHT_BLUE, PatternType.BORDER));
            patterns.add(new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_TOP));

        } else {

            if(material.equalsIgnoreCase("blue_banner")){

                patterns.add(new Pattern(DyeColor.BLUE, PatternType.TRIANGLE_TOP));
                patterns.add(new Pattern(DyeColor.BLUE, PatternType.BORDER));
                patterns.add(new Pattern(DyeColor.BLUE, PatternType.STRIPE_TOP));

            } else {

                if(material.equalsIgnoreCase("red_banner")){

                    patterns.add(new Pattern(DyeColor.RED, PatternType.TRIANGLE_TOP));
                    patterns.add(new Pattern(DyeColor.RED, PatternType.BORDER));
                    patterns.add(new Pattern(DyeColor.RED, PatternType.STRIPE_TOP));

                } else {

                    if(material.equalsIgnoreCase("orange_banner")){

                        patterns.add(new Pattern(DyeColor.ORANGE, PatternType.TRIANGLE_TOP));
                        patterns.add(new Pattern(DyeColor.ORANGE, PatternType.BORDER));
                        patterns.add(new Pattern(DyeColor.ORANGE, PatternType.STRIPE_TOP));

                    } else {

                        if(material.equalsIgnoreCase("yellow_banner")){

                            patterns.add(new Pattern(DyeColor.YELLOW, PatternType.TRIANGLE_TOP));
                            patterns.add(new Pattern(DyeColor.YELLOW, PatternType.BORDER));
                            patterns.add(new Pattern(DyeColor.YELLOW, PatternType.STRIPE_TOP));

                        } else {

                            if(material.equalsIgnoreCase("lime_banner")){

                                patterns.add(new Pattern(DyeColor.LIME, PatternType.TRIANGLE_TOP));
                                patterns.add(new Pattern(DyeColor.LIME, PatternType.BORDER));
                                patterns.add(new Pattern(DyeColor.LIME, PatternType.STRIPE_TOP));

                            } else {

                                if(material.equalsIgnoreCase("pink_banner")){

                                    patterns.add(new Pattern(DyeColor.PINK, PatternType.TRIANGLE_TOP));
                                    patterns.add(new Pattern(DyeColor.PINK, PatternType.BORDER));
                                    patterns.add(new Pattern(DyeColor.PINK, PatternType.STRIPE_TOP));

                                } else {

                                    if(material.equalsIgnoreCase("purple_banner")){

                                        patterns.add(new Pattern(DyeColor.PURPLE, PatternType.TRIANGLE_TOP));
                                        patterns.add(new Pattern(DyeColor.PURPLE, PatternType.BORDER));
                                        patterns.add(new Pattern(DyeColor.PURPLE, PatternType.STRIPE_TOP));

                                    }

                                }

                            }

                        }

                    }

                }

            }

        }

        meta.setPatterns(patterns);

        item.setItemMeta(meta);

        inv.setItem(invSlot - 1, item);
        return item;

    }

}
