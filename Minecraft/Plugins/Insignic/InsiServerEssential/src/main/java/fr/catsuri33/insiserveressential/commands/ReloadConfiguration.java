package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadConfiguration implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("reloadconfiguration")) {

            if(sender.isOp() || sender.hasPermission("insiserveressential.reloadconfiguration")) {

                if (args.length == 0) {

                    InsiServerEssential.getInstance().configManager.reload2FACodes();
                    InsiServerEssential.getInstance().configManager.reloadHomes();
                    InsiServerEssential.getInstance().configManager.reloadRanks();

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §aYou have reloaded the configurations !");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §aVus avez reload les configurations !");

                    }

                } else {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/reloadconfiguration §c!");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/reloadconfiguration §c!");

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

        return false;

    }
}
