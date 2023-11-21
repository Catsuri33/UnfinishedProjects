package fr.insignicevents.lobby.listeners;

import fr.insignicevents.lobby.Lobby;
import fr.insignicevents.lobby.database.players.PlayersTable;
import fr.insignicevents.lobby.utils.ScoreboardUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(!p.hasPlayedBefore()){

            PlayersTable.setPlayerCoins(p.getUniqueId(), PlayersTable.getPlayerCoins(p.getUniqueId()) + 50);

        }

        PlayersTable.createPlayer(p.getUniqueId(), p);

        ScoreboardUtils.createScoreboard("lobby", Lobby.getInstance().getConfig().getString("event-name"), p);

        e.setJoinMessage("§7(§2+§7) §f" + p.getName());

        p.sendMessage("§7§m                                   ");
        p.sendMessage("");
        p.sendMessage("    " + Lobby.getInstance().getConfig().getString("event-name"));
        p.sendMessage("");
        p.sendMessage("§7§m                                   ");

    }

}
