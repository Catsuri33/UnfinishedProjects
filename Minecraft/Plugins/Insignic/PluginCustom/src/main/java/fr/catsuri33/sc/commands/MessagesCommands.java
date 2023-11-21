package fr.catsuri33.sc.commands;

import fr.catsuri33.sc.Main;
import fr.catsuri33.sc.world.MessagesManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessagesCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("msg")){

            if (sender instanceof Player) {

                Player player = (Player) sender;

                if (args.length < 2) {

                    player.sendMessage(Main.prefix + " §cErreur, la commande est §6/msg <Joueur> <Message> §c!");
                    return false;

                }

                if(Bukkit.getOfflinePlayer(args[0]).getPlayer() != null){

                    Player receiver = Bukkit.getOfflinePlayer(args[0]).getPlayer();

                    MessagesManager.setReplyTarget(player, receiver);

                    args[0] = "";

                    StringBuilder sb = new StringBuilder();
                    for(String parts : args){

                        sb.append(parts + " ");

                    }

                    player.sendMessage("§eEnvoyé à §6" + receiver.getName() + " §e§l>§7" + sb.toString());
                    receiver.sendMessage("§eReçu de §6" + player.getName() + " §e§l>§7" + sb.toString());
                    return true;

                } else {

                    player.sendMessage(Main.prefix + " §cErreur, ce joueur n'est pas connecté §c!");
                    return false;

                }

            } else {

                sender.sendMessage(Main.prefix + " §cErreur, la commande ne peut etre effectuee que par un joueur !");
                return false;

            }

        }

        if(label.equalsIgnoreCase("r")){

            if (sender instanceof Player) {

                Player player = (Player) sender;

                if (args.length < 1) {

                    player.sendMessage(Main.prefix + " §cErreur, la commande est §6/r <Message> §c!");
                    return false;

                }

                if(MessagesManager.getReplyTarget(player) != null){

                    Player receiver = MessagesManager.getReplyTarget(player);

                    StringBuilder sb = new StringBuilder();
                    for(String parts : args){

                        sb.append(parts + " ");

                    }

                    player.sendMessage("§eEnvoyé à §6" + receiver.getName() + " §e§l>§7" + sb.toString());
                    receiver.sendMessage("§eReçu de §6" + player.getName() + " §e§l>§7" + sb.toString());
                    return true;

                } else {

                    player.sendMessage(Main.prefix + " §cErreur, vous n'avez pas de conversation en cours §c!");
                    return false;

                }

            } else {

                sender.sendMessage(Main.prefix + " §cErreur, la commande ne peut etre effectuee que par un joueur !");
                return false;

            }

        }

        return false;

    }

}
