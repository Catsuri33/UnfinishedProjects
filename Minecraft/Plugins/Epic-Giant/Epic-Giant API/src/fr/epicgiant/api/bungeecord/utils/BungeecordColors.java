package fr.epicgiant.api.bungeecord.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.Random;

public class BungeecordColors {

    private static ChatColor[] chatColors;

    static {
        BungeecordColors.chatColors = new ChatColor[]{
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
    }

    public static ChatColor getRandomChatColor(){

        return BungeecordColors.chatColors[new Random().nextInt(7)];

    }

}
