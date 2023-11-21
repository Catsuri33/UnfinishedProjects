package fr.epicgiant.api.bukkit.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ExplosionUtils {

    static ExplosionUtils instance;
    public static ExplosionUtils getInstance(){ return instance; }

    public static void createExplosion(Player p, Location loc, float distance, boolean damage){

        p.getWorld().createExplosion(loc, distance, damage);

    }

}
