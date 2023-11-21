package fr.catsuri33.disvoice;

import fr.catsuri33.disvoice.utils.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class Disvoice extends JavaPlugin {

    private static Disvoice instance;
    private JDA jda;

    @Override
    public void onLoad(){

        super.onLoad();

    }

    @Override
    public void onEnable() {

        instance = this;

        try {

            jda = JDABuilder.createDefault("TOKEN").build();
            //jda = new JDABuilder("TOKEN").build();

        } catch (LoginException e) {

            e.printStackTrace();

        }

        Logger.success("Plugin enabled !");

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

    public static Disvoice getInstance(){

        return instance;

    }

    public JDA getJda() {

        return jda;

    }

}
