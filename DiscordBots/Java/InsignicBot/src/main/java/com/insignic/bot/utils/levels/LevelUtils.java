package com.insignic.bot.utils.levels;

import com.insignic.bot.database.DatabaseManager;
import net.dv8tion.jda.api.entities.User;

public class LevelUtils {

    public static void checkLevel(User user){

        if(DatabaseManager.instance.getXP(user.getIdLong()) >= Levels.getXPNeeded(DatabaseManager.instance.getLevel(user.getIdLong()))){

            DatabaseManager.instance.removeXP(user.getIdLong(), Levels.getXPNeeded(DatabaseManager.instance.getLevel(user.getIdLong())));
            DatabaseManager.instance.addLevel(user.getIdLong(), 1);

            user.openPrivateChannel().queue(privateChannel -> {

                privateChannel.sendMessage("Your are now level **" + DatabaseManager.instance.getLevel(user.getIdLong()) + "** !").queue();

            });

        }

    }

}
