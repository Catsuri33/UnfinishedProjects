package fr.catsuri33.uhc.ui;

import fr.catsuri33.uhc.UHC;
import fr.catsuri33.uhc.scoreboard.ScoreboardManager;
import fr.catsuri33.uhc.utils.ItemStackUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SlotsUI {

    public static Inventory inv;
    public static String inventoryName;
    public static int inventoryRows = 3 * 9;

    public static void initializeSlotsUI(){

        inventoryName = ItemStackUtils.chat("&8Configurer les slots");

        inv = Bukkit.createInventory(null, inventoryRows);

    }

    public static Inventory Gui(Player player){

        Inventory toReturn = Bukkit.createInventory(null, inventoryRows, inventoryName);

        ItemStackUtils.createItem(inv, "player_head", 1, 14, "&eSlots", "§7Choisissez le nombre", "§7de slots de la partie", " ", "§e» §7Nombre de slots: §e" + Bukkit.getServer().getMaxPlayers(), " ");

        ItemStackUtils.createItem(inv, "light_blue_banner", 1, 16, "&b+1");
        ItemStackUtils.createItem(inv, "lime_banner", 1, 17, "&a+5");
        ItemStackUtils.createItem(inv, "green_banner", 1, 18, "&2+10");

        ItemStackUtils.createItem(inv, "yellow_banner", 1, 12, "&e-1");
        ItemStackUtils.createItem(inv, "orange_banner", 1, 11, "&6-5");
        ItemStackUtils.createItem(inv, "red_banner", 1, 10, "&c-10");

        ItemStackUtils.createItem(inv, "arrow", 1, 23, "&6&l« &r&eRetour");

        toReturn.setContents(inv.getContents());
        return toReturn;

    }

    public static void onClicked(Player player, int slot, ItemStack clicked, Inventory inv){

        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&b+1"))){

            player.closeInventory();

            int slotsConfig = Bukkit.getServer().getMaxPlayers();
            int playersOnline = Bukkit.getOnlinePlayers().size();
            int slots = slotsConfig + 1;

            if(slots < playersOnline){

                player.sendMessage("§b[§6UHC§b] §cErreur, vous ne pouvez pas descendre les slots en dessous du nombre de connectés !");

            } else {

                if(slots > 50){

                    player.sendMessage("§b[§6UHC§b] §cErreur, la limite de slots est de 50 !");

                } else {

                    try {

                        UHC.getInstance().changeSlots(slots);

                    } catch(ReflectiveOperationException e) {

                        e.printStackTrace();

                    }

                    for(Player players : Bukkit.getOnlinePlayers()){

                        ScoreboardManager.updateSlotsScoreboardLobby(players);

                    }

                }

            }

            UHC.getInstance().updateServerProperties();

            player.openInventory(SlotsUI.Gui(player));

        }

        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&a+5"))){

            player.closeInventory();

            int slotsConfig = Bukkit.getServer().getMaxPlayers();
            int playersOnline = Bukkit.getOnlinePlayers().size();
            int slots = slotsConfig + 5;

            if(slots < playersOnline){

                player.sendMessage("§b[§6UHC§b] §cErreur, vous ne pouvez pas descendre les slots en dessous du nombre de connectés !");

            } else {

                if(slots > 50){

                    player.sendMessage("§b[§6UHC§b] §cErreur, la limite de slots est de 50 !");

                } else {

                    try {

                        UHC.getInstance().changeSlots(slots);

                    } catch(ReflectiveOperationException e) {

                        e.printStackTrace();

                    }

                    for(Player players : Bukkit.getOnlinePlayers()){

                        ScoreboardManager.updateSlotsScoreboardLobby(players);

                    }

                }

            }

            UHC.getInstance().updateServerProperties();

            player.openInventory(SlotsUI.Gui(player));

        }

        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&2+10"))){

            player.closeInventory();

            int slotsConfig = Bukkit.getServer().getMaxPlayers();
            int playersOnline = Bukkit.getOnlinePlayers().size();
            int slots = slotsConfig + 10;

            if(slots < playersOnline){

                player.sendMessage("§b[§6UHC§b] §cErreur, vous ne pouvez pas descendre les slots en dessous du nombre de connectés !");

            } else {

                if(slots > 50){

                    player.sendMessage("§b[§6UHC§b] §cErreur, la limite de slots est de 50 !");

                } else {

                    try {

                        UHC.getInstance().changeSlots(slots);

                    } catch(ReflectiveOperationException e) {

                        e.printStackTrace();

                    }

                    for(Player players : Bukkit.getOnlinePlayers()){

                        ScoreboardManager.updateSlotsScoreboardLobby(players);

                    }

                }

            }

            UHC.getInstance().updateServerProperties();

            player.openInventory(SlotsUI.Gui(player));

        }

        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&e-1"))){

            player.closeInventory();

            int slotsConfig = Bukkit.getServer().getMaxPlayers();
            int playersOnline = Bukkit.getOnlinePlayers().size();
            int slots = slotsConfig - 1;

            if(slots < playersOnline){

                player.sendMessage("§b[§6UHC§b] §cErreur, vous ne pouvez pas descendre les slots en dessous du nombre de connectés !");

            } else {

                if(slots > 50){

                    player.sendMessage("§b[§6UHC§b] §cErreur, la limite de slots est de 50 !");

                } else {

                    try {

                        UHC.getInstance().changeSlots(slots);

                    } catch(ReflectiveOperationException e) {

                        e.printStackTrace();

                    }

                    for(Player players : Bukkit.getOnlinePlayers()){

                        ScoreboardManager.updateSlotsScoreboardLobby(players);

                    }

                }

            }

            UHC.getInstance().updateServerProperties();

            player.openInventory(SlotsUI.Gui(player));

        }

        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&6-5"))){

            player.closeInventory();

            int slotsConfig = Bukkit.getServer().getMaxPlayers();
            int playersOnline = Bukkit.getOnlinePlayers().size();
            int slots = slotsConfig - 5;

            if(slots < playersOnline){

                player.sendMessage("§b[§6UHC§b] §cErreur, vous ne pouvez pas descendre les slots en dessous du nombre de connectés !");

            } else {

                if(slots > 50){

                    player.sendMessage("§b[§6UHC§b] §cErreur, la limite de slots est de 50 !");

                } else {

                    try {

                        UHC.getInstance().changeSlots(slots);

                    } catch(ReflectiveOperationException e) {

                        e.printStackTrace();

                    }

                    for(Player players : Bukkit.getOnlinePlayers()){

                        ScoreboardManager.updateSlotsScoreboardLobby(players);

                    }

                }

            }

            UHC.getInstance().updateServerProperties();

            player.openInventory(SlotsUI.Gui(player));

        }

        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&c-10"))){

            player.closeInventory();

            int slotsConfig = Bukkit.getServer().getMaxPlayers();
            int playersOnline = Bukkit.getOnlinePlayers().size();
            int slots = slotsConfig - 10;

            if(slots < playersOnline){

                player.sendMessage("§b[§6UHC§b] §cErreur, vous ne pouvez pas descendre les slots en dessous du nombre de connectés !");

            } else {

                if(slots > 50){

                    player.sendMessage("§b[§6UHC§b] §cErreur, la limite de slots est de 50 !");

                } else {

                    try {

                        UHC.getInstance().changeSlots(slots);

                    } catch(ReflectiveOperationException e) {

                        e.printStackTrace();

                    }

                    for(Player players : Bukkit.getOnlinePlayers()){

                        ScoreboardManager.updateSlotsScoreboardLobby(players);

                    }


                }

            }

            UHC.getInstance().updateServerProperties();

            player.openInventory(SlotsUI.Gui(player));

        }

        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&6&l« &r&eRetour"))) {

            player.closeInventory();
            player.openInventory(HostUI.Gui(player));

        }

    }

}
