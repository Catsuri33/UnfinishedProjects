package fr.catsuri33.uhc;

import fr.catsuri33.uhc.commands.Host;
import fr.catsuri33.uhc.commands.Reload;
import fr.catsuri33.uhc.game.Gamerules;
import fr.catsuri33.uhc.game.Gamestates;
import fr.catsuri33.uhc.listeners.*;
import fr.catsuri33.uhc.listeners.legacypvp.armors.ArmorModule;
import fr.catsuri33.uhc.listeners.legacypvp.cooldown.CooldownModule;
import fr.catsuri33.uhc.tool.Cuboid;
import fr.catsuri33.uhc.tool.ScoreboardSign;
import fr.catsuri33.uhc.ui.HostUI;
import fr.catsuri33.uhc.ui.SlotsUI;
import fr.catsuri33.uhc.ui.TeamUI;
import net.minecraft.server.v1_14_R1.BiomeBase;
import net.minecraft.server.v1_14_R1.ChatComponentText;
import net.minecraft.server.v1_14_R1.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;

public class UHC extends JavaPlugin {

    private static UHC instance;

    private boolean tablistChanged;
    private HashMap<UUID, PermissionAttachment> playerPermissions = new HashMap<>();

    public ArrayList<UUID> playerInGame = new ArrayList<>();
    public ArrayList<UUID> playerHost = new ArrayList<>();
    public Map<Player, ScoreboardSign> boards = new HashMap<>();

    public void onEnable(){

        instance = this;

        getListeners();
        getCommands();
        loadConfig();

        setup();

        super.onEnable();

    }

    public void onDisable(){

        for(Player players : Bukkit.getOnlinePlayers()){

            players.kickPlayer("§b[§6UHC§b]\n §cRedémarrage du serveur !");

        }

        super.onDisable();

    }

    public void onLoad(){

        System.out.println("[ UHC ] Suppression du monde en cours...");

        Bukkit.unloadWorld("world", false);
        deleteworld(new File("world"));

        Bukkit.unloadWorld("world_nether", false);
        deleteworld(new File("world_nether"));

        Bukkit.unloadWorld("world_the_end", false);
        deleteworld(new File("world_the_end"));

        replaceBiomes();

    }

    public static UHC getInstance() {

        return instance;

    }

    private void loadConfig(){

        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

    }

    private void getCommands(){

        getCommand("reload").setExecutor(new Reload());
        getCommand("rl").setExecutor(new Reload());
        getCommand("host").setExecutor(new Host());

    }

