package fr.catsuri33.bot2nd4.commands;

import fr.catsuri33.bot2nd4.Bot2nd4;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;

public class MuteCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e){

        String[] args = e.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot2nd4.prefix + "mute")){

            if(args.length <= 2){

                sendErrorMessage(e.getChannel(), e.getMember());

            }

            if(args.length >= 3){

                Member target = e.getMessage().getMentionedMembers().get(0);
                Role muted = e.getGuild().getRolesByName("Muet", true).get(0);
                String reason = "";

                for(int i = 2; i < args.length; i++){

                    reason += args[i] + " ";

                }

                e.getGuild().addRoleToMember(target, muted);

                sendLog(e.getMember(), target, reason, e.getGuild().getTextChannelById("694581116576727081"));
                sendSuccess(e.getMember(), target, reason, e.getMessage().getTextChannel());

            }

        }

    }

    public void sendErrorMessage(TextChannel channel, Member member){

        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Erreur !");
        builder.setFooter(member.getUser().getName(), member.getUser().getAvatarUrl());
        builder.setColor(Color.decode("#e74c3c"));
        builder.addField("La commande est: !mute <@Utilisateur> <Raison>", "", false);
        channel.sendMessage(builder.build()).complete().delete().queueAfter(15, TimeUnit.SECONDS);

    }

    public void sendLog(Member muter, Member muted, String reason, TextChannel channel){

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Mute");
        builder.setColor(Color.decode("#e74c3c"));
        builder.addField("Utilisateur rendu muet: ", muted.getAsMention(), false);
        builder.addField("Rendu muet par: ", muter.getAsMention(), false);
        builder.addField("Rendu muet le: ", sdf.format(date), false);
        builder.addField("Rendu muet à: ", stf.format(date), false);
        builder.addField("Rendu muet pour le motif: ", reason, false);
        channel.sendMessage(builder.build()).queue();

    }

    public void sendSuccess(Member muter, Member muted, String reason, TextChannel channel){

        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Mute");
        builder.setColor(Color.decode("#e74c3c"));
        builder.addField(muter.getEffectiveName() + " a rendu muet " + muted.getEffectiveName() + " pour le motif: " + reason, "", false);
        channel.sendMessage(builder.build()).queue();

    }

}
