package com.insignic.bot.events.command.commands.global;

import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;
import java.util.List;

public class UserCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final User user = commandContext.getAuthor();
        final Member member = commandContext.getMember();
        final List<String> args = commandContext.getArgs();

        if(args.size() < 1 || message.getMentionedMembers().isEmpty()){

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle(user.getName());
            embedBuilder.setThumbnail(user.getAvatarUrl());
            embedBuilder.setColor(new Color(0, 151, 230));

            embedBuilder.addField("User", user.getAsMention(), false);
            embedBuilder.addField("Discriminator", user.getDiscriminator(), false);
            embedBuilder.addField("Full Username", user.getAsTag(), false);
            embedBuilder.addField("Id", user.getId(), false);
            embedBuilder.addField("Joined On", member.getTimeJoined().toString(), false);
            embedBuilder.addField("Creation Date", user.getTimeCreated().toString(), false);

            embedBuilder.setFooter(user.getName() + " - InsignicBot", user.getAvatarUrl());

            channel.sendMessage(embedBuilder.build()).queue();
            return;

        }

        final Member target = message.getMentionedMembers().get(0);
        final User targetUser = target.getUser();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(targetUser.getName());
        embedBuilder.setThumbnail(targetUser.getAvatarUrl());
        embedBuilder.setColor(new Color(0, 151, 230));

        embedBuilder.addField("User", targetUser.getAsMention(), false);
        embedBuilder.addField("Discriminator", targetUser.getDiscriminator(), false);
        embedBuilder.addField("Full Username", targetUser.getAsTag(), false);
        embedBuilder.addField("Id", targetUser.getId(), false);
        embedBuilder.addField("Joined On", target.getTimeJoined().toString(), false);
        embedBuilder.addField("Creation Date", targetUser.getTimeCreated().toString(), false);

        embedBuilder.setFooter(targetUser.getName() + " - InsignicBot", targetUser.getAvatarUrl());

        channel.sendMessage(embedBuilder.build()).queue();

    }

    @Override
    public String getName() {

        return "user";

    }

}
