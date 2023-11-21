package fr.odilonesport.fallenkingdoms.listeners.player;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.guis.TeamGui;
import fr.odilonesport.fallenkingdoms.game.player.GamePlayer;
import fr.odilonesport.fallenkingdoms.utils.GameStates;
import fr.odilonesport.fallenkingdoms.utils.RegionManager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.WAITING)){

            p.setFoodLevel(20);

        }

        if(!p.getGameMode().equals(GameMode.SPECTATOR) && (GameStates.isState(GameStates.GAME) || GameStates.isState(GameStates.ASSAULTS))){

            String playerTeamName = TeamGui.getPlayersTeam().get(p.getUniqueId()).toLowerCase();
            GamePlayer gamePlayer = GamePlayer.gamePlayers.get(p.getName());

            if(Main.getInstance().basesRegions.containsKey(playerTeamName)){

                RegionManager playerBase = Main.getInstance().basesRegions.get(playerTeamName);

                if(playerBase.isInArea(p.getLocation()) && !gamePlayer.isInBase){

                    gamePlayer.isInBase = true;
                    p.sendMessage(Main.getInstance().prefix + "§aVous rentrez dans votre base.");

                }

                if(!playerBase.isInArea(p.getLocation()) && gamePlayer.isInBase){

                    gamePlayer.isInBase = false;
                    p.sendMessage(Main.getInstance().prefix + "§cVous sortez de votre base.");

                }

                for(String teamName : Main.getInstance().basesRegions.keySet()){

                    RegionManager base = Main.getInstance().basesRegions.get(teamName);
                    String teamColor = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("game.teams." + teamName.toLowerCase() + ".color"));

                    if(base != playerBase){

                        if(base.isInArea(p.getLocation()) && !gamePlayer.isInEnemyBase){

                            gamePlayer.isInEnemyBase = true;
                            p.sendMessage(Main.getInstance().prefix + "§fVous rentrez dans la base " + teamColor + (teamName.substring(0, 1).toUpperCase() + teamName.substring(1)) + "§f.");
                            return;

                        }

                        if(!base.isInArea(p.getLocation()) && gamePlayer.isInEnemyBase){

                            gamePlayer.isInEnemyBase = false;
                            p.sendMessage(Main.getInstance().prefix + "§fVous sortez de la base " + teamColor + (teamName.substring(0, 1).toUpperCase() + teamName.substring(1)) + "§f.");
                            return;

                        }

                    }

                }

            }

        }

    }

}
