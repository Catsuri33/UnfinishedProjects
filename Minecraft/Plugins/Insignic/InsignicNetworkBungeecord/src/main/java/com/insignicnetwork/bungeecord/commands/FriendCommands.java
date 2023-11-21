package com.insignicnetwork.bungeecord.commands;

import com.insignicnetwork.bungeecord.mysql.FriendsMySQL;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendCommands extends Command {

    public FriendsMySQL friendsMySQL = new FriendsMySQL();
    public Map<ProxiedPlayer, ProxiedPlayer> requestFriend = new HashMap<>();

    public FriendCommands(){

        super("friend", null, "friends", "f");

    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof ProxiedPlayer){

            ProxiedPlayer p = (ProxiedPlayer) sender;

            if(args.length == 0){

                sendMessage(p, "§cErreur, la commande est §e/friend <Add | Remove | Accept | Deny §e| List> <Joueur> §c!");
                return;

            }

            if(args.length == 1){

                if(args[0].equalsIgnoreCase("accept")){

                    if(!(requestFriend.containsKey(p))){

                        sendMessage(p, "§cErreur, vous n'avez pas de demande d'amis en attente !");
                        return;

                    }

                    if(requestFriend.get(p) == null){

                        sendMessage(p, "§cErreur, la création d'ami ne s'est pas réalisée correctement !");
                        return;

                    }

                    if(friendsMySQL.isFriendWith(p.getName(), requestFriend.get(p).getName())){

                        sendMessage(p, "§cErreur vous êtes déjà amis avec §e" + requestFriend.get(p).getName() + " §c!");
                        return;

                    }

                    friendsMySQL.addFriend(p.getUniqueId(), requestFriend.get(p).getUniqueId());
                    friendsMySQL.addFriend(requestFriend.get(p).getUniqueId(), p.getUniqueId());

                    sendMessage(p, "§aVous êtes désormais ami avec §e" + requestFriend.get(p).getName() + " §a!");
                    sendMessage(requestFriend.get(p), "§aVous êtes désormais ami avec §e" + p.getName() + " §a!");

                    requestFriend.remove(p);

                }

                if(args[0].equalsIgnoreCase("deny")){

                    if(!(requestFriend.containsKey(p))){

                        sendMessage(p, "§cErreur, vous n'avez pas de demande d'amis en attente !");
                        return;

                    }

                    if(requestFriend.get(p) == null){

                        sendMessage(p, "§cErreur, la création d'ami ne s'est pas réalisée correctement !");
                        return;

                    }

                    if(friendsMySQL.isFriendWith(p.getName(), requestFriend.get(p).getName())){

                        sendMessage(p, "§cErreur vous êtes déjà amis avec §e" + requestFriend.get(p).getName() + " §c!");
                        return;

                    }

                    sendMessage(p, "§aVous avez refusé la demande d'amis de §e" + requestFriend.get(p).getName() + " §a!");
                    sendMessage(requestFriend.get(p), "§e" + p.getName() + " §ca refusé votre demande d'amis !");

                    requestFriend.remove(p);

                }

                if(args[0].equalsIgnoreCase("list")){

                    if(friendsMySQL.getFriendsCount(p.getName()) == 0){

                        sendMessage(p, "§cVous n'avez pas d'amis sur le serveur !");
                        return;

                    }

                    List<String> friendsOnline = new ArrayList<>();
                    List<String> friendsOffline = new ArrayList<>();

                    for(String friends : friendsMySQL.getFriendlist(p.getName())){

                        if(ProxyServer.getInstance().getPlayer(friends) == null){

                            friendsOffline.add(friends);

                        }

                        if(ProxyServer.getInstance().getPlayer(friends) != null){

                            friendsOnline.add(friends);

                        }

                    }

                    sendMessage(p, "§eVoici votre liste d'amis:");

                    if(!friendsOnline.isEmpty()){

                        String colorPath = "§a";

                        for(int x = 0; x < friendsOnline.size(); x++){

                            colorPath = colorPath + "■ " + friendsOnline.get(x) + "\n§a";
                            colorPath.trim();

                            sendMessage(p, colorPath.substring(0, colorPath.length() - 3));

                        }

                    }

                    if(!friendsOffline.isEmpty()){

                        String colorPath = "§c";

                        for(int x = 0; x < friendsOffline.size(); x++){

                            colorPath = colorPath + "■ " + friendsOffline.get(x) + "\n§c";
                            colorPath.trim();

                            sendMessage(p, colorPath.substring(0, colorPath.length() - 3));

                        }

                    }

                }

                // Activer demandes d'amis (Plus tard via menu options)
                if(args[0].equalsIgnoreCase("enable")){

                    if(friendsMySQL.getAllowRequest(p.getName()) == 0){

                        friendsMySQL.setAllowRequests(p.getName(), 1);
                        sendMessage(p, "§aVous avez §eactivé §avos demandes d'amis !");
                        return;

                    }

                    if(friendsMySQL.getAllowRequest(p.getName()) == 1){

                        sendMessage(p, "§cErreur, vos demandes d'amis sont déjà activées !");
                        return;

                    }

                }

                // Désactiver demandes d'amis (Plus tard via menu options)
                if(args[0].equalsIgnoreCase("disable")){

                    if(friendsMySQL.getAllowRequest(p.getName()) == 1){

                        friendsMySQL.setAllowRequests(p.getName(), 0);
                        sendMessage(p, "§aVous avez §edésactivé §avos demandes d'amis !");
                        return;

                    }

                    if(friendsMySQL.getAllowRequest(p.getName()) == 0){

                        sendMessage(p, "§cErreur, vos demandes d'amis sont déjà désactivées !");
                        return;

                    }

                }

            }

            if(args[0].equalsIgnoreCase("add")){

                if(args.length < 2){

                    sendMessage(p, "§cErreur, la commande est §e/friend <Add | Remove | Accept §e| Deny | List> <Joueur> §c!");
                    return;

                }

                if(args.length == 2){

                    String targetName = args[1];

                    if(ProxyServer.getInstance().getPlayer(targetName) != null){

                        if(friendsMySQL.getAllowRequest(targetName) == 1){

                            if(friendsMySQL.getAllowRequest(p.getName()) == 1){

                                if(requestFriend.containsValue(p)){

                                    sendMessage(p, "§cErreur, vous avez déjà une demande d'amis en cours ! Veuillez l'accepter ou la refuser !");
                                    return;

                                }

                                if(ProxyServer.getInstance().getPlayer(targetName) == p){

                                    sendMessage(p, "§cErreur, vous ne pouvez pas vous ajouter en amis vous même !");
                                    return;

                                }

                                if(friendsMySQL.isFriendWith(p.getName(), targetName)){

                                    sendMessage(p, "§cErreur, vous êtes déjà amis avec §e" + targetName + " §c!");
                                    return;

                                }

                                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetName);
                                requestFriend.put(target, p);

                                sendMessage(target, "§e" + p.getName() + " §asouhaite vous ajouter en amis !");
                                sendMessage(p, "§aVous avez demandé en amis §e" + target.getName() + " §a!");

                            } else {

                                sendMessage(p, "§cErreur, vous n'avez pas activé vos demandes d'amis !");
                                return;

                            }

                        } else {

                            sendMessage(p, "§cErreur, le joueur §e" + targetName + " §cn'a pas activé ses demandes d'amis !");
                            return;

                        }

                    } else {

                        sendMessage(p, "§cErreur, le joueur spécifié n'est pas connecté ou n'existe pas !");
                        return;

                    }

                }

            }

            if(args[0].equalsIgnoreCase("remove")){

                if(args.length < 2){

                    sendMessage(p, "§cErreur, la commande est §e/friend <Add | Remove | Accept §e| Deny | List> <Joueur> §c!");
                    return;

                }

                if(args.length == 2){

                    String targetName = args[1];

                    if(!friendsMySQL.isFriendWith(p.getName(), targetName)){

                        sendMessage(p, "§cErreur, vous nêtes pas amis avec §e" + targetName + " §c!");
                        return;

                    }

                    sendMessage(p, "§Vous n'êtes désormais plus amis avec §e" + targetName + " §a!");
                    friendsMySQL.removeFriend(p.getName(), targetName);
                    friendsMySQL.removeFriend(targetName, p.getName());

                }

            }

        }

    }

    private void sendMessage(ProxiedPlayer p, String message){

        p.sendMessage(new TextComponent(message));

    }

}
