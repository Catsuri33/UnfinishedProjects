package fr.catsuri33.insifactions.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GuiManager {

    public static Inventory createFactionInv;

    public static void createFactionInv(){

        createFactionInv = Bukkit.createInventory(null, 27, "§8Créer une Faction");

        // Validate Item
        ItemStack validateItem = new ItemStack(Material.GREEN_TERRACOTTA);
        ItemMeta validateMeta = validateItem.getItemMeta();

        validateMeta.setDisplayName("§6Créer la Faction");
        List<String> validateLore = new ArrayList<>();
        validateLore.add("§7» Valider la création de");
        validateLore.add("§7votre faction.");
        validateMeta.setLore(validateLore);
        validateItem.setItemMeta(validateMeta);

        // Faction Name Item
        ItemStack factionNameItem = new ItemStack(Material.NAME_TAG);
        ItemMeta factionNameMeta = factionNameItem.getItemMeta();

        factionNameMeta.setDisplayName("§6Nom");
        List<String> factionNameLore = new ArrayList<>();
        factionNameLore.add("§7» Choisir le nom de votre");
        factionNameLore.add("§7faction.");
        factionNameLore.add("§7» ");
        factionNameMeta.setLore(factionNameLore);
        factionNameItem.setItemMeta(factionNameMeta);

        createFactionInv.setItem(2, factionNameItem);
        createFactionInv.setItem(22, validateItem);

    }

}
