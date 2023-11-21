package com.insignic.bot.events.command.commands.bot_admin;

import com.insignic.bot.config.ConfigManager;
import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.database.MongoDb;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import com.insignic.bot.utils.Logger;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import org.bson.Document;

import java.util.List;

public class SendNewsToChannelsCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        JDA jda = commandContext.getJDA();
        final TextChannel channel = commandContext.getChannel();
        final Message message = commandContext.getMessage();
        final Member member = commandContext.getMember();
        final User user = commandContext.getAuthor();
        final List<String> args = commandContext.getArgs();
        final long guildId = commandContext.getGuild().getIdLong();

        if(user.getId().equalsIgnoreCase(ConfigManager.get("OWNER_ID"))){

            if(args.size() < 1){

                channel.sendMessage("Error, the command is `" + DatabaseManager.instance.getPrefix(guildId) + "sendnews <Message>`").queue();
                return;

            }

            final String invoke = this.getName();
            final String contentRaw = commandContext.getMessage().getContentRaw();
            final int index = contentRaw.indexOf(invoke) + invoke.length();
            final String body = contentRaw.substring(index).trim();
            int serversCount = 0;

            MongoDatabase mongoDatabase = MongoDb.mongoDatabaseInsignicBot;
            MongoCollection collection = mongoDatabase.getCollection("guild_settings");

            for(int i = 1; i < collection.countDocuments(); i++){

                Document foundId = (Document) collection.find(new Document("id", i)).first();

                if(!foundId.get("id_channel_news").toString().equalsIgnoreCase("")){

                    final TextChannel channelToSend = jda.getTextChannelById(foundId.get("id_channel_news").toString());

                    if(channelToSend != null){

                        channelToSend.sendMessage(body).queue();
                        serversCount++;

                    }

                }

            }

            channel.sendMessage("You have send the news message:\n\n" + body + "\n\nMessage send to **" + serversCount + "** servers.").queue();

        } else {

            channel.sendMessage("Error, you don't have permission to use this command !").queue();

        }

    }

    @Override
    public String getName() {

        return "sendnews";

    }

}
