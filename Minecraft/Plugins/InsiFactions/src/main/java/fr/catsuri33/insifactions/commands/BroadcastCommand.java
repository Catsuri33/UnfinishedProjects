package fr.catsuri33.insifactions.commands;

import fr.catsuri33.insifactions.InsiFactions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("broadcast")){

            if(sender.isOp() || sender.hasPermission("insifactions.broadcast")){

                if(args.length == 0){

                    sender.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/broadcast <Message> §c!");
                    return false;

                }

                if(args.length >= 1){

                    StringBuilder sb = new StringBuilder();

                    for(String message : args){

                        sb.append(message + " ");

                    }

                    String message = sb.toString().replace("&", "§");

                    for(Player players : Bukkit.getOnlinePlayers()){

                        players.sendMessage(InsiFactions.prefix + "§r" + message);

                    }

                }

            } else {

                sender.sendMessage(InsiFactions.prefix + "§cErreur, vous n'avez pas la permission d'exécuter cette commande !");
                return false;

            }

        }

        return false;

    }

}
