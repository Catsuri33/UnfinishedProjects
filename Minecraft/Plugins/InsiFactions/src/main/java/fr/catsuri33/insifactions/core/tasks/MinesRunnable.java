package fr.catsuri33.insifactions.core.tasks;

import fr.catsuri33.insifactions.InsiFactions;
import fr.catsuri33.insifactions.core.Mines;
import fr.catsuri33.insifactions.utils.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class MinesRunnable extends BukkitRunnable {

    //public static int timer = 0;

    @Override
    public void run() {

        for(Mines mines : InsiFactions.getMines()){

            //timer = mines.removeOneSecondTimer();
            mines.removeOneSecondTimer();

            if(mines.getTimer() == 36000) {

                for (Player players : Bukkit.getOnlinePlayers()) {

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e10 heures §a!");

                }

            }

            if(mines.getTimer() == 32400) {

                for (Player players : Bukkit.getOnlinePlayers()) {

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e9 heures §a!");

                }

            }

            if(mines.getTimer() == 28800) {

                for (Player players : Bukkit.getOnlinePlayers()) {

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e8 heures §a!");

                }

            }

            if(mines.getTimer() == 25200) {

                for (Player players : Bukkit.getOnlinePlayers()) {

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e7 heures §a!");

                }

            }

            if(mines.getTimer() == 21600) {

                for (Player players : Bukkit.getOnlinePlayers()) {

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e6 heures §a!");

                }

            }

            if(mines.getTimer() == 18000){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e5 heures §a!");

                }

            }

            if(mines.getTimer() == 14400){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e4 heures §a!");

                }

            }

            if(mines.getTimer() == 10800){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e3 heures §a!");

                }

            }

            if(mines.getTimer() == 7200){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e2 heures §a!");

                }

            }

            if(mines.getTimer() == 3600){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e1 heure §a!");

                }

            }

            if(mines.getTimer() == 1800){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e30 minutes §a!");

                }

            }

            if(mines.getTimer() == 600){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e10 minutes §a!");

                }

            }

            if(mines.getTimer() == 60){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e1 minute §a!");

                }

            }

            if(mines.getTimer() == 30){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e30 secondes §a!");

                }

            }

            if(mines.getTimer() == 15){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e15 secondes §a!");

                }

            }

            if(mines.getTimer() == 10){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e10 secondes §a!");

                }

            }

            if(mines.getTimer() == 5){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e5 secondes §a!");

                }

            }

            if(mines.getTimer() == 4){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e4 secondes §a!");

                }

            }

            if(mines.getTimer() == 3){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e3 secondes §a!");

                }

            }

            if(mines.getTimer() == 2){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e2 secondes §a!");

                }

            }

            if(mines.getTimer() == 1){

                for(Player players : Bukkit.getOnlinePlayers()){

                    players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §asera reset dans §e1 seconde §a!");

                }

            }

            if(mines.getTimer() <= 0){

                for(Player players : Bukkit.getOnlinePlayers()){

                    if(mines.getTimer() <= 0){

                        final World world = players.getWorld();
                        Cuboid cuboid = new Cuboid(new Location(world, mines.getX1(), mines.getY1(), mines.getZ1()), new Location(world, mines.getX2(), mines.getY2(), mines.getZ2()));

                        for(Block blocks : cuboid){

                            Random random = new Random();
                            int randomNumber;

                            randomNumber = random.nextInt(101);

                            if(randomNumber >= 0 && randomNumber <= mines.getCoalAmount()){

                                blocks.setType(Material.COAL_ORE);

                            }

                            if(randomNumber > mines.getCoalAmount() && randomNumber <= mines.getCoalAmount() + mines.getIronAmount()){

                                blocks.setType(Material.IRON_ORE);

                            }

                            if(randomNumber > mines.getCoalAmount() + mines.getIronAmount() && randomNumber <= mines.getCoalAmount() + mines.getIronAmount() + mines.getGoldAmount()){

                                blocks.setType(Material.GOLD_ORE);

                            }

                            if(randomNumber > mines.getCoalAmount() + mines.getIronAmount() + mines.getGoldAmount() && randomNumber <= mines.getCoalAmount() + mines.getIronAmount() + mines.getGoldAmount() + mines.getRedstoneAmount()){

                                blocks.setType(Material.REDSTONE_ORE);

                            }

                            if(randomNumber > mines.getCoalAmount() + mines.getIronAmount() + mines.getGoldAmount() + mines.getRedstoneAmount() && randomNumber <= mines.getCoalAmount() + mines.getIronAmount() + mines.getGoldAmount() + mines.getRedstoneAmount() + mines.getLapizAmount()){

                                blocks.setType(Material.LAPIS_ORE);

                            }

                            if(randomNumber > mines.getCoalAmount() + mines.getIronAmount() + mines.getGoldAmount() + mines.getRedstoneAmount() + mines.getLapizAmount() && randomNumber <= mines.getCoalAmount() + mines.getIronAmount() + mines.getGoldAmount() + mines.getRedstoneAmount() + mines.getLapizAmount() + mines.getEmeraldAmount()){

                                blocks.setType(Material.EMERALD_ORE);

                            }

                            if(randomNumber > mines.getCoalAmount() + mines.getIronAmount() + mines.getGoldAmount() + mines.getRedstoneAmount() + mines.getLapizAmount() + mines.getEmeraldAmount() && randomNumber <= mines.getCoalAmount() + mines.getIronAmount() + mines.getGoldAmount() + mines.getRedstoneAmount() + mines.getLapizAmount() + mines.getEmeraldAmount() + mines.getDiamondAmount()){

                                blocks.setType(Material.DIAMOND_ORE);

                            }

                            if(randomNumber > mines.getCoalAmount() + mines.getIronAmount() + mines.getGoldAmount() + mines.getRedstoneAmount() + mines.getLapizAmount() + mines.getEmeraldAmount() + mines.getDiamondAmount() && randomNumber <= 100){

                                blocks.setType(Material.STONE);

                            }

                        }

                        ConfigurationSection minesSection = InsiFactions.instance.configManager.getMinesConfiguration().getConfigurationSection("mines");
                        for(String minesName : minesSection.getKeys(false)){

                            final int timerHours = InsiFactions.instance.configManager.getMinesConfiguration().getInt("mines." + minesName  + ".reset-time.hours") * 3600;
                            final int timerMinutes = InsiFactions.instance.configManager.getMinesConfiguration().getInt("mines." + minesName  + ".reset-time.minutes") * 60;
                            final int timerSeconds = InsiFactions.instance.configManager.getMinesConfiguration().getInt("mines." + minesName  + ".reset-time.seconds");

                            if(mines.getTimer() <= 0){

                                if(mines.getName().equalsIgnoreCase(minesName)){

                                    mines.setTimer(timerHours + timerMinutes + timerSeconds);

                                }

                            }

                        }

                        players.sendMessage(InsiFactions.instance.prefix + "§aLa mine §e" + mines.getName() + " §avient d'être reset !");

                    }

                }

            }

        }

    }

}

