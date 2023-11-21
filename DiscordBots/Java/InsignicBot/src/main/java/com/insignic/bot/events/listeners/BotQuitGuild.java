package com.insignic.bot.events.listeners;

import com.insignic.bot.utils.ConsoleColors;
import com.insignic.bot.utils.Logger;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotQuitGuild extends ListenerAdapter {

    @Override
    public void onGuildLeave(GuildLeaveEvent e){

        Guild server = e.getGuild();

        // Servers Presence
        e.getJDA().getPresence().setActivity(Activity.watching(e.getJDA().getGuilds().size() + " servers !"));

        // Logs
        Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ] " + ConsoleColors.ANSI_BLUE + e.getJDA().getSelfUser().getName() + " has quit '" + e.getGuild().getName() + "' server. This servers has " + e.getGuild().getMemberCount() + " members.");

    }

}
