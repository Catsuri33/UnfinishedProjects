package fr.catsuri33.insiuhc.commands;

import fr.catsuri33.insiuhc.InsiUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HostCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(command.getName().equalsIgnoreCase("host") || command.getName().equalsIgnoreCase("h")) {

                if (sender.isOp() || sender.hasPermission("insiuhc.host")) {

                    if(args.length == 0){

                        if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsi§fUHC §b» §cError, do §e/h help §cto get the list of commands !");

                        }

                        if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsi§fUHC §b» §cErreur, faites §e/h help §cpour obtenir la liste des commandes !");

                        }

                    }

                    if(args.length == 1){

                        if(args[0].equalsIgnoreCase("help")){

                            if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("                  §bHelp Menu §fPage [1/2]");
                                sender.sendMessage("§b- §e/h <add|remove> <Player> §b: Add an host to the game.");

                            }

                            if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("                  §bMenu d'Aide §fPage [1/2]");
                                sender.sendMessage("§b- §e/h <add|remove> <Joueur> §b: Ajouter un host pour la partie.");

                            }

                        } else {

                            if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsi§fUHC §b» §cError, do §e/h help §cto get the list of commands !");

                            }

                            if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsi§fUHC §b» §cErreur, faites §e/h help §cpour obtenir la liste des commandes !");

                            }

                        }

                    }

                    if(args.length == 2){

                        if(args[0].equalsIgnoreCase("add")){

                            String targetName = args[1];
                            Player target = Bukkit.getPlayer(targetName);

                            if(Bukkit.getPlayerExact(targetName) != null) {

                                if(!InsiUHC.getInstance().hosts.contains(target.getUniqueId())){

                                    InsiUHC.getInstance().hosts.add(target.getUniqueId());
                                    target.setDisplayName("§c[Host] " + p.getName() + "§r");
                                    p.setPlayerListName("§c[Host] " + p.getName() + "§r");

                                    if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                        sender.sendMessage("§bInsi§fUHC §b» §aYou have added §e" + targetName + " §ato the host list !");

                                    }

                                    if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                        sender.sendMessage("§bInsi§fUHC §b» §aVous avez ajouté §e" + targetName + " §aa la liste des hosts !");

                                    }

                                } else {

                                    if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                        sender.sendMessage("§bInsi§fUHC §b» §cError, the player §e" + targetName + " §cis already an host !");

                                    }

                                    if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                        sender.sendMessage("§bInsi§fUHC §b» §cEreur, le joueur §e" + targetName + " §cest déjà un host !");

                                    }

                                }

                            } else {

                                if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsi§fUHC §b» §cError, the player §e" + targetName + " §cis not online or does not exist !");

                                }

                                if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsi§fUHC §b» §cEreur, le joueur §e" + targetName + " §cn'est pas en ligne ou n'existe pas !");

                                }

                            }

                        }

                        if(args[0].equalsIgnoreCase("remove")){

                            String targetName = args[1];
                            Player target = Bukkit.getPlayer(targetName);

                            if(Bukkit.getPlayerExact(targetName) != null) {

                                if(InsiUHC.getInstance().hosts.contains(target.getUniqueId())){

                                    InsiUHC.getInstance().hosts.remove(target.getUniqueId());
                                    target.setDisplayName("§f" + p.getName() + "§r");
                                    p.setPlayerListName("§f" + p.getName() + "§r");

                                    if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                        sender.sendMessage("§bInsi§fUHC §b» §aYou have removed §e" + targetName + " §afrom the host list !");

                                    }

                                    if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                        sender.sendMessage("§bInsi§fUHC §b» §aVous avez enlevé §e" + targetName + " §ade la liste des hosts !");

                                    }

                                } else {

                                    if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                        sender.sendMessage("§bInsi§fUHC §b» §cError, the player §e" + targetName + " §cis not an host !");

                                    }

                                    if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                        sender.sendMessage("§bInsi§fUHC §b» §cEreur, le joueur §e" + targetName + " §cn'est pas un host !");

                                    }

                                }

                            } else {

                                if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsi§fUHC §b» §cError, the player §e" + targetName + " §cis not online or does n't exist !");

                                }

                                if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsi§fUHC §b» §cEreur, le joueur §e" + targetName + " §cn'est pas en ligne ou n'existe pas !");

                                }

                            }

                        }

                    }

                    if(args.length == 3){

                    }

                    return true;

                } else {

                    if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        sender.sendMessage("§bInsi§fUHC §b» §cError, you don't have permission to execute this command !");

                    }

                    if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        sender.sendMessage("§bInsi§fUHC §b» §cErreur, vous n'avez pas la permission d'exécuter cette commande !");

                    }

                }

            }

        } else {

            if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                sender.sendMessage(ChatColor.RED + "Error, you must be a player to use this command !");

            }

            if (InsiUHC.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                sender.sendMessage(ChatColor.RED + "Erreur, vous devez être un joueur pour effectuer cette commande !");

            }

        }

        return false;

    }
}
