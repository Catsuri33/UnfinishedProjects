package fr.odilonesport.fallenkingdoms.utils;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public enum BannerColor {

    RED("§c", Material.RED_BANNER),
    YELLOW("§e", Material.YELLOW_BANNER),
    BLUE("§9", Material.BLUE_BANNER),
    GREEN("§a", Material.GREEN_BANNER),
    AQUA("§b", Material.LIGHT_BLUE_BANNER),
    PINK("§d", Material.PINK_BANNER);

    String color;
    Material banner;
    public static List<String> colors = Arrays.asList("§c", "§e", "§9", "§a", "§b", "§d");

    BannerColor(String color, Material banner) {

        this.color = color;
        this.banner = banner;

    }

    public static Material getBanner(String color) {

        for(BannerColor teamColor : BannerColor.values()) {

            if(teamColor.color.equalsIgnoreCase(color)){

                return teamColor.banner;

            }

        }

        return Material.WHITE_BANNER;

    }

}
