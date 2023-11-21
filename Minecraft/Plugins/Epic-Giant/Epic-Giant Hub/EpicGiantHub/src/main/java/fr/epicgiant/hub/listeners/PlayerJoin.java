package fr.epicgiant.hub.listeners;

import fr.epicgiant.hub.EpicGiantHub;
import fr.epicgiant.hub.database.Account;
import fr.epicgiant.hub.database.ranks.RankUnit;
import fr.epicgiant.hub.tools.Title;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private EpicGiantHub instance = EpicGiantHub.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        Account account = new Account(player);
        account.setup();

        if(!(account.getRank() == RankUnit.PLAYER)) {

            e.setJoinMessage(account.getRank().getPrefix() + player.getName() + " §6joined the hub !");

        } else if(account.getRank() == RankUnit.PLAYER) {

            e.setJoinMessage(null);

        }

        player.getInventory().clear();
        player.getEquipment().clear();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setLevel(0);
        player.setExp(0);
        player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

        Title title = new Title("§6§lEpic-Giant", "§fWelcome to the server !");
        title.send(player, 1, 7, 1);

    }
}
