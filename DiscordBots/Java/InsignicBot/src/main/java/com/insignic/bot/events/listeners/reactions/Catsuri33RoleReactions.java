package com.insignic.bot.events.listeners.reactions;

import com.insignic.bot.utils.ConsoleColors;
import com.insignic.bot.utils.Logger;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;

public class Catsuri33RoleReactions extends ListenerAdapter {

    private long rolesChannelID = 730776277765586984L;
    private long rulesChannelID = 730776266436902962L;
    private long guildID = 427444638937251840L;
    private HashMap<Long, Long> reactionRolesToRoleID = new HashMap<>();
    private HashMap<String, Long> reactionRolesStringToRoleID = new HashMap<>();
    private HashMap<String, Long> reactionRulesToRoleID = new HashMap<>();

    public Catsuri33RoleReactions(){

        // Languages
        // Twitter: Emoji - Role
        reactionRolesToRoleID.put(730800079304261753L, 730775630245003266L);
        // Twitch: Emoji - Role
        reactionRolesToRoleID.put(730800000270991421L, 730775591913127946L);
        // Announcements: Emoji - Role
        reactionRolesStringToRoleID.put("\uD83D\uDCE2", 730775658942431374L);

        // Rules
        // Checkmark: Emoji - Role
        reactionRulesToRoleID.put("✅", 730792308785807410L);

    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e){

        if(e.getGuild().getIdLong() == guildID){

            if(e.getChannel().getIdLong() == rolesChannelID){

                if(e.getReactionEmote().isEmoji()){

                    Long roleID = reactionRolesStringToRoleID.get(e.getReactionEmote().getName());
                    if(roleID == null) return;

                    e.getGuild().addRoleToMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

                    Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ][ " + e.getGuild().getName() + " ] " + ConsoleColors.ANSI_BLUE + "Added role " + e.getJDA().getRoleById(roleID).getName() + " to " + e.getUser().getName() + "#" + e.getUser().getDiscriminator() + ".");

                }

                if(e.getReactionEmote().isEmote()){

                    Long roleID = reactionRolesToRoleID.get(e.getReactionEmote().getIdLong());
                    if(roleID == null) return;

                    e.getGuild().addRoleToMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

                    Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ][ " + e.getGuild().getName() + " ] " + ConsoleColors.ANSI_BLUE + "Added role " + e.getJDA().getRoleById(roleID).getName() + " to " + e.getUser().getName() + "#" + e.getUser().getDiscriminator() + ".");

                }

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

            if(e.getChannel().getIdLong() == rolesChannelID){

                if(e.getReactionEmote().isEmoji()){

                    Long roleID = reactionRolesStringToRoleID.get(e.getReactionEmote().getName());
                    if(roleID == null) return;

                    e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

                    //Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ][ " + e.getGuild().getName() + " ] " + ConsoleColors.ANSI_BLUE + "Removed role " + e.getJDA().getRoleById(roleID).getName() + " to " + e.getUser().getName() + "#" + e.getUser().getDiscriminator() + ".");

                }

                if(e.getReactionEmote().isEmote()){

                    Long roleID = reactionRolesToRoleID.get(e.getReactionEmote().getIdLong());
                    if(roleID == null) return;

                    e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

                    //Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ][ " + e.getGuild().getName() + " ] " + ConsoleColors.ANSI_BLUE + "Removed role " + e.getJDA().getRoleById(roleID).getName() + " to " + e.getUser().getName() + "#" + e.getUser().getDiscriminator() + ".");

                }

            }

            if(e.getChannel().getIdLong() == rulesChannelID){

                Long roleID = reactionRulesToRoleID.get(e.getReactionEmote().getName());
                if(roleID == null) return;

                e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

                //Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ][ " + e.getGuild().getName() + " ] " + ConsoleColors.ANSI_BLUE + "Removed role " + e.getJDA().getRoleById(roleID).getName() + " to " + e.getUser().getName() + "#" + e.getUser().getDiscriminator() + ".");

            }

        }

    }

}
