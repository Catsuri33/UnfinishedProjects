package fr.catsuri33.uhcrun.listeners;

import fr.catsuri33.uhcrun.UHCRun;
import fr.catsuri33.uhcrun.game.Game;
import fr.catsuri33.uhcrun.game.GameStates;
import fr.catsuri33.uhcrun.lang.Messages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoin implements Listener {

    private static int task;
    private static int timer = 60;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(GameStates.isState(GameStates.LOBBY)){

            p.setGameMode(GameMode.ADVENTURE);
            p.getInventory().clear();
            p.getActivePotionEffects().clear();

            if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("en")){

                e.setJoinMessage(Messages.PREFIX.getMessage() + "§6" + p.getName() + Messages.JOIN_MESSAGE_EN.getMessage());

            }

            if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("fr")){

                e.setJoinMessage(Messages.PREFIX.getMessage() + "§6" + p.getName() + Messages.JOIN_MESSAGE_FR.getMessage());

            }

            if(!UHCRun.getInstance().playersInGame.contains(p.getUniqueId())){

                UHCRun.getInstance().playersInGame.add(p.getUniqueId());

                if(UHCRun.getInstance().playersInGame.size() == UHCRun.getInstance().getConfig().getInt("player-min")){

                    if(UHCRun.getInstance().playersInGame.size() == UHCRun.getInstance().getConfig().getInt("player-max")){

                        timer = 30;

                    }

                    task = Bukkit.getScheduler().scheduleSyncRepeatingTask(UHCRun.getInstance(), new Runnable() {

                        @Override
                        public void run() {

                            timer --;

                            setXPLevel(timer);

                            if(timer == 30 || timer == 15 || timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1){

                                for(UUID uuid : UHCRun.getInstance().playersInGame){

                                    Player pl = Bukkit.getPlayer(uuid);

                                    if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("en")){

                                        pl.sendMessage(Messages.PREFIX.getMessage() + "§eThe game start in " + timer + " seconds.");
                                        pl.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                                    }

                                    if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("fr")){

                                        pl.sendMessage(Messages.PREFIX.getMessage() + "§eLa partie commence dans " + timer + " secondes.");
                                        pl.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                                    }

                                }

                            }

                            if(timer == 0){

                                for(UUID uuid : UHCRun.getInstance().playersInGame){

                                    Player pl = Bukkit.getPlayer(uuid);

                                    if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("en")){

                                        pl.sendMessage(Messages.PREFIX.getMessage() + Messages.GAME_START_MESSAGE_EN.getMessage());
                                        pl.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

                                    }

                                    if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("fr")){

                                        pl.sendMessage(Messages.PREFIX.getMessage() + Messages.GAME_START_MESSAGE_FR.getMessage());
                                        pl.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

                                    }

                                }

                                Bukkit.getScheduler().cancelTask(task);

                                Game.start();

                            }

                        }

                    },20 ,20);

                }

            }

        } else {

            p.setGameMode(GameMode.SPECTATOR);

            if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("en")){

                p.sendMessage(Messages.PREFIX.getMessage() + Messages.GAME_ALREADY_START_EN.getMessage());

            }

            if(UHCRun.getInstance().getConfig().getString("language").equalsIgnoreCase("fr")){

                p.sendMessage(Messages.PREFIX.getMessage() + Messages.GAME_ALREADY_START_FR.getMessage());

            }

        }

    }

    public static void setXPLevel(int timer){

        for(UUID uuid : UHCRun.getInstance().playersInGame){

            Player pl = Bukkit.getPlayer(uuid);

            pl.setLevel(timer);

        }

    }

}
