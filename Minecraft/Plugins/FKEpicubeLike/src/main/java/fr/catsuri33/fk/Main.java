package fr.catsuri33.fk;

import fr.catsuri33.fk.game.scoreboards.Scoreboards;
import fr.catsuri33.fk.listeners.ListenersManager;
import fr.catsuri33.fk.game.runnables.Lobby;
import fr.catsuri33.fk.utils.GameStates;
import fr.catsuri33.fk.utils.Gamerules;
import fr.catsuri33.fk.utils.RegionManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class Main extends JavaPlugin {

    private static Main instance;

    public Lobby lobby;
    public static String prefix = "§8[§9FK§8] §f";
    public List<UUID> redTeam = new ArrayList<>();
    public List<UUID> blueTeam = new ArrayList<>();
    public RegionManager hub;
    public RegionManager redBase;
    public RegionManager blueBase;
    public Scoreboards scoreboards = new Scoreboards();
    public int lobbyRunnableTimer = 0;

    @Override
    public void onEnable() {

        instance = this;
        new ListenersManager(this);
        lobby = new Lobby();

        if(Bukkit.getWorlds().get(0).getName().equals("FKCactus")){

            blueBase = new RegionManager(new Location(Bukkit.getWorld("FKCactus"), 47, 0, 2), new Location(Bukkit.getWorld("FKCactus"), 75, 255, -26));
            redBase = new RegionManager(new Location(Bukkit.getWorld("FKCactus"), 131, 0, 89), new Location(Bukkit.getWorld("FKCactus"), 159, 255, 117));
            hub = new RegionManager(new Location(Bukkit.getWorld("FKCactus"), 89, 0, 67), new Location(Bukkit.getWorld("FKCactus"), 83, 256, 75));

        }

        Gamerules.setGamerulesLobby();

        GameStates.setState(GameStates.WAITING);

        if(!Bukkit.getOnlinePlayers().isEmpty()){

            for(Player players : Bukkit.getOnlinePlayers()){

                scoreboards.createLobbyBoard(players);

            }

        }

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static Main getInstance(){

        return instance;

    }

}