    private void getListeners(){

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new ArmorModule(), this);
        pm.registerEvents(new CooldownModule(), this);

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerDrop(), this);
        pm.registerEvents(new BlockPlace(), this);
        pm.registerEvents(new BlockBreak(), this);
        pm.registerEvents(new EntityTakeDamage(), this);
        pm.registerEvents(new InventoryClick(), this);
        pm.registerEvents(new PlayerInteract(), this);

    }

    private void setup(){

        Bukkit.getWorlds().forEach(this::setupWorld);
        setupSlots();
        setupWorldborder();
        setupSpawn();
        setupTabList();
        initializeGuis();

        Gamestates.setState(Gamestates.LOBBY);

    }

    public void setupPermissions(Player player){

        PermissionAttachment attachment = player.addAttachment(this);
        this.playerPermissions.put(player.getUniqueId(), attachment);
        permissionSetter(player.getUniqueId());

    }

    private void permissionSetter(UUID uuid){

        PermissionAttachment attachment = this.playerPermissions.get(uuid);

        for(String groups : this.getConfig().getConfigurationSection("groups").getKeys(false)){

            for(String permissions : this.getConfig().getStringList("groups." + groups + ".permissions")){

                attachment.setPermission(permissions, true);

            }

        }

    }

    private void deleteworld(File path){

        if(path.exists()){

            File files[] = path.listFiles();

            for(int i = 0; i < files.length; i++){

                if(files[i].isDirectory()){

                    deleteworld(files[i]);

                } else {

                    files[i].delete();

                }

            }

        }

    }

    private void setupSlots(){

        try {

            this.changeSlots(24);

        } catch(ReflectiveOperationException e) {

            e.printStackTrace();

        }

    }

    @SuppressWarnings("deprecation")
    private void setupWorld(World w){

        Arrays.stream(Gamerules.values()).forEach(g -> w.setGameRuleValue(g.getName(), "false"));
        w.setTime(5000);
        w.setPVP(false);
        w.setSpawnLocation(new Location(Bukkit.getWorlds().get(0), 0, 202, 0));

    }

    public static void replaceBiomes() {
        Field biomesField = null;

        try {
            biomesField = Biome.class.getDeclaredField("biomes");
            biomesField.setAccessible(true);
            if (biomesField.get((Object)null) instanceof Biome[]) {

                Biome[] biomes = ((Biome[])biomesField.get((Object)null));
                biomes[Biome.OCEAN.hashCode()] = Biome.DARK_FOREST;
                biomes[Biome.COLD_OCEAN.hashCode()] = Biome.DARK_FOREST;
                biomes[Biome.DEEP_COLD_OCEAN.hashCode()] = Biome.PLAINS;
                biomes[Biome.DEEP_OCEAN.hashCode()] = Biome.PLAINS;
                biomes[Biome.DEEP_FROZEN_OCEAN.hashCode()] = Biome.DARK_FOREST;
                biomes[Biome.DEEP_FROZEN_OCEAN.hashCode()] = Biome.DARK_FOREST_HILLS;
                biomes[Biome.DEEP_LUKEWARM_OCEAN.hashCode()] = Biome.PLAINS;
                biomes[Biome.DEEP_WARM_OCEAN.hashCode()] = Biome.PLAINS;

            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private void setupWorldborder(){

        WorldBorder wb = Bukkit.getWorlds().get(0).getWorldBorder();
        wb.setCenter(0, 0);
        wb.setSize(3000);
        wb.setDamageAmount(0.5);
        wb.setWarningDistance(0);

    }

    @SuppressWarnings("deprecation")
    private void setupSpawn(){

        Cuboid spawn = new Cuboid(new Location(Bukkit.getWorlds().get(0), 20, 200, 20), new Location(Bukkit.getWorlds().get(0), -20, 200, -20));
        spawn.forEach(b -> {

            b.setType(Material.WHITE_STAINED_GLASS);

        });

        spawn = new Cuboid(new Location(Bukkit.getWorlds().get(0), 20, 201, 20), new Location(Bukkit.getWorlds().get(0), -20, 203, -20));
        spawn.forEach(b -> {

            b.setType(Material.LIGHT_GRAY_STAINED_GLASS_PANE);

        });

        spawn = new Cuboid(new Location(Bukkit.getWorlds().get(0), 19, 201, 19), new Location(Bukkit.getWorlds().get(0), -19, 203, -19));
        spawn.forEach(b -> {

            b.setType(Material.AIR);

        });

        Bukkit.getWorlds().get(0).setSpawnLocation(0, 202, 0);
        Bukkit.setSpawnRadius(0);

    }

    public void changeSlots(int slots) throws ReflectiveOperationException {
        Method serverGetHandle = getServer().getClass().getDeclaredMethod("getHandle");

        Object playerList = serverGetHandle.invoke(getServer());
        Field maxPlayersField = playerList.getClass().getSuperclass().getDeclaredField("maxPlayers");

        maxPlayersField.setAccessible(true);
        maxPlayersField.set(playerList, slots);
    }

    public void updateServerProperties() {
        Properties properties = new Properties();
        File propertiesFile = new File("server.properties");

        try {
            try (InputStream is = new FileInputStream(propertiesFile)) {
                properties.load(is);
            }

            String maxPlayers = Integer.toString(getServer().getMaxPlayers());

            if (properties.getProperty("max-players").equals(maxPlayers)) {
                return;
            }

            getLogger().info("Saving max players to server.properties...");
            properties.setProperty("max-players", maxPlayers);

            try (OutputStream os = new FileOutputStream(propertiesFile)) {
                properties.store(os, "Minecraft server properties");
            }
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "An error occurred while updating the server properties", e);
        }
    }

    private void initializeGuis(){

        HostUI.initializeHostUI();
        SlotsUI.initializeSlotsUI();
        TeamUI.initializeTeamUI();

    }

    private void setupTabList(){

        new BukkitRunnable(){

            @Override
            public void run(){

                PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
                Object header = new ChatComponentText("\n §b[§6UHC§b]\n §7§m                    »§r     §7§m«                    \n");
                Object footer = new ChatComponentText("\n §7§m                                               \n");

                try{

                    Field headerField = packet.getClass().getDeclaredField("header");
                    headerField.setAccessible(true);

                    Field footerField = packet.getClass().getDeclaredField("footer");
                    footerField.setAccessible(true);

                    headerField.set(packet, header);
                    footerField.set(packet, footer);

                    if(Bukkit.getOnlinePlayers().size() == 0) return;

                    for(Player player : Bukkit.getOnlinePlayers()){

                        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);

                    }

                } catch(NoSuchFieldException | IllegalAccessException e){

                    e.printStackTrace();

                }

            }

        }.runTaskTimer(UHC.getInstance(), 0, 20);

    }


}
