package fr.epicgiant.core.commands;

import fr.epicgiant.core.Main;
import fr.epicgiant.core.utils.ServerManagement;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Maintenance implements CommandExecutor {

    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("maintenance")){

            if(args.length == 1){

                if(args[0].equalsIgnoreCase("on")){

                    if(sender.isOp()){

                        Main.Maintenance = true;
                        ServerManagement.kickAllNotAllowedMaintenance();

                        sender.sendMessage("§2You have just activated the maintenance !");

                    } else {
                        sender.sendMessage("§cError, you do not have permission to do this!");
                    }

                } else if(args[0].equalsIgnoreCase("off")){

                    if(sender.isOp()){

                        Main.Maintenance = false;

                        sender.sendMessage("§cYou have just deactivated the maintenance !");

                    } else {
                        sender.sendMessage("§cError, you do not have permission to do this!");
                    }

                } else if(args[0].equalsIgnoreCase("list")){

                    OfflinePlayer player;

                    for(UUID uuid : Main.getAuthorizedMaintenance()){

                        player = Bukkit.getOfflinePlayer(uuid);

                        if(player != null){

                            sender.sendMessage("§6Maintenance List :\n§e- " + player.getName());

                        }

                    }

                } else {

                    sender.sendMessage("§cError, the argument is invalid !");

                }

            } else if(args.length == 2){

                if(args[0].equalsIgnoreCase("add")){

                    final String playerName = args[1];
                    final Player player = Bukkit.getPlayer(playerName);

                    if(player != null){

                        final UUID uuid = player.getUniqueId();

                        Main.getAuthorizedMaintenance().add(uuid);

                    } else {

                        sender.sendMessage("§cThis player is offline !");

                    }

                }

                if(args[0].equalsIgnoreCase("remove")){

                    final String playerName = args[1];
                    final Player player = Bukkit.getPlayer(playerName);

                    if(player != null){

                        final UUID uuid = player.getUniqueId();

                        Main.getAuthorizedMaintenance().remove(uuid);

                    } else {

                        sender.sendMessage("§cThis player is offline !");

                    }

                }

            } else {

                sender.sendMessage("§cError, the length of the argument is invalid !");

            }
            return true;
        }

        return false;

    }
}
