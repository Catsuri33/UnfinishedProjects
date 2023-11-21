package fr.epicgiant.hub.listeners;

import fr.epicgiant.hub.EpicGiantHub;
import fr.epicgiant.hub.database.Account;
import fr.epicgiant.hub.database.ranks.RankUnit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

    public class PlayerChat implements Listener {
        private List<Player> cooldown = new ArrayList<>();

        @EventHandler
        public void onChat(AsyncPlayerChatEvent e){

            Player player = e.getPlayer();
            RankUnit rank = Account.getAccount(player).getRank();

            e.setFormat(rank.getPrefix() + "%1$s §7» " + (rank == RankUnit.PLAYER ? "§7" : "§f") + "%2$s");

            if(cooldown.contains(player)){
                e.setCancelled(true);
                player.sendMessage("§cPlease wait between each messages !");
                return;
            }

            if(rank.getPower() > RankUnit.MODERATOR.getPower()){
                cooldown.add(player);
                Bukkit.getScheduler().runTaskLater(EpicGiantHub.getInstance(), () -> cooldown.remove(player), 2 * 20L);
            }

        }

}
