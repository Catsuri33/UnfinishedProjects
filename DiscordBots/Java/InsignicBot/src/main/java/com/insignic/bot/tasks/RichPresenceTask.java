package com.insignic.bot.tasks;


import com.insignic.bot.InsignicBot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;

import java.util.TimerTask;

public class RichPresenceTask extends TimerTask {

    private JDA jda = InsignicBot.jda;
    private int timer = 0;

    public void run(){

        if(timer == 1){

            // Servers Presence
            jda.getPresence().setActivity(Activity.watching(jda.getGuilds().size() + " servers !"));

        }

        if(timer == 20){

            // Users Presence
            int totalMembers = 0;
            for(int i = 0; i < jda.getGuilds().size(); i++){

                Guild guild = jda.getGuilds().get(i);
                totalMembers = totalMembers + guild.getMemberCount();

            }

            jda.getPresence().setActivity(Activity.watching(totalMembers + " users !"));

        }

        if(timer == 40){

            // Servers Presence
            jda.getPresence().setActivity(Activity.watching("i!help"));

        }

        if(timer == 60){

            timer = 0;

        }

        timer++;

    }

}
