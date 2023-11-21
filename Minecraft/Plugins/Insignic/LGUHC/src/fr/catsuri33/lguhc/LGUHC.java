package fr.catsuri33.lguhc;

import fr.catsuri33.lguhc.commands.Broadcast;
import fr.catsuri33.lguhc.commands.GameEditor;
import fr.catsuri33.lguhc.game.Gamestates;
import fr.catsuri33.lguhc.listeners.*;
import fr.catsuri33.lguhc.tools.Cuboid;
import fr.catsuri33.lguhc.tools.ScoreboardLib;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * LGUHC
 * Create the 10/07/2019
 *
 * @author Catsuri33
 * @version 1.0.0
 */

public class LGUHC extends JavaPlugin {

    private static LGUHC instance;

    @Override
    public void onEnable() {

        System.out.println("[ LGUHC ] Enabling the plugin...");

        instance = this;

        saveDefaultConfig();
        registerEvents();
        registerCommands();

        setupSpawn();

        Gamestates.setState(Gamestates.LOBBY);

        super.onEnable();
    }

    @Override
    public void onDisable() {

        System.out.println("[ LGUHC ] Disabling the plugin...");

        super.onDisable();
    }

    public static LGUHC getInstance(){
        return instance;
    }

    private void registerEvents(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerMove(), this);
        pm.registerEvents(new PlaceBlock(), this);
        pm.registerEvents(new BreakBlock(), this);

    }

    private void registerCommands(){

        getCommand("broadcast").setExecutor(new Broadcast());
        getCommand("gameeditor").setExecutor(new GameEditor());

    }

    public void setupSpawn(){

        Cuboid spawn = new Cuboid(new Location(Bukkit.getWorlds().get(0), 20, 200, 20), new Location(Bukkit.getWorlds().get(0), -20, 200, -20));
        spawn.forEach(b -> {

            b.setType(Material.WHITE_STAINED_GLASS);

        });

        spawn = new Cuboid(new Location(Bukkit.getWorlds().get(0), 20, 201, 20), new Location(Bukkit.getWorlds().get(0), -20, 203, -20));
        spawn.forEach(b -> {

            b.setType(Material.GRAY_STAINED_GLASS_PANE);

        });

        spawn = new Cuboid(new Location(Bukkit.getWorlds().get(0), 19, 201, 19), new Location(Bukkit.getWorlds().get(0), -19, 203, -19));
        spawn.forEach(b -> {

            b.setType(Material.AIR);

        });

        Bukkit.getWorlds().get(0).setSpawnLocation(0, 202, 0);

    }

    public void sendScoreboard(Player player){

        if(LGUHC.getInstance().getConfig().getString("scoreboard.ip") == null){

            ScoreboardLib scoreboard = new ScoreboardLib("§c§lLG§6UHC");

            scoreboard.add("   ", 7);
            scoreboard.add("§cEpisode: ", 6);
            scoreboard.add("§cPlayers: §f" + Bukkit.getOnlinePlayers().size(), 5);
            scoreboard.add("  ", 4);
            scoreboard.add("§cTime: §f", 3);
            scoreboard.add("§cBorder: §f", 2);
            scoreboard.add(" ", 1);
            scoreboard.add("§6play.myserver.com", 0);

            scoreboard.build();

            scoreboard.send(player);

        } else {

            ScoreboardLib scoreboard = new ScoreboardLib("§c§lLG§6UHC");

            scoreboard.add("   ", 7);
            scoreboard.add("§cEpisode: ", 6);
            scoreboard.add("§cPlayers: §f" + Bukkit.getOnlinePlayers().size(), 5);
            scoreboard.add("  ", 4);
            scoreboard.add("§cTime: §f", 3);
            scoreboard.add("§cBorder: §f", 2);
            scoreboard.add(" ", 1);
            scoreboard.add(LGUHC.getInstance().getConfig().getString("scoreboard.ip"), 0);

            scoreboard.build();

            scoreboard.send(player);

        }

    }

}
