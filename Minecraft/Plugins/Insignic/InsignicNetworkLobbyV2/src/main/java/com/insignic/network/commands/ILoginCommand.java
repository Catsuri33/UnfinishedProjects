package com.insignic.network.commands;

import com.insignic.network.Lobby;
import com.insignic.network.database.DatabaseManager;
import com.insignic.network.utils.EncryptPassword;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ILoginCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(args.length != 2){

                sender.sendMessage(Lobby.prefix + " §cError, the command is §e/ilogin <Username> <Password> §c!");
                return false;

            } else {

                String nickname = args[0];
                String password = args[1];

                if(DatabaseManager.instance.hasAccount(nickname)){

                    if(EncryptPassword.decryptString(DatabaseManager.instance.getPassword(nickname)).equals(password)){

                        if(DatabaseManager.instance.getMinecraftAccountUUID(nickname).equals("")){

                            DatabaseManager.instance.setMinecraftAccountUUID(nickname, p.getUniqueId().toString());
                            DatabaseManager.instance.addXP(p.getUniqueId().toString(), 15);
                            DatabaseManager.instance.addInsiCoins(p.getUniqueId().toString(), 10.0);

                            sender.sendMessage(Lobby.prefix + " §aYou have successfully logged in to your InsignicAccount !");
                            sender.sendMessage(Lobby.prefix + " §7Rewards: §9+15XP §7and §e+10 InsiCoins");
                            p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0f, 1.0f);
                            return true;

                        } else {

                            sender.sendMessage(Lobby.prefix + " §cError, your Minecraft account is already linked to the Insignic account §e" + DatabaseManager.instance.getNickname(p.getUniqueId().toString()) + " §c!");
                            return false;

                        }

                    } else {

                        sender.sendMessage(Lobby.prefix + " §cError, the password doesn't match with the account !");
                        return false;

                    }

                } else {

                    sender.sendMessage(Lobby.prefix + " §cError, there is no account with this nickname !");
                    return false;

                }

            }

        } else {

            sender.sendMessage(Lobby.prefix + " §cError, this command can only be used by a player !");
            return false;

        }

    }

}
