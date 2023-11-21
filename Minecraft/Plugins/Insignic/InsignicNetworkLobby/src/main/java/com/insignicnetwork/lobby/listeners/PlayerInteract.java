package com.insignicnetwork.lobby.listeners;

import com.insignicnetwork.lobby.Lobby;
import com.insignicnetwork.lobby.guis.LobbyGuis;
import com.insignicnetwork.lobby.mysql.FriendsMySQL;
import com.insignicnetwork.lobby.mysql.PlayersMySQL;
import com.insignicnetwork.lobby.mysql.ranks.RanksList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerInteract implements Listener {

    public FriendsMySQL friendsMySQL = new FriendsMySQL();
    Map<String, Long> cooldownVisibilityItem = new HashMap<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack is = e.getItem();

        if(is == null){

            return;

        }

        if(Lobby.waitingLogin.contains(p.getUniqueId())){

            return;

        }

        if(is.getType() == Material.COMPASS && is.hasItemMeta() && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("§eJeux")){

            LobbyGuis.createInventory(p);
            p.openInventory(LobbyGuis.invGames);

        }

        if(is.getType() == Material.PLAYER_HEAD && is.hasItemMeta() && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("§eProfil")){

            LobbyGuis.createInventory(p);
            p.openInventory(LobbyGuis.invProfile);

        }

        if(is.getType() == Material.BEACON && is.hasItemMeta() && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("§eLobby")){

            LobbyGuis.createInventory(p);
            p.openInventory(LobbyGuis.invLobbies);

        }

        if(is.getType() == Material.LIME_DYE && is.hasItemMeta() && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("§eVisibilité: Tout le Monde")){

            if(cooldownVisibilityItem.containsKey(p.getName())){

                if(cooldownVisibilityItem.get(p.getName()) > System.currentTimeMillis()){

                    long timeLeft = (cooldownVisibilityItem.get(p.getName()) - System.currentTimeMillis()) / 1000;
                    p.sendMessage("§cErreur, vous devez patienter encore §e" + timeLeft + " secondes §cavant de faire ceci !");
                    return;

                }

            }

            cooldownVisibilityItem.put(p.getName(), System.currentTimeMillis() + (5 * 1000));

            ItemStack purpleDye = new ItemStack(Material.PURPLE_DYE, 1);
            ItemMeta purpleDyeMeta = purpleDye.getItemMeta();
            purpleDyeMeta.setDisplayName("§eVisibilité: Amis");
            List<String> purpleDyeLore = new ArrayList<>();
            purpleDyeLore.add("§7» Changer la visibilité des joueurs.");
            purpleDyeMeta.setLore(purpleDyeLore);
            purpleDye.setItemMeta(purpleDyeMeta);

            for(Player players : Bukkit.getOnlinePlayers()){

                if(players != p){

                    if(PlayersMySQL.getPlayerRank(players.getUniqueId()).getName().equals(RanksList.PLAYER.getName())){

                        p.hidePlayer(Lobby.instance, players);

                    }

                }

            }

            p.sendMessage("§aVous avez changé votre visibilité en: §eAmis§a.");

            p.getInventory().setItem(7, purpleDye);

        }

        if(is.getType() == Material.PURPLE_DYE && is.hasItemMeta() && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("§eVisibilité: Amis")){

            if(cooldownVisibilityItem.containsKey(p.getName())){

                if(cooldownVisibilityItem.get(p.getName()) > System.currentTimeMillis()){

                    long timeLeft = (cooldownVisibilityItem.get(p.getName()) - System.currentTimeMillis()) / 1000;
                    p.sendMessage("§cErreur, vous devez patienter encore §e" + timeLeft + " secondes §cavant de faire ceci !");
                    return;

                }

            }

            cooldownVisibilityItem.put(p.getName(), System.currentTimeMillis() + (5 * 1000));

            ItemStack grayDye = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta grayDyeMeta = grayDye.getItemMeta();
            grayDyeMeta.setDisplayName("§eVisibilité: Personne");
            List<String> grayDyeLore = new ArrayList<>();
            grayDyeLore.add("§7» Changer la visibilité des joueurs.");
            grayDyeMeta.setLore(grayDyeLore);
            grayDye.setItemMeta(grayDyeMeta);

            for(Player players : Bukkit.getOnlinePlayers()){

                if(players != p){

                    if(PlayersMySQL.getPlayerRank(players.getUniqueId()).getName().equals(RanksList.PLAYER.getName())){

                        p.hidePlayer(Lobby.instance, players);

                    }

                }

            }

            p.sendMessage("§aVous avez changé votre visibilité en: §ePersonne§a.");

            p.getInventory().setItem(7, grayDye);

        }

        if(is.getType() == Material.GRAY_DYE && is.hasItemMeta() && is.getItemMeta().hasDisplayName() && is.getItemMeta().getDisplayName().equalsIgnoreCase("§eVisibilité: Personne")){

            if(cooldownVisibilityItem.containsKey(p.getName())){

                if(cooldownVisibilityItem.get(p.getName()) > System.currentTimeMillis()){

                    long timeLeft = (cooldownVisibilityItem.get(p.getName()) - System.currentTimeMillis()) / 1000;
                    p.sendMessage("§cErreur, vous devez patienter encore §e" + timeLeft + " secondes §cavant de faire ceci !");
                    return;

                }

            }

            cooldownVisibilityItem.put(p.getName(), System.currentTimeMillis() + (5 * 1000));

            ItemStack limeDye = new ItemStack(Material.LIME_DYE, 1);
            ItemMeta limeDyeMeta = limeDye.getItemMeta();
            limeDyeMeta.setDisplayName("§eVisibilité: Tout le Monde");
            List<String> limeDyeLore = new ArrayList<>();
            limeDyeLore.add("§7» Changer la visibilité des joueurs.");
            limeDyeMeta.setLore(limeDyeLore);
            limeDye.setItemMeta(limeDyeMeta);

            for(Player players : Bukkit.getOnlinePlayers()){

                if(players != p){

                    p.showPlayer(Lobby.instance, players);

                }

            }

            p.sendMessage("§aVous avez changé votre visibilité en: §eTout le Monde§a.");

            p.getInventory().setItem(7, limeDye);

        }

    }

}
