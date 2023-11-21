package fr.catsuri33.insiserveressential.listeners;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){

        Player p = e.getPlayer();

        if(InsiServerEssential.getInstance().authLocked.contains(p.getUniqueId())){

            e.setCancelled(true);

        }

    }

}
