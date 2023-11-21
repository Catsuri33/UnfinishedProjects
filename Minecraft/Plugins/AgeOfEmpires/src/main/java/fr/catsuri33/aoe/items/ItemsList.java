package fr.catsuri33.aoe.items;

import fr.catsuri33.aoe.AgeOfEmpires;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemsList {

    public static Inventory inv;

    public static void createTeamInventory(){

        inv = Bukkit.createInventory(null, 27, "§8Sélectionnez votre équipe");

        ItemStack teamItem = new ItemStack(Material.WHITE_BANNER);
        ItemMeta teamItemMeta = teamItem.getItemMeta();
        List<String> loreTeamItem = new ArrayList<>();

        // Players number per teams inferior 6
        if(AgeOfEmpires.getInstance().getConfig().getInt("players-team") <= 6){

            // Red Team
            teamItem.setType(Material.RED_BANNER);
            teamItemMeta.setDisplayName("§cRouges");
            loreTeamItem.clear();
            loreTeamItem.add("§7» Cliquez pour rejoindre");
            loreTeamItem.add("§7l'équipe rouge.");
            teamItemMeta.setLore(loreTeamItem);
            teamItem.setItemMeta(teamItemMeta);

            inv.setItem(10, teamItem);

            // Blue Team
            teamItem.setType(Material.BLUE_BANNER);
            teamItemMeta.setDisplayName("§9Bleus");
            loreTeamItem.clear();
            loreTeamItem.add("§7» Cliquez pour rejoindre");
            loreTeamItem.add("§7l'équipe bleu.");
            teamItemMeta.setLore(loreTeamItem);
            teamItem.setItemMeta(teamItemMeta);

            inv.setItem(11, teamItem);

        }

        // Players number per teams inferior 6
        if(AgeOfEmpires.getInstance().getConfig().getInt("players-team") > 6 && AgeOfEmpires.getInstance().getConfig().getInt("players-team") <= 12){

            // Red Team
            teamItem.setType(Material.RED_BANNER);
            teamItemMeta.setDisplayName("§cRouges");
            loreTeamItem.clear();
            loreTeamItem.add("§7» Cliquez pour rejoindre");
            loreTeamItem.add("§7l'équipe rouge.");
            teamItemMeta.setLore(loreTeamItem);
            teamItem.setItemMeta(teamItemMeta);

            inv.setItem(10, teamItem);

            // Blue Team
            teamItem.setType(Material.BLUE_BANNER);
            teamItemMeta.setDisplayName("§9Bleus");
            loreTeamItem.clear();
            loreTeamItem.add("§7» Cliquez pour rejoindre");
            loreTeamItem.add("§7l'équipe bleu.");
            teamItemMeta.setLore(loreTeamItem);
            teamItem.setItemMeta(teamItemMeta);

            inv.setItem(11, teamItem);

            // Green Team
            teamItem.setType(Material.GREEN_BANNER);
            teamItemMeta.setDisplayName("§aVerts");
            loreTeamItem.clear();
            loreTeamItem.add("§7» Cliquez pour rejoindre");
            loreTeamItem.add("§7l'équipe verte.");
            teamItemMeta.setLore(loreTeamItem);
            teamItem.setItemMeta(teamItemMeta);

            inv.setItem(12, teamItem);

        }

        // Close Button
        teamItem.setType(Material.BARRIER);
        teamItemMeta.setDisplayName("§cFermer");
        loreTeamItem.clear();
        loreTeamItem.add("§7» Cliquez pour fermer");
        loreTeamItem.add("§7l'interface.");
        teamItemMeta.setLore(loreTeamItem);
        teamItem.setItemMeta(teamItemMeta);

        inv.setItem(22, teamItem);

    }

    public static void giveTeamItem(Player p, Inventory inv){

        ItemStack teamItem = new ItemStack(Material.WHITE_BANNER);
        ItemMeta teamItemMeta = teamItem.getItemMeta();
        List<String> loreTeamItem = new ArrayList<>();

        teamItemMeta.setDisplayName("§eÉquipe");
        loreTeamItem.add("§7» Cliquez pour sélectionner");
        loreTeamItem.add("§7votre équipe.");
        teamItemMeta.setLore(loreTeamItem);
        teamItem.setItemMeta(teamItemMeta);

        inv.setItem(4, teamItem);

    }

}
