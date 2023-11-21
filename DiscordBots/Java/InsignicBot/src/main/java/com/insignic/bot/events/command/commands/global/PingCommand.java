package com.insignic.bot.events.command.commands.global;

import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.JDA;

public class PingCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        JDA jda = commandContext.getJDA();

        jda.getRestPing().queue(

                (ping) -> commandContext.getChannel().sendMessageFormat("Ping: %sms", ping, jda.getGatewayPing()).queue()

        );

    }

    @Override
    public String getName() {

        return "ping";

    }

}
