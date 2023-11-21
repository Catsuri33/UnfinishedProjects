package com.insignic.bot.utils.ban;

import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.utils.TimeUtils;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class BanManager {

    public void ban(User user, TextChannel channel, List<String> args, long endInSeconds, String reason, String authorName){

        if(isBanned(user)){

            channel.sendMessage("Error, this user is already banned !").queue();
            return;

        }

        long endInMillis = endInSeconds * 1000;
        long end = endInMillis + System.currentTimeMillis();

        DatabaseManager.instance.setAccountState(user.getIdLong(), 1);
        if(args.get(1).equalsIgnoreCase("-1")){

            DatabaseManager.instance.setBanTime(user.getIdLong(), -1L);

        } else {

            DatabaseManager.instance.setBanTime(user.getIdLong(), end);

        }
        DatabaseManager.instance.setBanReason(user.getIdLong(), reason);
        DatabaseManager.instance.setBanAuthor(user.getIdLong(), authorName);
        DatabaseManager.instance.addBanTotal(user.getIdLong(), 1);

        channel.sendMessage("You have banned " + user.getAsMention() + " InsignicAccount account.").queue();
        user.openPrivateChannel().queue(privateChannel -> {

            privateChannel.sendMessage("__**InsignicAccounts**__\n\nYour account has been banned by '" + authorName + "' for '" + reason + "' !\nTime left: **" + getTimeLeft(user) + "**").queue();

        });

    }

    public void unban(User user){

        if(!isBanned(user)) return;

        DatabaseManager.instance.setAccountState(user.getIdLong(), 0);
        DatabaseManager.instance.setBanTime(user.getIdLong(), 0L);
        DatabaseManager.instance.setBanReason(user.getIdLong(), "");
        DatabaseManager.instance.setBanAuthor(user.getIdLong(), "");

        user.openPrivateChannel().queue(privateChannel -> {

            privateChannel.sendMessage("__**InsignicAccounts**__\n\nYour account has been unbanned !").queue();

        });

    }

    public boolean isBanned(User user){

        if(DatabaseManager.instance.getNickname(user.getIdLong()) != null){

            if(DatabaseManager.instance.getAccountState(user.getIdLong()) == 1){

                return true;

            }

        } else {

            return false;

        }

        return false;

    }

    public void checkDuration(User user){

        if(!isBanned(user)) return;

        if(getEnd(user) == -1){

            return;

        }

        if(getEnd(user) < System.currentTimeMillis()){

            unban(user);

        }

    }

    public long getEnd(User user){

        if(!isBanned(user)) return 0;

        if(DatabaseManager.instance.getBanTime(user.getIdLong()) != 0){

            return DatabaseManager.instance.getBanTime(user.getIdLong());

        }

        return -1;

    }

    public String getTimeLeft(User user){

        if(!isBanned(user)) return "";

        if(getEnd(user) == -1){

            return "Definitive";

        }

        long timeLeft = (getEnd(user) - System.currentTimeMillis()) / 1000;
        int years = 0;
        int months = 0;
        int days = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        while(timeLeft >= TimeUtils.YEAR.getUnitSeconds()){

            years++;
            timeLeft -= TimeUtils.YEAR.getUnitSeconds();

        }

        while(timeLeft >= TimeUtils.MONTH.getUnitSeconds()){

            months++;
            timeLeft -= TimeUtils.MONTH.getUnitSeconds();

        }

        while(timeLeft >= TimeUtils.DAY.getUnitSeconds()){

            days++;
            timeLeft -= TimeUtils.DAY.getUnitSeconds();

        }

        while(timeLeft >= TimeUtils.HOUR.getUnitSeconds()){

            hours++;
            timeLeft -= TimeUtils.HOUR.getUnitSeconds();

        }

        while(timeLeft >= TimeUtils.MINUTE.getUnitSeconds()){

            minutes++;
            timeLeft -= TimeUtils.MINUTE.getUnitSeconds();

        }

        while(timeLeft >= TimeUtils.SECOND.getUnitSeconds()){

            seconds++;
            timeLeft -= TimeUtils.SECOND.getUnitSeconds();

        }

        return years + " " + TimeUtils.YEAR.getUnitName() + ", " + months + " " + TimeUtils.MONTH.getUnitName() + ", " + days + " " + TimeUtils.DAY.getUnitName() + ", " + hours + " " + TimeUtils.HOUR.getUnitName() + ", " + minutes + " " + TimeUtils.MINUTE.getUnitName() + ", " + seconds + " " + TimeUtils.SECOND.getUnitName() + ".";

    }

    public String getReason(User user){

        if(!isBanned(user)) return "";

        if(!DatabaseManager.instance.getBanReason(user.getIdLong()).equals("")){

            return DatabaseManager.instance.getBanReason(user.getIdLong());

        }

        return "";

    }

    public String getAuthor(User user){

        if(!isBanned(user)) return "";

        if(!DatabaseManager.instance.getBanAuthor(user.getIdLong()).equals("")){

            return DatabaseManager.instance.getBanAuthor(user.getIdLong());

        }

        return "";

    }

}
