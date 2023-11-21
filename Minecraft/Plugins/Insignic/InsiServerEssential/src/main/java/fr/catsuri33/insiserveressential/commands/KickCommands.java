package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import fr.catsuri33.insiserveressential.lang.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("kick")){

                if(p.isOp() || p.hasPermission("insiserveressential.kick")){

                    if(args.length <= 0){

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_PLAYER_EN.getMessage());

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_PLAYER_FR.getMessage());

                        }

                    }

                    if(args.length == 1){

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_REASON_EN.getMessage());

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_REASON_FR.getMessage());

                        }

                    }

                    if(args.length == 2){

                        String targetName = args[0];
                        Player target = Bukkit.getPlayer(targetName);

                        String reason = args[1];
                        reason.replace("&", "§");

                        if (Bukkit.getPlayerExact(targetName) != null) {

                            target.kickPlayer(reason);

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aYou have kick the player §e" + targetName + " §a!");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cVous avez exclu le joueur §e" + targetName + " §a!");

                            }

                        } else {

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cThe player §e" + targetName + " §cis not online or does not exist !");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cLe joueur §e" + targetName + " §cn'est pas en ligne ou n'existe pas !");

                            }

                        }

                    }

                    if(args.length > 2){

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_COMMAND_KICK_EN.getMessage());

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_COMMAND_KICK_FR.getMessage());

                        }

                    }

                } else {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_PERMISSION_EN.getMessage());

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_PERMISSION_FR.getMessage());

                    }

                }

            }

            if(label.equalsIgnoreCase("kickall")){

                if(p.isOp() || p.hasPermission("insiserveressential.kickall")){

                    if(args.length <= 0){

                        for(Player players : Bukkit.getOnlinePlayers()){

                            if(!players.hasPermission("insiserveressential.kickall")){

                                players.kickPlayer("Kick All");

                            }

                        }

                    }

                    if(args.length >= 1){

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_COMMAND_KICKALL_EN.getMessage());

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_COMMAND_KICKALL_FR.getMessage());

                        }

                    }

                } else {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_PERMISSION_EN.getMessage());

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_PERMISSION_FR.getMessage());

                    }

                }

            }

        }

        return false;

    }

}
