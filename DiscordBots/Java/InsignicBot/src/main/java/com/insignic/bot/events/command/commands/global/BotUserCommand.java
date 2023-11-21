package com.insignic.bot.events.command.commands.global;

import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;

import java.awt.*;
import java.util.List;

public class BotUserCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final JDA jda = commandContext.getJDA();
        final User selfUser = commandContext.getSelfUser();
        final Guild guild = commandContext.getGuild();
        final Member botMember = guild.getMember(selfUser);
        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();
        final List<String> args = commandContext.getArgs();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(selfUser.getName());
        embedBuilder.setThumbnail(selfUser.getAvatarUrl());
        embedBuilder.setColor(new Color(0, 151, 230));

        embedBuilder.addField("Bot", selfUser.getAsMention(), false);
        embedBuilder.addField("Discriminator", selfUser.getDiscriminator(), false);
        embedBuilder.addField("Full Username", selfUser.getAsTag(), false);
        embedBuilder.addField("Id", selfUser.getId(), false);
        embedBuilder.addField("Joined On", botMember.getTimeJoined().toString(), false);
        embedBuilder.addField("Creation Date", botMember.getTimeCreated().toString(), false);
        embedBuilder.addField("OS Name", System.getProperty("os.name"), false);
        embedBuilder.addField("OS Version", System.getProperty("os.version"), false);
        embedBuilder.addField("OS Architecture", System.getProperty("os.arch"), false);
        embedBuilder.addField("Avaible Processors Cores", String.valueOf(Runtime.getRuntime().availableProcessors()), false);

        embedBuilder.setFooter(selfUser.getName() + " - InsignicBot", selfUser.getAvatarUrl());

        channel.sendMessage(embedBuilder.build()).queue();

    }

    @Override
    public String getName() {

        return "bot";

    }

}
