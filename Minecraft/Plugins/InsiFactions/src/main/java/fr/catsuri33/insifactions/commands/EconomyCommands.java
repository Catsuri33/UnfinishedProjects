package fr.catsuri33.insifactions.commands;

import fr.catsuri33.insifactions.InsiFactions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconomyCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("money")){

                if(args.length == 0){

                    String amountOfMoney = InsiFactions.configManager.getPlayersConfig().get("players." + p.getUniqueId() + ".money").toString();

                    if(amountOfMoney.contains("-")){

                        p.sendMessage(InsiFactions.prefix + "§eVoici votre argent: §c" + InsiFactions.configManager.getPlayersConfig().get("players." + p.getUniqueId() + ".money") + InsiFactions.getInstance().getConfig().get("economy.currency.display"));
                        return true;

                    } else {

                        p.sendMessage(InsiFactions.prefix + "§eVoici votre argent: §a" + InsiFactions.configManager.getPlayersConfig().get("players." + p.getUniqueId() + ".money") + InsiFactions.getInstance().getConfig().get("economy.currency.display"));
                        return true;

                    }

                }

                if(args.length == 1){

                    String targetName = args[0];
                    Player target = Bukkit.getPlayer(targetName);

                    if(Bukkit.getPlayerExact(targetName) != null){

                        String amountOfMoney = InsiFactions.configManager.getPlayersConfig().get("players." + target.getUniqueId() + ".money").toString();

                        if(InsiFactions.configManager.getPlayersConfig().contains("players." + target.getUniqueId())){

                            if(amountOfMoney.contains("-")){

                                p.sendMessage(InsiFactions.prefix + "§eVoici l'argent de§6 " + targetName + "§e: §c" + InsiFactions.configManager.getPlayersConfig().get("players." + target.getUniqueId() + ".money") + InsiFactions.getInstance().getConfig().get("economy.currency.display"));
                                return true;

                            } else {

                                p.sendMessage(InsiFactions.prefix + "§eVoici l'argent de§6 " + targetName + "§e: §a" + InsiFactions.configManager.getPlayersConfig().get("players." + target.getUniqueId() + ".money") + InsiFactions.getInstance().getConfig().get("economy.currency.display"));
                                return true;

                            }

                        } else {

                            p.sendMessage(InsiFactions.prefix + "§cErreur, ce joueur n'est pas enregistré, veuillez contacter les administrateurs !");
                            return false;

                        }

                    } else {

                        p.sendMessage(InsiFactions.prefix + "§cErreur, ce joueur n'existe pas ou n'est pas connecté !");
                        return false;

                    }

                }

                if(args.length == 2){

                    if(p.isOp() || p.hasPermission("insifactions.economy")){

                        p.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/money <Joueur> <Pay - Add - Remove> <Montant> §c!");

                    } else {

                        p.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/money <Joueur> <Pay> <Montant> §c!");

                    }

                    return false;

                }

                if(args.length == 3){

                    String targetName = args[0];
                    Player target = Bukkit.getPlayer(targetName);

                    if(Bukkit.getPlayerExact(targetName) != null){

                        int amount = Integer.parseInt(args[2]);

                        if(args[1].equalsIgnoreCase("pay")){

                            if(InsiFactions.configManager.getPlayersConfig().getInt("players." + p.getUniqueId() + ".money") <= 0){

                                p.sendMessage(InsiFactions.prefix + "§cErreur, vous n'avez pas assez d'argent pour payer §e" + targetName + " §c!");
                                return false;

                            } else {

                                InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".money", InsiFactions.configManager.getPlayersConfig().getInt("players." + p.getUniqueId() + ".money") - amount);
                                InsiFactions.configManager.getPlayersConfig().set("players." + target.getUniqueId() + ".money", InsiFactions.configManager.getPlayersConfig().getInt("players." + target.getUniqueId() + ".money") + amount);
                                InsiFactions.configManager.savePlayersConfig();

                                p.sendMessage(InsiFactions.prefix + "§aVous avez payé §e" + amount + InsiFactions.getInstance().getConfig().get("economy.currency.display") + " §aà §e" + targetName + " §a!");
                                target.sendMessage(InsiFactions.prefix + "§aVous avez reçu §e" + amount + InsiFactions.getInstance().getConfig().get("economy.currency.display") + " §ade §e" + p.getName() + " §a!");
                                return true;

                            }

                        }

                        if(args[1].equalsIgnoreCase("add")){

                            if(p.isOp() || p.hasPermission("insifactions.economy")){

                                InsiFactions.configManager.getPlayersConfig().set("players." + target.getUniqueId() + ".money", InsiFactions.configManager.getPlayersConfig().getInt("players." + target.getUniqueId() + ".money") + amount);
                                InsiFactions.configManager.savePlayersConfig();

                                p.sendMessage(InsiFactions.prefix + "§aVous avez ajouté §e" + amount + InsiFactions.getInstance().getConfig().get("economy.currency.display") + " §aà §e" + targetName + " §a!");
                                target.sendMessage(InsiFactions.prefix + "§e" + targetName + " §avous a ajouté §e" + amount + InsiFactions.getInstance().getConfig().get("economy.currency.display") + " §asur votre compte !");
                                return true;

                            }

                        }

                        if(args[1].equalsIgnoreCase("remove")){

                            if(p.isOp() || p.hasPermission("insifactions.economy")){

                                InsiFactions.configManager.getPlayersConfig().set("players." + target.getUniqueId() + ".money", InsiFactions.configManager.getPlayersConfig().getInt("players." + target.getUniqueId() + ".money") - amount);
                                InsiFactions.configManager.savePlayersConfig();

                                p.sendMessage(InsiFactions.prefix + "§aVous avez retiré §e" + amount + InsiFactions.getInstance().getConfig().get("economy.currency.display") + " §aà §e" + targetName + " §a!");
                                target.sendMessage(InsiFactions.prefix + "§e" + targetName + " §cvous a retiré §e" + amount + InsiFactions.getInstance().getConfig().get("economy.currency.display") + " §cde votre compte !");
                                return true;

                            }

                        }

                    }

                }

                if(args.length >= 4){

                    if(p.isOp() || p.hasPermission("insifactions.economy")){

                        p.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/money <Joueur> <Pay - Add - Remove> <Montant> §c!");

                    } else {

                        p.sendMessage(InsiFactions.prefix + "§cErreur, la commande est §e/money <Joueur> <Pay> <Montant> §c!");

                    }

                    return false;

                }

            }

        } else {

            sender.sendMessage(InsiFactions.prefix + "§cErreur, vous devez être un joueur pour effectuer cette commande !");
            return false;

        }

        return false;

    }

}
