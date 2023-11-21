package fr.epicgiant.core.commands;

import fr.epicgiant.core.utils.ServerManagement;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class KickALL implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("kickall")){

            if(sender.isOp()){

                ServerManagement.kickAll();
                sender.sendMessage("§2You have successfully kick all the players.");

            }

        }

        return false;

    }
}
