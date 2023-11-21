package com.insignic.bot.events.listeners.reactions;

import com.insignic.bot.utils.ConsoleColors;
import com.insignic.bot.utils.Logger;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;

public class PremiereQuatreRoleReactions extends ListenerAdapter {

    private long rolesChannelID = 774360880484712529L;
    private long guildID = 774360677631655987L;
    private HashMap<String, Long> reactionRolesToRoleID = new HashMap<>();

    public PremiereQuatreRoleReactions(){

        // Roles
        // Green_Apple - SVT 1: Emoji - Role
        reactionRolesToRoleID.put("\uD83C\uDF4F", 774612014160805949L);
        // Apple - SVT 2: Emoji - Role
        reactionRolesToRoleID.put("\uD83C\uDF4E", 774612404389806090L);
        // Rocket - Anglais C: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDE80", 774612484148559922L);
        // Flying_Saucer - Anglais O: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDEF8", 774612507188527105L);
        // MoneyBag - Espagnol: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCB0", 774612732153430026L);
        // Money_With_Wings - Allemand: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCB8", 774612890980319232L);
        // Dog - Math A: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDC36", 774613051559116802L);
        // Cat - Math W: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDC31", 774613119179816970L);
        // Boomerang - Physique-Chimie: Emoji - Role
        reactionRolesToRoleID.put("\uD83E\uDE83", 774613189848858638L);
        // Airplane - LLCE Anglais: Emoji - Role
        reactionRolesToRoleID.put("✈️", 774613285478858752L);
        // Butterfly - SVT: Emoji - Role
        reactionRolesToRoleID.put("\uD83E\uDD8B", 774613389904838656L);
        // Hourglass - Histoire Geo-Pol: Emoji - Role
        reactionRolesToRoleID.put("⌛", 774613735934263306L);
        // Sleeping - SES: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDE34", 774614626141863976L);
        // Wrench - SI: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDD27", 774614083831595009L);
        // Hammer_Pick - NSI: Emoji - Role
        reactionRolesToRoleID.put("⚒️", 774614216476459050L);
        // Globe_with_Meridians - Humanité-Philo: Emoji - Role
        reactionRolesToRoleID.put("\uD83C\uDF10", 774613752309481512L);

    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e){

        if(e.getGuild().getIdLong() == guildID){

            if(e.getChannel().getIdLong() == rolesChannelID){

                Long roleID = reactionRolesToRoleID.get(e.getReactionEmote().getName());
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

                Long roleID = reactionRolesToRoleID.get(e.getReactionEmote().getName());
                if(roleID == null) return;

                e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();

                //Logger.info(ConsoleColors.ANSI_CYAN + "[ SERVER ][ " + e.getGuild().getName() + " ] " + ConsoleColors.ANSI_BLUE + "Removed role " + e.getJDA().getRoleById(roleID).getName() + " to " + e.getUser().getName() + "#" + e.getUser().getDiscriminator() + ".");

            }

        }

    }

}
