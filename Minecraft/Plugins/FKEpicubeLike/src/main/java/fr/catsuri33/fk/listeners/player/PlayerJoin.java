package fr.catsuri33.fk.listeners.player;

import fr.catsuri33.fk.Main;
import fr.catsuri33.fk.game.player.GamePlayer;
import fr.catsuri33.fk.game.runnables.Lobby;
import fr.catsuri33.fk.utils.CustomItems;
import fr.catsuri33.fk.utils.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(!GameStates.isState(GameStates.WAITING)){

            e.setJoinMessage(null);
            p.setGameMode(GameMode.SPECTATOR);

            if(p.getWorld().getName().equals("FKCactus")){

                p.teleport(new Location(p.getWorld(), 86.5, 91, 68.5, 0f, 1.0f));

            }

            return;

        }

        e.setJoinMessage(Main.prefix + "§f" + p.getDisplayName() + " §7a rejoint la partie §a(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")");

        p.getInventory().clear();
        p.getActivePotionEffects().clear();
        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20.0);
        p.setFoodLevel(20);
        p.setExp(0.0f);
        p.setLevel(0);

        if(p.getWorld().getName().equals("FKCactus")){

            p.teleport(new Location(p.getWorld(), 86.5, 91, 68.5, 0f, 1.0f));

        }

        new GamePlayer(p.getName());

        p.getInventory().setItem(0, CustomItems.giveKitsItem());

        if((Bukkit.getOnlinePlayers().size() >= 1) && (!Lobby.start)){

            // Scoreboard
            Main.getInstance().scoreboards.createLobbyBoard(p);

            // Lobby Runnable
            new Lobby().runTaskTimer(Main.getInstance(), 0L, 20L);
            Lobby.start = true;

        }

    }

}
