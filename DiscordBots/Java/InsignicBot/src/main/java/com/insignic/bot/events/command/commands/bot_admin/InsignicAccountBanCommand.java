package com.insignic.bot.events.command.commands.bot_admin;

import com.insignic.bot.config.ConfigManager;
import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import com.insignic.bot.utils.ban.BanManager;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class InsignicAccountBanCommand implements ICommand {

    private BanManager banManager = new BanManager();

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();
        final User user = commandContext.getAuthor();
        final List<String> args = commandContext.getArgs();
        final long guildId = commandContext.getGuild().getIdLong();

        if(user.getId().equalsIgnoreCase(ConfigManager.get("OWNER_ID"))){

            if(args.size() < 3 || message.getMentionedMembers().isEmpty()){

                channel.sendMessage("Error, the command is `" + DatabaseManager.instance.getPrefix(guildId) + "iaban <@User> <Time> <Reason>`").queue();
                return;

            }

            final Member target = message.getMentionedMembers().get(0);

            // Check if user has higher rank.

            final Long time = Long.valueOf(args.get(1));
            final String reason = String.join(" ", args.subList(2, args.size()));

            banManager.ban(target.getUser(), channel, args, time, reason, user.getName());

        } else {

            channel.sendMessage("Error, you don't have permission to use this command !").queue();
            return;

        }

    }

    @Override
    public String getName() {

        return "iaban";

    }

}
