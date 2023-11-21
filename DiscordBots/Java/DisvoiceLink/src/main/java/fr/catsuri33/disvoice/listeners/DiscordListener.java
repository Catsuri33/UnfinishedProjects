package fr.catsuri33.disvoice.listeners;

import fr.catsuri33.disvoice.utils.Logger;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiscordListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent e){

        e.getJDA().getPresence().setActivity(Activity.playing("Link voice between Spigot and Discord !"));
        Logger.success("Discord bot connected !");

        super.onReady(e);

    }

}
