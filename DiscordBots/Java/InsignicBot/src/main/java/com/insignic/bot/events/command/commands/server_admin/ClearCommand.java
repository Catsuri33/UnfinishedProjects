package com.insignic.bot.events.command.commands.server_admin;

import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class ClearCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();
        final List<String> args = commandContext.getArgs();
        final Long guildId = commandContext.getGuild().getIdLong();

        if(args.size() < 1){

            channel.sendMessage("Error, the command is `" + DatabaseManager.instance.getPrefix(guildId) + "clear <Amount>`").queue();
            return;

        }

        if(!member.hasPermission(Permission.MESSAGE_MANAGE)){

            channel.sendMessage("Error, you don't have permission to use this command !").queue();
            return;

        }

        try {

            final int amountOfMessages = Integer.parseInt(args.get(0));

            try {

                final List<Message> messages = channel.getHistory().retrievePast(amountOfMessages).complete();
                channel.deleteMessages(messages).queue();

                channel.sendMessage(member.getAsMention() + ", **" + messages.size() + "** messages have been deleted !").queue();

            } catch(IllegalArgumentException e){

                if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")){

                    channel.sendMessage("Error, too many messages selected ! (Minimum 1, Maximum 100)").queue();
                    return;

                } else {

                    channel.sendMessage("Error, selected messages are older than 2 weeks !").queue();
                    return;

                }

            }

        } catch (NumberFormatException e) {

            channel.sendMessage("Error, the argument must be a number !").queue();
            return;

        }

    }

    @Override
    public String getName() {

        return "clear";

    }

}
