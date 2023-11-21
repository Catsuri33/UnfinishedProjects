package fr.epicgiant.api.bukkit.utils;

import net.minecraft.server.v1_14_R1.EnumColor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;

import java.util.Random;

public class ColorUtils {

    private static Color[] colors;
    private static DyeColor[] dyeColors;
    private static ChatColor[] chatColors;
    private static EnumColor[] enumColors;

    /**
     * Get a random color
     * @return
     */
    public static Color getRandomColor(){

        return ColorUtils.colors[new Random().nextInt(16)];

    }

    /**
     * Get a random enum color
     * @return
     */
    public static EnumColor getRandomEnumColor(){

        return ColorUtils.enumColors[new Random().nextInt(16)];

    }

    /**
     * Get a random DyeColor
     * @return
     */
    public static DyeColor getRandomDyeColor(){

        return ColorUtils.dyeColors[new Random().nextInt(16)];

    }

    /**
     * Get a random ChatColor
     * @return
     */
    public static ChatColor getRandomChatColor(){

        return ColorUtils.chatColors[new Random().nextInt(16)];

    }

    static {
        ColorUtils.colors = new Color[]{
                Color.AQUA,
                Color.BLUE,
                Color.BLACK,
                Color.FUCHSIA,
                Color.GRAY,
                Color.GREEN,
                Color.LIME,
                Color.MAROON,
                Color.NAVY,
                Color.ORANGE,
                Color.PURPLE,
                Color.RED,
                Color.SILVER,
                Color.TEAL,
                Color.WHITE,
                Color.YELLOW
        };

        ColorUtils.dyeColors = new DyeColor[]{
                DyeColor.YELLOW,
                DyeColor.WHITE,
                DyeColor.RED,
                DyeColor.PURPLE,
                DyeColor.ORANGE,
                DyeColor.LIME,
                DyeColor.GREEN,
                DyeColor.GRAY,
                DyeColor.BLACK,
                DyeColor.BLUE,
                DyeColor.BROWN,
                DyeColor.CYAN,
                DyeColor.LIGHT_BLUE,
                DyeColor.LIGHT_GRAY,
                DyeColor.MAGENTA,
                DyeColor.PINK
        };

        ColorUtils.chatColors = new ChatColor[]{
                ChatColor.YELLOW,
                ChatColor.WHITE,
                ChatColor.RED,
                ChatColor.GREEN,
                ChatColor.GRAY,
                ChatColor.BLACK,
                ChatColor.BLUE,
                ChatColor.AQUA,
                ChatColor.DARK_AQUA,
                ChatColor.DARK_BLUE,
                ChatColor.DARK_GRAY,
                ChatColor.DARK_GREEN,
                ChatColor.DARK_PURPLE,
                ChatColor.DARK_RED,
                ChatColor.GOLD,
                ChatColor.LIGHT_PURPLE
        };

        ColorUtils.enumColors = new EnumColor[]{
                EnumColor.LIGHT_BLUE,
                EnumColor.LIGHT_GRAY,
                EnumColor.BLUE,
                EnumColor.BLACK,
                EnumColor.GRAY,
                EnumColor.GREEN,
                EnumColor.LIME,
                EnumColor.ORANGE,
                EnumColor.PURPLE,
                EnumColor.RED,
                EnumColor.WHITE,
                EnumColor.YELLOW,
                EnumColor.BROWN,
                EnumColor.CYAN,
                EnumColor.MAGENTA,
                EnumColor.PINK
        };
    }

}
