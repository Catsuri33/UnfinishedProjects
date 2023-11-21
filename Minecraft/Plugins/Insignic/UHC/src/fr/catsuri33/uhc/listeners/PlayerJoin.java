package fr.catsuri33.uhc.listeners;

import fr.catsuri33.uhc.UHC;
import fr.catsuri33.uhc.game.Gamestates;
import fr.catsuri33.uhc.packets.Actionbar;
import fr.catsuri33.uhc.packets.Title;
import fr.catsuri33.uhc.scoreboard.ScoreboardManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PlayerJoin implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if(Gamestates.isState(Gamestates.LOBBY)){

            player.teleport(new Location(Bukkit.getWorlds().get(0), 0, 202, 0));
            player.setGameMode(GameMode.ADVENTURE);
            player.getInventory().clear();
            player.getEquipment().clear();
            player.setFoodLevel(20);
            player.setHealth(20);
            player.setLevel(0);
            player.getActivePotionEffects().forEach(pe -> player.removePotionEffect(pe.getType()));


            UHC.getInstance().playerInGame.add(player.getUniqueId());

            if(UHC.getInstance().playerHost.contains(player.getUniqueId())){

                e.setJoinMessage("§7[§a+§7] §c[Host] " + player.getName() + " §7a rejoint la partie !");

                player.setDisplayName("§c[Host] §c" + player.getName() + "§f");
                player.setPlayerListName("§c[Host] §c" + player.getName());
                UHC.getInstance().setupPermissions(player);

                ItemStack hostItem = new ItemStack(Material.COMPARATOR, 1);
                ItemMeta hostItemMeta = hostItem.getItemMeta();
                hostItemMeta.setDisplayName("§cHost Editor");
                hostItemMeta.setLore(Arrays.asList("§r§7Utilisez cet item pour configurer", "§r§7les paramètres de la partie."));
                hostItem.setItemMeta(hostItemMeta);

                player.getInventory().setItem(4, hostItem);
                player.updateInventory();

            } else {

                e.setJoinMessage("§7[§a+§7] §8" + player.getName() + " §7a rejoint la partie !");
                player.setDisplayName("§7" + player.getName() + "§7");
                player.setPlayerListName("§7" + player.getName());

            }

        } else {

            e.setJoinMessage(null);
            player.setGameMode(GameMode.SPECTATOR);

        }

        Title.sendTitle(player, "§6UHC", "§eBienvenue en §6UHC §e!", 20);

        for(Player players : Bukkit.getOnlinePlayers()){

            Actionbar.sendActionbar(player, "§b(§e" + Bukkit.getOnlinePlayers().size() + "§b/§e" + Bukkit.getServer().getMaxPlayers() + "§b) §6" + player.getName() + " §ea rejoint la partie !");

            if(Gamestates.isState(Gamestates.LOBBY)){

                ScoreboardManager.sendScoreboardLobby(player);

            }

        }



    }

}
