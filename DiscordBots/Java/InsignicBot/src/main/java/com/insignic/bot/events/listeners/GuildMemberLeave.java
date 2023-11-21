package com.insignic.bot.events.listeners;

import com.insignic.bot.database.MongoDb;
import com.mongodb.client.MongoCollection;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bson.Document;

import javax.annotation.Nonnull;
import java.awt.*;

public class GuildMemberLeave extends ListenerAdapter {

    @Override
    public void onGuildMemberLeave(@Nonnull GuildMemberLeaveEvent e){

        JDA jda = e.getJDA();
        Long guildId = e.getGuild().getIdLong();
        Guild guild = e.getGuild();
        User user = e.getUser();

        MongoCollection collection = MongoDb.mongoDatabaseInsignicBot.getCollection("guild_settings");
        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(!foundGuild.get("id_channel_welcome").toString().equalsIgnoreCase("")){

            final TextChannel welcomeChannel = jda.getTextChannelById(foundGuild.get("id_channel_welcome").toString());

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Goodbye !");
            embedBuilder.setThumbnail(user.getAsTag());
            embedBuilder.setColor(new Color(231, 76, 60));
            embedBuilder.addField("Goodbye " + user.getAsTag() + ", we hope to see you again on '" + guild.getName() + "' server !", "", true);
            embedBuilder.setFooter(guild.getName() + " - InsignicBot", guild.getIconUrl());

            welcomeChannel.sendMessage(embedBuilder.build()).queue();

        }

    }

}
