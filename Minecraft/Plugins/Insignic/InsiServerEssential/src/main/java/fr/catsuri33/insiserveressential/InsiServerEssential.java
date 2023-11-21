package fr.catsuri33.insiserveressential;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import fr.catsuri33.insiserveressential.commands.*;
import fr.catsuri33.insiserveressential.config.ConfigManager;
import fr.catsuri33.insiserveressential.listeners.*;
import fr.catsuri33.insiserveressential.utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class InsiServerEssential extends JavaPlugin {

    public static InsiServerEssential instance;
    public ArrayList<UUID> authLocked;
    public ConfigManager configManager;

    @Override
    public void onEnable() {

        instance = this;

        registerListeners();
        registerCommands();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        loadConfigManager();

        new UpdateChecker(this, 75216).getLatestVersion(version -> {

            if(this.getDescription().getVersion().equalsIgnoreCase(version)){

                log(ChatColor.GREEN + "The plugin is up to date !");

            } else {

                log(ChatColor.YELLOW + "The plugin has an update ! Please download it at: https://www.spigotmc.org/resources/insiserveressential.75216/ !");

            }

        });

        authLocked = new ArrayList<>();

        log("Plugin Enabled ! Created by Catsuri33 !");

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static InsiServerEssential getInstance() {

        return instance;

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerMove(), this);
        pm.registerEvents(new BlockBreak(), this);
        pm.registerEvents(new BlockPlace(), this);

    }

    public void registerCommands(){

        getCommand("gm0").setExecutor(new GameModes());
        getCommand("gm1").setExecutor(new GameModes());
        getCommand("gm2").setExecutor(new GameModes());
        getCommand("gm3").setExecutor(new GameModes());
        getCommand("fly").setExecutor(new Fly());
        getCommand("ptime").setExecutor(new PTime());
        //getCommand("repair").setExecutor(new Repair());
        getCommand("broadcast").setExecutor(new Broadcast());
        getCommand("setslots").setExecutor(new SetSlots());
        getCommand("sethome").setExecutor(new Home());
        getCommand("home").setExecutor(new Home());
        getCommand("delhome").setExecutor(new Home());
        getCommand("craft").setExecutor(new Gui());
        //getCommand("enchant").setExecutor(new Gui());
        getCommand("ec").setExecutor(new Gui());
        getCommand("reloadconfiguration").setExecutor(new ReloadConfiguration());
        //getCommand("rank").setExecutor(new RanksCommands());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        //getCommand("speed").setExecutor(new SpeedCommand());
        getCommand("kick").setExecutor(new KickCommands());
        getCommand("kickall").setExecutor(new KickCommands());
        getCommand("ban").setExecutor(new BanCommand());
        getCommand("tempban").setExecutor(new BanCommand());

    }

    public void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ InsiServerEssential ] " + message);

    }

    public boolean playerInputCode(Player p, int code){

        String secretKey = InsiServerEssential.getInstance().configManager.get2FACodes().getString("authcodes." + p.getUniqueId());

        GoogleAuthenticator gauth = new GoogleAuthenticator();
        boolean codeIsValid = gauth.authorize(secretKey, code);

        if(codeIsValid){

            InsiServerEssential.getInstance().authLocked.remove(p.getUniqueId());
            return codeIsValid;

        }

        return codeIsValid;

    }

    public void loadConfigManager(){

        configManager = new ConfigManager();
        configManager.setupConfigurations();

        configManager.get2FACodes().addDefault("authcodes", "");
        configManager.getHomes().addDefault("homes", "");
        configManager.getRanks().addDefault("ranks", "");
        configManager.getRanks().set("ranks.admin.name", "Administrator");
        configManager.getRanks().set("ranks.admin.prefix", "&c[ADMIN]");
        configManager.getRanks().set("ranks.admin.suffix", "");

        configManager.get2FACodes().options().copyDefaults(true);
        configManager.save2FACodes();
        configManager.getHomes().options().copyDefaults(true);
        configManager.saveHomes();
        configManager.getRanks().options().copyDefaults(true);
        configManager.saveRanks();
        configManager.reload2FACodes();
        configManager.reloadHomes();
        configManager.reloadRanks();

    }

}
