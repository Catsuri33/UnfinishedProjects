package fr.catsuri33.lguhc.listeners;

import fr.catsuri33.lguhc.LGUHC;
import fr.catsuri33.lguhc.game.Gamestates;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * LGUHC
 * Create the 10/07/2019
 *
 * @author Catsuri33
 * @version 1.0.0
 */

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        e.setJoinMessage("§8[§a+§8] §e" + player.getName() + " §7(§e" + Bukkit.getOnlinePlayers().size() + "§7/§e" + Bukkit.getMaxPlayers() + "§7)");

        player.getInventory().clear();
        player.teleport(new Location(Bukkit.getWorld("world"), 0, 202, 0));

        for(Player pls : Bukkit.getOnlinePlayers()){

            LGUHC.getInstance().sendScoreboard(player);

        }

        if(Gamestates.isState(Gamestates.LOBBY)) {

            player.setGameMode(GameMode.ADVENTURE);

            player.sendTitle("§c§lLG§6UHC", "Welcome !");

            ItemStack gameEditor = new ItemStack(Material.CHEST);
            ItemMeta gameEditorMeta = gameEditor.getItemMeta();
            gameEditorMeta.setDisplayName("§6§lGame Editor");
            gameEditorMeta.setLore(Arrays.asList("§r§fEdit the options of the game."));
            gameEditor.setItemMeta(gameEditorMeta);

            player.getInventory().setItem(4, gameEditor);
            player.updateInventory();

        }

        if(Gamestates.isState(Gamestates.GAME) || Gamestates.isState(Gamestates.GAMEPVP)) {

            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("§3[§c§lLG§6UHC§r§3] §cYou are now a spectator !");

        }

    }

}
