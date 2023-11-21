package fr.catsuri33.survieminecraftbot;

import fr.catsuri33.survieminecraftbot.listeners.*;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class SurvieMinecraftBot extends JavaPlugin {

    private JDA jda;
    private final long channelID = 674599771167522826L;

    @Override
    public void onLoad() {

        try {

            jda = new JDABuilder(AccountType.BOT).setToken("TOKEN").addEventListeners(new Discord(this)).build();

        } catch (LoginException e) {

            e.printStackTrace();

        }

        super.onLoad();

    }

    @Override
    public void onEnable() {

        registerListeners();

        super.onEnable();

    }

    @Override
    public void onDisable() {

        jda.shutdown();
        super.onDisable();

    }

    public JDA getJda() {

        return jda;

    }

    public void registerListeners(){

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new Spigot(this), this);

        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new PlayerQuit(this), this);
        pm.registerEvents(new PlayerDeath(this), this);

    }

    public long getChannelID() {

        return channelID;

    }

    public void sendMessageToSpigot(Message message){

        Bukkit.broadcastMessage("§9Discord » §e" + message.getAuthor().getAsTag() + " : §f" + message.getContentDisplay());

    }

    public void sendMessageToDiscord(Player player, String message){

        jda.getTextChannelById(channelID).sendMessage(player.getName() + "» " + message).queue();

    }

    public void sendDeathToDiscord(String message){

        jda.getTextChannelById(channelID).sendMessage("MORT» " +message).queue();

    }

}
