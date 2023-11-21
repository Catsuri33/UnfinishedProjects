package fr.funblock.listeners;

import fr.funblock.FunBlock;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Action action = e.getAction();
        Block block = e.getClickedBlock();

        if(action.equals(Action.RIGHT_CLICK_BLOCK)){

            if(block.getType().equals(Material.SKULL)){

                ConfigurationSection headsSection = FunBlock.configManager.getHeadsConfig().getConfigurationSection("heads");

                if(FunBlock.configManager.getHeadsConfig().get("heads.0") != null){

                    for (String heads : headsSection.getKeys(false)) {

                        if(block.getLocation().getX() == FunBlock.configManager.getHeadsConfig().getInt("heads." + heads + ".x") && block.getLocation().getY() == FunBlock.configManager.getHeadsConfig().getInt("heads." + heads + ".y") && block.getLocation().getZ() == FunBlock.configManager.getHeadsConfig().getInt("heads." + heads + ".z")){

                            if(!FunBlock.configManager.getPlayersConfig().getBoolean("players." + p.getUniqueId() + ".heads." + heads)){

                                FunBlock.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".heads." + heads, true);
                                FunBlock.configManager.getPlayersConfig().set("players." + p.getUniqueId() + ".heads-count", FunBlock.configManager.getPlayersConfig().getInt("players." + p.getUniqueId() + ".heads-count") + 1);

                                FunBlock.configManager.savePlayersConfig();
                                FunBlock.configManager.reloadPlayerConfig();

                                p.sendMessage(FunBlock.getInstance().prefix + "§aVous avez trouvé la tête numéro §e" + heads + " §a!");

                            } else {

                                p.sendMessage(FunBlock.getInstance().prefix + "§cVous avez déjà trouvé cette tête !");
                                return;

                            }

                        }

                    }

                }

            }

        }

    }

}
