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

public class Noucheca_OWRoleReactions extends ListenerAdapter {

    private long channelID = 732300586552393811L;
    private long guildID = 732278001215078421L;
    private HashMap<Long, Long> reactionToRoleID = new HashMap<>();

    public Noucheca_OWRoleReactions(){

        // Twitch: Emoji - Role
        reactionToRoleID.put(732301524046184578L, 732298116899930142L);
        // Youtube: Emoji - Role
        reactionToRoleID.put(732301667936108667L, 732295740411609088L);

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e){

        if(e.getMessage().getContentRaw().equalsIgnoreCase(InsignicBot.prefix + "nouchecareactions")){

            if((e.getAuthor().getId().equalsIgnoreCase(ConfigManager.get("OWNER_ID")))){

                if(e.getGuild().getIdLong() == guildID){

                    if(e.getChannel().getIdLong() == channelID){

                        e.getChannel().sendMessage("**Choisissez vos rôles:**\n\n- <:twitch:732301524046184578>: Follower Twitch\n- <:youtube:732301667936108667>: Abonné Youtube").queue();

                    } else {

                        e.getChannel().sendMessage("Error, the command must be used in the #salon-des-rôles channel !").queue();

                    }

                } else {

                    e.getChannel().sendMessage("Error, the command must be used in the 'NouChecA_OW' server !").queue();

                }

            } else {

                e.getChannel().sendMessage("Error, you don't have permission to execute this command !").queue();

            }

        }

    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e){

        if(e.getGuild().getIdLong() == guildID){

            if(e.getChannel().getIdLong() == channelID){

                Long roleID = reactionToRoleID.get(e.getReactionEmote().getIdLong());
                if(roleID == null) return;

                e.getGuild().addRoleToMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

                Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ][ " + e.getGuild().getName() + " ] " + ConsoleColors.ANSI_BLUE + "Added role " + e.getJDA().getRoleById(roleID).getName() + " to " + e.getUser().getName() + "#" + e.getUser().getDiscriminator() + ".");

            }

        }

    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e){

        if(e.getGuild().getIdLong() == guildID){

            if(e.getChannel().getIdLong() == channelID){

                Long roleID = reactionToRoleID.get(e.getReactionEmote().getIdLong());
                if(roleID == null) return;

                e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

                Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ][ " + e.getGuild().getName() + " ] " + ConsoleColors.ANSI_BLUE + "Added role " + e.getJDA().getRoleById(roleID).getName() + " to " + e.getUser().getName() + "#" + e.getUser().getDiscriminator() + ".");

            }

        }

    }

}
