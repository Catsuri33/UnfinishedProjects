package fr.catsuri33.insiuhc;

import fr.catsuri33.insiuhc.commands.HostCommand;
import fr.catsuri33.insiuhc.config.ConfigManager;
import fr.catsuri33.insiuhc.utils.UpdateChecker;
//import net.minecraft.server.v1_15_R1.ChatComponentText;
//import net.minecraft.server.v1_15_R1.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
//import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
//import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
//import org.bukkit.scheduler.BukkitRunnable;

//import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

public class InsiUHC extends JavaPlugin {

    public static InsiUHC instance;
    public ConfigManager configManager;
    public ArrayList<UUID> hosts;

    @Override
    public void onEnable() {

        instance = this;

        registerListeners();
        registerCommands();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        loadConfigManager();

        hosts = new ArrayList<>();

        //new BukkitRunnable(){

            //PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();

            //@Override
            //public void run(){

                //Object header = new ChatComponentText("\n§fINSI§bUHC\n");
                //Object footer = new ChatComponentText("\n§eCreated by §6Catsuri33 §e!\n§fPlayers : §e" + Bukkit.getOnlinePlayers().size() + "§2/" + Bukkit.getMaxPlayers() + "\n");

                //try{

                    //Field a = packet.getClass().getDeclaredField("a");
                    //a.setAccessible(true);
                    //Field b = packet.getClass().getDeclaredField("a");
                    //a.setAccessible(true);

                    //a.set(packet, header);
                    //b.set(packet, footer);

                    //if(Bukkit.getOnlinePlayers().size() == 0) return;
                    //for(Player player : Bukkit.getOnlinePlayers()){

                        //((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);

                    //}

                //} catch(NoSuchFieldException | IllegalAccessException e){

                    //e.printStackTrace();

                //}

            //}

        //}.runTaskTimer(this, 0, 20);

        new UpdateChecker(this, 75216).getLatestVersion(version -> {

            if(this.getDescription().getVersion().equalsIgnoreCase(version)){

                log(ChatColor.GREEN + "The plugin is up to date !");

            } else {

                log(ChatColor.YELLOW + "The plugin has an update ! Please download it at: https://www.spigotmc.org/resources/insiserveressential.75216/ !");

            }

        });

        log("Plugin Enabled ! Created by Catsuri33 !");

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static InsiUHC getInstance() {

        return instance;

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

    }

    public void registerCommands(){

        getCommand("host").setExecutor(new HostCommand());
        getCommand("h").setExecutor(new HostCommand());

    }

    public void log(String message){

        Bukkit.getConsoleSender().sendMessage("[ InsiUHC ] " + message);

    }

    public void loadConfigManager(){

        configManager = new ConfigManager();
        configManager.setupConfigurations();

        configManager.getHost().addDefault("hosts", "");

        configManager.getHost().options().copyDefaults(true);
        configManager.saveHost();
        configManager.reloadHost();

    }

}
