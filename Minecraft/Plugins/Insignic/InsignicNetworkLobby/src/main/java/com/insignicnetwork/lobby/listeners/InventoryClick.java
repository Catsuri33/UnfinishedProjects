package com.insignicnetwork.lobby.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.insignicnetwork.lobby.Lobby;
import com.insignicnetwork.lobby.guis.LobbyGuis;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(!p.getGameMode().equals(GameMode.CREATIVE)){

            e.setCancelled(true);

        }

        if(e.getInventory().equals(LobbyGuis.invGames) && e.getSlot() == 21){

            p.sendMessage("§aTéléportation au serveur Practice...");

            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("Practice");

            p.sendPluginMessage(Lobby.instance, "BungeeCord", out.toByteArray());

        }

        if(e.getInventory().equals(LobbyGuis.invGames) && e.getSlot() == 23){

            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("GoldenRush01");

            p.sendPluginMessage(Lobby.instance, "BungeeCord", out.toByteArray());

        }

        if(e.getInventory().equals(LobbyGuis.invGames) && e.getSlot() == 53){

            p.sendMessage("§aTéléportation au centre du hub...");
            p.teleport(new Location(p.getWorld(), 0.5, 57, 0.5, 0, (float) 2.5));

        }

        if(e.getInventory().equals(LobbyGuis.invLobbies) && e.getSlot() == 0){

            p.sendMessage("§aTéléportation au Lobby01...");

            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("Lobby01");

            p.sendPluginMessage(Lobby.instance, "BungeeCord", out.toByteArray());

        }

    }

}
