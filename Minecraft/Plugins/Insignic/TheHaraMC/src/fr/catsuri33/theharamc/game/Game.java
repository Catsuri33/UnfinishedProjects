/*                              */
/*       TheHaraMC-UHC          */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 12/08/2019       */
/*    Updated: 12/08/2019       */
/*    Name: Game                */
/*                              */

package fr.catsuri33.theharamc.game;

import fr.catsuri33.theharamc.UHC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Game {

    static int timer = 0;
    static int task;

    public static void start(){

        Gamestates.setState(Gamestates.PREGAME);

        for(UUID uuid : UHC.getInstance().playerInGame){

            Player player = Bukkit.getPlayer(uuid);

            Teleport.randomTp(player);

        }

        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(UHC.getInstance(), new Runnable() {

            @Override
            public void run() {

                timer--;

                if(timer == 30){

                    Gamestates.setState(Gamestates.GAME);
                    Bukkit.broadcastMessage("§b[§6UHC§b] §cDégâts de chute activés !");

                }

                if(timer == 600){

                    Bukkit.getWorlds().get(0).setPVP(true);
                    Bukkit.broadcastMessage("§b[§6UHC§b] §cPvp activé !");
                    Gamestates.setState(Gamestates.GAMEPVP);

                }

                if(timer <= 600){

                    if(timer > 12000){

                        Borders bordures = new Borders();
                        bordures.decreaseBorder();

                    }

                }

            }

        }, 20, 20);

    }



}
