package fr.epicgiant.core.listeners;

import fr.epicgiant.core.Main;
import fr.epicgiant.core.infos.PlayerInfos;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerJoin implements Listener {

    @EventHandler (priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if(Main.Maintenance){

            if(player.isOp() || Main.getAuthorizedMaintenance().contains(player.getUniqueId())){

                return;

            } else {

                player.kickPlayer("§r §6§lEpic-Giant\n §r§cThe server is on maintenance !\n §cMore information on our Twitter: §6§l@GiantEpic");

            }

        }

        Main.getInstance().playerInfos.update(player);

    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        Player player = e.getPlayer();
        Main.getInstance().banManager.checkDuration(player.getUniqueId());

        if(Main.getInstance().banManager.isBanned(player.getUniqueId())){
            e.setResult(PlayerLoginEvent.Result.KICK_BANNED);
            e.setKickMessage("§6§lEpic-Giant\n §cYou are banned !\n §8Reason : §e" + Main.getInstance().banManager.getReason(player.getUniqueId()) + "§8Time remaining : §e" + Main.getInstance().banManager.getTimeLeft(player.getUniqueId()));
        }
    }

}
