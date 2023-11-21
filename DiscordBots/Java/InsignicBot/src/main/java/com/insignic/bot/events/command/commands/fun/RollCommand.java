package com.insignic.bot.events.command.commands.fun;

import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class RollCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();

        int ransdomDice = 1 + (int)(Math.random() * ((6 - 1) + 1));

        channel.sendMessage(member.getAsMention() + ", the dice gave you a " + ransdomDice + ".").queue();

    }

    @Override
    public String getName() {

        return "roll";

    }

}
