package fr.insignic.practice.game;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Arenas {

    private Location loc1;
    private Location loc2;
    private List<Player> players;
    private boolean isInGame;

    public Arenas(Location loc1, Location loc2){

        this.loc1 = loc1;
        this.loc2 = loc2;
        restart();

    }

    public Location getLoc1() {

        return loc1;

    }

    public Location getLoc2() {

        return loc2;

    }

    public List<Player> getPlayers() {

        return players;

    }

    public void setStarted(){

        this.isInGame = true;

    }

    public boolean isInGame() {

        return isInGame;

    }

    public void eliminate(Player victim){

        players.remove(victim);

        if(victim.isOnline()){

            victim.sendMessage("§bInsignic §6» §cVous avez perdu le duel !");

        }

        checkWin();

    }

    private void checkWin(){

        if(players.size() == 1){

            Player winner = players.get(0);
            winner.sendMessage("§bInsignic §6» §aVous avez gagné le duel !");
            restart();

        }

    }

    private void restart(){

        this.players = new ArrayList<>();
        this.isInGame = false;

    }

}
