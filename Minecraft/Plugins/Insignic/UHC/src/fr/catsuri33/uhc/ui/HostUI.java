package fr.catsuri33.uhc.ui;


import fr.catsuri33.uhc.utils.ItemStackUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class HostUI {

    public static Inventory inv;
    public static String inventoryName;
    public static int inventoryRows = 4 * 9;

    public static String gameMode = "FFA";

    public static void initializeHostUI(){

        inventoryName = ItemStackUtils.chat("&8Configurer le serveur");

        inv = Bukkit.createInventory(null, inventoryRows);

    }

    public static Inventory Gui(Player player){

        Inventory toReturn = Bukkit.createInventory(null, inventoryRows, inventoryName);

        ItemStackUtils.createItem(inv, "player_head", 1, 14, "&eSlots", "§7Choisissez le nombre", "§7de slots de la partie", " ", "§e» §7Nombre de slots: §e" + Bukkit.getServer().getMaxPlayers() , " ", "§6§l» §r§eCliquez pour changer");
        ItemStackUtils.createItem(inv, "lime_terracotta", 1, 32, "&2Start", "§7Démarrer la partie.", " ", "§6§l» §r§eCliquez ici pour démarrer la partie.");
        ItemStackUtils.createItem(inv, "black_banner", 1, 16, "&eMode de Jeu", "§7Choisissez le mode", "§7de jeu de la partie.", " ", "§e» §7Mode de jeu: §e" + gameMode, "", "§6§l» §r§eCliquez ici pour changer le mode de jeu.");

        toReturn.setContents(inv.getContents());
        return toReturn;

    }

    public static void onClicked(Player player, int slot, ItemStack clicked, Inventory inv){

        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&eSlots"))){

            player.closeInventory();
            player.openInventory(SlotsUI.Gui(player));

        }

        if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ItemStackUtils.chat("&eMode de Jeu"))){

            player.closeInventory();

            if(gameMode.equals("FFA")){

                gameMode = "2vs2";

                for(Player players : Bukkit.getOnlinePlayers()){

                    ItemStack teamItem = new ItemStack(Material.WHITE_BANNER, 1);
                    ItemMeta teamItemMeta = teamItem.getItemMeta();
                    teamItemMeta.setDisplayName("§eÉquipes");
                    teamItemMeta.setLore(Arrays.asList("§r§7Utilisez cet item pour", "§r§7choisir votre équipe."));
                    teamItem.setItemMeta(teamItemMeta);

                    players.getInventory().setItem(0, teamItem);
                    players.updateInventory();

                }

            } else {

                if(gameMode.equals("2vs2")){

                    gameMode = "3vs3";

                } else {

                    if(gameMode.equals("3vs3")){

                        gameMode = "4vs4";

                    } else {

                        if(gameMode.equals("4vs4")){

                            gameMode = "5vs5";

                        } else {

                            if(gameMode.equals("5vs5")){

                                gameMode = "FFA";

                                for(Player players : Bukkit.getOnlinePlayers()){

                                    for(ItemStack itemStack : players.getInventory().getContents()){
                                        if(itemStack != null && itemStack.getItemMeta().getDisplayName().equals("§eÉquipes")) {

                                            player.getInventory().removeItem(itemStack);
                                            player.updateInventory();

                                        }
                                    }

                                }

                            }

                        }

                    }

                }

            }

            player.openInventory(HostUI.Gui(player));

        }

    }

}
