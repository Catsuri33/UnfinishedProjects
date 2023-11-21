package com.insignicnetwork.essentials.commands;

import com.insignicnetwork.essentials.guis.ReportGui;
import com.insignicnetwork.essentials.managers.PlayerManager;
import com.insignicnetwork.essentials.mysql.PlayersMySQL;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModerationCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("mod")){

                if(p.isOp() || p.hasPermission("insignicnetwork.mod")){

                    if(PlayersMySQL.getPlayerState(p.getUniqueId()) >= 2){

                        if(args.length == 0){

                            if(PlayersMySQL.getPlayerState(p.getUniqueId()) == 3){

                                PlayerManager pm = PlayerManager.getFromPlayer(p);

                                PlayersMySQL.setPlayerState(p.getUniqueId(), 2);
                                p.getActivePotionEffects().clear();
                                p.setGameMode(GameMode.SURVIVAL);
                                p.setAllowFlight(false);

                                pm.giveInventory();
                                pm.destroy();

                                p.sendMessage("§cVous n'êtes désormais plus en mode modération !");

                                return true;

                            }

                            PlayerManager pm = new PlayerManager(p);
                            pm.init();

                            PlayersMySQL.setPlayerState(p.getUniqueId(), 3);
                            p.getActivePotionEffects().clear();
                            p.setAllowFlight(true);

                            pm.saveInventory();
                            p.getInventory().clear();

                            p.sendMessage("§aVous êtes désormais en mode modération !");


                        }

                        if(args.length >= 1){

                            p.sendMessage("§cErreur, la commande est §e/mod §c!");

                        }

                    } else {

                        p.sendMessage("§cErreur, vous devez être connecté pour effectuer cette commande !");

                    }

                } else {

                    p.sendMessage("§cErreur, vous n'avez pas la permission d'executer cette commande !");

                }

            }

            if(label.equalsIgnoreCase("report")){

                if(PlayersMySQL.getPlayerState(p.getUniqueId()) == 1){

                    p.sendMessage("§cErreur, vous devez être connecté pour effectuer cette commande !");
                    return true;

                }

                if(args.length == 1){

                    String targetName = args[0];
                    Player target = Bukkit.getPlayer(targetName);

                    if (Bukkit.getPlayerExact(targetName) != null) {

                        if(p.getName() != target.getName()){

                            ReportGui.createInventory(p, target);
                            p.openInventory(ReportGui.reportInv);

                        } else {

                            p.sendMessage("§cErreur, vous ne pouvez pas vous report vous même !");

                        }

                    } else {

                        p.sendMessage("§cErreur, le joueur spécifié n'est pas connecté ou n'existe pas !");

                    }

                } else {

                    p.sendMessage("§cErreur, la commande est §e/report <Joueur> §c!");

                }

            }

            return true;

        }

        return false;

    }

}
