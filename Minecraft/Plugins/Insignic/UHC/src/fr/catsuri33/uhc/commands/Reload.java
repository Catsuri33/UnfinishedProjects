package fr.catsuri33.uhc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("rl") || command.getName().equalsIgnoreCase("reload")){

            if(sender instanceof Player){

                sender.sendMessage("§b[§6UHC§b] §cCette commande est désactivée, veuillez redémarrer le serveur !");

            } else {

                Bukkit.getLogger().warning("[UHC] Cette commande est desactivee, veuillez redemarrer le serveur !;");

            }

        }

        return false;

    }
}
