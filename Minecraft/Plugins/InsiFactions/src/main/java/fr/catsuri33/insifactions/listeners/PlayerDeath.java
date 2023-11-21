package fr.catsuri33.insifactions.listeners;

import fr.catsuri33.insifactions.InsiFactions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){

        Player p = e.getEntity();

        if(InsiFactions.configManager.getPlayersConfig().contains("players." + p.getUniqueId())){

            InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".death-count", InsiFactions.configManager.getPlayersConfig().getInt("players." + p.getUniqueId() + ".death-count") + 1);
            InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".ratio", InsiFactions.configManager.getPlayersConfig().getDouble("players." + p.getUniqueId() + ".kill-count") / InsiFactions.configManager.getPlayersConfig().getDouble("players." + p.getUniqueId() + ".death-count"));
            InsiFactions.configManager.savePlayersConfig();
            InsiFactions.configManager.reloadPlayerConfig();

        }

        if(e.getEntity().getKiller() instanceof Player){

            Player killer = e.getEntity().getKiller();

            InsiFactions.configManager.getPlayersConfig().set("players." + killer.getUniqueId() + ".kill-count", InsiFactions.configManager.getPlayersConfig().getInt("players." + p.getUniqueId() + ".kill-count") + 1);
            InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".ratio", InsiFactions.configManager.getPlayersConfig().getDouble("players." + p.getUniqueId() + ".kill-count") / InsiFactions.configManager.getPlayersConfig().getDouble("players." + p.getUniqueId() + ".death-count"));
            InsiFactions.configManager.savePlayersConfig();
            InsiFactions.configManager.reloadPlayerConfig();

        }

    }

}
