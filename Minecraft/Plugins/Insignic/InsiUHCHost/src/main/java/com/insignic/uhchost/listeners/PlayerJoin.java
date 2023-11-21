package com.insignic.uhchost.listeners;

import com.insignic.uhchost.UHCHost;
import com.insignic.uhchost.game.GameStates;
import com.insignic.uhchost.game.guis.HostCustomisationInventory;
import com.insignic.uhchost.game.guis.SlotsConfigurationInventory;
import com.insignic.uhchost.game.guis.SlotsInventory;
import com.insignic.uhchost.game.lobby.FloorRunnable;
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

        if(Bukkit.getOnlinePlayers().size() == 1){

            new FloorRunnable().runTaskTimer(UHCHost.getInstance(), 0L, 5L);

        }

        if(GameStates.isState(GameStates.LOBBY)){

            if(SlotsConfigurationInventory.slotsNumber == Bukkit.getOnlinePlayers().size() - 1){

                p.kickPlayer(UHCHost.prefix + "\n\n§cLa partie est pleine !");

            }

            e.setJoinMessage("§6[§2+§6] §e" + p.getDisplayName() + " §7(" + Bukkit.getOnlinePlayers().size() + "§8/§7" + SlotsConfigurationInventory.slotsNumber + ")");

            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().clear();
            p.getActivePotionEffects().clear();
            p.setHealth(20.0);
            p.setFoodLevel(20);
            p.setLevel(0);
            p.setExp(0.0f);
            p.teleport(new Location(p.getWorld(), 0, 201, 0));

            if(p.isOp() || p.hasPermission("insiuhc.host")){

                UHCHost.hostList.add(p);

                p.setDisplayName("§c[Host] " + p.getName() + "§r");
                p.setPlayerListName("§c[Host] " + p.getName() + "§r");

                HostCustomisationInventory.giveHostItem(p, p.getInventory());

            } else {

                p.setDisplayName(p.getName() + "§r");
                p.setPlayerListName(p.getName() + "§r");

            }

        } else {

            if(SlotsInventory.spectator){

                e.setJoinMessage(null);

                p.setGameMode(GameMode.SPECTATOR);
                p.getInventory().clear();
                p.getActivePotionEffects().clear();
                p.setHealth(20.0);
                p.setFoodLevel(20);
                p.setLevel(0);
                p.setExp(0.0f);
                p.teleport(new Location(p.getWorld(), 0, 201, 0));

            } else {

                p.kickPlayer(UHCHost.prefix + "\n\n§cLa partie a déja démarré !");

            }

        }

    }

}
