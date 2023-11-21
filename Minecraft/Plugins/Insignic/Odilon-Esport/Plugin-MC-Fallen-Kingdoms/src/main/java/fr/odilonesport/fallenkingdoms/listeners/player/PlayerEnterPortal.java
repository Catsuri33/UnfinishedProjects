package fr.odilonesport.fallenkingdoms.listeners.player;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.runnables.GameRunnable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerEnterPortal implements Listener {

    @EventHandler
    public void onPlayerEnterPortal(PlayerTeleportEvent e){

        Player p = e.getPlayer();

        if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)){

            if(GameRunnable.days < Main.getInstance().getConfig().getInt("game.timers.nether")){

                p.sendMessage(Main.getInstance().prefix + "§cErreur, le Nether n'est pas encore activé !");
                e.setCancelled(true);

            }

        }

        if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)){

            if(GameRunnable.days < Main.getInstance().getConfig().getInt("game.timers.end")){

                p.sendMessage(Main.getInstance().prefix + "§cErreur, l'END n'est pas encore activé !");
                e.setCancelled(true);

            }

        }

    }

}
