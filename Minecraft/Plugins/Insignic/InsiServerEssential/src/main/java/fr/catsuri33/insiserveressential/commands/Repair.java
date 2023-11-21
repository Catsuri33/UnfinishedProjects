package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Repairable;

public class Repair implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("repair")){

                if(p.isOp() || p.hasPermission("insiserveressential.repair")){

                    if (args.length <= 0) {

                        ItemStack item = p.getInventory().getItemInMainHand();

                        if(item instanceof Repairable){

                            item.setDurability((short)0);

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aYour item has been repaired.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aVotre item a été réparé.");

                            }

                        } else {

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cError, this item cannot be repaired !");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, cet item ne peut pas être réparé !");

                            }

                        }

                    }

                    if (args.length > 0) {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/repair §c! (Hold the item in the main hand)");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/repair §c! (Tenez l'item dans la main principale)");

                        }

                    }

                } else {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cError, you don't have the permission to execute this command !");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous n'avez pas la permission d'exéctuter cette commande !");

                    }

                }

            }

            return true;

        }

        return false;

    }

}
