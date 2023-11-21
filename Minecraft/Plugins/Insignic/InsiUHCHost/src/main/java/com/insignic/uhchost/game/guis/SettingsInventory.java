package com.insignic.uhchost.game.guis;

import com.insignic.uhchost.UHCHost;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SettingsInventory {

    public static Inventory inv;

    public static void createInventory(){

        inv = Bukkit.createInventory(null, 27, "§8Paramètres");

        ItemStack is = new ItemStack(Material.WHITE_STAINED_GLASS);
        ItemMeta im = is.getItemMeta();

        // Settings Item
        im.setDisplayName("§eSol du Lobby");
        List<String> lore = new ArrayList<>();
        lore.add("§7» Modifier les paramètres");
        lore.add("§7du sol du lobby.");

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("All")){

            lore.add("§7Statut: §eTout");

        }

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("OnlyTeam")){

            lore.add("§7Statut: §eEquipes Uniquement");

        }

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("OnlyDefault")){

            lore.add("§7Statut: §eMulticolore Uniquement");

        }

        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("Deactivated")){

            lore.add("§7Statut: §eDésactivé");

        }

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(10, is);

        // Return Item
        is.setType(Material.ARROW);
        im.setDisplayName("§eRetour");
        lore.clear();

        im.setLore(lore);
        is.setItemMeta(im);

        inv.setItem(22, is);

    }

}
