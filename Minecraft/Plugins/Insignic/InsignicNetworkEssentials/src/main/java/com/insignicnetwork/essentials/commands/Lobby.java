package com.insignicnetwork.essentials.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.insignicnetwork.essentials.Essentials;
import com.insignicnetwork.essentials.mysql.PlayersMySQL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lobby implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("lobby")){

            if(sender instanceof Player){

                Player p = (Player) sender;

                if(PlayersMySQL.getPlayerState(p.getUniqueId()) == 1){

                    p.sendMessage("§cErreur, vous devez être connecté pour effectuer cette commande !");
                    return true;

                }

                if(args.length == 0){

                    p.sendMessage("§aTéléportation vers le lobby en cours !");

                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("Connect");
                    out.writeUTF("Lobby01");

                    p.sendPluginMessage(Essentials.instance, "BungeeCord", out.toByteArray());

                }

                if(args.length > 0){

                    p.sendMessage("§cErreur, la commande est §e/lobby §c!");

                }

            }

        }

        return false;

    }

}
