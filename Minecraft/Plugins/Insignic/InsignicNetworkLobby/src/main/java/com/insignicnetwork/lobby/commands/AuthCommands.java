package com.insignicnetwork.lobby.commands;

import com.insignicnetwork.lobby.Lobby;
import com.insignicnetwork.lobby.mysql.PlayersMySQL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuthCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(label.equalsIgnoreCase("register")){

                if(args.length == 0){

                    p.sendMessage("§cErreur, la commande est §e/register <Mot de Passe> §c!");

                }

                if(args.length == 1){

                    if(!Lobby.waitingLogin.contains(p.getUniqueId())){

                        p.sendMessage("§cErreur, vous êtes déjà connecté au serveur !");
                        return true;

                    }

                    if(!PlayersMySQL.getPlayerPassword(p.getUniqueId()).equalsIgnoreCase("null")){

                        p.sendMessage("§cErreur, vous possédez déjà un compte, veuillez faire §e/login <Mot de Passe> §c!");
                        return true;

                    }

                    PlayersMySQL.setPlayerPassword(p.getUniqueId(), args[0]);
                    p.sendMessage("§aVotre mot de passe a été sauvegardé ! Veuillez faire §e/login <Mot de Passe> §apour vous connecter !");
                    return true;

                }

                if(args.length > 1){

                    p.sendMessage("§cErreur, la commande est §e/register <Mot de Passe> §c!");

                }

            }

            if(label.equalsIgnoreCase("login")){

                if(args.length == 0){

                    p.sendMessage("§cErreur, la commande est §c/login <Mot de Passe> §c!");

                }

                if(args.length == 1){

                    if(!Lobby.waitingLogin.contains(p.getUniqueId())){

                        p.sendMessage("§cErreur, vous êtes déjà connecté au serveur !");
                        return true;

                    }

                    if(PlayersMySQL.getPlayerPassword(p.getUniqueId()).equalsIgnoreCase("null")){

                        p.sendMessage("§cErreur, vous n'avez pas de mot de passe, veuillez faire §e/register <Mot de Passe> §c!");
                        return true;

                    }

                    if(PlayersMySQL.getPlayerPassword(p.getUniqueId()).equalsIgnoreCase(args[0])){

                        Lobby.waitingLogin.remove(p.getUniqueId());
                        p.sendMessage("§aBonjour §e" + p.getName() + "§a, connection réussie avec succés !");
                        PlayersMySQL.setPlayerState(p.getUniqueId(), 2);
                        return true;

                    } else {

                        p.sendMessage("§cErreur, mot de passe incorrect !");
                        return true;

                    }

                }

                if(args.length > 1){

                    p.sendMessage("§cErreur, la commande est §c/login <Mot de Passe> §c!");

                }

            }

            if(label.equalsIgnoreCase("password")){

                if(args.length <= 1){

                    p.sendMessage("§cErreur, la commande est §c/password <Ancien Mot de Passe> <Nouveau Mot de Passe> §c!");

                }

                if(args.length == 2){

                    if(Lobby.waitingLogin.contains(p.getUniqueId())){

                        p.sendMessage("§cErreur, vous devez être connecté pour effectuer ceci !");
                        return true;

                    }

                    if(args[0].equalsIgnoreCase(PlayersMySQL.getPlayerPassword(p.getUniqueId()))){

                        PlayersMySQL.setPlayerPassword(p.getUniqueId(), args[1]);
                        p.sendMessage("§aVotre mot de passe a bien été changé !");
                        return true;

                    } else {

                        p.sendMessage("§cErreur, votre ancien mot de passe n'est pas valide §c!");
                        return true;

                    }

                }

                if(args.length > 2){

                    p.sendMessage("§cErreur, la commande est §c/password <Ancien Mot de Passe> <Nouveau Mot de Passe> §c!");

                }

            }

            return true;

        }

        return false;

    }
}
