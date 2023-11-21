package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Broadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("broadcast")) {

            if (sender.isOp() || sender.hasPermission("insiserveressential.fly")) {

                if(args.length == 0){

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cError, you must specify arguments ! §e/broadcast <Arguments> §c!");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous devez spécifier des arguments ! §e/broadcast <Arguments> §c!");

                    }

                }

                if(args.length >= 1){

                    StringBuilder sb = new StringBuilder();

                    for(String part : args){

                        sb.append(part + " ");

                    }

                    Bukkit.broadcastMessage("§7»§m               §r §cBroadcast §r§7§m               §r§7«");
                    Bukkit.broadcastMessage("§6» §f" + sb.toString());
                    Bukkit.broadcastMessage("§7»§m                                             §r§7«");

                }

            } else {

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                    sender.sendMessage("§bInsiServer§fEssential §6» §cError, you don't have the permission to execute this command !");

                }

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                    sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous n'avez pas la permission d'exéctuter cette commande !");

                }

            }

            return true;

        }

        return false;

    }
}
