package com.epicgiant.hub.network;

import com.epicgiant.hub.utils.PlayerHeadUtils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public enum Servers {

    LOBBY01("Lobby01", PlayerHeadUtils.skullTextureBuilder("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2E3Y2RhOTAwNGZjMTk3ZDY2YWZiYzJiMDAzYTViOWVmMTNjZjQ2MDBiMWZjNzQ5MDA2NzU5MGYwNDcxODFlIn19fQ=="), "§aLobby #1", (ArrayList<String>) Arrays.asList("§6§l> §r§eCliquez ici pour rejoindre", "§ele lobby §6#1.")),
    LOBBY02("Lobby02", PlayerHeadUtils.skullTextureBuilder("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2E3Y2RhOTAwNGZjMTk3ZDY2YWZiYzJiMDAzYTViOWVmMTNjZjQ2MDBiMWZjNzQ5MDA2NzU5MGYwNDcxODFlIn19fQ=="), "§aLobby #2", (ArrayList<String>) Arrays.asList("§6§l> §r§eCliquez ici pour rejoindre", "§ele lobby §6#2."));

    private final String serverName;
    private final ItemStack itemStack;
    private final String serverDisplayName;
    private final ArrayList<String> serverLores;

    Servers(String serverName, ItemStack itemStack, String serverDisplayName, ArrayList<String> serverLores){

        this.serverName = serverName;
        this.itemStack = itemStack;
        this.serverDisplayName = serverDisplayName;
        this.serverLores = serverLores;

    }

    public String getServerName() {

        return serverName;

    }

    public ItemStack getItemStack() {

        return itemStack;

    }

    public String getServerDisplayName() {

        return serverDisplayName;

    }

    public ArrayList<String> getServerLores() {

        return serverLores;

    }
}
