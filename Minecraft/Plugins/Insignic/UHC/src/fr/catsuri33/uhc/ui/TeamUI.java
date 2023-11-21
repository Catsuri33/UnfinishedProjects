package fr.catsuri33.uhc.ui;

import fr.catsuri33.uhc.utils.ItemStackUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public class TeamUI {

    public static Inventory inv;
    public static String inventoryName;
    public static int inventoryRows = 4 * 9;

    public static ArrayList<UUID> playerInTeamLightBlue = new ArrayList<>();
    public static String playerName = "";

    public static void initializeTeamUI(){

        inventoryName = ItemStackUtils.chat("&8Équipes");

        inv = Bukkit.createInventory(null, inventoryRows);

    }

    public static Inventory Gui(Player player){

        Inventory toReturn = Bukkit.createInventory(null, inventoryRows, inventoryName);

        if(HostUI.gameMode.equals("2vs2") && Bukkit.getMaxPlayers() <= 4){

            ItemStackUtils.createItem(inv, "light_blue_banner", 1, 1, "&bBleue Clair", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
            ItemStackUtils.createItem(inv, "blue_banner", 1, 2, "&9Bleue", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");

        } else {

            if(HostUI.gameMode.equals("2vs2") && Bukkit.getMaxPlayers() <= 6){

                ItemStackUtils.createItem(inv, "light_blue_banner", 1, 1, "&bBleue Clair", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                ItemStackUtils.createItem(inv, "blue_banner", 1, 2, "&9Bleue", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                ItemStackUtils.createItem(inv, "red_banner", 1, 3, "&cRouge", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");

            } else {

                if(HostUI.gameMode.equals("2vs2") && Bukkit.getMaxPlayers() <= 8){

                    ItemStackUtils.createItem(inv, "light_blue_banner", 1, 1, "&bBleue Clair", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                    ItemStackUtils.createItem(inv, "blue_banner", 1, 2, "&9Bleue", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                    ItemStackUtils.createItem(inv, "red_banner", 1, 3, "&cRouge", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                    ItemStackUtils.createItem(inv, "orange_banner", 1, 4, "&6Orange", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");

                } else {

                    if(HostUI.gameMode.equals("2vs2") && Bukkit.getMaxPlayers() <= 10){

                        ItemStackUtils.createItem(inv, "light_blue_banner", 1, 1, "&bBleue Clair", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                        ItemStackUtils.createItem(inv, "blue_banner", 1, 2, "&9Bleue", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                        ItemStackUtils.createItem(inv, "red_banner", 1, 3, "&cRouge", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                        ItemStackUtils.createItem(inv, "orange_banner", 1, 4, "&6Orange", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                        ItemStackUtils.createItem(inv, "yellow_banner", 1, 5, "&eJaune", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");

                    } else {

                        if(HostUI.gameMode.equals("2vs2") && Bukkit.getMaxPlayers() <= 12){

                            ItemStackUtils.createItem(inv, "light_blue_banner", 1, 1, "&bBleue Clair", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                            ItemStackUtils.createItem(inv, "blue_banner", 1, 2, "&9Bleue", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                            ItemStackUtils.createItem(inv, "red_banner", 1, 3, "&cRouge", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                            ItemStackUtils.createItem(inv, "orange_banner", 1, 4, "&6Orange", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                            ItemStackUtils.createItem(inv, "yellow_banner", 1, 5, "&eJaune", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                            ItemStackUtils.createItem(inv, "lime_banner", 1, 6, "&aVerte", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");

                        } else {

                            if(HostUI.gameMode.equals("2vs2") && Bukkit.getMaxPlayers() <= 14){

                                ItemStackUtils.createItem(inv, "light_blue_banner", 1, 1, "&bBleue Clair", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                ItemStackUtils.createItem(inv, "blue_banner", 1, 2, "&9Bleue", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                ItemStackUtils.createItem(inv, "red_banner", 1, 3, "&cRouge", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                ItemStackUtils.createItem(inv, "orange_banner", 1, 4, "&6Orange", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                ItemStackUtils.createItem(inv, "yellow_banner", 1, 5, "&eJaune", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                ItemStackUtils.createItem(inv, "lime_banner", 1, 6, "&aVerte", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                ItemStackUtils.createItem(inv, "pink_banner", 1, 7, "&dRose", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");

                            } else {

                                if(HostUI.gameMode.equals("2vs2") && Bukkit.getMaxPlayers() <= 16){

                                    ItemStackUtils.createItem(inv, "light_blue_banner", 1, 1, "&bBleue Clair", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                    ItemStackUtils.createItem(inv, "blue_banner", 1, 2, "&9Bleue", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                    ItemStackUtils.createItem(inv, "red_banner", 1, 3, "&cRouge", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                    ItemStackUtils.createItem(inv, "orange_banner", 1, 4, "&6Orange", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                    ItemStackUtils.createItem(inv, "yellow_banner", 1, 5, "&eJaune", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                    ItemStackUtils.createItem(inv, "lime_banner", 1, 6, "&aVerte", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                    ItemStackUtils.createItem(inv, "pink_banner", 1, 7, "&dRose", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");
                                    ItemStackUtils.createItem(inv, "purple_banner", 1, 8, "&5Violette", "&7Membres de l'équipe:", "", "&e» &7[Place Libre]", "&e» &7[Place Libre]", "", "&6&l» &r&eCliquez pour rejoindre l'équipe.");

                                }

                            }

                        }

                    }

                }

            }

        }

        toReturn.setContents(inv.getContents());
        return toReturn;

    }

    public static void onClicked(Player player, int slot, ItemStack clicked, Inventory inv){

        if(HostUI.gameMode.equals("2vs2") && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&bBleue Clair"))){

            if(playerInTeamLightBlue.size() == 2){

                player.sendMessage("§b[§6UHC§b] §cErreur, cette équipe est pleine !");

            } else {

                player.closeInventory();

                playerInTeamLightBlue.add(player.getUniqueId());



                player.openInventory(TeamUI.Gui(player));

            }

        }

    }

}
