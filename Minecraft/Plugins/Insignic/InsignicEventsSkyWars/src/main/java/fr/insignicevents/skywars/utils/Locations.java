package fr.insignicevents.skywars.utils;

import java.util.ArrayList;

import fr.insignicevents.skywars.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Locations {

    public static ArrayList<Location> cagesLocationMap1 = new ArrayList<>();

    public Locations(){

        if(Bukkit.getWorld("SkyWars01").getName().equalsIgnoreCase("SkyWars01")){

            World w = Bukkit.getWorld("SkyWars01");

            cagesLocationMap1.add(new Location(w, 6, 83, -3));
            cagesLocationMap1.add(new Location(w, -4, 74, 24));
            cagesLocationMap1.add(new Location(w, -29, 74, 6));
            cagesLocationMap1.add(new Location(w, -22, 83, -32));

        }

    }

    public static void teleportPlayers(){

        for(int i = 0; i < SkyWars.getInstance().playerList.size(); i++){

            if(Bukkit.getWorld("SkyWars01").getName().equalsIgnoreCase("SkyWars01")){

                Player p = SkyWars.getInstance().playerList.get(i);

                Location cage = cagesLocationMap1.get(i);
                p.teleport(cage);

            }

        }

    }

}
