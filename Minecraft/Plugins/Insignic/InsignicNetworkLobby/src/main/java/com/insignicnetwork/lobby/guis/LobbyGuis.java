package com.insignicnetwork.lobby.guis;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.insignicnetwork.lobby.Lobby;
import com.insignicnetwork.lobby.messages.MessagesBungeeCord;
import com.insignicnetwork.lobby.mysql.PlayersMySQL;
import com.insignicnetwork.lobby.mysql.ranks.RanksList;
import com.insignicnetwork.lobby.utils.Convert;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class LobbyGuis {

    public static Inventory invGames;
    public static Inventory invProfile;
    public static Inventory invLobbies;

    public static void createInventory(Player p){

        invGames = Bukkit.createInventory(null, 54, "§8Jeux");

        // Practice Item
        ItemStack practiceItem = new ItemStack(Material.IRON_SWORD);
        ItemMeta practiceItemMeta = practiceItem.getItemMeta();

        practiceItemMeta.setDisplayName("§ePractice §7[§cBETA§7]");
        practiceItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> practiceItemLore = new ArrayList<>();
        practiceItemLore.add("§7» Rejoindre le Practice.");
        practiceItemLore.add("§cMode de jeu en Beta !");
        practiceItemMeta.setLore(practiceItemLore);
        practiceItem.setItemMeta(practiceItemMeta);

        // GoldenRush Item
        ItemStack goldenRushItem = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldenRushItemMeta = goldenRushItem.getItemMeta();

        goldenRushItemMeta.setDisplayName("§eGoldenRush §7[§cBETA§7] §bNEW");
        goldenRushItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> goldenRushLore = new ArrayList<>();
        goldenRushLore.add("§7» Rejoindre le GoldenRush.");
        goldenRushLore.add("§cMode de jeu en Beta !");
        goldenRushItemMeta.setLore(goldenRushLore);
        goldenRushItem.setItemMeta(goldenRushItemMeta);

        // Hub Item
        ItemStack lobbyItem = new ItemStack(Material.RED_BED);
        ItemMeta lobbyItemMeta = lobbyItem.getItemMeta();

        lobbyItemMeta.setDisplayName("§eHub");
        lobbyItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lobbyItemLore = new ArrayList<>();
        lobbyItemLore.add("§7» Téléportation au centre du hub.");
        lobbyItemMeta.setLore(lobbyItemLore);
        lobbyItem.setItemMeta(lobbyItemMeta);

        invGames.setItem(21, practiceItem);
        invGames.setItem(23, goldenRushItem);
        invGames.setItem(53, lobbyItem);


        invProfile = Bukkit.createInventory(null, 54, "§8Profil");

        // Head Item
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta playerHeadMeta = (SkullMeta) playerHead.getItemMeta();

        playerHeadMeta.setDisplayName("§e" + p.getName());
        playerHeadMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        playerHeadMeta.setOwningPlayer(p);
        List<String> playerHeadLore = new ArrayList<>();

        if(!PlayersMySQL.getPlayerRank(p.getUniqueId()).getName().equals(RanksList.PLAYER.getName())){

            playerHeadLore.add("§7Grade: " + PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix());

        } else {

            playerHeadLore.add("§7Grade: " + PlayersMySQL.getPlayerRank(p.getUniqueId()).getName());

        }

        playerHeadLore.add("§7Coins: §a" + PlayersMySQL.getPlayerCoins(p.getUniqueId()));
        playerHeadLore.add("§7InsiCoins: §a" + PlayersMySQL.getPlayerInsiCoins(p.getUniqueId()));
        playerHeadMeta.setLore(playerHeadLore);
        playerHead.setItemMeta(playerHeadMeta);

        invProfile.setItem(22, playerHead);

        // Level Item
        ItemStack levelItem = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta levelItemMeta = levelItem.getItemMeta();

        levelItemMeta.setDisplayName("§eLevel");
        levelItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> levelItemLore = new ArrayList<>();
        levelItemLore.add("§7Level: §a" + PlayersMySQL.getPlayerLevel(p.getUniqueId()));
        levelItemLore.add("§7Expérience: §a" + PlayersMySQL.getPlayerXP(p.getUniqueId()));
        levelItemMeta.setLore(levelItemLore);
        levelItem.setItemMeta(levelItemMeta);

        invProfile.setItem(31, levelItem);


        invLobbies = Bukkit.createInventory(null, 27, "§8Lobby");

        ItemStack lobby01Item = new ItemStack(Material.GREEN_TERRACOTTA);
        ItemMeta lobby01Meta = lobby01Item.getItemMeta();

        lobby01Meta.setDisplayName("§eLobby01");
        lobby01Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lobby01Lore = new ArrayList<>();
        MessagesBungeeCord.requestPlayerCount("Lobby01");
        lobby01Lore.add("§7Joueurs: §a" + MessagesBungeeCord.playerCount.toString());

        if(Convert.stringToInt(MessagesBungeeCord.playerCount.toString()) < 15){

            lobby01Lore.add("§7Présence: §aFAIBLE");

        }

        if(Convert.stringToInt(MessagesBungeeCord.playerCount.toString()) < 25 && Convert.stringToInt(MessagesBungeeCord.playerCount.toString()) > 15){

            lobby01Lore.add("§7Présence: §aMOYENNE");

        }

        if(Convert.stringToInt(MessagesBungeeCord.playerCount.toString()) < 50 && Convert.stringToInt(MessagesBungeeCord.playerCount.toString()) > 25){

            lobby01Lore.add("§7Présence: §aELEVE");

        }

        lobby01Meta.setLore(lobby01Lore);
        lobby01Item.setItemMeta(lobby01Meta);

        invLobbies.setItem(0, lobby01Item);

    }

}
