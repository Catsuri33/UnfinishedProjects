package fr.catsuri33.survieminecraftbot.listeners;

import fr.catsuri33.survieminecraftbot.SurvieMinecraftBot;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Discord extends ListenerAdapter {

    private final SurvieMinecraftBot main;

    public Discord(SurvieMinecraftBot main){

        this.main = main;

    }

    @Override
    public void onReady(@Nonnull ReadyEvent e) {

        System.out.println("Bot connecté !");
        e.getJDA().getPresence().setStatus(OnlineStatus.ONLINE);
        e.getJDA().getPresence().setActivity(Activity.playing("Serveur survie ! (:"));
        super.onReady(e);

    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent e) {

        if(e.getAuthor().isBot()){

            return;

        }

        if(e.getGuild() == null){

            return;

        }

        if(e.getChannel().getIdLong() != main.getChannelID()){

            return;

        }

        main.sendMessageToSpigot(e.getMessage());
        super.onMessageReceived(e);

    }

}
