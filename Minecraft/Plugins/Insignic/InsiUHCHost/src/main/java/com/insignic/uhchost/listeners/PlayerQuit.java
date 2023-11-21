package com.insignic.uhchost.listeners;

import com.insignic.uhchost.UHCHost;
import com.insignic.uhchost.game.GameStates;
import com.insignic.uhchost.game.guis.SlotsConfigurationInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.LOBBY)){

            e.setQuitMessage("§6[§c-§6] §e" + p.getDisplayName() + " §7(" + (Bukkit.getOnlinePlayers().size() - 1) + "§8/§7" + SlotsConfigurationInventory.slotsNumber + ")");

            if(p.isOp() || p.hasPermission("insiuhc.host")){

                UHCHost.hostList.remove(p);

            }

        } else {

            e.setQuitMessage(null);

        }

    }

}
