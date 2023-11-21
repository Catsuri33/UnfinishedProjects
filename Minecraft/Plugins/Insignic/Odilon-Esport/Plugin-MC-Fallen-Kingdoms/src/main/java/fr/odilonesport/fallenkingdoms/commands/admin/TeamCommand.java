package fr.odilonesport.fallenkingdoms.commands.admin;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.utils.BannerColor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TeamCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("team")) {

            if(!sender.isOp()) {

                sender.sendMessage(Main.getInstance().prefix + "§cErreur, vous n'avez pas la permission d'éxecuter cette commande !");
                return false;

            }

            if(args.length > 0){

                if(args[0].equals("add")){

                    if(args.length == 3){

                        String teamName = args[1].toLowerCase();

                        if(Main.getInstance().getConfig().getConfigurationSection("game.teams." + teamName) == null){

                            String teamColor = ChatColor.translateAlternateColorCodes('&', args[2]);

                            if(BannerColor.colors.contains(teamColor)){

                                teamName = teamName.toString().substring(0, 1).toUpperCase() + teamName.toString().substring(1);
                                Main.getInstance().getConfig().set("game.teams." + teamName.toLowerCase() + ".color", teamColor);
                                Main.getInstance().saveConfig();

                                sender.sendMessage(Main.getInstance().prefix +  "§aVous avez créé l'équipe " + teamColor + teamName + " §a!");
                                return true;

                            } else {

                                sender.sendMessage(Main.getInstance().prefix +  "§cErreur, les couleurs disponibles sont: §e'&c, &e, &9, &a, &b, &d' §c!");
                                return false;

                            }

                        } else {

                            teamName = teamName.toString().substring(0, 1).toUpperCase() + teamName.toString().substring(1);
                            sender.sendMessage(Main.getInstance().prefix +  "§cErreur, l'équipe §e" + teamName + " §cexiste déjà !");
                            return false;

                        }

                    } else {

                        sender.sendMessage(Main.getInstance().prefix +  "§cErreur, la commande est '§e/team <add> <team name> <color (&c, &e, &9, &a, &b, &d)>§c' !");
                        return false;

                    }

                }

                if(args[0].equals("remove")){

                    if(args.length == 2){

                        String teamName = args[1].toString().toLowerCase();

                        if(Main.getInstance().getConfig().getConfigurationSection("game.teams." + teamName) != null){

                            teamName = teamName.toString().substring(0, 1).toUpperCase() + teamName.toString().substring(1);
                            String teamColor = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("game.teams." + teamName + ".color"));
                            Main.getInstance().getConfig().set("game.teams." + teamName, null);
                            Main.getInstance().saveConfig();

                            sender.sendMessage(Main.getInstance().prefix + "§aVous avez supprimé l'équipe " + teamColor + teamName + " §a!");
                            return true;

                        } else {

                            teamName = teamName.toString().substring(0, 1).toUpperCase() + teamName.toString().substring(1);
                            sender.sendMessage(Main.getInstance().prefix +  "§cErreur, l'équipe §e" + teamName + " §cn'existe pas !");
                            return false;

                        }

                    } else {

                        sender.sendMessage(Main.getInstance().prefix +  "§cErreur, la commande est '§e/team <remove> <team name>§c' !");
                        return false;

                    }

                }

            } else {

                sender.sendMessage(Main.getInstance().prefix +  "§cErreur, la commande est '§e/team <add/remove> <team name> <color (&c, &e, &9, &a, &b, &d)>§c' !");
                return false;

            }

        }

        return false;

    }

}
