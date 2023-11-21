package fr.catsuri33.aoe.listeners;

import fr.catsuri33.aoe.AgeOfEmpires;
import fr.catsuri33.aoe.game.GameStates;
import fr.catsuri33.aoe.items.ItemsList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(Bukkit.getOnlinePlayers().size() - 1 >= AgeOfEmpires.getInstance().getConfig().getInt("players-max") && !p.hasPermission("aoe.entermax") && !p.isOp() && GameStates.isState(GameStates.LOBBY)){

            p.kickPlayer("§6AgeOfEmpires\n\n§cLa partie est pleine !");
            e.setJoinMessage(null);
            return;

        }

        if(GameStates.isState(GameStates.GAME) || GameStates.isState(GameStates.END)){

            p.getInventory().clear();
            p.getActivePotionEffects().clear();
            p.setLevel(0);
            p.setExp(0.0f);
            p.setHealth(20.0f);
            p.setFoodLevel(20);
            p.setGameMode(GameMode.SPECTATOR);
            e.setJoinMessage(null);
            return;

        }

        e.setJoinMessage("§6AgeOfEmpires §l» §r§a" + p.getName() + " §ea rejoint la partie ! (§a" + Bukkit.getOnlinePlayers().size() + "§e/§a" + Bukkit.getMaxPlayers() + "§e)");

        p.getInventory().clear();
        p.getActivePotionEffects().clear();
        p.setLevel(0);
        p.setExp(0.0f);
        p.setHealth(20.0f);
        p.setFoodLevel(20);
        p.setGameMode(GameMode.SURVIVAL);
        ItemsList.giveTeamItem(p, p.getInventory());

    }

}
