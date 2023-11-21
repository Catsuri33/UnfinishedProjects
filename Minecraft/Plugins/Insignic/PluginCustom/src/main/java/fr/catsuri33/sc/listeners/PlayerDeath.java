package fr.catsuri33.sc.listeners;

import fr.catsuri33.sc.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){

        if(e.getEntity() instanceof Player){

            Player p = e.getEntity();

            Main.worldOfDeath.put(p.getUniqueId(), p.getWorld());

            if(Main.configManager.getPlayersConfig().contains("players." + p.getUniqueId())){

                Main.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".death-count", Main.configManager.getPlayersConfig().getInt("players." + p.getUniqueId() + ".death-count") + 1);
                Main.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".ratio", Main.configManager.getPlayersConfig().getDouble("players." + p.getUniqueId() + ".kill-count") / Main.configManager.getPlayersConfig().getDouble("players." + p.getUniqueId() + ".death-count"));
                Main.configManager.savePlayersConfig();
                Main.configManager.reloadPlayerConfig();

            }

            if(e.getEntity().getKiller() instanceof Player){

                Player killer = e.getEntity().getKiller();

                Main.configManager.getPlayersConfig().set("players." + killer.getUniqueId() + ".kill-count", Main.configManager.getPlayersConfig().getInt("players." + p.getUniqueId() + ".kill-count") + 1);
                Main.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".ratio", Main.configManager.getPlayersConfig().getDouble("players." + p.getUniqueId() + ".kill-count") / Main.configManager.getPlayersConfig().getDouble("players." + p.getUniqueId() + ".death-count"));
                Main.configManager.savePlayersConfig();
                Main.configManager.reloadPlayerConfig();

            }

        }

    }

}
