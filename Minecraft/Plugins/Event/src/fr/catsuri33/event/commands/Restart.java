package fr.catsuri33.event.commands;

import fr.catsuri33.event.management.ServerManagement;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Restart implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("restart")){

            ServerManagement.kickOnShutdown();
            Bukkit.getServer().shutdown();

            return true;

        }

        return false;

    }

}
