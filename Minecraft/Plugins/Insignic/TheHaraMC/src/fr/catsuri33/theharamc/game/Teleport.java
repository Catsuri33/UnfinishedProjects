/*                              */
/*       TheHaraMC-UHC          */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 12/08/2019       */
/*    Updated: 12/08/2019       */
/*    Name: Teleport            */
/*                              */

package fr.catsuri33.theharamc.game;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Random;

public class Teleport {

    public static void randomTp(Player player){

        Random random = new Random();

        int x = random.nextInt(1000);
        int y = 128;
        int z = - random.nextInt(1000) ;

        World world = player.getWorld();

        Location randomLocation = new Location(world, x, y, z);

        player.teleport(randomLocation);

    }

}
