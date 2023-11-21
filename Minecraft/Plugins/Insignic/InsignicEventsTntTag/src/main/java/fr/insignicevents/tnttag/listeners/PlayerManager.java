package fr.insignicevents.tnttag.listeners;

import org.bukkit.event.Listener;

import java.util.UUID;

public class PlayerManager implements Listener {

    private UUID uuid;
    private boolean inGame;
    private boolean isDead;

    PlayerManager(UUID uuid, boolean inGame, boolean isDead){

        this.uuid = uuid;
        this.inGame = inGame;
        this.isDead = isDead;

    }

    public UUID getUuid() {

        return uuid;

    }

    public void setUuid(UUID uuid) {

        this.uuid = uuid;

    }

    public boolean isInGame() {

        return inGame;

    }

    public void setInGame(boolean inGame) {

        this.inGame = inGame;

    }

    public boolean isDead() {

        return isDead;

    }

    public void setDead(boolean dead) {

        isDead = dead;

    }
}
