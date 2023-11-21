package com.insignic.bot.events.command.commands.music;

import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import com.insignic.bot.utils.lavaplayer.PlayerManager;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

import java.net.URI;
import java.net.URISyntaxException;

public class PlayCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Long guildId = commandContext.getGuild().getIdLong();

        // Disable in certain servers.
        // 1ère4 Lesparre
        if(guildId == 774360677631655987L){

            channel.sendMessage("Error, this command is disabled in this server !").queue();
            return;

        }

        if(commandContext.getArgs().isEmpty()){

            channel.sendMessage("Error, the command is `" + DatabaseManager.instance.getPrefix(guildId) + "play <Link>` !").queue();
            return;

        }

        Member self = commandContext.getSelfMember();
        GuildVoiceState selfVoiceState = self.getVoiceState();

        if(!self.hasPermission(Permission.VOICE_CONNECT)){

            channel.sendMessage("Error, I'm missing permissions to connect in a voice channel !").queue();
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

        if(!selfVoiceState.inVoiceChannel()){

            audioManager.openAudioConnection(memberChannel);
            channel.sendMessage("Connected to voice channel named `" + memberChannel.getName() + "` !").queue();

        }

        if(!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())){

            channel.sendMessage("Error, you need to be in the same voice channel as me to play music !").queue();
            return;

        }

        String link = String.join(" ", commandContext.getArgs());

        if(!isURL(link)){

            link = "ytsearch:" + link;

        }

        PlayerManager.getInstance().loadAndPlay(channel, link);

    }

    @Override
    public String getName() {

        return "play";

    }

    private boolean isURL(String url){

        try {

            new URI(url);
            return true;

        } catch(URISyntaxException e){

            return false;

        }

    }

}
