package fr.funblock.listeners;

import fr.funblock.FunBlock;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(!FunBlock.configManager.getPlayersConfig().contains("players." + p.getUniqueId())){

            FunBlock.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".pseudo", p.getName());
            FunBlock.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".rank", "Joueur");
            FunBlock.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".money", 0);
            FunBlock.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".heads-count", 0);
            FunBlock.configManager.savePlayersConfig();

        }

        ConfigurationSection ranksSection = FunBlock.configManager.getRanksConfig().getConfigurationSection("ranks");

        for(String ranks : ranksSection.getKeys(false)){

            if(FunBlock.configManager.getRanksConfig().getString("ranks." + ranks + ".name").equals(FunBlock.configManager.getPlayersConfig().getString("players." + p.getUniqueId() + ".rank"))){

                p.setDisplayName(FunBlock.configManager.getRanksConfig().get("ranks." + ranks + ".prefix") + p.getName() + FunBlock.configManager.getRanksConfig().get("ranks." + ranks + ".suffix"));
                p.setPlayerListName(FunBlock.configManager.getRanksConfig().get("ranks." + ranks + ".prefix") + p.getName() + FunBlock.configManager.getRanksConfig().get("ranks." + ranks + ".suffix"));

            }

        }

        ConfigurationSection headsSection = FunBlock.configManager.getHeadsConfig().getConfigurationSection("heads");

        if(FunBlock.configManager.getHeadsConfig().get("heads.0") != null){

            for (String heads : headsSection.getKeys(false)) {

                if(FunBlock.configManager.getPlayersConfig().get("players." + p.getUniqueId() + ".heads." + heads) == null){

                    FunBlock.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".heads." + heads, false);

                    FunBlock.configManager.savePlayersConfig();
                    FunBlock.configManager.reloadPlayerConfig();

                }

            }

        }

        String joinMessage = FunBlock.getInstance().getConfig().getString("options.messages.join");
        String joinMessageColor = joinMessage.replace("&", "§");
        String joinMessagePlayer = joinMessageColor.replace("%player%", p.getName());

        e.setJoinMessage(joinMessagePlayer);

    }

}
