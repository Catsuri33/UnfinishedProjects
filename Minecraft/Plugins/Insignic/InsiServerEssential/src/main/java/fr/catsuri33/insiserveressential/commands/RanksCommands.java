package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RanksCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(label.equalsIgnoreCase("rank")) {

            if(sender.isOp() || sender.hasPermission("insiserveressential.rank")) {

                if (args.length == 0) {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/rank <set|remove> <Player> §c!");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/rank <set|remove> <Joueur> §c!");

                    }

                }

                if(args.length == 1){

                    if(args[0].equalsIgnoreCase("set")){

                        

                    } else if(args[0].equalsIgnoreCase("remove")){



                    } else {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/rank <set|remove> <Player> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/rank <set|remove> <Joueur> §c!");

                        }

                    }

                }

                if(args.length == 2){

                    String targetName = args[1];
                    Player target = Bukkit.getPlayer(targetName);

                    if(args[0].equalsIgnoreCase("set")){

                        if (Bukkit.getPlayerExact(targetName) != null) {



                        }

                    } else if(args[0].equalsIgnoreCase("remove")){



                    } else {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/rank <set|remove> <Player> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/rank <set|remove> <Joueur> §c!");

                        }

                    }

                }

            } else {

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                    sender.sendMessage("§bInsiServer§fEssential §6» §cError, you don't have the permission to execute this command !");

                }

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                    sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous n'avez pas la permission d'exéctuter cette commande !");

                }

            }

        }

        return false;

    }

}
