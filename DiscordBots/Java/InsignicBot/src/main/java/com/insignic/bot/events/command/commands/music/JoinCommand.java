package com.insignic.bot.events.command.commands.music;

import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Member self = commandContext.getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();

        if(!self.hasPermission(Permission.VOICE_CONNECT)){

            channel.sendMessage("Error, I'm missing permissions to connect in a voice channel !").queue();
            return;

        }

        if(selfVoiceState.inVoiceChannel()){

            channel.sendMessage("Error, I'm already in a voice channel !").queue();
            return;

        }

        final Member member = commandContext.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();

        if(!memberVoiceState.inVoiceChannel()){

            channel.sendMessage("Error, you need to be in a voice channel to execute this command !").queue();
            return;

        }

        final AudioManager audioManager = commandContext.getGuild().getAudioManager();
        final VoiceChannel memberChannel = memberVoiceState.getChannel();

        audioManager.openAudioConnection(memberChannel);

        channel.sendMessage("Connected to voice channel named `" + memberChannel.getName() + "` !").queue();

    }

    @Override
    public String getName() {

        return "join";

    }

}
