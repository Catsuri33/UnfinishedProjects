package com.insignic.bot.events.listeners.reactions;

import com.insignic.bot.InsignicBot;
import com.insignic.bot.config.ConfigManager;
import com.insignic.bot.utils.ConsoleColors;
import com.insignic.bot.utils.Logger;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;

public class InsignicRoleReactions extends ListenerAdapter {

    private long languagesChannelID = 746443535800205323L;
    private long rulesChannelID = 546394414189379587L;
    private long guildID = 539336915049250816L;
    private HashMap<String, Long> reactionLanguagesToRoleID = new HashMap<>();
    private HashMap<String, Long> reactionRulesToRoleID = new HashMap<>();

    public InsignicRoleReactions(){

        // Languages
        // French: Emoji - Role
        reactionLanguagesToRoleID.put("\uD83C\uDDEB\uD83C\uDDF7", 539888191444877312L);
        // English: Emoji - Role
        reactionLanguagesToRoleID.put("\uD83C\uDDEC\uD83C\uDDE7", 539888239117467689L);

        // Rules
        // Checkmark: Emoji - Role
        reactionRulesToRoleID.put("✅", 578615009765097482L);

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e){

        if(e.getMessage().getContentRaw().equalsIgnoreCase(InsignicBot.prefix + "ilreactions")){

            if((e.getAuthor().getId().equalsIgnoreCase(ConfigManager.get("OWNER_ID")))){

                if(e.getGuild().getIdLong() == guildID){

                    if(e.getChannel().getIdLong() == languagesChannelID){

                        e.getChannel().sendMessage("**Choose your languages:**\n\n- \uD83C\uDDEB\uD83C\uDDF7: French\n- \uD83C\uDDEC\uD83C\uDDE7: English").queue();

                    } else {

                        e.getChannel().sendMessage("Error, the command must be used in the #languages channel !").queue();

                    }

                } else {

                    e.getChannel().sendMessage("Error, the command must be used in the 'Insignic' server !").queue();

                }

            } else {

                e.getChannel().sendMessage("Error, you don't have permission to execute this command !").queue();

            }

        }

    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e){

        if(e.getGuild().getIdLong() == guildID){

            if(e.getChannel().getIdLong() == languagesChannelID){

                Long roleID = reactionLanguagesToRoleID.get(e.getReactionEmote().getName());
                if(roleID == null) return;

                e.getGuild().addRoleToMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

                Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ][ " + e.getGuild().getName() + " ] " + ConsoleColors.ANSI_BLUE + "Added role " + e.getJDA().getRoleById(roleID).getName() + " to " + e.getUser().getName() + "#" + e.getUser().getDiscriminator() + ".");

            }

            if(e.getChannel().getIdLong() == rulesChannelID){

                Long roleID = reactionRulesToRoleID.get(e.getReactionEmote().getName());
                if(roleID == null) return;

                e.getGuild().addRoleToMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

                Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ][ " + e.getGuild().getName() + " ] " + ConsoleColors.ANSI_BLUE + "Added role " + e.getJDA().getRoleById(roleID).getName() + " to " + e.getUser().getName() + "#" + e.getUser().getDiscriminator() + ".");

            }

        }

    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e){

        if(e.getGuild().getIdLong() == guildID){

            if(e.getChannel().getIdLong() == languagesChannelID){

                Long roleID = reactionLanguagesToRoleID.get(e.getReactionEmote().getName());
                if(roleID == null) return;

                e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

            }

            if(e.getChannel().getIdLong() == rulesChannelID){

                Long roleID = reactionRulesToRoleID.get(e.getReactionEmote().getName());
                if(roleID == null) return;

                e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

            }

        }

    }

}
