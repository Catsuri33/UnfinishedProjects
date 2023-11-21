package fr.catsuri33.insiserveressential.commands;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("sethome")){

                if(p.isOp() || p.hasPermission("insiserveressential.sethome")){

                    if (args.length <= 0) {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, you must specify a name for your home !");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous devez spécifier un nom pour votre maison !");

                        }

                        return true;

                    }

                    String homeName = args[0];
                    double x = Bukkit.getPlayer(p.getUniqueId()).getLocation().getX();
                    double y = Bukkit.getPlayer(p.getUniqueId()).getLocation().getY();
                    double z = Bukkit.getPlayer(p.getUniqueId()).getLocation().getZ();
                    String currentWorldName = Bukkit.getPlayer(p.getUniqueId()).getLocation().getWorld().getName();

                    if(args.length == 1){

                        if(homeName.equalsIgnoreCase("list")){

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cError, you can't call your home like that !");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous ne pouvez pas appeler votre maison comme ça !");

                            }

                            return true;

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aYou have set a house with the name §e" + homeName + "§a.");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez défini une maison avec le nom §e" + homeName + "§a.");

                        }

                        InsiServerEssential.getInstance().configManager.getHomes().set("homes." + p.getUniqueId() + "." + homeName + ".x", x);
                        InsiServerEssential.getInstance().configManager.getHomes().set("homes." + p.getUniqueId() + "." + homeName + ".y", y);
                        InsiServerEssential.getInstance().configManager.getHomes().set("homes." + p.getUniqueId() + "." + homeName + ".z", z);
                        InsiServerEssential.getInstance().configManager.getHomes().set("homes." + p.getUniqueId() + "." + homeName + ".world", currentWorldName);
                        InsiServerEssential.getInstance().configManager.saveHomes();

                    }

                    if(args.length > 1){

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/sethome <Name> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/sethome <Nom> §c!");

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

            if(label.equalsIgnoreCase("home")){

                if(p.isOp() || p.hasPermission("insiserveressential.home")){

                    if (args.length <= 0) {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, you must specify a house name where you will teleport !");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous devez spécifier un nom de maison où vous téléporter !");

                        }

                        return true;

                    }

                    String homeName = args[0];

                    if(args.length == 1){

                        if(args[0].equalsIgnoreCase("list")){

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aHere are your available homes: §e");

                            }

                            if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                sender.sendMessage("§bInsiServer§fEssential §6» §aVoici vos maisons disponibles: §e");

                            }

                        }

                        ConfigurationSection playerSection = InsiServerEssential.getInstance().configManager.getHomes().getConfigurationSection("homes." + p.getUniqueId().toString());
                        for(String homesName : playerSection.getKeys(false)){

                            if(args[0].equalsIgnoreCase("list")){

                                sender.sendMessage("§6- §e" + homesName);

                            } else {

                                if(homesName.contains(args[0])){

                                    double x = Double.parseDouble(InsiServerEssential.getInstance().configManager.getHomes().getString("homes." + p.getUniqueId() + "." + args[0] + ".x"));
                                    double y = Double.parseDouble(InsiServerEssential.getInstance().configManager.getHomes().getString("homes." + p.getUniqueId() + "." + args[0] + ".y"));
                                    double z = Double.parseDouble(InsiServerEssential.getInstance().configManager.getHomes().getString("homes." + p.getUniqueId() + "." + args[0] + ".z"));
                                    String world = InsiServerEssential.getInstance().configManager.getHomes().getString("homes." + p.getUniqueId() + "." + args[0] + ".world");

                                    p.teleport(new Location(Bukkit.getWorld(world), x, y, z));

                                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                        sender.sendMessage("§bInsiServer§fEssential §6» §aYou have been teleported to your home §e" + homeName + "§a.");

                                    }

                                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                        sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez été téléporté a votre maison §e" + homeName + "§a.");

                                    }

                                } else {

                                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                        sender.sendMessage("§bInsiServer§fEssential §6» §cError, there is no house with the name §e" + homeName + " §c!");

                                    }

                                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                        sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, il n'y a pas de maison avec le nom §e" + homeName + "!");

                                    }

                                }

                            }

                        }

                    }

                    if(args.length > 1){

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/home <Name> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/home <Nom> §c!");

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

            if(label.equalsIgnoreCase("delhome")){

                if(p.isOp() || p.hasPermission("insiserveressential.delhome")){

                    if (args.length <= 0) {

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, you must specify the name of the house you want to delete !");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, vous devez spécifier le nom de la maison que vous voulez supprimer !");

                        }

                        return true;

                    }

                    String homeName = args[0];

                    if(args.length == 1){

                        ConfigurationSection playerSection = InsiServerEssential.getInstance().configManager.getHomes().getConfigurationSection("homes." + p.getUniqueId().toString());
                        for(String homesName : playerSection.getKeys(false)){

                            if(homesName.contains(args[0])){

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §aYou have deleted the house with the name §e" + homeName + "§a.");

                                }

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §aVous avez supprimé la maison avec le nom §e" + homeName + "§a.");

                                }

                                InsiServerEssential.getInstance().configManager.getHomes().set("homes." + p.getUniqueId() + "." + homeName, null);
                                InsiServerEssential.getInstance().configManager.saveHomes();

                            } else {

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cError, there is no house with the name §e" + homeName + " §c!");

                                }

                                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                                    sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, il n'y a pas de maison avec le nom §e" + homeName + "!");

                                }

                            }

                        }

                    }

                    if(args.length > 1){

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cError, the command is §e/delhome <Name> §c!");

                        }

                        if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                            sender.sendMessage("§bInsiServer§fEssential §6» §cErreur, la commande est §e/delhome <Nom> §c!");

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
