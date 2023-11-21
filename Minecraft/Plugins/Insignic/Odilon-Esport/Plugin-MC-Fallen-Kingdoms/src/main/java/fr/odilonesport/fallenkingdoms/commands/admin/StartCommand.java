package fr.odilonesport.fallenkingdoms.commands.admin;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.runnables.LobbyRunnable;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("start")) {

            if(!sender.isOp()){

                sender.sendMessage(Main.getInstance().prefix + "§cErreur, vous n'avez pas la permission d'éxecuter cette commande !");
                return false;

            }

            if(args.length > 0){

                sender.sendMessage(Main.getInstance().prefix + "§cErreur, la commande est '§e/start§c !");
                return false;

            }

            if(LobbyRunnable.start){

                sender.sendMessage(Main.getInstance().prefix + "§cErreur, la partie est en cours de lancement !");
                return false;

            }

            for(Player player : Bukkit.getOnlinePlayers()){

                player.getInventory().clear();

            }

            new LobbyRunnable().runTaskTimer(Main.getInstance(), 0L, 20L);
            LobbyRunnable.start = true;

            sender.sendMessage(Main.getInstance().prefix + "§aVous avez lancé la partie !");
            return true;

        }

        return false;

    }

}
