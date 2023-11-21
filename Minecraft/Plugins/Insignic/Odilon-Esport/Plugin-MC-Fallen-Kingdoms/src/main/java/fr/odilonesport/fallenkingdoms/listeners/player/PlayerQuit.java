package fr.odilonesport.fallenkingdoms.listeners.player;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.utils.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        if((!GameStates.isState(GameStates.WAITING)) && !p.getGameMode().equals(GameMode.SURVIVAL)){

            e.setQuitMessage(null);
            return;

        }

        e.setQuitMessage(Main.getInstance().prefix + "§6" + p.getDisplayName() + " §ea quitté la partie. §c(" + (Bukkit.getOnlinePlayers().size() - 1) + "/" + Bukkit.getMaxPlayers() + ")");

    }

}
