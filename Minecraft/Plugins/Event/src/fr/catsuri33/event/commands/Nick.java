package fr.catsuri33.event.commands;

import fr.catsuri33.event.Event;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Nick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("nick")){

            if(!(sender instanceof Player)){

                sender.sendMessage("La commande '/nick' est utilisable seulement par un joueur ! (Requiert Streamer et Plus !)");
                return true;

            }

            Player player = (Player) sender;

            if(args.length == 0){

                player.sendMessage("§6§lEvent ► §r§6§lNick Menu");
                player.sendMessage("§7- §a/nick set <Pseudo> §7: Changer son pseudo.");

            } else {

                if(args[0].equalsIgnoreCase("set")){

                    if(args.length == 1){

                        player.sendMessage("§6§lEvent ► §r§c/nick set <Pseudo>");
                        return true;

                    } else {

                        if(args.length == 2){

                            if(player.hasPermission("event.nick") || player.isOp()){

                                Event.getInstance().setNick(player, args[1]);
                                player.sendMessage("§6§lEvent ► §r§aFélicitations, vous avez changé votre display name ! §f(Nouveau display name : §6" + args[1] + "§f)");

                            }

                        } else if(args.length == 3){

                            if(player.hasPermission("event.nick.other") || player.isOp()){

                                Player c = Bukkit.getPlayer(args[2]);

                                if(c.isOnline()){

                                    Event.getInstance().setNick(c, args[1]);
                                    player.sendMessage("§6§lEvent ► §r§aFélicitations, vous avez changé le nick §e" + c.getName() + " §6en " + args[1]);

                                } else {

                                    player.sendMessage("§6§lEvent ► §r§cJe ne trouve pas le joueur §e" + args[2] + " §c!");

                                }

                            }

                        }

                    }

                } else if(args[0].equalsIgnoreCase("check")){



                }

            }

        }

        return false;

    }

}
