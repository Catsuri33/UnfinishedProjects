package com.insignic.bot.events.command.commands.global;

import com.insignic.bot.config.ConfigManager;
import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.List;

public class HelpCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();
        final List<String> args = commandContext.getArgs();
        final Guild guild = commandContext.getGuild();
        final Long guildId = commandContext.getGuild().getIdLong();
        final String prefix = DatabaseManager.instance.getPrefix(guildId);

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Commands List:");
        embedBuilder.setThumbnail(commandContext.getSelfUser().getAvatarUrl());
        embedBuilder.setColor(new Color(39, 174, 96));
        if(member.getId().equalsIgnoreCase(ConfigManager.get("OWNER_ID"))){

            embedBuilder.addField("Bot Admin Commands:", "- " + prefix + "shutdown\n- " + prefix + "sendnews <Message>\n- " + prefix + "iaban <@User> <Time> <Reason>\n- " + prefix + "iaunban <@User>", false);

        }
        if(member.hasPermission(Permission.ADMINISTRATOR) || member.hasPermission(Permission.KICK_MEMBERS) || member.hasPermission(Permission.BAN_MEMBERS) || member.getId().equalsIgnoreCase(ConfigManager.get("OWNER_ID"))){

            embedBuilder.addField("Server Admin Commands:", "- " + prefix + "ban <@User> <Reason>\n- " + prefix + "kick <@User> <Reason>\n- " + prefix + "clear <Amount>\n- " + prefix + "channel <News | Welcome> <Set | Remove> <#Channel>\n- " + prefix + "prefix <Prefix>", false);

        }
        embedBuilder.addField("Global Commands:", "- " + prefix + "help\n- " + prefix + "ping\n- " + prefix + "user <@User>\n- " + prefix + "bot\n- " + prefix + "server", false);
        embedBuilder.addField("Music Commands:", "- " + prefix + "play <Youtube Link>\n- " + prefix + "stop\n- " + prefix + "skip\n- " + prefix + "leave", false);
        embedBuilder.addField("Fun Commands:", "- " + prefix + "roll", false);
        embedBuilder.addField("Insignic Commands:", "- " + prefix + "account\n- " + prefix + "account <Create>\n- " + prefix + "everify\n- " + prefix + "everify <Code>\n- " + prefix + "badges <@User>", false);
        embedBuilder.setFooter(guild.getName() + " - InsignicBot", guild.getIconUrl());

        channel.sendMessage(embedBuilder.build()).queue();

    }

    @Override
    public String getName() {

        return "help";

    }

}
