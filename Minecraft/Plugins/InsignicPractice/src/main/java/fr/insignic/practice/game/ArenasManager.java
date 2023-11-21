package fr.insignic.practice.game;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ArenasManager {

    private List<Arenas> arenas = new ArrayList<>();

    public void addArena(Arenas arena){

        this.arenas.add(arena);

    }

    public void joinArena(Player player1, Player player2){

        Arenas nextArena = getNextArena();

        if(nextArena != null){

            nextArena.getPlayers().add(player1);
            nextArena.getPlayers().add(player2);

            player1.teleport(nextArena.getLoc1());
            player2.teleport(nextArena.getLoc2());

            nextArena.setStarted();

        } else {

            player1.sendMessage("§bInsignic §6» §cErreur, il n'y a pas d'arène disponible !");
            player2.sendMessage("§bInsignic §6» §cErreur, il n'y a pas d'arène disponible !");

        }

    }

    public Arenas getArenasByPlayer(Player p){

        for(Arenas arena : arenas){

            if(arena.getPlayers().contains(p)){

                return arena;

            }

        }

        return null;

    }

    private Arenas getNextArena(){

        for(Arenas arena : arenas){

            if(!arena.isInGame()){

                return arena;

            }

        }

        return null;

    }

    public List<Arenas> getArenas(){

        return arenas;

    }

}
