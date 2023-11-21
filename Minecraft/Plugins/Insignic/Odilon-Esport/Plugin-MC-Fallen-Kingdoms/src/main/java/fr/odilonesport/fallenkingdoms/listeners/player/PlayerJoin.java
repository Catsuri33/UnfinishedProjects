package fr.odilonesport.fallenkingdoms.listeners.player;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.guis.TeamGui;
import fr.odilonesport.fallenkingdoms.game.player.GamePlayer;
import fr.odilonesport.fallenkingdoms.game.runnables.LobbyRunnable;
import fr.odilonesport.fallenkingdoms.utils.CustomItems;
import fr.odilonesport.fallenkingdoms.utils.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

        // Setup GameState
        if(!GameStates.isState(GameStates.WAITING) && GamePlayer.gamePlayers.get(p.getName()) == null){

            e.setJoinMessage(null);
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage(Main.getInstance().prefix + "§cLa partie a déjà commencé, vous êtes désormais un spectateur !");

            return;

        }

        // Join message in chat and tp to lobby.
        e.setJoinMessage(Main.getInstance().prefix + "§6" + p.getDisplayName() + " §ea rejoint la partie. §a(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")");

        if(!GameStates.isState(GameStates.WAITING)){

            String teamName = TeamGui.getPlayersTeam().get(p.getUniqueId()).toLowerCase();
            String teamColor = Main.getInstance().getConfig().getString("game.teams." + teamName + ".color");
            p.setPlayerListName(ChatColor.translateAlternateColorCodes('&', teamColor) + p.getDisplayName());
            return;

        }

        if(Main.getInstance().getConfig().get("game.lobby.x") != null && Main.getInstance().getConfig().get("game.lobby.y") != null && Main.getInstance().getConfig().get("game.lobby.z") != null){

            p.teleport(new Location(p.getWorld(), Main.getInstance().getConfig().getInt("game.lobby.x"), Main.getInstance().getConfig().getInt("game.lobby.y"), Main.getInstance().getConfig().getInt("game.lobby.z"), 90, 0));

        }

        // Setup player.
        p.getActivePotionEffects().clear();
        p.setGameMode(GameMode.SURVIVAL);
        p.setLevel(0);
        p.setTotalExperience(0);
        p.setHealth(20.0f);
        p.setFoodLevel(20);
        p.getInventory().clear();

        Main.getInstance().scoreboards.createLobbyBoard(p);

        // Inventory
        if(TeamGui.getPlayersTeam().containsKey(p.getUniqueId())){

            String teamName = TeamGui.getPlayersTeam().get(p.getUniqueId()).toLowerCase();
            String teamColor = Main.getInstance().getConfig().getString("game.teams." + teamName + ".color");
            p.setPlayerListName(ChatColor.translateAlternateColorCodes('&', teamColor) + p.getDisplayName());

            if(LobbyRunnable.start){

                return;

            }

            p.getInventory().setItem(0, CustomItems.giveTeamItem(ChatColor.translateAlternateColorCodes('&', teamColor)));

        } else {

            if(LobbyRunnable.start){

                return;

            }

            p.getInventory().setItem(0, CustomItems.giveTeamItemStart());

        }

    }

}
