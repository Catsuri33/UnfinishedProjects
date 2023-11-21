package fr.catsuri33.lguhc.commands;

import fr.catsuri33.lguhc.game.Gamestates;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * LGUHC
 * Create the 10/07/2019
 *
 * @author Catsuri33
 * @version 1.0.0
 */

public class GameEditor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(Gamestates.isState(Gamestates.LOBBY)) {

                Inventory inv = Bukkit.createInventory(null, 45, "§6§lGame Editor");

                inv.addItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                inv.setItem(0, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

                player.openInventory(inv);

            } else {

                player.sendMessage("§3[§c§lLG§6UHC§r§3] §cError, you can't edit the game when it's started !");

            }

            return true;

        }

        return false;

    }
}
