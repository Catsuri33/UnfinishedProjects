package fr.catsuri33.uhc.listeners;

import fr.catsuri33.uhc.UHC;
import fr.catsuri33.uhc.game.Gamestates;
import fr.catsuri33.uhc.packets.Actionbar;
import fr.catsuri33.uhc.scoreboard.ScoreboardManager;
import fr.catsuri33.uhc.ui.TeamUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player player = e.getPlayer();

        UHC.getInstance().playerInGame.remove(player.getUniqueId());
        TeamUI.playerInTeamLightBlue.remove(player.getUniqueId());

        if(UHC.getInstance().boards.containsKey(player)){

            UHC.getInstance().boards.get(player).destroy();

        }

        if(Gamestates.isState(Gamestates.LOBBY)){

            if(UHC.getInstance().playerHost.contains(player.getUniqueId())){

                e.setQuitMessage("§7[§c-§7] §c[Host] " + player.getName() + " §7a quitté la partie !");

            } else {

                e.setQuitMessage("§7[§c-§7] §8" + player.getName() + " §7a quitté la partie !");

            }

        } else {

            e.setQuitMessage(null);

        }

        for(Player players : Bukkit.getOnlinePlayers()){

            Actionbar.sendActionbar(players, "§b(§e" + Bukkit.getOnlinePlayers().size() + "§b/§e" + Bukkit.getServer().getMaxPlayers() + "§b) §6" + player.getName() + " §ca quitté la partie !");
            ScoreboardManager.updateSlotsScoreboardLobby(players);

        }

    }

}
