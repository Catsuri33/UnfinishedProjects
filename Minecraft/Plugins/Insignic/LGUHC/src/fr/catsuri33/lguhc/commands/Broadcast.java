package fr.catsuri33.lguhc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * LGUHC
 * Create the 10/07/2019
 *
 * @author Catsuri33
 * @version 1.0.0
 */

public class Broadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Broadcast Command
        if(command.getName().equalsIgnoreCase("broadcast")){

            if(args.length == 0){

                sender.sendMessage("§3[§c§lLG§6UHC§r§3] §cError, you must specify your message : /broadcast <message>");

            }

            if(args.length >= 1){

                StringBuilder bc = new StringBuilder();
                for(String part : args){

                    bc.append(part + " ");

                }

                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§3[§c§lLG§6UHC§r§3] §e" + bc.toString());
                Bukkit.broadcastMessage(" ");

            }

            return true;

        }

        return false;

    }
}
