package fr.catsuri33.sc.listeners;

import fr.catsuri33.sc.Main;
import fr.catsuri33.sc.core.tasks.TimerMoneyRunnable;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleport implements Listener {

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e){

        Player p = e.getPlayer();
        World worldTp = e.getTo().getWorld();

        if(Main.getInstance().getConfig().get("economy.timers." + worldTp.getName()) != null){

            if(TimerMoneyRunnable.playersJoin.containsKey(p)){

                TimerMoneyRunnable.playersJoin.remove(p);

            }

            TimerMoneyRunnable.playersJoin.put(p, System.currentTimeMillis());

        } else {

            if(TimerMoneyRunnable.playersJoin.containsKey(p)){

                TimerMoneyRunnable.playersJoin.remove(p);

            }

        }

    }

}
