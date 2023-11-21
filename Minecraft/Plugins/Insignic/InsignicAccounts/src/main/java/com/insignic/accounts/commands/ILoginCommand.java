package com.insignic.accounts.commands;

import com.insignic.accounts.Main;
import com.insignic.accounts.database.DatabaseManager;
import com.insignic.accounts.utils.EncryptPassword;
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

                sender.sendMessage(Main.prefix + " §cError, the command is §e/ilogin <Nickname> <Password> §c!");
                return false;

            } else {

                String nickname = args[0];
                String password = args[1];

                if(DatabaseManager.instance.hasAccount(nickname)){

                    if(EncryptPassword.decryptString(DatabaseManager.instance.getPassword(nickname)).equals(password)){

                        if(DatabaseManager.instance.getMinecraftAccountUUID(nickname).equals("")){

                            DatabaseManager.instance.setMinecraftAccountUUID(nickname, p.getUniqueId().toString());

                            sender.sendMessage(Main.prefix + " §aYou have successfully logged in to your InsignicAccount !");
                            return true;

                        } else {

                            sender.sendMessage(Main.prefix + " §cError, your Minecraft account is already linked to the Insignic account §e" + DatabaseManager.instance.getNickname(p.getUniqueId().toString()) + " §c!");
                            return false;

                        }

                    } else {

                        sender.sendMessage(Main.prefix + " §cError, the password doesn't match with the account !");
                        return false;

                    }

                } else {

                    sender.sendMessage(Main.prefix + " §cError, there is no account with this nickname !");
                    return false;

                }

            }

        } else {

            sender.sendMessage(Main.prefix + " §cError, this command can only be used by a player !");
            return false;

        }

    }

}
