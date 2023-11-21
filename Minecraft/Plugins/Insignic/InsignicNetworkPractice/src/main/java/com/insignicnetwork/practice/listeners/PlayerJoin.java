package com.insignicnetwork.practice.listeners;

import com.insignicnetwork.practice.core.divisions.DivisionsManager;
import com.insignicnetwork.practice.mysql.PracticeMySQL;
import com.insignicnetwork.practice.mysql.PlayersMySQL;
import com.insignicnetwork.practice.mysql.ranks.RanksList;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        final Player p = e.getPlayer();
        final Inventory inventory = p.getInventory();
        final ItemStack[] itemStacks = inventory.getContents();

        p.getInventory().clear();
        p.getActivePotionEffects().clear();
        p.setGameMode(GameMode.SURVIVAL);
        p.teleport(new Location(p.getWorld(), -35.5, 67, -241.5, 0, (float) 2.5));

        DivisionsManager.checkDivisions(p.getUniqueId());

        if(!PlayersMySQL.getPlayerRank(p.getUniqueId()).getName().equals(RanksList.PLAYER.getName())){

            e.setJoinMessage(PracticeMySQL.getPlayerDivision(p.getUniqueId()).getPrefix() + PlayersMySQL.getPlayerRank(p.getUniqueId()).getPrefix() + p.getName() + " §ea rejoint le practice !");

        } else {

            e.setJoinMessage(null);

        }

    }

}
