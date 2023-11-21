/*                              */
/*       TheHaraMC-UHC          */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 12/08/2019       */
/*    Updated: 12/08/2019       */
/*    Name: Main                */
/*                              */

package fr.catsuri33.theharamc;

import fr.catsuri33.theharamc.game.Gamestates;
import fr.catsuri33.theharamc.listeners.*;
import fr.catsuri33.theharamc.tools.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WorldBorder;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.UUID;

public class UHC extends JavaPlugin {

    private static UHC instance;

    public ArrayList<UUID> playerInGame = new ArrayList<>();

    public void onEnable(){

        instance = this;

        getListeners();
        getCommands();
        loadConfig();

        try {

            this.changeSlots(UHC.getInstance().getConfig().getInt("player-max"));

        } catch(ReflectiveOperationException e) {

            e.printStackTrace();

        }

        Bukkit.getWorlds().get(0).setPVP(false);

        Gamestates.setState(Gamestates.LOBBY);

        WorldBorder wb = Bukkit.getWorlds().get(0).getWorldBorder();
        wb.setCenter(0, 0);
        wb.setSize(1000);

        setupSpawn();

    }

    public void onDisable(){



    }

    public static UHC getInstance() {

        return instance;

    }

    private void loadConfig(){

        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

    }

    private void getCommands(){



    }

    private void getListeners(){

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new Break(), this);
        pm.registerEvents(new Place(), this);
        pm.registerEvents(new Pvp(), this);

    }

    @SuppressWarnings("deprecation")
    private void setupSpawn(){

        Cuboid spawn = new Cuboid(new Location(Bukkit.getWorlds().get(0), 20, 200, 20), new Location(Bukkit.getWorlds().get(0), -20, 200, -20));
        spawn.forEach(b -> {

            b.setType(Material.STAINED_GLASS);
            b.setData((byte) 0);

        });

        spawn = new Cuboid(new Location(Bukkit.getWorlds().get(0), 20, 201, 20), new Location(Bukkit.getWorlds().get(0), -20, 203, -20));
        spawn.forEach(b -> {

            b.setType(Material.STAINED_GLASS_PANE);
            b.setData((byte) 7);

        });

        spawn = new Cuboid(new Location(Bukkit.getWorlds().get(0), 19, 201, 19), new Location(Bukkit.getWorlds().get(0), -19, 203, -19));
        spawn.forEach(b -> {

            b.setType(Material.AIR);

        });

        Bukkit.getWorlds().get(0).setSpawnLocation(0, 202, 0);
        Bukkit.setSpawnRadius(0);

    }

    private void changeSlots(int slots) throws ReflectiveOperationException {
        Method serverGetHandle = getServer().getClass().getDeclaredMethod("getHandle");

        Object playerList = serverGetHandle.invoke(getServer());
        Field maxPlayersField = playerList.getClass().getSuperclass().getDeclaredField("maxPlayers");

        maxPlayersField.setAccessible(true);
        maxPlayersField.set(playerList, slots);
    }

}
