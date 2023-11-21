package fr.catsuri33.aoe.listeners;

import fr.catsuri33.aoe.AgeOfEmpires;
import fr.catsuri33.aoe.game.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        if(Bukkit.getOnlinePlayers().size() - 1 >= AgeOfEmpires.getInstance().getConfig().getInt("players-max") && !p.hasPermission("aoe.entermax") && !p.isOp() && GameStates.isState(GameStates.LOBBY)){

            e.setQuitMessage(null);
            return;

        }

        e.setQuitMessage("§6AgeOfEmpires §l» §r§a" + p.getName() + " §ea quitté la partie ! (§c" + (Bukkit.getOnlinePlayers().size() - 1) + "§e/§c" + Bukkit.getMaxPlayers() + "§e)");

    }

}
