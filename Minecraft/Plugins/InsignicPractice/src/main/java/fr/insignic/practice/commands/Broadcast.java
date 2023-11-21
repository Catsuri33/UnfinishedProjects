package fr.insignic.practice.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Broadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("broadcast")){

            if(args.length == 0){

                sender.sendMessage("§bInsignic §6» §cErreur, la commande est /broadcast <Arguments> !");

            }

            if(args.length >= 1){

                if(sender.isOp()){

                    StringBuilder sb = new StringBuilder();

                    for(String part : args){

                        sb.append(part + " ");

                    }

                    Bukkit.broadcastMessage("§7»§m               §r §cBroadcast §r§7§m               §r§7«");
                    Bukkit.broadcastMessage("§6» §f" + sb.toString());
                    Bukkit.broadcastMessage("§7»§m                                             §r§7«");

                } else {

                    sender.sendMessage("§bInsignic §6» §cErreur, vous n'avez pas les permissions pour effectuer cette commande !");

                }

            }

            return true;

        }

        return false;

    }
}
