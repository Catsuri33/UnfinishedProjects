package com.insignic.bot.events.listeners;

import com.insignic.bot.database.MongoDb;
import com.insignic.bot.utils.members.AleatoryJoinMessages;
import com.mongodb.client.MongoCollection;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bson.Document;

import javax.annotation.Nonnull;
import java.awt.*;

public class GuildMemberJoin extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent e){

        JDA jda = e.getJDA();
        Long guildId = e.getGuild().getIdLong();
        Guild guild = e.getGuild();
        User user = e.getUser();
        Member member = e.getMember();

        MongoCollection collection = MongoDb.mongoDatabaseInsignicBot.getCollection("guild_settings");
        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(guildId == 774360677631655987L){

            guild.addRoleToMember(user.getId(), e.getJDA().getRoleById("774581627665907722")).queue();

        }

        if(guildId == 775255428568973312L){

            guild.addRoleToMember(user.getId(), e.getJDA().getRoleById("775257341347889164")).queue();

        }

        if(!foundGuild.get("id_channel_welcome").toString().equalsIgnoreCase("")){

            final TextChannel welcomeChannel = jda.getTextChannelById(foundGuild.get("id_channel_welcome").toString());

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Welcome !");
            if(user.getAvatarUrl() != null) {

                embedBuilder.setThumbnail(user.getAvatarUrl());

            }
            embedBuilder.setColor(new Color(46, 204, 113));
            embedBuilder.addField(AleatoryJoinMessages.getMessage(user, guild), "", true);
            embedBuilder.setFooter(guild.getName() + " - InsignicBot", guild.getIconUrl());

            welcomeChannel.sendMessage(embedBuilder.build()).queue();

        }

    }

}
