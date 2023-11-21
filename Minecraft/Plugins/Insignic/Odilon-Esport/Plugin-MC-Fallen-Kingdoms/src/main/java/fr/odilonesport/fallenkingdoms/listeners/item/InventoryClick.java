package fr.odilonesport.fallenkingdoms.listeners.item;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.guis.TeamGui;
import fr.odilonesport.fallenkingdoms.game.scoreboards.LobbyBoard;
import fr.odilonesport.fallenkingdoms.game.scoreboards.Scoreboards;
import fr.odilonesport.fallenkingdoms.utils.BannerColor;
import fr.odilonesport.fallenkingdoms.utils.CustomItems;
import fr.odilonesport.fallenkingdoms.utils.GameStates;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if(GameStates.isState(GameStates.WAITING) && !p.getGameMode().equals(GameMode.CREATIVE)){

            e.setCancelled(true);

        }

        if(e.getView().getTitle().equals("§8Sélection: §eChoisir") || e.getView().getTitle().equals("§8Sélection: §e" + TeamGui.getPlayersTeam().get(p.getUniqueId()))){

            List<Object> teamFields = Arrays.asList(Main.getInstance().getConfig().getConfigurationSection("game.teams").getKeys(false).toArray());

            for(Object key : teamFields){

                String teamName = key.toString().substring(0, 1).toUpperCase() + key.toString().substring(1);
                String teamColor = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("game.teams." + key + ".color"));

                if(e.getClickedInventory() != null && e.getClickedInventory().getType() != InventoryType.PLAYER && e.getSlot() == teamFields.indexOf(key)){

                    if(TeamGui.getPlayersTeam().containsKey(p.getUniqueId())){

                        TeamGui.getPlayersTeam().remove(p.getUniqueId());

                    }

                    p.setPlayerListName(teamColor + p.getDisplayName());

                    TeamGui.getPlayersTeam().put(p.getUniqueId(), teamName);
                    p.sendMessage(Main.getInstance().prefix + "§6Votre équipe : " + teamColor + teamName);
                    Main.getInstance().scoreboards.createLobbyBoard(p);
                    p.getInventory().setItem(0, CustomItems.giveTeamItem(teamColor));
                    p.getOpenInventory().close();

                }

            }

        }

    }

}
