package com.insignic.bot.events.command.commands.global;

import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

import java.awt.*;
import java.util.List;

public class ServerCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Guild guild = commandContext.getGuild();
        final Member member = commandContext.getMember();
        final List<String> args = commandContext.getArgs();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(guild.getName());
        embedBuilder.setThumbnail(guild.getIconUrl());
        embedBuilder.setColor(new Color(0, 151, 230));

        embedBuilder.addField("Server Name", guild.getName(), false);
        embedBuilder.addField("Id", guild.getId(), false);
        embedBuilder.addField("Owner", guild.getOwner().getAsMention(), false);
        embedBuilder.addField("Region", guild.getRegion().toString(), false);
        embedBuilder.addField("Boosts Amount", String.valueOf(guild.getBoostCount()), false);
        embedBuilder.addField("Channel Amount", String.valueOf(guild.getChannels().size()), false);
        embedBuilder.addField("Members Amount", String.valueOf(guild.getMemberCount()), false);
        embedBuilder.addField("Creation Date", guild.getTimeCreated().toString(), false);

        embedBuilder.setFooter(guild.getName() + " - InsignicBot", guild.getIconUrl());

        channel.sendMessage(embedBuilder.build()).queue();

    }

    @Override
    public String getName() {

        return "server";

    }

}
