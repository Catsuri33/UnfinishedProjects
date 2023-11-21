package fr.catsuri33.sc.core.tasks;

import fr.catsuri33.sc.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class TimerMoneyRunnable extends BukkitRunnable {

    public static HashMap<Player, Long> playersJoin = new HashMap<>();

    @Override
    public void run() {

        for(Player players : Bukkit.getOnlinePlayers()) {

            ConfigurationSection worldsSection = Main.getInstance().getConfig().getConfigurationSection("economy.timers");

            if(!playersJoin.containsKey(players)) return;

            for(String worldName : worldsSection.getKeys(false)){

                if(players.getWorld().getName().equals(worldName)){

                    long minutesToMillis = Long.valueOf(Main.getInstance().getConfig().getInt("economy.timers." + worldName + ".minutes") * 60000);
                    if((System.currentTimeMillis() - playersJoin.get(players)) >= minutesToMillis){

                        Main.getInstance().configManager.getPlayersConfig().set("players." + players.getUniqueId() + ".money", Main.getInstance().configManager.getPlayersConfig().getInt("players." + players.getUniqueId() + ".money") + Main.getInstance().getConfig().getInt("economy.timers." + worldName + ".money"));
                        Main.getInstance().configManager.savePlayersConfig();
                        Main.getInstance().configManager.reloadPlayerConfig();

                        playersJoin.remove(players);
                        playersJoin.put(players, System.currentTimeMillis());

                        players.sendMessage(Main.prefix + " §aVous avez reçu §6" + Main.getInstance().getConfig().getInt("economy.timers." + worldName + ".money") + Main.getInstance().getConfig().getString("economy.currency.display") + " §apour votre activité.");

                    }

                }

            }

        }

    }

}
