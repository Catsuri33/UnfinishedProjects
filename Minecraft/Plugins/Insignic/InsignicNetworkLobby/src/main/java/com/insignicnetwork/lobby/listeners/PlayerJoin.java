package com.insignicnetwork.lobby.listeners;

import com.insignicnetwork.lobby.Lobby;
import com.insignicnetwork.lobby.messages.MessagesBungeeCord;
import com.insignicnetwork.lobby.mysql.PlayersMySQL;
import com.insignicnetwork.lobby.mysql.ranks.RanksList;
import com.insignicnetwork.lobby.utils.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.List;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        final Player p = e.getPlayer();
        final Inventory inventory = p.getInventory();
        final ItemStack[] itemStacks = inventory.getContents();

        p.getInventory().clear();
        p.getActivePotionEffects().clear();
        p.setGameMode(GameMode.SURVIVAL);
        p.setTotalExperience(0);
        p.setLevel(0);
        p.teleport(new Location(p.getWorld(), 0.5, 57, 0.5, 0, (float) 2.5));

        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName("§eJeux");
        List<String> loreCompass = new ArrayList<>();
        loreCompass.add("§7» Choisir un jeu à rejoindre.");
        compassMeta.setLore(loreCompass);
        compass.setItemMeta(compassMeta);

        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta playerHeadMeta = (SkullMeta) playerHead.getItemMeta();
        playerHeadMeta.setDisplayName("§eProfil");
        playerHeadMeta.setOwningPlayer(p);
        List<String> lorePlayerHead = new ArrayList<>();
        lorePlayerHead.add("§7» Votre profil.");
        playerHeadMeta.setLore(lorePlayerHead);
        playerHead.setItemMeta(playerHeadMeta);

        ItemStack limeDye = new ItemStack(Material.LIME_DYE, 1);
        ItemMeta limeDyeMeta = limeDye.getItemMeta();
        limeDyeMeta.setDisplayName("§eVisibilité: Tout le Monde");
        List<String> limeDyeLore = new ArrayList<>();
        limeDyeLore.add("§7» Changer la visibilité des joueurs.");
        limeDyeMeta.setLore(limeDyeLore);
        limeDye.setItemMeta(limeDyeMeta);

        ItemStack beacon = new ItemStack(Material.BEACON, 1);
        ItemMeta beaconMeta = beacon.getItemMeta();
        beaconMeta.setDisplayName("§eLobby");
        List<String> beaconLore = new ArrayList<>();
        beaconLore.add("§7» Choisir un lobby à rejoindre.");
        beaconMeta.setLore(beaconLore);
        beacon.setItemMeta(beaconMeta);

        p.getInventory().setItem(4, compass);
        p.getInventory().setItem(0, playerHead);
        p.getInventory().setItem(7, limeDye);
        p.getInventory().setItem(8, beacon);

        if(PlayersMySQL.getPlayerState(p.getUniqueId()) == 1){

            Lobby.waitingLogin.add(p.getUniqueId());

        }

        if(Lobby.waitingLogin.contains(p.getUniqueId())){

            if(PlayersMySQL.getPlayerPassword(p.getUniqueId()).equalsIgnoreCase("null")){

                p.sendMessage("§cBienvenue nouveau joueur, vous devez vous enregistrer, utilisez §e/register <Mot de Passe> §c!");

            } else {

                p.sendMessage("§cVous devez vous connecter, utilisez §e/login <Mot de Passe> §c!");

            }

        }

        if(!PlayersMySQL.getPlayerRank(p.getUniqueId()).getName().equals(RanksList.PLAYER.getName())){

            e.setJoinMessage(PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix() + p.getName() + " §ea rejoint le lobby !");

        } else {

            e.setJoinMessage(null);

        }

        ScoreboardManager sm = Bukkit.getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard scoreboard = sm.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("lobby", "dummy", "§bINSIGNIC §fNETWORK");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score7 = objective.getScore("§r  ");
        score7.setScore(7);
        Score score6 = objective.getScore("§fGrade: " + PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix());
        score6.setScore(6);
        Score score5 = objective.getScore("§fNiveau: §a" + PlayersMySQL.getPlayerLevel(p.getUniqueId()));
        score5.setScore(5);
        Score score4 = objective.getScore("§r ");
        score4.setScore(4);
        Score score3 = objective.getScore("§fServeur: §aLobby01");
        score3.setScore(3);
        Score score2 = objective.getScore("§fJoueurs: §a" + MessagesBungeeCord.playerCount.toString());
        score2.setScore(2);
        Score score1 = objective.getScore("§r");
        score1.setScore(1);
        Score score0 = objective.getScore("§eplay.insignic.com");
        score0.setScore(0);

        p.setScoreboard(scoreboard);

    }

}
