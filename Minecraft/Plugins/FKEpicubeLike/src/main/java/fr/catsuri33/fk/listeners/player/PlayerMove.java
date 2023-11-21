package fr.catsuri33.fk.listeners.player;

import fr.catsuri33.fk.Main;
import fr.catsuri33.fk.game.player.GamePlayer;
import fr.catsuri33.fk.utils.ArrowTarget;
import fr.catsuri33.fk.utils.GameStates;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){

        Player p = e.getPlayer();
        GamePlayer gamePlayer = GamePlayer.gamePlayers.get(p.getName());

        if(GameStates.isState(GameStates.WAITING)){

            if(!Main.getInstance().hub.isInArea(p.getLocation()) && p.getLocation().getY() < 91){

                p.teleport(new Location(p.getWorld(), 86.5, 91, 68.5, 0f, 1.0f));
                p.sendMessage(Main.prefix + "§cNe vous éloignez pas trop !");

            }

            return;

        }

        if(GameStates.isState(GameStates.GAME)){

            if(gamePlayer.getTeam() != null){

                double distance = p.getLocation().distance(gamePlayer.region.getMiddle());
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§7Votre base: §f" + (int) distance + "m " + ArrowTarget.getArrowColor(distance) + ArrowTarget.calculateArrow(p, gamePlayer.region.getMiddle())));

            }

            // Rouges
            if(Main.getInstance().redBase.isInArea(p.getLocation())){

                if(Main.getInstance().redTeam.contains(p.getUniqueId())){

                    if(!gamePlayer.isInBase){

                        gamePlayer.isInBase = true;
                        p.sendMessage(Main.prefix + "§2Vous rentrez dans votre base.");

                    }

                } else {

                    if(!gamePlayer.isInEnemyBase){

                        gamePlayer.isInEnemyBase = true;
                        p.sendMessage(Main.prefix + "§fVous rentrez dans la base §cRouge§f.");

                    }

                }

            } else {

                if(Main.getInstance().redTeam.contains(p.getUniqueId())){

                    if(gamePlayer.isInBase){

                        gamePlayer.isInBase = false;
                        p.sendMessage(Main.prefix + "§cVous sortez de votre base.");

                    }

                } else {

                    if(gamePlayer.isInEnemyBase){

                        gamePlayer.isInEnemyBase = false;
                        p.sendMessage(Main.prefix + "§fVous sortez de la base §cRouge§f.");

                    }

                }

            }

            // Bleus
            if(Main.getInstance().blueBase.isInArea(p.getLocation())){

                if(Main.getInstance().blueTeam.contains(p.getUniqueId())){

                    if(!gamePlayer.isInBase){

                        gamePlayer.isInBase = true;
                        p.sendMessage(Main.prefix + "§2Vous rentrez dans votre base.");

                    }

                } else {

                    if(!gamePlayer.isInEnemyBase){

                        gamePlayer.isInEnemyBase = true;
                        p.sendMessage(Main.prefix + "§fVous rentrez dans la base §9Bleue§f.");

                    }

                }

            } else {

                if(Main.getInstance().blueTeam.contains(p.getUniqueId())){

                    if(gamePlayer.isInBase){

                        gamePlayer.isInBase = false;
                        p.sendMessage(Main.prefix + "§cVous sortez de votre base.");

                    }

                } else {

                    if(gamePlayer.isInEnemyBase){

                        gamePlayer.isInEnemyBase = false;
                        p.sendMessage(Main.prefix + "§fVous sortez de la base §9Bleue§f.");

                    }

                }

            }

        }

    }

}
