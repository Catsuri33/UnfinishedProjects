package fr.catsuri33.fk.listeners.player;

import fr.catsuri33.fk.Main;
import fr.catsuri33.fk.game.scoreboards.LobbyBoard;
import fr.catsuri33.fk.utils.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();
        LobbyBoard lobbyBoard = new LobbyBoard(p.getUniqueId());

        if(lobbyBoard.hasID()){

            lobbyBoard.stop();

        }

        if(!GameStates.isState(GameStates.WAITING)){

            e.setQuitMessage(null);
            return;

        }

        e.setQuitMessage(Main.prefix + "§f" + p.getDisplayName() + " §7a quitté la partie §c(" + (Bukkit.getOnlinePlayers().size() - 1) + "/" + Bukkit.getMaxPlayers() + ")");

    }

}
