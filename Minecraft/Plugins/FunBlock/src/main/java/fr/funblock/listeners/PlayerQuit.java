package fr.funblock.listeners;

import fr.funblock.FunBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        FunBlock.getInstance().playerPerms.remove(p.getUniqueId());

        String quitMessage = FunBlock.getInstance().getConfig().getString("options.messages.quit");
        String quitMessageColor = quitMessage.replace("&", "§");
        String quitMessagePlayer = quitMessageColor.replace("%player%", p.getName());

        e.setQuitMessage(quitMessagePlayer);

    }

}
