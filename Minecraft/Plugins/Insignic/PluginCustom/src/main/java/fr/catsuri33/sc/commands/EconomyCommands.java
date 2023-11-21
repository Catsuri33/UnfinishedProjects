package fr.catsuri33.sc.commands;

import fr.catsuri33.sc.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class EconomyCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("money")){

                if(args.length == 0){

                    String amountOfMoney = Main.configManager.getPlayersConfig().get("players." + p.getUniqueId() + ".money").toString();

                    if(amountOfMoney.contains("-")){

                        p.sendMessage(Main.prefix + " §eVoici votre argent: §c" + Main.configManager.getPlayersConfig().get("players." + p.getUniqueId() + ".money") + Main.getInstance().getConfig().get("economy.currency.display"));
                        return true;

                    } else {

                        p.sendMessage(Main.prefix + " §eVoici votre argent: §a" + Main.configManager.getPlayersConfig().get("players." + p.getUniqueId() + ".money") + Main.getInstance().getConfig().get("economy.currency.display"));
                        return true;

                    }

                }

                if(args.length == 1){

                    String targetName = args[0];
                    Player target = Bukkit.getPlayer(targetName);

                    if(Bukkit.getPlayerExact(targetName) != null){

                        String amountOfMoney = Main.configManager.getPlayersConfig().get("players." + target.getUniqueId() + ".money").toString();

                        if(Main.configManager.getPlayersConfig().contains("players." + target.getUniqueId())){

                            if(amountOfMoney.contains("-")){

                                p.sendMessage(Main.prefix + " §eVoici l'argent de§6 " + targetName + "§e: §c" + Main.configManager.getPlayersConfig().get("players." + target.getUniqueId() + ".money") + Main.getInstance().getConfig().get("economy.currency.display"));
                                return true;

                            } else {

                                p.sendMessage(Main.prefix + " §eVoici l'argent de§6 " + targetName + "§e: §a" + Main.configManager.getPlayersConfig().get("players." + target.getUniqueId() + ".money") + Main.getInstance().getConfig().get("economy.currency.display"));
                                return true;

                            }

                        } else {

                            p.sendMessage(Main.prefix + " §cErreur, ce joueur n'est pas enregistré, veuillez contacter les administrateurs !");
                            return false;

                        }

                    } else {

                        p.sendMessage(Main.prefix + " §cErreur, ce joueur n'existe pas ou n'est pas connecté !");
                        return false;

                    }

                }

                if(args.length == 2){

                    if(p.isOp() || p.hasPermission("server.economy")){

                        p.sendMessage(Main.prefix + " §cErreur, la commande est §e/money <Joueur> <Pay - Add - Remove> <Montant> §c!");

                    } else {

                        p.sendMessage(Main.prefix + " §cErreur, la commande est §e/money <Joueur> <Pay> <Montant> §c!");

                    }

                    return false;

                }

                if(args.length == 3){

                    String targetName = args[0];
                    Player target = Bukkit.getPlayer(targetName);

                    if(Bukkit.getPlayerExact(targetName) != null){

                        int amount = Integer.parseInt(args[2]);

                        if(args[1].equalsIgnoreCase("pay")){

                            if(Main.configManager.getPlayersConfig().getInt("players." + p.getUniqueId() + ".money") <= 0){

                                p.sendMessage(Main.prefix + " §cErreur, vous n'avez pas assez d'argent pour payer §e" + targetName + " §c!");
                                return false;

                            } else {

                                Main.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".money", Main.configManager.getPlayersConfig().getInt("players." + p.getUniqueId() + ".money") - amount);
                                Main.configManager.getPlayersConfig().set("players." + target.getUniqueId() + ".money", Main.configManager.getPlayersConfig().getInt("players." + target.getUniqueId() + ".money") + amount);
                                Main.configManager.savePlayersConfig();

                                p.sendMessage(Main.prefix + " §aVous avez payé §e" + amount + Main.getInstance().getConfig().get("economy.currency.display") + " §aà §e" + targetName + " §a!");
                                target.sendMessage(Main.prefix + " §aVous avez reçu §e" + amount + Main.getInstance().getConfig().get("economy.currency.display") + " §ade §e" + p.getName() + " §a!");
                                return true;

                            }

                        }

                        if(args[1].equalsIgnoreCase("add")){

                            if(p.isOp() || p.hasPermission("server.economy")){

                                Main.configManager.getPlayersConfig().set("players." + target.getUniqueId() + ".money", Main.configManager.getPlayersConfig().getInt("players." + target.getUniqueId() + ".money") + amount);
                                Main.configManager.savePlayersConfig();

                                p.sendMessage(Main.prefix + " §aVous avez ajouté §e" + amount + Main.getInstance().getConfig().get("economy.currency.display") + " §aà §e" + targetName + " §a!");
                                target.sendMessage(Main.prefix + " §e" + targetName + " §avous a ajouté §e" + amount + Main.getInstance().getConfig().get("economy.currency.display") + " §asur votre compte !");
                                return true;

                            } else {

                                p.sendMessage(Main.prefix + " §cErreur, vous n'avez pas la permission d'effectuer cette commande !");
                                return false;

                            }

                        }

                        if(args[1].equalsIgnoreCase("remove")){

                            if(p.isOp() || p.hasPermission("server.economy")){

                                Main.configManager.getPlayersConfig().set("players." + target.getUniqueId() + ".money", Main.configManager.getPlayersConfig().getInt("players." + target.getUniqueId() + ".money") - amount);
                                Main.configManager.savePlayersConfig();

                                p.sendMessage(Main.prefix + " §aVous avez retiré §e" + amount + Main.getInstance().getConfig().get("economy.currency.display") + " §aà §e" + targetName + " §a!");
                                target.sendMessage(Main.prefix + " §e" + targetName + " §cvous a retiré §e" + amount + Main.getInstance().getConfig().get("economy.currency.display") + " §cde votre compte !");
                                return true;

                            } else {

                                p.sendMessage(Main.prefix + " §cErreur, vous n'avez pas la permission d'effectuer cette commande !");
                                return false;

                            }

                        }

                    } else {

                        p.sendMessage(Main.prefix + " §cErreur, ce joueur n'existe pas ou n'est pas connecté !");
                        return false;

                    }

                }

                if(args.length >= 4){

                    if(p.isOp() || p.hasPermission("server.economy")){

                        p.sendMessage(Main.prefix + " §cErreur, la commande est §e/money <Joueur> <Pay - Add - Remove> <Montant> §c!");

                    } else {

                        p.sendMessage(Main.prefix + " §cErreur, la commande est §e/money <Joueur> <Pay> <Montant> §c!");

                    }

                    return false;

                }

            }

            if(label.equalsIgnoreCase("mtimer")){

                if(p.isOp() || p.hasPermission("server.mtimer")){

                    if(args.length < 4){

                        p.sendMessage(Main.prefix + " §cErreur, la commande est §e/mtimer <Add | Remove> <Monde> <Temps En Minutes> <Argent> §c!");
                        return false;

                    }

                    if(args[0].equalsIgnoreCase("add")){

                        String worldName = args[1];

                        if (Bukkit.getWorld(worldName) != null) {

                            ConfigurationSection worldsSection = Main.getInstance().getConfig().getConfigurationSection("economy.timers");

                            if(worldsSection != null){

                                for(String worldsName : worldsSection.getKeys(false)){

                                    if(worldsName.equals(worldName)){

                                        p.sendMessage(Main.prefix + " §cErreur, ce monde comporte déjà un timer !");
                                        return false;

                                    }

                                }

                            }

                            World world = Bukkit.getWorld(args[1]);
                            Integer minutes = Integer.parseInt(args[2]);
                            Integer money = Integer.parseInt(args[3]);

                            Main.getInstance().getConfig().set("economy.timers." + worldName + ".minutes", minutes);
                            Main.getInstance().getConfig().set("economy.timers." + worldName + ".money", money);
                            Main.getInstance().saveConfig();
                            Main.getInstance().reloadConfig();

                            p.sendMessage(Main.prefix + " §aVous avez ajouté un timer dans le monde §6" + worldName + " §ade §6" + minutes + "min §apour §6" + money + Main.getInstance().getConfig().get("economy.currency.display") + "§a.");
                            return true;

                        } else {

                            p.sendMessage(Main.prefix + " §cErreur, ce monde n'existe pas !");
                            return false;

                        }

                    }

                    if(args[0].equalsIgnoreCase("remove")){

                        p.sendMessage(Main.prefix + " §cDisponible prochainement, pour le moment veuillez supprimer manuellement dans le fichier §6'config.yml' §c!");
                        return false;

                    }

                    p.sendMessage(Main.prefix + " §cErreur, la commande est §e/mtimer <Add | Remove> <Monde> <Temps En Minutes> <Argent> §c!");
                    return false;

                } else {

                    p.sendMessage(Main.prefix + " §cErreur, vous n'avez pas la permission d'effectuer cette commande !");
                    return false;

                }

            }

        } else {

            sender.sendMessage(Main.prefix + " §cErreur, la commande ne peut etre effectuee que par un joueur !");
            return false;

        }

        return false;

    }

}

