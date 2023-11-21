package fr.catsuri33.sc.commands;

import fr.catsuri33.sc.Main;
import fr.catsuri33.sc.core.tasks.TimerMoneyRunnable;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldTpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0 || args.length > 1) {

                player.sendMessage(Main.prefix + " §cErreur, la commande est §6/wtp <Monde> §c!");
                return false;

            }

            if (player.isOp() || player.hasPermission("worlds.wtp")) {

                if (args.length == 1) {

                    String worldName = args[0];

                    if (Bukkit.getWorld(worldName) != null) {

                        World world = Bukkit.getWorld(worldName);

                        if(player.getWorld().equals(world)){

                            player.sendMessage(Main.prefix + " §cVous êtes déjà connecté sur ce monde !");
                            return false;

                        } else {

                            player.teleport(world.getSpawnLocation());

                            player.sendMessage(Main.prefix + " §aVous avez été téléporté dans le monde §6" + world.getName() + " §a!");
                            return true;

                        }

                    } else {

                        player.sendMessage(Main.prefix + " §cErreur, ce monde n'existe pas !");
                        return false;

                    }

                }

            } else {

                player.sendMessage(Main.prefix + " §cErreur, vous n'avez pas la permission d'exécuter cette commande !");
                return false;

            }

        } else {

            sender.sendMessage(Main.prefix + " §cErreur, la commande ne peut etre effectuee que par un joueur !");
            return false;

        }

        return false;

    }

}
