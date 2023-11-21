package com.insignic.bot.events.listeners;

import com.insignic.bot.InsignicBot;
import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.utils.levels.LevelUtils;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.DecimalFormat;
import java.util.Random;

public class MessageRewards extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){

        Member member = e.getMember();
        User user  = member.getUser();

        if(DatabaseManager.instance.getNickname(member.getIdLong()) != null){

            if(InsignicBot.messageRewardsMap.containsKey(member)){

                if((InsignicBot.messageRewardsMap.get(member) + 3600000) <= System.currentTimeMillis()){

                    InsignicBot.messageRewardsMap.remove(member);

                }

            }

            if(!InsignicBot.messageRewardsMap.containsKey(member)){

                Random random = new Random();
                Integer randomXP = random.nextInt(10 - 1) + 1;
                Double randomInsiCoins = random.nextDouble() * (5 - 1) + 1;
                DecimalFormat df = new DecimalFormat("#.##");
                String replaceInsiCoins = df.format(randomInsiCoins).replace(",",  ".");
                Double randomInsiCoinsRound = Double.valueOf(replaceInsiCoins);

                DatabaseManager.instance.addXP(member.getIdLong(), randomXP);
                DatabaseManager.instance.addInsiCoins(member.getIdLong(), randomInsiCoinsRound);

                InsignicBot.messageRewardsMap.put(member, System.currentTimeMillis());

            }

            LevelUtils.checkLevel(user);

        }

    }

}
