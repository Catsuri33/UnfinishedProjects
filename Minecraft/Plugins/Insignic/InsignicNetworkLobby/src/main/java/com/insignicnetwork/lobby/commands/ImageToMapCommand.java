package com.insignicnetwork.lobby.commands;

import com.insignicnetwork.lobby.Lobby;
import com.insignicnetwork.lobby.core.tasks.RenderImage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ImageToMapCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("map")){

            if(sender instanceof Player){

                if(args.length == 2){

                    if(args[0].equalsIgnoreCase("render")){

                        final Player player = (Player) sender;
                        final String path = args[1];

                        new RenderImage(player, path).runTaskAsynchronously(Lobby.getInstance());

                    }

                } else {

                    sender.sendMessage("§cErreur, nombre d'arguments incorrect : §e/map <Lien> §c!");

                }

            }

            return true;

        }

        return false;

    }
}
