package fr.catsuri33.uhcrun.listeners;

import fr.catsuri33.uhcrun.UHCRun;
import fr.catsuri33.uhcrun.lang.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        UHCRun.getInstance().playersInGame.remove(p.getUniqueId());

        if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("en")){

            e.setQuitMessage(Messages.PREFIX.getMessage() + "§6" + p.getName() + Messages.QUIT_MESSAGE_EN.getMessage());

        }

        if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("fr")){

            e.setQuitMessage(Messages.PREFIX.getMessage() + "§6" + p.getName() + Messages.QUIT_MESSAGE_FR.getMessage());

        }

        e.setQuitMessage(null);

    }

}
