package fr.catsuri33.uhcrun.game;

import fr.catsuri33.uhcrun.UHCRun;
import fr.catsuri33.uhcrun.lang.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class Game {

    private static int timer = 0;
    private static int task;

    public static void start(){

        GameStates.setState(GameStates.PREGAME);

        for(UUID uuid : UHCRun.getInstance().playersInGame){

            Player p = Bukkit.getPlayer(uuid);

            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 1));

            Teleport.randomTP(p);

        }

        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(UHCRun.getInstance(), new Runnable() {

            @Override
            public void run() {

                timer++;

                if(timer == 30){

                    GameStates.setState(GameStates.GAME);

                }

                if(timer == 1200){

                    Bukkit.getWorld("world").setPVP(true);
                    GameStates.setState(GameStates.MEETUP);

                    if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("en")){

                        Bukkit.broadcastMessage(Messages.PREFIX.getMessage() + Messages.PVP_ACTIVATED_EN.getMessage());

                    }

                    if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("fr")){

                        Bukkit.broadcastMessage(Messages.PREFIX.getMessage() + Messages.PVP_ACTIVATED_FR.getMessage());

                    }

                }

                if(timer <= 600){

                    if(timer > 0){

                        Bordures b = new Bordures();
                        b.decreaseBorder();

                    }

                }

                if(timer == 0){

                    for(UUID uuid : UHCRun.getInstance().playersInGame){

                        Player p = Bukkit.getPlayer(uuid);
                        p.teleport(new Location(Bukkit.getWorld("world"), 0, 0, 0));

                        Bordures b = new Bordures();
                        b.setBorder(50.0);

                    }

                }

            }

        },20, 20);

    }

}
