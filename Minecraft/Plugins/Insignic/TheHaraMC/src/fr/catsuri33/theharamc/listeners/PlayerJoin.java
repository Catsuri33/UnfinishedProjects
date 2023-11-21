/*                              */
/*       TheHaraMC-UHC          */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 12/08/2019       */
/*    Updated: 12/08/2019       */
/*    Name: PlayerJoin          */
/*                              */

package fr.catsuri33.theharamc.listeners;

import fr.catsuri33.theharamc.UHC;
import fr.catsuri33.theharamc.game.Game;
import fr.catsuri33.theharamc.game.Gamestates;
import fr.catsuri33.theharamc.packets.Actionbar;
import fr.catsuri33.theharamc.packets.Title;
import net.minecraft.server.v1_9_R1.ChatComponentText;
import net.minecraft.server.v1_9_R1.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.util.UUID;

public class PlayerJoin implements Listener {

    static int task;
    static int timer = 30;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if(Gamestates.isState(Gamestates.LOBBY)){

            if(!UHC.getInstance().playerInGame.contains(player.getUniqueId())){

                UHC.getInstance().playerInGame.add(player.getUniqueId());

                if(UHC.getInstance().playerInGame.size() == UHC.getInstance().getConfig().getInt("player-min")){

                    task = Bukkit.getScheduler().scheduleSyncRepeatingTask(UHC.getInstance(), new Runnable() {

                        @Override
                        public void run(){

                            timer--;
                            setLevel(timer);

                            if(timer == 15){

                                for(UUID uuid : UHC.getInstance().playerInGame){

                                    Player p = Bukkit.getPlayer(uuid);
                                    Title.sendTitle(p, "§315", "", 10);
                                    p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                                }

                            }

                            if(timer == 10){

                                for(UUID uuid : UHC.getInstance().playerInGame){

                                    Player p = Bukkit.getPlayer(uuid);
                                    Title.sendTitle(p, "§b10", "", 10);
                                    p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                                }

                            }

                            if(timer == 5){

                                for(UUID uuid : UHC.getInstance().playerInGame){

                                    Player p = Bukkit.getPlayer(uuid);
                                    Title.sendTitle(p, "§25", "", 10);
                                    p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                                }

                            }

                            if(timer == 4){

                                for(UUID uuid : UHC.getInstance().playerInGame){

                                    Player p = Bukkit.getPlayer(uuid);
                                    Title.sendTitle(p, "§a4", "", 10);
                                    p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                                }

                            }

                            if(timer == 3){

                                for(UUID uuid : UHC.getInstance().playerInGame){

                                    Player p = Bukkit.getPlayer(uuid);
                                    Title.sendTitle(p, "§63", "", 10);
                                    p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                                }

                            }

                            if(timer == 2){

                                for(UUID uuid : UHC.getInstance().playerInGame){

                                    Player p = Bukkit.getPlayer(uuid);
                                    Title.sendTitle(p, "§e2", "", 10);
                                    p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                                }

                            }

                            if(timer == 1){

                                for(UUID uuid : UHC.getInstance().playerInGame){

                                    Player p = Bukkit.getPlayer(uuid);
                                    Title.sendTitle(p, "§c1", "", 10);
                                    p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1, 1);

                                }

                            }

                            if(timer == 0){

                                for(UUID uuid : UHC.getInstance().playerInGame){

                                    Player p = Bukkit.getPlayer(uuid);
                                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

                                    Game.start();

                                }

                                Bukkit.getScheduler().cancelTask(task);

                            }

                        }

                    }, 20, 20);

                }

            }

            player.setGameMode(GameMode.ADVENTURE);

            player.teleport(new Location(Bukkit.getWorlds().get(0), 0, 202, 0));

            Title.sendTitle(player, "§6§lUHC", "§bBienvenue en UHC !", 10);
            Actionbar.sendActionbar(player, "§e(§f" + Bukkit.getServer().getOnlinePlayers().size() + "§e/§f" + Bukkit.getMaxPlayers() + "§e) §6" + player.getName() + " §ea rejoint la partie !");

        } else {

            player.setGameMode(GameMode.SPECTATOR);

        }

        new BukkitRunnable(){

            @Override
            public void run(){

                PacketPlayOutPlayerListHeaderFooter p = new PacketPlayOutPlayerListHeaderFooter();
                Object header = new ChatComponentText("§6§lTheHaraMC\n \n§r§eVous jouez en UHC !\n");
                Object footer = new ChatComponentText("\n§eJoueurs: §f" + Bukkit.getServer().getOnlinePlayers().size() + "\n \n§6play.ipserveur.fr");

                try{

                    Field a = p.getClass().getDeclaredField("a");
                    a.setAccessible(true);

                    Field b = p.getClass().getDeclaredField("b");
                    b.setAccessible(true);

                    a.set(p, header);
                    b.set(p, footer);

                    if(Bukkit.getOnlinePlayers().size() == 0){ return; }
                    for(Player player : Bukkit.getOnlinePlayers()){

                        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(p);

                    }

                } catch(NoSuchFieldException | IllegalAccessException e){

                    e.printStackTrace();

                }

            }

        }.runTaskTimer(UHC.getInstance(), 0, 20);

    }

    public void setLevel(int timer){

        for(UUID uuid : UHC.getInstance().playerInGame){

            Player p = Bukkit.getPlayer(uuid);

            p.setLevel(timer);

        }

    }

}
