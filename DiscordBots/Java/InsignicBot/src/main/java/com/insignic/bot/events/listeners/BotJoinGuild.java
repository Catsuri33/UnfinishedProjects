package com.insignic.bot.events.listeners;

import com.insignic.bot.database.MongoDb;
import com.insignic.bot.utils.ConsoleColors;
import com.insignic.bot.utils.Logger;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bson.Document;

public class BotJoinGuild extends ListenerAdapter {

    @Override
    public void onGuildJoin(GuildJoinEvent e){

        Guild server = e.getGuild();
        Long guildId = e.getGuild().getIdLong();
        MongoDatabase mongoDatabase = MongoDb.mongoClientInsignicBot.getDatabase("InsignicBot");
        MongoCollection collection = mongoDatabase.getCollection("guild_settings");

        // Servers Presence
        e.getJDA().getPresence().setActivity(Activity.watching(e.getJDA().getGuilds().size() + " servers !"));

        // MongoDB
        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(foundGuild == null){

            Document newGuild = new Document("id", collection.countDocuments() + 1);
            newGuild.append("guild_id", String.valueOf(guildId));
            newGuild.append("guild_name", server.getName());
            newGuild.append("prefix", "i!");
            newGuild.append("id_channel_news", "");
            newGuild.append("id_channel_welcome", "");

            collection.insertOne(newGuild);

        }

        // Logs
        Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ] " + ConsoleColors.ANSI_BLUE + e.getJDA().getSelfUser().getName() + " has joined '" + e.getGuild().getName() + "' server. This servers has " + e.getGuild().getMemberCount() + " members.");

    }

}
