package com.insignic.bot.utils;

import com.insignic.bot.database.DatabaseManager;

public class BadgesManager {

    public static String getBadges(Long userId){

        String badgesString = DatabaseManager.instance.getBadges(userId);
        String badgesEmojis = "";

        if(badgesString.contains("discord_staff")){

            badgesEmojis = badgesEmojis + " <:discord_staff:778337630411554887>";

        }

        if(badgesString.contains("insignic_staff")){

            badgesEmojis = badgesEmojis + " <:insignic_staff:777978937824903178>";

        }

        if(badgesString.contains("verified")){

            badgesEmojis = badgesEmojis + " <:verified:778337659885584386>";

        }

        if(badgesString.contains("account_creation_1")){

            badgesEmojis = badgesEmojis + " <:account_creation_1:806503364031676456>";

        }

        return badgesEmojis;

    }

    public static String getBadgesWithDesc(Long userId){

        String badgesString = DatabaseManager.instance.getBadges(userId);
        String badgesEmojis = "";

        if(badgesString.contains("discord_staff")){

            badgesEmojis = badgesEmojis + " <:discord_staff:778337630411554887>: Badge for Discord employees.-";

        }

        if(badgesString.contains("insignic_staff")){

            badgesEmojis = badgesEmojis + " <:insignic_staff:777978937824903178>: Badge for Insignic employees.-";

        }

        if(badgesString.contains("verified")){

            badgesEmojis = badgesEmojis + " <:verified:778337659885584386>: Badge for verified partners/creators...-";

        }

        if(badgesString.contains("account_creation_1")){

            badgesEmojis = badgesEmojis + " <:account_creation_1:806503364031676456>: Badge for 1 year of an account.";

        }

        return badgesEmojis;

    }

}
