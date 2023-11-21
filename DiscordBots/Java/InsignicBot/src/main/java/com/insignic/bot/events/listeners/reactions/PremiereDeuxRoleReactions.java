package com.insignic.bot.events.listeners.reactions;

import com.insignic.bot.utils.ConsoleColors;
import com.insignic.bot.utils.Logger;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;

public class PremiereDeuxRoleReactions extends ListenerAdapter {

    private long rolesChannelID = 775265982549721089L;
    private long guildID = 775255428568973312L;
    private HashMap<String, Long> reactionRolesToRoleID = new HashMap<>();

    public PremiereDeuxRoleReactions(){

        // Roles
        // Alembic - SVT-Physique 1: Emoji - Role
        reactionRolesToRoleID.put("⚗️", 775268496875192321L);
        // Microbe - SVT-Physique 2: Emoji - Role
        reactionRolesToRoleID.put("\uD83E\uDDA0", 775268526935113728L);
        // Blue_Book - Anglais C: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCD8", 775267451423686686L);
        // Newspaper - Anglais O: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCF0", 775267478610640916L);
        // Telephone - Anglais R: Emoji - Role
        reactionRolesToRoleID.put("☎️", 775282902199173160L);
        // Flag_ES - Espagnol Cuyeu: Emoji - Role
        reactionRolesToRoleID.put("\uD83C\uDF0D", 775267295466356757L);
        // Flag_DE - Allemand: Emoji - Role
        reactionRolesToRoleID.put("\uD83C\uDF7A", 775267363582771230L);
        // Triangular_Ruler - Math A: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCD0", 775267255817994241L);
        // Straight_Ruler - Math W: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCCF", 775267220053557288L);
        // Test_Tube - Physique-Chimie: Emoji - Role
        reactionRolesToRoleID.put("\uD83E\uDDEA", 775270859039965234L);
        // Calendar - LLCE Anglais: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCC6", 775272311766646804L);
        // DNA - SVT: Emoji - Role
        reactionRolesToRoleID.put("\uD83E\uDDEC", 775270889196879954L);
        // Globe_With_Meridians - Histoire Geo-Pol: Emoji - Role
        reactionRolesToRoleID.put("\uD83C\uDF10", 775272338073321522L);
        // Bar_Chart - SES: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCCA", 775271610731069441L);
        // Wrench - SI: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDD27", 775271625611935784L);
        // Computer - NSI: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCBB", 775271636064141313L);
        // Notebook_With_Decorative_Cover - Humanité-Philo: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCD4", 775272364082593792L);
        //  - Anglais-Euro: Emoji - Role
        reactionRolesToRoleID.put("\uD83D\uDCB6", 775272410831781928L);

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
