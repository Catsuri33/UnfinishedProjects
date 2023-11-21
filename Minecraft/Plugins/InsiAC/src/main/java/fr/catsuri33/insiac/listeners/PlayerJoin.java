package fr.catsuri33.insiac.listeners;

import fr.catsuri33.insiac.InsiAC;
import fr.catsuri33.insiac.mysql.PlayersMySQL;
import fr.catsuri33.insiac.mysql.ServersMySQL;
import fr.catsuri33.insiac.sanctions.bans.BanManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(ServersMySQL.isPasswordCorrect(InsiAC.getInstance().getConfig().getString("server-name"))){

            PlayersMySQL.createAccount(p.getUniqueId(), InsiAC.getInstance().getConfig().getString("server-name"));

            BanManager.checkDuration(p.getUniqueId(), InsiAC.getInstance().getConfig().getString("server-name"));

            if(BanManager.isBanned(p.getUniqueId())){

                e.setJoinMessage(null);
                p.kickPlayer("§6§lInsiAC\n\n§r§cYou are banned !\n§6Reason: §r§c" + BanManager.getReason(p.getUniqueId(), InsiAC.getInstance().getConfig().getString("server-name")) + "\n§6Time Left: §c" + BanManager.getTimeLeft(p.getUniqueId(), InsiAC.getInstance().getConfig().getString("server-name")));

            }

        }

    }

}
