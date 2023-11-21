package fr.catsuri33.uhcrun.game;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Random;

public class Teleport {

    public static void randomTP(Player p){

        Random r = new Random();
        int x = r.nextInt(1000);
        int y = 128;
        int z = - r.nextInt(1000);
        World world = p.getWorld();

        Location randomLocation = new Location(world, x, y, z);

        p.teleport(randomLocation);

    }

}
