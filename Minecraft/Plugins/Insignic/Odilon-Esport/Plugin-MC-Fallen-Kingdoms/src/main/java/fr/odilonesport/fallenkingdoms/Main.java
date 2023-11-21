package fr.odilonesport.fallenkingdoms;

import fr.odilonesport.fallenkingdoms.commands.admin.SetAreaCommand;
import fr.odilonesport.fallenkingdoms.commands.admin.StartCommand;
import fr.odilonesport.fallenkingdoms.commands.admin.TeamCommand;
import fr.odilonesport.fallenkingdoms.game.scoreboards.Scoreboards;
import fr.odilonesport.fallenkingdoms.listeners.item.InventoryClick;
import fr.odilonesport.fallenkingdoms.listeners.player.*;
import fr.odilonesport.fallenkingdoms.utils.GameStates;
import fr.odilonesport.fallenkingdoms.utils.Gamerules;
import fr.odilonesport.fallenkingdoms.utils.RegionManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {

    private static Main INSTANCE;
    public String prefix;
    public Map<String, RegionManager> basesRegions = new HashMap<>();
    public Map<String, RegionManager> chestsRegions = new HashMap<>();
    public Scoreboards scoreboards = new Scoreboards();

    @Override
    public void onEnable() {

        INSTANCE = this;
        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("plugin.prefix")) + " ";

        loadListeners();
        loadCommands();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        GameStates.setState(GameStates.WAITING);

        Bukkit.getWorlds().get(0).setTime(0);
        Gamerules.setGamerulesLobby();

        // Bases
        if(Main.getInstance().getConfig().getConfigurationSection("game.teams") != null){

            Object[] teamFields = Main.getInstance().getConfig().getConfigurationSection("game.teams").getKeys(false).toArray();

            for(Object key : teamFields){

                Integer radiusBase = getConfig().getInt("game.teams." + key + ".base.radius");
                Double xBase = getConfig().getDouble("game.teams." + key + ".base.x");
                Double yBase = getConfig().getDouble("game.teams." + key + ".base.y");
                Double zBase = getConfig().getDouble("game.teams." + key + ".base.z");

                RegionManager baseRegion = new RegionManager(new Location(Bukkit.getWorlds().get(0), xBase + radiusBase, yBase, zBase - radiusBase - 0.5), new Location(Bukkit.getWorlds().get(0), xBase - radiusBase - 0.5, yBase, zBase + radiusBase));
                basesRegions.put(key.toString(), baseRegion);

            }

        }

        if(!Bukkit.getOnlinePlayers().isEmpty()){

            for(Player player : Bukkit.getOnlinePlayers()){

                scoreboards.createLobbyBoard(player);

            }

        }

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    /**
     * Charger les événements du plugin.
     */
    private void loadListeners() {

        PluginManager pm = Bukkit.getPluginManager();

        // Player
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerPlace(), this);
        pm.registerEvents(new PlayerBreak(), this);
        pm.registerEvents(new PlayerDrop(), this);
        pm.registerEvents(new PlayerMove(), this);
        pm.registerEvents(new PlayerPickup(), this);
        pm.registerEvents(new PlayerTookDamage(), this);
        pm.registerEvents(new PlayerInteract(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerDeath(), this);
        pm.registerEvents(new PlayerEnterPortal(), this);

        // Gui
        pm.registerEvents(new InventoryClick(), this);

    }

    /**
     * Charger les commandes du plugin.
     */
    private void loadCommands() {

        getCommand("setarea").setExecutor(new SetAreaCommand());
        getCommand("start").setExecutor(new StartCommand());
        getCommand("team").setExecutor(new TeamCommand());

    }

    /**
     * La fonction pour obtenir l'instance de la classe Main.
     *
     * @return L'instance de la classe Main.java
     */
    public static Main getInstance() {

        return INSTANCE;

    }

}
