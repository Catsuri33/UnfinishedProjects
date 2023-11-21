package fr.insignicevents.skywars.listeners;

import fr.insignicevents.skywars.SkyWars;
import fr.insignicevents.skywars.game.GameStates;
import fr.insignicevents.skywars.utils.Locations;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private static String prefix = "§7[§bI§fE§7] §r";

    private static int timer = 30;
    private static int task;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.PREGAME) || GameStates.isState(GameStates.GAME) || GameStates.isState(GameStates.FINISH)){

            p.setGameMode(GameMode.SPECTATOR);
            p.teleport(new Location(p.getWorld(), 0, 100, 0));
            p.sendMessage(prefix + "§cUne partie est déjà en cours, tu es désormais spectateur !");

            return;

        }

        if(!SkyWars.getInstance().playerList.contains(p)){

            p.setGameMode(GameMode.SURVIVAL);
            p.teleport(new Location(p.getWorld(), 0, 100, 0));

            e.setJoinMessage("§7(§2+§7) §f" + p.getName());

            SkyWars.getInstance().playerList.add(p);

            if(SkyWars.getInstance().playerList.size() == 1){

                task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable() {

                    @Override
                    public void run() {

                        timer--;

                        if(timer == 15 || timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1){

                            Bukkit.broadcastMessage(prefix + "§fLa partie commence dans §e" + timer + " §fsecondes !");
                            p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                        }

                        if(timer == 0){

                            Bukkit.broadcastMessage("§7§m                                    ");
                            Bukkit.broadcastMessage("              §6SkyWars");
                            Bukkit.broadcastMessage("§fLa partie commence, bonne chance !");
                            Bukkit.broadcastMessage("§7§m                                    ");

                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

                            Bukkit.getScheduler().cancelTask(task);

                            GameStates.setState(GameStates.PREGAME);

                            Locations.teleportPlayers();

                        }

                    }

                }, 20, 20);

            }

        }

    }

}
