package com.insignic.uhchost.game.lobby;

import com.insignic.uhchost.UHCHost;
import com.insignic.uhchost.game.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class FloorRunnable extends BukkitRunnable {

    public static boolean start = false;

    @Override
    public void run() {

        if(Bukkit.getOnlinePlayers().size() < 1 && (GameStates.isState(GameStates.LOBBY))) {

            start = false;

            this.cancel();
            return;

        }

        if(GameStates.isState(GameStates.LOBBY)){

            for(Player players : Bukkit.getOnlinePlayers()){

                players.setFoodLevel(20);

                int blockX = players.getLocation().getBlock().getX();
                int blockY = players.getLocation().getBlock().getY() - 1;
                int blockZ = players.getLocation().getBlock().getZ();
                Block block = Bukkit.getWorld("world").getBlockAt(new Location(Bukkit.getWorld("world"), blockX, blockY, blockZ));

                Random random = new Random();
                int randomNumber;
                randomNumber = random.nextInt(101);

                if(!block.getType().isAir()){

                    if(!block.getType().equals(Material.WHITE_STAINED_GLASS_PANE)){

                        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("All")){

                            if(randomNumber >= 0 && randomNumber <= 6){

                                block.setType(Material.WHITE_STAINED_GLASS);

                            }

                            if(randomNumber > 6 && randomNumber <= 12){

                                block.setType(Material.ORANGE_STAINED_GLASS);

                            }

                            if(randomNumber > 12 && randomNumber <= 18){

                                block.setType(Material.MAGENTA_STAINED_GLASS);

                            }

                            if(randomNumber > 18 && randomNumber <= 24){

                                block.setType(Material.LIGHT_BLUE_STAINED_GLASS);

                            }

                            if(randomNumber > 24 && randomNumber <= 30){

                                block.setType(Material.YELLOW_STAINED_GLASS);

                            }

                            if(randomNumber > 30 && randomNumber <= 36){

                                block.setType(Material.LIME_STAINED_GLASS);

                            }

                            if(randomNumber > 36 && randomNumber <= 42){

                                block.setType(Material.PINK_STAINED_GLASS);

                            }

                            if(randomNumber > 42 && randomNumber <= 48){

                                block.setType(Material.GRAY_STAINED_GLASS);

                            }

                            if(randomNumber > 48 && randomNumber <= 54){

                                block.setType(Material.LIGHT_GRAY_STAINED_GLASS);

                            }

                            if(randomNumber > 54 && randomNumber <= 60){

                                block.setType(Material.CYAN_STAINED_GLASS);

                            }

                            if(randomNumber > 60 && randomNumber <= 66){

                                block.setType(Material.PURPLE_STAINED_GLASS);

                            }

                            if(randomNumber > 66 && randomNumber <= 72){

                                block.setType(Material.BLUE_STAINED_GLASS);

                            }

                            if(randomNumber > 72 && randomNumber <= 78){

                                block.setType(Material.BROWN_STAINED_GLASS);

                            }

                            if(randomNumber > 78 && randomNumber <= 84){

                                block.setType(Material.GREEN_STAINED_GLASS);

                            }

                            if(randomNumber > 84 && randomNumber <= 90){

                                block.setType(Material.RED_STAINED_GLASS);

                            }

                            if(randomNumber > 90 && randomNumber <= 96){

                                block.setType(Material.BLACK_STAINED_GLASS);

                            }

                        }

                        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("OnlyTeam")){



                        }

                        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("OnlyDefault")){

                            if(randomNumber >= 0 && randomNumber <= 6){

                                block.setType(Material.WHITE_STAINED_GLASS);

                            }

                            if(randomNumber > 6 && randomNumber <= 12){

                                block.setType(Material.ORANGE_STAINED_GLASS);

                            }

                            if(randomNumber > 12 && randomNumber <= 18){

                                block.setType(Material.MAGENTA_STAINED_GLASS);

                            }

                            if(randomNumber > 18 && randomNumber <= 24){

                                block.setType(Material.LIGHT_BLUE_STAINED_GLASS);

                            }

                            if(randomNumber > 24 && randomNumber <= 30){

                                block.setType(Material.YELLOW_STAINED_GLASS);

                            }

                            if(randomNumber > 30 && randomNumber <= 36){

                                block.setType(Material.LIME_STAINED_GLASS);

                            }

                            if(randomNumber > 36 && randomNumber <= 42){

                                block.setType(Material.PINK_STAINED_GLASS);

                            }

                            if(randomNumber > 42 && randomNumber <= 48){

                                block.setType(Material.GRAY_STAINED_GLASS);

                            }

                            if(randomNumber > 48 && randomNumber <= 54){

                                block.setType(Material.LIGHT_GRAY_STAINED_GLASS);

                            }

                            if(randomNumber > 54 && randomNumber <= 60){

                                block.setType(Material.CYAN_STAINED_GLASS);

                            }

                            if(randomNumber > 60 && randomNumber <= 66){

                                block.setType(Material.PURPLE_STAINED_GLASS);

                            }

                            if(randomNumber > 66 && randomNumber <= 72){

                                block.setType(Material.BLUE_STAINED_GLASS);

                            }

                            if(randomNumber > 72 && randomNumber <= 78){

                                block.setType(Material.BROWN_STAINED_GLASS);

                            }

                            if(randomNumber > 78 && randomNumber <= 84){

                                block.setType(Material.GREEN_STAINED_GLASS);

                            }

                            if(randomNumber > 84 && randomNumber <= 90){

                                block.setType(Material.RED_STAINED_GLASS);

                            }

                            if(randomNumber > 90 && randomNumber <= 96){

                                block.setType(Material.BLACK_STAINED_GLASS);

                            }

                        }

                        if(UHCHost.configManager.getSettingsConfiguration().getString("settings.lobby-floor").equals("Deactivated")){

                            return;

                        }

                    }

                }

            }

        }

    }

}
