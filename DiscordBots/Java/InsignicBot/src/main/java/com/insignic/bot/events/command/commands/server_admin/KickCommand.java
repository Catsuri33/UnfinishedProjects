package com.insignic.bot.events.command.commands.server_admin;

import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class KickCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();
        final List<String> args = commandContext.getArgs();
        final Long guildId = commandContext.getGuild().getIdLong();

        if(args.size() < 2 || message.getMentionedMembers().isEmpty()){

            channel.sendMessage("Error, the command is `" + DatabaseManager.instance.getPrefix(guildId) + "kick <@User> <Reason>`").queue();
            return;

        }

        final Member target = message.getMentionedMembers().get(0);

        if(!member.canInteract(target) || !member.hasPermission(Permission.KICK_MEMBERS)){

            channel.sendMessage("Error, you don't have permission to use this command !").queue();
            return;

        }

        final Member selfMember = commandContext.getSelfMember();

        if(!selfMember.canInteract(target) || !selfMember.hasPermission(Permission.KICK_MEMBERS)){

            channel.sendMessage("Error, I am missing permissions to kick this user !").queue();
            return;

        }

        final String reason = String.join(" ", args.subList(1, args.size()));

        commandContext.getGuild().kick(target, reason).reason(reason).queue(

                (__) -> channel.sendMessage("**" + target.getUser().getName() + "** was kicked by **" + member.getUser().getName() + "** for: '" + reason + "' !").queue(),
                (error) -> channel.sendMessageFormat("Error, couldn't kick this user: %s", error.getMessage()).queue()

        );

    }

    @Override
    public String getName() {

        return "kick";

    }

}
