package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

                if(label.equalsIgnoreCase("feed")){

                if(p.isOp() || p.hasPermission("insiserveressential.feed")){

                    if(args.length <= 0){

                        p.setFoodLevel(20);

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aYou have been feed.");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez été nourri !");

                        }

                    }

                    if(args.length == 1){

                        String targetName = args[0];

                        Player target = Bukkit.getPlayer(targetName);

                        if (Bukkit.getPlayerExact(targetName) != null) {

                            target.setFoodLevel(20);

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                target.sendMessage("§bInsiServer§fEssential §6» §aYou have been feed by §e" + p.getName() + "§a.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez été nourri par " + p.getName() + "§e.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aYou have feed §e" + targetName + "§a.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez nourri " + targetName + "§e.");

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

                    if(args.length > 1){

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/feed <Player> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est /feed <Joueur> §c!");

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

            return true;

        }

        return false;

    }

}
