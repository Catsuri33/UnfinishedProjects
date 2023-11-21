package fr.odilonesport.fallenkingdoms.listeners.player;

import fr.odilonesport.fallenkingdoms.game.player.GamePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){

        Player deadPlayer = e.getEntity();
        Player killer = e.getEntity().getKiller();
        GamePlayer gameDeadPlayer = GamePlayer.gamePlayers.get(deadPlayer.getName());

        gameDeadPlayer.addDeathCount();

        if(killer == null){

            return;

        }

        GamePlayer gameKillerPlayer = GamePlayer.gamePlayers.get(killer.getName());
        gameKillerPlayer.addKillCount();

    }

}
