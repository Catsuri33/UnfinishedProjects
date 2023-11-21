package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import fr.catsuri33.insiserveressential.utils.VerifyVar;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PTime implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("ptime")){

                if(p.isOp() || p.hasPermission("insiserveressential.ptime")){

                    if (args.length <= 0) {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, you must specify arguments : §e/ptime <time|reset> <Player> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous devez spécifier des arguments : §e/ptime <temps|reset> <Joueur> §c!");

                        }

                        return true;

                    }

                    if (args.length == 1) {

                        if(args[0].equalsIgnoreCase("reset")){

                            p.resetPlayerTime();

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cYou have reset your time in the world !");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cVous avez reset votre temps dans le monde !");

                            }

                        } else {

                            if(VerifyVar.isLong(args[0])){

                                String timeString = args[0];
                                long timeLong = Long.parseLong(timeString);

                                p.setPlayerTime(timeLong, true);

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed your time in the world to §e" + timeLong + "§a.");

                                }

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé votre temps dans le monde en §e" + timeLong + "§a.");

                                }

                            } else {

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cError, you must specify a number as an argument !");

                                }

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous devez spécifier un nombre en argument !");

                                }

                            }

                        }

                    }

                    if (args.length == 2) {

                        if(args[0].equalsIgnoreCase("reset")){

                            String targetName = args[1];

                            Player target = Bukkit.getPlayer(targetName);

                            if (Bukkit.getPlayerExact(targetName) != null) {

                                target.resetPlayerTime();

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cYou have reset the time of §e" + targetName + " §cin the world !");
                                    target.sendMessage("§bInsiServer§fEssential §6» §cYour time in the world has been reset !");

                                }

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cVous avez reset le temps de §e" + targetName + " §cdans le monde !");
                                    target.sendMessage("§bInsiServer§fEssential §6» §cVotre temps dans le monde a été reset !");

                                }

                            } else {

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cThe player §e" + targetName + " §cis not online or does not exist !");

                                }

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cLe joueur §e" + targetName + " §cn'est pas en ligne ou n'existe pas !");

                                }

                            }

                        } else {

                            if(VerifyVar.isLong(args[0])){

                                String targetName = args[1];

                                Player target = Bukkit.getPlayer(targetName);

                                if (Bukkit.getPlayerExact(targetName) != null) {

                                    String timeString = args[0];
                                    long timeLong = Long.parseLong(timeString);

                                    p.setPlayerTime(timeLong, true);

                                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                        sender.sendMessage("§bInsiServer§fEssential §6» §aYou have changed the time of §e" + targetName + " §ain the world to §e" + timeLong + "§a.");
                                        target.sendMessage("§bInsiServer§fEssential §6» §aYour time in the world has been changed to §e" + timeLong + "§a.");

                                    }

                                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                        sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé le temps de §e" + targetName + " §adans le monde en §e" + timeLong + "§a.");
                                        target.sendMessage("§bInsiServer§fEssential §6» §aVotre temps dans le monde a été changé en §e" + timeLong + "§a.");

                                    }

                                } else {

                                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                        sender.sendMessage("§bInsiServer§fEssential §6» §cThe player §e" + targetName + " §cis not online or does not exist !");

                                    }

                                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                        sender.sendMessage("§bInsiServer§fEssential §6» §cLe joueur §e" + targetName + " §cn'est pas en ligne ou n'existe pas !");

                                    }

                                }

                            } else {

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cError, you must specify a number as an argument !");

                                }

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous devez spécifier un nombre en argument !");

                                }

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

            return true;

        }

        return false;

    }

}
