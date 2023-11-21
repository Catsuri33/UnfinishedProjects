package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("fly")){

                if(p.isOp() || p.hasPermission("insiserveressential.fly")){

                    if (args.length <= 0) {

                        if(p.getAllowFlight()){

                            p.setAllowFlight(false);

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cYou have deactivated the fly mode.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cVous avez désactivé le mode de vol.");

                            }

                            return true;

                        } else {

                            p.setAllowFlight(true);

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aYou have activated the fly mode.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez activé le mode de vol.");

                            }

                            return true;

                        }

                    }

                    if (args.length == 1) {

                        String targetName = args[0];

                        Player target = Bukkit.getPlayer(targetName);

                        if (Bukkit.getPlayerExact(targetName) != null) {

                            if(p.getAllowFlight()){

                                target.setAllowFlight(false);

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cYou have deactivated the fly mode of §e" + target.getName() + "§c.");
                                    target.sendMessage("§bInsiServer§fEssential §6» §cYou are no longer in flight mode !");

                                }

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cVous avez désactivé le mode de vol pour §e" + target.getName() + "§c.");
                                    target.sendMessage("§bInsiServer§fEssential §6» §cVous n'êtes désormais plus en mode vol !");

                                }

                            } else {

                                target.setAllowFlight(true);

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §aYou have activated the fly mode of §e" + target.getName() + "§a.");
                                    target.sendMessage("§bInsiServer§fEssential §6» §aYou are now in flight mode !");

                                }

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez activé le mode de vol pour §e" + target.getName() + "§a.");
                                    target.sendMessage("§bInsiServer§fEssential §6» §aVous êtes désormais en mode vol !");

                                }

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

                    if (args.length > 1) {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/fly <Player> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/fly <Joueur> §c!");

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
