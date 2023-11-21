package com.insignic.bot.events.listeners;

import com.insignic.bot.config.ConfigManager;
import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.CommandManager;
import com.insignic.bot.events.command.ICommand;
import com.insignic.bot.utils.ConsoleColors;
import com.insignic.bot.utils.Logger;
import com.insignic.bot.utils.ban.BanManager;
import me.duncte123.botcommons.BotCommons;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Shutdown extends ListenerAdapter {

    private final CommandManager commandManager = new CommandManager();
    private BanManager banManager = new BanManager();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){

        User user = e.getAuthor();
        String raw = e.getMessage().getContentRaw();
        long guildId = e.getGuild().getIdLong();

        final String prefix = DatabaseManager.instance.getPrefix(guildId);

        if(user.isBot() || e.isWebhookMessage()){

            return;

        }

        banManager.checkDuration(user);

        if(raw.equalsIgnoreCase(prefix + "shutdown")){

            if(user.getId().equalsIgnoreCase(ConfigManager.get("OWNER_ID"))){

                Logger.info(ConsoleColors.ANSI_CYAN + "[ INFO ]" + ConsoleColors.ANSI_BLUE + " " + e.getAuthor().getName() + "#" + e.getAuthor().getDiscriminator() + " performed 'i!shutdown' command on '" + e.getGuild().getName() + "' server.");

                Logger.info(ConsoleColors.ANSI_CYAN + "[ INFO ]" + ConsoleColors.ANSI_BLUE + " Shutting down...");
                e.getChannel().sendMessage("Shutting down...").queue();

                e.getJDA().shutdown();
                BotCommons.shutdown(e.getJDA());

                return;

            } else {

                e.getChannel().sendMessage("Error, you don't have permission to use this command !").queue();

            }

        }

        if(raw.startsWith(prefix)){

            commandManager.handle(e);

        }

    }

}
