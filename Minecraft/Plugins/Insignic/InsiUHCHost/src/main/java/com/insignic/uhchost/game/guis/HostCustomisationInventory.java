package com.insignic.uhchost.game.guis;

import com.insignic.uhchost.UHCHost;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class HostCustomisationInventory {

    public static Inventory inv;

    public static void createInventory(){

        inv = Bukkit.createInventory(null, 36, "§8Configurer la Partie");

        ItemStack isHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta imHead = (SkullMeta) isHead.getItemMeta();
        ItemStack is = new ItemStack(Material.LIME_CONCRETE);
        ItemMeta im = is.getItemMeta();

        // PVP Item
        is.setType(Material.DIAMOND_SWORD);
        im.setDisplayName("§ePvP");
        List<String> lore = new ArrayList<>();
        lore.add("§7» Cliquez pour configurer");
        lore.add("§7les paramètres du PvP.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(9, is);

        // Worldborder Item
        is.setType(Material.BARRIER);
        im.setDisplayName("§eBordure");
        lore.clear();
        lore.add("§7» Cliquez pour configurer");
        lore.add("§7la bordure.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(12, is);

        // GameMode Item
        is.setType(Material.BLACK_BANNER);
        im.setDisplayName("§eMode de Jeu");
        lore.clear();

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("FFA")){

            lore.add("§7» Mode: §eFFA");

        }

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("2vs2")){

            lore.add("§7» Mode: §e2vs2");

        }

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("3vs3")){

            lore.add("§7» Mode: §e3vs3");

        }

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("4vs4")){

            lore.add("§7» Mode: §e4vs4");

        }

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("5vs5")){

            lore.add("§7» Mode: §e5vs5");

        }

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("10vs10")){

            lore.add("§7» Mode: §e10vs10");

        }

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("25vs25")){

            lore.add("§7» Mode: §e25vs25");

        }

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.server.gamemode").equals("50vs50")){

            lore.add("§7» Mode: §e50vs50");

        }

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(13, is);

        // Slots Item
        is.setType(Material.COMPASS);
        im.setDisplayName("§eSlots");
        lore.clear();
        lore.add("§7» Cliquez pour configurer");
        lore.add("§7les slots de la partie.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(14, is);

        // Nether Item
        is.setType(Material.OBSIDIAN);
        im.setDisplayName("§eNether");
        lore.clear();
        lore.add("§7» Cliquez pour configurer");
        lore.add("§7les paramètres du nether.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(17, is);

        // Configs Item
        is.setType(Material.COMMAND_BLOCK_MINECART);
        im.setDisplayName("§eConfigurations");
        lore.clear();
        lore.add("§7» Cliquez pour choisir");
        lore.add("§7un configuration pré-définie.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(27, is);

        // Tweet Item
        imHead.setDisplayName("§eTweeter");
        imHead.setOwner("MHF_Twitter");
        lore.clear();
        lore.add("§7» Poster un tweet sur");
        lore.add("§7le compte §e@InsiUHCHost§7.");
        imHead.setLore(lore);
        isHead.setItemMeta(imHead);

        inv.setItem(30, isHead);

        // Start Game Item
        is.setType(Material.LIME_CONCRETE);
        im.setDisplayName("§eDémarrer la Partie");
        lore.clear();
        lore.add("§7» Cliquez pour démarrer");
        lore.add("§7la partie.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(31, is);

        // Pregen Map Item
        is.setType(Material.GRASS_BLOCK);
        im.setDisplayName("§ePré-Générer la Map");
        lore.clear();
        lore.add("§7» Cliquez pour pré-générer");
        lore.add("§7la map.");
        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(32, is);

        // Settings Item
        isHead.setType(Material.PLAYER_HEAD);
        imHead.setDisplayName("§eParamètres");
        imHead.setOwner("EladYat");
        lore.clear();
        lore.add("§7» Modifier les paramètres");
        lore.add("§7du serveur.");
        imHead.setLore(lore);
        isHead.setItemMeta(imHead);

        inv.setItem(35, isHead);

    }

    public static void giveHostItem(Player p, Inventory inv){

        ItemStack hostItem = new ItemStack(Material.CHEST);
        ItemMeta hostItemMeta = hostItem.getItemMeta();
        List<String> loreHostItem = new ArrayList<>();

        hostItemMeta.setDisplayName("§eHost");
        loreHostItem.add("§7» Cliquez pour configurer");
        loreHostItem.add("§7votre partie.");
        hostItemMeta.setLore(loreHostItem);
        hostItem.setItemMeta(hostItemMeta);

        inv.setItem(4, hostItem);

    }

}
