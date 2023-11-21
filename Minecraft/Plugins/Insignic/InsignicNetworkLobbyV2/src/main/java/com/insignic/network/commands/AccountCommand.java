package com.insignic.network.commands;

import com.insignic.network.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AccountCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(args.length == 0){



            }

            if(args.length == 1){



            }

            if(args.length >= 2){

                sender.sendMessage(Lobby.prefix + " §cError, the command is §e/account <Player> §c!");
                return false;

            }

        } else {

            sender.sendMessage(Lobby.prefix + " §cError, this command can only be used by a player !");
            return false;

        }

        return false;

    }

}
