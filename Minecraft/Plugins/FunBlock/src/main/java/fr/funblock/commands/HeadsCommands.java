package fr.funblock.commands;

import fr.funblock.FunBlock;
import fr.funblock.utils.VerifyVar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class HeadsCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("heads")){

            if(args.length == 0){

                if(sender instanceof Player){

                    Player p = (Player) sender;

                    if(FunBlock.configManager.getHeadsConfig().getInt("count") != 0){

                        p.sendMessage(FunBlock.getInstance().prefix + "§eVous avez trouvé §6" + FunBlock.configManager.getPlayersConfig().getInt("players." + p.getUniqueId() + ".heads-count") + "§e/§6" + FunBlock.configManager.getHeadsConfig().getInt("count") + " §etêtes !");
                        return true;

                    } else {

                        p.sendMessage(FunBlock.getInstance().prefix + "§cErreur, il n'y a aucune têtes à chercher !");
                        return false;

                    }

                } else {

                    sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, vous devez être un joueur pour effectuer cette commande !");
                    return false;

                }

            }

            if(args.length == 1){

                if(args[0].equalsIgnoreCase("list")){

                    if(sender.isOp() || sender.hasPermission("funblock.headslist")){

                        if(FunBlock.configManager.getHeadsConfig().getInt("heads.count") != 0){



                        } else {

                            sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, il n'y a aucune têtes de disponibles !");
                            return false;

                        }

                    } else {

                        sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, vous n'avez pas la permission d'exécuter cette commande !");
                        return false;

                    }

                } else {

                    sendHelpHeadsMessage(sender);
                    return false;

                }

            }

            if(args.length == 2 || args.length == 3){

                sendHelpHeadsMessage(sender);
                return false;

            }

            if(args.length == 4){

                if(args[0].equalsIgnoreCase("add")) {

                    if(sender.isOp() || sender.hasPermission("funblock.headsadd")){

                        if (VerifyVar.isInt(args[1])) {

                            if (VerifyVar.isInt(args[2])) {

                                if (VerifyVar.isInt(args[3])) {

                                    int x = Integer.parseInt(args[1]);
                                    int y = Integer.parseInt(args[2]);
                                    int z = Integer.parseInt(args[3]);

                                    ConfigurationSection headsSection = FunBlock.configManager.getHeadsConfig().getConfigurationSection("heads");

                                    if(headsSection == null){

                                        if (FunBlock.configManager.getHeadsConfig().get("heads.0") == null) {

                                            FunBlock.configManager.getHeadsConfig().set("heads.0.x", x);
                                            FunBlock.configManager.getHeadsConfig().set("heads.0.y", y);
                                            FunBlock.configManager.getHeadsConfig().set("heads.0.z", z);

                                            FunBlock.configManager.getHeadsConfig().set("count", FunBlock.configManager.getHeadsConfig().getInt("count") + 1);

                                            FunBlock.configManager.saveHeadsConfig();
                                            FunBlock.configManager.reloadHeadsConfig();

                                            sender.sendMessage(FunBlock.getInstance().prefix + "§aVous avez ajouté la tête numéro §60 §aaux coordonnés: §eX: §6" + x + " §a- §eY: §6" + y + " §a- §eZ: §6" + z + " §a!");
                                            return true;

                                        }

                                    }

                                    for (String heads : headsSection.getKeys(false)) {

                                        int headNumber = Integer.parseInt(heads) + 1;

                                        if (FunBlock.configManager.getHeadsConfig().get("heads." + headNumber) == null) {

                                            FunBlock.configManager.getHeadsConfig().set("heads." + headNumber + ".x", x);
                                            FunBlock.configManager.getHeadsConfig().set("heads." + headNumber + ".y", y);
                                            FunBlock.configManager.getHeadsConfig().set("heads." + headNumber + ".z", z);

                                            FunBlock.configManager.getHeadsConfig().set("count", FunBlock.configManager.getHeadsConfig().getInt("count") + 1);

                                            FunBlock.configManager.saveHeadsConfig();
                                            FunBlock.configManager.reloadHeadsConfig();

                                            sender.sendMessage(FunBlock.getInstance().prefix + "§aVous avez ajouté la tête numéro §6" + headNumber + " §aaux coordonnés: §eX: §6" + x + " §a- §eY: §6" + y + " §a- §eZ: §6" + z + " §a!");
                                            return true;

                                        }

                                    }

                                } else {

                                    sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, la variables 'z' doit être un nombre !");
                                    return false;

                                }

                            } else {

                                sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, la variables 'y' doit être un nombre !");
                                return false;

                            }

                        } else {

                            sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, la variables 'x' doit être un nombre !");
                            return false;

                        }

                    } else {

                        sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, vous n'avez pas la permission d'exécuter cette commande !");
                        return false;

                    }

                }

                if(args[0].equalsIgnoreCase("remove")){

                    if(sender.isOp() || sender.hasPermission("funblock.headsremove")){

                        if (VerifyVar.isInt(args[1])) {

                            if (VerifyVar.isInt(args[2])) {

                                if (VerifyVar.isInt(args[3])) {

                                    int x = Integer.parseInt(args[1]);
                                    int y = Integer.parseInt(args[2]);
                                    int z = Integer.parseInt(args[3]);

                                    ConfigurationSection headsSection = FunBlock.configManager.getHeadsConfig().getConfigurationSection("heads");

                                    if(headsSection == null){

                                        sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, il n'y a aucune tête à supprimer !");
                                        return false;

                                    }

                                    for (String heads : headsSection.getKeys(false)) {

                                        int headNumber = Integer.parseInt(heads) + 1;

                                        if(FunBlock.configManager.getHeadsConfig().getInt("heads." + headNumber + ".x") == x && FunBlock.configManager.getHeadsConfig().getInt("heads." + headNumber + ".y") == y && FunBlock.configManager.getHeadsConfig().getInt("heads." + headNumber + ".z") == z){

                                            FunBlock.configManager.getHeadsConfig().set("heads." + headNumber, "");
                                            FunBlock.configManager.getHeadsConfig().set("count", FunBlock.configManager.getHeadsConfig().getInt("count") - 1);

                                            FunBlock.configManager.saveHeadsConfig();
                                            FunBlock.configManager.reloadHeadsConfig();

                                            sender.sendMessage(FunBlock.getInstance().prefix + "§aVous avez retiré la tête numéro §6" + headNumber + " §aaux coordonnés: §eX: §6" + x + " §a- §eY: §6" + y + " §a- §eZ: §6" + z + " §a!");
                                            return true;

                                        }

                                    }

                                } else {

                                    sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, la variables 'z' doit être un nombre !");
                                    return false;

                                }

                            } else {

                                sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, la variables 'y' doit être un nombre !");
                                return false;

                            }

                        } else {

                            sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, la variables 'x' doit être un nombre !");
                            return false;

                        }

                    } else {

                        sender.sendMessage(FunBlock.getInstance().prefix + "§cErreur, vous n'avez pas la permission d'exécuter cette commande !");
                        return false;

                    }

                } else {

                    sendHelpHeadsMessage(sender);
                    return false;

                }

            }

            if(args.length > 4){

                sendHelpHeadsMessage(sender);
                return false;

            }

        }

        return false;

    }

    public static void sendHelpHeadsMessage(CommandSender sender){

        sender.sendMessage("§7§m               §6 Aide Têtes §7§m               ");
        sender.sendMessage("§e- §6/heads §7: Voir le nombre de têtes que vous avez obtenus.");

        if(sender.isOp() || sender.hasPermission("funblock.headslist")){

            sender.sendMessage("§e- §6/heads list §7: Voir le nombre de têtes total et leur position.");

        }

        if(sender.isOp() || sender.hasPermission("funblock.headsadd")){

            sender.sendMessage("§e- §6/heads add <x> <y> <z> §7: Ajouter des têtes.");

        }

        if(sender.isOp() || sender.hasPermission("funblock.headsremove")){

            sender.sendMessage("§e- §6/heads remove <x> <y> <z> §7: Retirer des têtes.");

        }

        sender.sendMessage("§7§m                                             ");

    }

}
