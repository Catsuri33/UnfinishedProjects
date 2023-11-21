package com.insignic.bot.events.command.commands.server_admin;

import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import com.insignic.bot.utils.Logger;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class PrefixCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();
        final User user = commandContext.getAuthor();
        final List<String> args = commandContext.getArgs();
        final long guildId = commandContext.getGuild().getIdLong();

        if(args.size() < 1){

            channel.sendMessage("Error, the command is `" + DatabaseManager.instance.getPrefix(guildId) + "prefix <Prefix>`").queue();
            return;

        }

        if(!member.hasPermission(Permission.ADMINISTRATOR)){

            channel.sendMessage("Error, you don't have permission to use this command !").queue();
            return;

        }

        final String newPrefix = String.join(" ", args.subList(0, args.size()));

        DatabaseManager.instance.setPrefix(guildId, newPrefix);

        channel.sendMessage("The new prefix of the bot for this server is `" + newPrefix + "` !").queue();
        Logger.info(user.getName() + "#" + user.getDiscriminator() + " changed the prefix of the bot on '" + message.getGuild().getName() + "' server in '" + newPrefix + "'.");

    }

    @Override
    public String getName() {

        return "prefix";

    }

}
