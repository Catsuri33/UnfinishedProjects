package com.insignic.bot.events.command.commands.music;

import com.insignic.bot.events.command.CommandContext;
import com.insignic.bot.events.command.ICommand;
import com.insignic.bot.utils.lavaplayer.GuildMusicManager;
import com.insignic.bot.utils.lavaplayer.PlayerManager;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public class StopCommand implements ICommand {

    @Override
    public void handle(CommandContext commandContext) {

        final TextChannel channel = commandContext.getChannel();
        final Member self = commandContext.getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();
        final Member member = commandContext.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();
        final Long guildId = commandContext.getGuild().getIdLong();

        // Disable in certain servers.
        // 1ère4 Lesparre
        if(guildId == 774360677631655987L){

            channel.sendMessage("Error, this command is disabled in this server !").queue();
            return;

        }

        if(!selfVoiceState.inVoiceChannel()){

            channel.sendMessage("Error, I need to be in a voice channel to execute this command !").queue();
            return;

        }

        if(!memberVoiceState.inVoiceChannel()){

            channel.sendMessage("Error, you need to be in a voice channel to execute this command !").queue();
            return;

        }

        if(!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())){

            channel.sendMessage("Error, you need to be in the same voice channel as me to stop music !").queue();
            return;

        }

        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(commandContext.getGuild());

        musicManager.scheduler.player.stopTrack();
        musicManager.scheduler.queue.clear();

        channel.sendMessage("Music stopped !").queue();

    }

    @Override
    public String getName() {

        return "stop";

    }

}
