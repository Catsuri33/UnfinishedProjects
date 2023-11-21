package fr.odilonesport.fallenkingdoms.game.player;

import java.util.*;

public class GamePlayer {

    private String name;

    public static Map<String, GamePlayer> gamePlayers = new HashMap<>();
    public boolean isInBase;
    public boolean isInEnemyBase;
    public Integer killCount;
    public Integer deathCount;

    public GamePlayer(String name){

        this.name = name;
        this.isInBase = false;
        this.isInEnemyBase = false;
        this.killCount = 0;
        this.deathCount = 0;

        gamePlayers.put(name, this);

    }

    public String getName() {

        return name;

    }

    public Integer getKillCount() {

        return killCount;

    }

    public Integer getDeathCount() {

        return deathCount;

    }

    public void addKillCount(){

        gamePlayers.get(name).killCount = gamePlayers.get(name).killCount + 1;

    }

    public void addDeathCount(){

        gamePlayers.get(name).deathCount = gamePlayers.get(name).deathCount + 1;

    }

}
