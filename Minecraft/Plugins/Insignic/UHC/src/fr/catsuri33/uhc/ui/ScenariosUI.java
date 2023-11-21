package fr.catsuri33.uhc.ui;

import fr.catsuri33.uhc.utils.ItemStackUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ScenariosUI {

    public static Inventory inv;
    public static String inventoryName;
    public static int inventoryRows = 4 * 9;

    public static void initializeSlotsUI(){

        inventoryName = ItemStackUtils.chat("&8Scenarios");

        inv = Bukkit.createInventory(null, inventoryRows);

    }

    public static Inventory Gui(Player player){

        Inventory toReturn = Bukkit.createInventory(null, inventoryRows, inventoryName);

        ItemStackUtils.createItem(inv, "arrow", 1, 33, "&6&l« &r&eRetour");

        toReturn.setContents(inv.getContents());
        return toReturn;

    }

    public static void onClicked(Player player, int slot, ItemStack clicked, Inventory inv) {

        if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&b+1"))) {


        }

    }

}
