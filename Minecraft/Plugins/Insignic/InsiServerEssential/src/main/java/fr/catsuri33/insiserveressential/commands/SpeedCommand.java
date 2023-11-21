package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import fr.catsuri33.insiserveressential.lang.Messages;
import fr.catsuri33.insiserveressential.utils.VerifyVar;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("speed")){

                if(p.isOp() || p.hasPermission("insiserveressential.speed")){

                    if (args.length <= 0) {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_NUMBER_EN.getMessage());

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_NUMBER_FR.getMessage());

                        }

                    }

                    if (args.length == 1) {

                        if(VerifyVar.isInt(args[0])){

                            String speed = args[0];
                            int speedInt = Integer.parseInt(speed);

                            p.setFlySpeed(speedInt);
                            p.setWalkSpeed(speedInt);

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aYou have set your speed at §e" + args[0] + "§a.");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé votre vitesse en §e" + args[0] + "§a.");

                            }

                        } else {

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_NUMBER_EN.getMessage());

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_NUMBER_FR.getMessage());

                            }

                        }

                    }

                    if (args.length == 2) {

                        if(VerifyVar.isInt(args[0])){

                            String speed = args[0];
                            int speedInt = Integer.parseInt(speed);

                            String targetName = args[1];
                            Player target = Bukkit.getPlayer(targetName);

                            if (Bukkit.getPlayerExact(targetName) != null) {

                                target.setFlySpeed(speedInt);
                                target.setWalkSpeed(speedInt);

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §aYou have set the speed of §e" + targetName + " at §e" + args[0] + "§a.");

                                }

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez changé la vitesse de §e" + targetName + " §aen §e" + args[0] + "§a.");

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

                                sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_NUMBER_EN.getMessage());

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_SPECIFY_NUMBER_FR.getMessage());

                            }

                        }

                    }

                    if(args.length > 2){

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_COMMAND_SPEED_EN.getMessage());

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage(Messages.PREFIX.getMessage() + Messages.ERROR_COMMAND_SPEED_FR.getMessage());

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

            return  true;

        }

        return false;

    }
}
