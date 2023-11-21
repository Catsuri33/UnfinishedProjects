package fr.catsuri33.fk.game.scoreboards;

import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LobbyBoard {

    private static Map<UUID, Integer> tasks = new HashMap<>();
    private final UUID uuid;

    public LobbyBoard(UUID uuid){

        this.uuid = uuid;

    }

    public void setID(int id){

        tasks.put(uuid, id);

    }

    public int getID(){

        return tasks.get(uuid);

    }

    public boolean hasID(){

        if(tasks.containsKey(uuid)){

            return true;

        }

        return false;

    }

    public void stop(){

        Bukkit.getScheduler().cancelTask(tasks.get(uuid));
        tasks.remove(uuid);

    }

}
