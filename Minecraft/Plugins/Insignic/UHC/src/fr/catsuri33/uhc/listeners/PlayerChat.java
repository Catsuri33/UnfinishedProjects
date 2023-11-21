package fr.catsuri33.uhc.listeners;

import fr.catsuri33.uhc.UHC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

        @EventHandler
        public void onChat(AsyncPlayerChatEvent e){

            Player player = e.getPlayer();

            if(UHC.getInstance().playerHost.contains(player.getUniqueId())){

                e.setFormat("§c[Host] " + player.getName() + " §f» " + "%2$s");

            } else {

                e.setFormat("§7" + player.getName() + " §7» " + "%2$s");

            }

        }

}
