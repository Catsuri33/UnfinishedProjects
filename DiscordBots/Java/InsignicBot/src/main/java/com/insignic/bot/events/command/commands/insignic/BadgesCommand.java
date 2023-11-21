package com.insignic.bot.events.command.commands.insignic;

import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import com.insignic.bot.utils.BadgesManager;
import net.dv8tion.jda.api.entities.*;

import java.util.List;

public class BadgesCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();
        final List<String> args = commandContext.getArgs();
        final Guild guild = commandContext.getGuild();
        final Long guildId = commandContext.getGuild().getIdLong();

        if(args.size() < 1 || message.getMentionedMembers().isEmpty()){

            if(DatabaseManager.instance.getNickname(member.getIdLong()) == null){

                channel.sendMessage("Error, you don't have an InsignicAccounts account ! To get started type `" + DatabaseManager.instance.getPrefix(guildId) + "account create` !").queue();
                return;

            }

            String badgesTotalString = BadgesManager.getBadgesWithDesc(member.getIdLong());
            String[] arrOfBadges = badgesTotalString.split("-");
            String finalMessage = "";

            for (String str : arrOfBadges){

                finalMessage = finalMessage + str + "\n";

            }

            channel.sendMessage("__**Badges of " + member.getAsMention() + "**__\n\n" + finalMessage).queue();
            return;

        }

        final Member target = message.getMentionedMembers().get(0);
        final User targetUser = target.getUser();

        if(DatabaseManager.instance.getNickname(targetUser.getIdLong()) == null){

            channel.sendMessage("Error, **" + targetUser.getName() + "** doesn't have an InsignicAccounts account !").queue();
            return;

        }

        String badgesTotalString = BadgesManager.getBadgesWithDesc(targetUser.getIdLong());
        String[] arrOfBadges = badgesTotalString.split("-");
        String finalMessage = "";

        for (String str : arrOfBadges){

            finalMessage = finalMessage + str + "\n";

        }

        channel.sendMessage("__**Badges of " + targetUser.getAsMention() + "**__\n\n" + finalMessage).queue();
        return;

    }

    @Override
    public String getName() {

        return "badges";

    }

}
