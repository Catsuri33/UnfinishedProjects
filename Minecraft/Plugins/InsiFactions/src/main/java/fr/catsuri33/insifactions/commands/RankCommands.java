package fr.catsuri33.insifactions.commands;

import fr.catsuri33.insifactions.InsiFactions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class RankCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("rank")){

            if(sender.isOp() || sender.hasPermission("insifactions.ranks")){

                if(args.length == 0){

                    sender.sendMessage(InsiFactions.prefix + "§eVoici la liste des grades disponibles: ");

                    ConfigurationSection ranksSection = InsiFactions.configManager.getRanksConfig().getConfigurationSection("ranks");

                    for(String ranks : ranksSection.getKeys(false)){

                        sender.sendMessage("§e- §6" + InsiFactions.configManager.getRanksConfig().get("ranks." + ranks + ".name"));

                    }

                    return true;

                }

                if(args.length == 1){

                    sender.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/rank <Joueur> <Add - Remove> <Grade>");
                    return false;

                }

                if(args.length == 2){

                    String targetName = args[0];

                    if(args[1].equalsIgnoreCase("remove")){

                        if(Bukkit.getPlayerExact(targetName) != null){

                            Player target = Bukkit.getPlayer(targetName);

                            if(!InsiFactions.configManager.getPlayersConfig().get("players." + target.getUniqueId() + ".rank").equals("")){

                                InsiFactions.configManager.getPlayersConfig().set("players." + target.getUniqueId() + ".rank", "");
                                InsiFactions.configManager.savePlayersConfig();
                                InsiFactions.configManager.reloadPlayerConfig();

                                target.setDisplayName("§r" + target.getName());
                                target.setPlayerListName("§r" + target.getName());

                                sender.sendMessage(InsiFactions.prefix + "§aVous avez enlevé le grade de §e" + targetName + " §a!");
                                target.sendMessage(InsiFactions.prefix + "§e" + sender.getName() + " §ca enlevé votre grade !");
                                return true;

                            } else {

                                sender.sendMessage(InsiFactions.prefix + "§cErreur, ce joueur n'a pas de grade !");
                                return false;

                            }

                        } else {

                            sender.sendMessage(InsiFactions.prefix + "§cErreur, ce joueur n'est pas connecté ou n'existe pas !");
                            return false;

                        }

                    } else {

                        sender.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/rank <Joueur> <Add - Remove> <Grade>");
                        return false;

                    }

                }

                if(args.length == 3){

                    String targetName = args[0];

                    if(args[1].equalsIgnoreCase("add")){

                        if(Bukkit.getPlayerExact(targetName) != null){

                            Player target = Bukkit.getPlayer(targetName);
                            String rank = args[2];

                            if(!InsiFactions.configManager.getPlayersConfig().get("players." + target.getUniqueId() + ".rank").equals(rank)){

                                ConfigurationSection ranksSection = InsiFactions.configManager.getRanksConfig().getConfigurationSection("ranks");

                                for(String ranks : ranksSection.getKeys(false)){

                                    if(rank.equalsIgnoreCase(InsiFactions.configManager.getRanksConfig().getString("ranks." + ranks + ".name"))){

                                        InsiFactions.configManager.getPlayersConfig().set("players." + target.getUniqueId() + ".rank", rank);
                                        InsiFactions.configManager.savePlayersConfig();
                                        InsiFactions.configManager.reloadPlayerConfig();

                                        target.setDisplayName(InsiFactions.configManager.getRanksConfig().get("ranks." + ranks + ".prefix") + target.getName() + InsiFactions.configManager.getRanksConfig().get("ranks." + ranks + ".suffix"));
                                        target.setPlayerListName(InsiFactions.configManager.getRanksConfig().get("ranks." + ranks + ".prefix") + target.getName() + InsiFactions.configManager.getRanksConfig().get("ranks." + ranks + ".suffix"));

                                        sender.sendMessage(InsiFactions.prefix + "§aVous avez changé le grade de §e" + targetName + " §aen §e" + rank + " §a!");
                                        target.sendMessage(InsiFactions.prefix + "§e" + sender.getName() + " §aa changé votre grade en §e" + rank + " §a!");
                                        return true;

                                    }

                                }

                            } else {

                                sender.sendMessage(InsiFactions.prefix + "§cErreur, ce joueur possède déjà ce grade !");
                                return false;

                            }

                        } else {

                            sender.sendMessage(InsiFactions.prefix + "§cErreur, ce joueur n'est pas connecté ou n'existe pas !");
                            return false;

                        }

                    } else {

                        sender.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/rank <Joueur> <Add - Remove> <Grade>");
                        return false;

                    }

                }

                if(args.length > 3){

                    sender.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/rank <Joueur> <Add - Remove> <Grade>");
                    return false;

                }

            } else {

                sender.sendMessage(InsiFactions.prefix + "§cErreur, vous n'avez pas la permission d'exécuter cette commande !");
                return false;

            }

        }

        return false;

    }

}
