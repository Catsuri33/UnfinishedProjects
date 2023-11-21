package fr.insignic.practice.commands;

import fr.insignic.practice.Practice;
import fr.insignic.practice.game.ArenasManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Duel implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            if(label.equalsIgnoreCase("duel")){

                Player p = (Player) sender;

                if(args.length == 0){

                    p.sendMessage("§bInsignic §6» §cErreur, la commande est /duel <Player> ou /duel <accept/deny> !");
                    return true;

                }

                if(args.length == 1){

                    String targetName = args[0];

                    if(args[0].equalsIgnoreCase("accept")){

                        if(Practice.getInstance().playersDuel.containsKey(p)){

                            p.sendMessage("§bInsignic §6» §aDuel accepté, téléportation en cours !");

                            Player firstTarget = Practice.getInstance().playersDuel.get(p);

                            firstTarget.sendMessage("§bInsignic §6» §aDuel accepté, téléportation en cours !");

                            Practice.getInstance().arenasManager.joinArena(p, firstTarget);

                            Practice.getInstance().playersDuel.remove(p);

                        } else {

                            p.sendMessage("§bInsignic §6» §cErreur, vous n'avez pas de demande de duel en attente !");

                        }

                    } else if(args[0].equalsIgnoreCase("deny")){

                        if(Practice.getInstance().playersDuel.containsKey(p)){

                            Player firstTarget = Practice.getInstance().playersDuel.get(p);

                            p.sendMessage("§bInsignic §6» §cDuel refusé !");
                            firstTarget.sendMessage("§bInsignic §6» §cLe joueur §e" + p.getName() + " §ca refusé le duel !");

                            Practice.getInstance().playersDuel.remove(p);

                        } else {

                            p.sendMessage("§bInsignic §6» §cErreur, vous n'avez pas de demande de duel en attente !");

                        }

                    } else if(Bukkit.getPlayerExact(targetName) != null){

                        Player target = Bukkit.getPlayer(targetName);

                        if(Practice.getInstance().playersDuel.containsKey(target)){

                            p.sendMessage("§bInsignic §6» §cErreur, §e" + targetName + " §cest déjà en duel !");
                            return true;

                        }

                        Practice.getInstance().playersDuel.put(target, p);

                        p.sendMessage("§bInsignic §6» §aVous venez de demander en duel §e" + targetName + " §a!");
                        target.sendMessage("§bInsignic §6» §aVous venez de recevoir une demande de duel de §e" + p.getName() + " §a!");

                    } else {

                        p.sendMessage("§bInsignic §6» §cErreur, le joueur §e" + targetName + " §cn'existe pas ou n'est pas en ligne !");

                    }

                    return true;

                }

                return true;

            }

        }

        return false;

    }
}
