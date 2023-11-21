package com.insignic.bot.utils.members;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;

import java.util.Random;

public class AleatoryJoinMessages {

    public static String getMessage(User user, Guild guild){

        Random random = new Random();
        int randomInt = 1 + random.nextInt() * (3 - 1);

        if(randomInt == 1){

            return "Welcome **" + user.getName() + "** on **" + guild.getName() + "** server !";

        }

        if(randomInt == 2){

            return "Hello **" + user.getName() + "**, welcome to **" + guild.getName() + "** Discord server !";

        }

        if(randomInt == 3){

            return "Welcome **" + user.getName() + "**, on **" + guild.getName() + "** Discord server, we hope you have a good time !";

        }

        return "Welcome **" + user.getName() + "** on **" + guild.getName() + "** server !";

    }

}
