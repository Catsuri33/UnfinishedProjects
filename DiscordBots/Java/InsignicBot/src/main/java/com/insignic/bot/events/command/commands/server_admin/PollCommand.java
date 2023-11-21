package com.insignic.bot.events.command.commands.server_admin;

import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;
import java.util.List;

public class PollCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final User selfUser = commandContext.getSelfUser();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();
        final List<String> args = commandContext.getArgs();
        final Long guildId = commandContext.getGuild().getIdLong();

        if(args.size() < 2){

            channel.sendMessage("Error, the command is `" + DatabaseManager.instance.getPrefix(guildId) + "poll <Title> <Description>`").queue();
            return;

        }

        String title = args.get(0);
        String description = args.get(1);

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(title);
        embedBuilder.setDescription(description);
        embedBuilder.setColor(new Color(241, 196, 15));



        embedBuilder.setFooter(selfUser.getName() + " - InsignicBot", selfUser.getAvatarUrl());

        channel.sendMessage(embedBuilder.build()).queue();

    }

    @Override
    public String getName() {

        return "poll";

    }

}
