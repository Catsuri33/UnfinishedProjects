package fr.catsuri33.insifactions.listeners;

import fr.catsuri33.insifactions.InsiFactions;
import fr.catsuri33.insifactions.permissions.PermissionsManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(!InsiFactions.configManager.getPlayersConfig().contains("players." + p.getUniqueId())){

            InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".pseudo", p.getName());
            InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".rank", "Player");
            InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".faction", "");
            InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".money", 0);
            InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".kill-count", 0);
            InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".death-count", 0);
            InsiFactions.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".ratio", 0.00);
            InsiFactions.configManager.savePlayersConfig();

        }

        if(InsiFactions.configManager.getMaintenanceConfig().getString("maintenance.enabled").equalsIgnoreCase("true")){

            if(!p.isOp() || !p.hasPermission("insifactions.staymaintenance")){

                p.kickPlayer("§c§lMaintenance\n§r§cUne maintenance est en cours ! !\n\n§6Durée: §eIndéfinie");

            }

        }

        ConfigurationSection ranksSection = InsiFactions.configManager.getRanksConfig().getConfigurationSection("ranks");

        for(String ranks : ranksSection.getKeys(false)){

            if(InsiFactions.configManager.getRanksConfig().getString("ranks." + ranks + ".name").equals(InsiFactions.configManager.getPlayersConfig().getString("players." + p.getUniqueId() + ".rank"))){

                p.setDisplayName(InsiFactions.configManager.getRanksConfig().get("ranks." + ranks + ".prefix") + p.getName() + InsiFactions.configManager.getRanksConfig().get("ranks." + ranks + ".suffix"));
                p.setPlayerListName(InsiFactions.configManager.getRanksConfig().get("ranks." + ranks + ".prefix") + p.getName() + InsiFactions.configManager.getRanksConfig().get("ranks." + ranks + ".suffix"));

            }

        }

        PermissionsManager.setupPermissions(p);

        String playersCount = Integer.toString(Bukkit.getOnlinePlayers().size());
        String playersMax = Integer.toString(Bukkit.getMaxPlayers());

        String messageStart = InsiFactions.getInstance().getConfig().getString("messages.join");
        String messagePlayer = messageStart.replace("%player%", p.getName());
        String messagePlayersCount = messagePlayer.replace("%players-count%", playersCount);
        String messagePlayersMax = messagePlayersCount.replace("%players-max%", playersMax);
        String messageColor = messagePlayersMax.replace("&", "§");

        e.setJoinMessage(messageColor);

    }

}
