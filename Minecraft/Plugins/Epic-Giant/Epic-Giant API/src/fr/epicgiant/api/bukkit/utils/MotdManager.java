package fr.epicgiant.api.bukkit.utils;

import net.minecraft.server.v1_14_R1.MinecraftServer;

public class MotdManager {

    private static MotdManager instance = new MotdManager();
    private MotdManager(){}
    public static MotdManager getInstance() { return instance; }

    @SuppressWarnings("deprecation")
    public void setLobbyMotd(String motd){
        MinecraftServer.getServer().setMotd(motd);
    }

    @SuppressWarnings("deprecation")
    public void setWaitingMotd(String motd){
        MinecraftServer.getServer().setMotd(motd);
    }

    @SuppressWarnings("deprecation")
    public void setGameMotd(String motd){
        MinecraftServer.getServer().setMotd(motd);
    }

    @SuppressWarnings("deprecation")
    public void setEndMotd(String motd){
        MinecraftServer.getServer().setMotd(motd);
    }

    @SuppressWarnings("deprecation")
    public void setGenerationMotd(int purcent){
        MinecraftServer.getServer().setMotd("Génération " + purcent + "%");
    }

}
