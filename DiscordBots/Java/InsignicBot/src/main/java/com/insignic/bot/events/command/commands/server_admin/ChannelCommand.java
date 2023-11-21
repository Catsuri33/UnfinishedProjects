package com.insignic.bot.events.command.commands.server_admin;

import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class ChannelCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();
        final User user = commandContext.getAuthor();
        final List<String> args = commandContext.getArgs();
        final long guildId = commandContext.getGuild().getIdLong();

        if(args.size() < 3 || message.getMentionedChannels().isEmpty()){

            channel.sendMessage("Error, the command is `" + DatabaseManager.instance.getPrefix(guildId) + "channel <news | welcome> <set | remove> <#channel>`").queue();
            return;

        }

        if(!member.hasPermission(Permission.ADMINISTRATOR)){

            channel.sendMessage("Error, you don't have permission to use this command !").queue();
            return;

        }

        if(args.get(0).equalsIgnoreCase("news")){

            final TextChannel channelChoose = message.getMentionedChannels().get(0);

            if(args.get(1).equalsIgnoreCase("set")){

                if(channelChoose.getId().equals(DatabaseManager.instance.getIdChannelNews(guildId))){

                    channel.sendMessage("Error, this channel is already used for the news !").queue();
                    return;

                }

                DatabaseManager.instance.setIdChannelNews(guildId, channelChoose.getId());

                channel.sendMessage("The channel for the news has been set to " + channelChoose.getAsMention() + " !").queue();

            }

            if(args.get(1).equalsIgnoreCase("remove")){

                if(!channelChoose.getId().equals(DatabaseManager.instance.getIdChannelNews(guildId))){

                    channel.sendMessage("Error, this channel is not used for the news !").queue();
                    return;

                }

                DatabaseManager.instance.setIdChannelNews(guildId, "");

                channel.sendMessage("The channel for the news has been deleted !").queue();

            }

        }
        else if(args.get(0).equalsIgnoreCase("welcome")){

            final TextChannel channelChoose = message.getMentionedChannels().get(0);

            if(args.get(1).equalsIgnoreCase("set")){

                if(channelChoose.getId().equals(DatabaseManager.instance.getIdChannelWelcome(guildId))){

                    channel.sendMessage("Error, this channel is already used for the join/left messages !").queue();
                    return;

                }

                DatabaseManager.instance.setIdChannelWelcome(guildId, channelChoose.getId());

                channel.sendMessage("The channel for the join/left messages has been set to " + channelChoose.getAsMention() + " !").queue();

            }

            if(args.get(1).equalsIgnoreCase("remove")){

                if(!channelChoose.getId().equals(DatabaseManager.instance.getIdChannelWelcome(guildId))){

                    channel.sendMessage("Error, this channel is not used for the join/left messages !").queue();
                    return;

                }

                DatabaseManager.instance.setIdChannelWelcome(guildId, "");

                channel.sendMessage("The channel for the join/left messages has been deleted !").queue();

            }

        }
        else {

            channel.sendMessage("Error, the command is `" + DatabaseManager.instance.getPrefix(guildId) + "channel <news | welcome> <set | remove> <#channel>`").queue();

        }

    }

    @Override
    public String getName() {

        return "channel";

    }

}
