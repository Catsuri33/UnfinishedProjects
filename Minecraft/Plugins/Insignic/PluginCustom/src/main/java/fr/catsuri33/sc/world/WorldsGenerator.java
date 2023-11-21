package fr.catsuri33.sc.world;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

public class WorldsGenerator {

    public static World world;

    public static void crateWorld(String worldName, WorldType worldType, boolean shouldGenerateStructures){

        WorldCreator wc = new WorldCreator(worldName);
        wc.type(worldType);
        wc.generateStructures(shouldGenerateStructures);

        world = wc.createWorld();

    }

}
