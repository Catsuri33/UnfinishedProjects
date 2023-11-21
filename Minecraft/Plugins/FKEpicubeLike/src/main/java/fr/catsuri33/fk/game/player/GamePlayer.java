package fr.catsuri33.fk.game.player;

import fr.catsuri33.fk.utils.RegionManager;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;

import java.util.*;

public class GamePlayer {

    private String name;
    private List<UUID> team;

    public static Map<String, GamePlayer> gamePlayers = new HashMap<>();
    public List<Block> furnaces = new ArrayList<>();
    public boolean isInBase;
    public boolean isInEnemyBase;
    public RegionManager region;

    public GamePlayer(String name){

        this.name = name;
        this.team = new ArrayList<>();
        this.isInBase = false;
        this.isInEnemyBase = false;

        gamePlayers.put(name, this);

    }

    public String getName() {

        return name;

    }

    public List<UUID> getTeam() {

        return team;

    }

}
