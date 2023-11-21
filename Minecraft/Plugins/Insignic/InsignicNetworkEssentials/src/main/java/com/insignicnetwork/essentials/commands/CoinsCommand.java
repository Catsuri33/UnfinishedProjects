package com.insignicnetwork.essentials.commands;

import com.insignicnetwork.essentials.Essentials;
import com.insignicnetwork.essentials.mysql.PlayersMySQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("coins")){

            if(sender.isOp() || sender.hasPermission("insignicnetwork.coins")){

                if(sender instanceof Player){

                    Player p = (Player) sender;

                    if(PlayersMySQL.getPlayerState(p.getUniqueId()) == 1){

                        p.sendMessage("§cErreur, vous devez être connecté pour effectuer cette commande !");
                        return true;

                    }

                }

                if(args.length == 0){

                    sender.sendMessage(ChatColor.RED + "Erreur, la commande est" + ChatColor.YELLOW + " /coins <set|add|remove> <Player> <Coins>" + ChatColor.RED + " !");

                }

                if(args.length == 1){

                    sender.sendMessage(ChatColor.RED + "Erreur, vous devez spécifier un joueur !");

                }

                if(args.length == 2){

                    sender.sendMessage(ChatColor.RED + "Erreur, vous devez spécifier un montant de coins !");

                }

                if(args.length == 3){

                    String targetName = args[1];
                    float coins = Float.parseFloat(args[2]);

                    Player target = Bukkit.getPlayer(targetName);

                    if(args[0].equalsIgnoreCase("set")){

                        if (Bukkit.getPlayerExact(targetName) != null) {

                            Essentials.getInstance().mySQL.setPlayerCoins(target.getUniqueId(), coins);
                            sender.sendMessage(ChatColor.GREEN + "Vous avez changé le nombre de coins de " + ChatColor.YELLOW + targetName + ChatColor.GREEN + " en " + ChatColor.YELLOW + coins + ChatColor.GREEN + ".");

                        } else {

                            sender.sendMessage(ChatColor.RED + "Erreur, le joueur spécifié n'existe pas dans la base de données !");

                        }

                    }

                    if(args[0].equalsIgnoreCase("add")){

                        if (Bukkit.getPlayerExact(targetName) != null) {

                            Essentials.getInstance().mySQL.addPlayerCoins(target.getUniqueId(), coins);
                            sender.sendMessage(ChatColor.GREEN + "Vous avez ajouté " + ChatColor.YELLOW + coins + ChatColor.GREEN + " coins a " + ChatColor.YELLOW + targetName + ChatColor.GREEN + ".");

                        } else {

                            sender.sendMessage(ChatColor.RED + "Erreur, le joueur spécifié n'existe pas dans la base de données !");

                        }

                    }

                    if(args[0].equalsIgnoreCase("remove")){

                        if (Bukkit.getPlayerExact(targetName) != null) {

                            Essentials.getInstance().mySQL.removePlayerCoins(target.getUniqueId(), coins);
                            sender.sendMessage(ChatColor.GREEN + "Vous avez enlevé " + ChatColor.YELLOW + coins + ChatColor.GREEN + " coins a " + ChatColor.YELLOW + targetName + ChatColor.GREEN + ".");

                        } else {

                            sender.sendMessage(ChatColor.RED + "Erreur, le joueur spécifié n'existe pas dans la base de données !");

                        }

                    }

                }

                if(args.length > 3){

                    sender.sendMessage(ChatColor.RED + "Erreur, la commande est " + ChatColor.YELLOW + " /coins <set|add|remove> <Player>" + ChatColor.RED + "!");

                }

                return true;

            } else {

                sender.sendMessage(ChatColor.RED + "Erreur, vous n'avez pas la permission d'executer cette commande !");

            }

            return true;

        }

        return false;

    }
}
