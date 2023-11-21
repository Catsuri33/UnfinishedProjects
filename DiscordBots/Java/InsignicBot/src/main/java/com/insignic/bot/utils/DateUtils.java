package com.insignic.bot.utils;

import java.util.Date;

public class DateUtils {

    public static boolean compareDates(String date1, Date date2){

        String dateString = String.valueOf(date2);
        String[] accountCreationDateSplit = date1.split(" ");
        String[] dateSplit = dateString.split(" ");

        String monthCreation = accountCreationDateSplit[1];
        String dayCreation = accountCreationDateSplit[2];
        String timeCreation = accountCreationDateSplit[3];
        String yearCreation = accountCreationDateSplit[5];

        String[] timeCreationSplit = timeCreation.split(":");
        String hoursCreation = timeCreationSplit[0];
        String minutesCreation = timeCreationSplit[1];
        String secondsCreation = timeCreationSplit[2];
        Integer hoursCreationInt = Integer.valueOf(hoursCreation);
        Integer minutesCreationInt = Integer.valueOf(minutesCreation);
        Integer secondsCreationInt = Integer.valueOf(secondsCreation);

        String monthDate = dateSplit[1];
        String dayDate = dateSplit[2];
        String timeDate = dateSplit[3];
        String yearDate = dateSplit[5];

        String[] timeDateSplit = timeDate.split(":");
        String hoursDate = timeDateSplit[0];
        String minutesDate = timeDateSplit[1];
        String secondsDate = timeDateSplit[2];
        Integer hoursDateInt = Integer.valueOf(hoursDate);
        Integer minutesDateInt = Integer.valueOf(minutesDate);
        Integer secondsDateInt = Integer.valueOf(secondsDate);

        Integer dayDateInt = Integer.valueOf(dayDate);
        Integer dayCreationInt = Integer.valueOf(dayCreation);
        Integer yearDateInt = Integer.valueOf(yearDate);
        Integer yearCreationInt = Integer.valueOf(yearCreation);

        if(monthDate.equals(monthCreation)){

            if(dayDateInt >= dayCreationInt){

                if(hoursDateInt >= hoursCreationInt && minutesDateInt >= minutesCreationInt && secondsDateInt >= secondsCreationInt){

                    if(yearDateInt == (yearCreationInt + getDifference(date1, date2))){

                        return true;

                    }

                }

            }

        }

        return false;

    }

    public static Integer getDifference(String date1, Date date2){

        String dateString = String.valueOf(date2);
        String[] accountCreationDateSplit = date1.split(" ");
        String[] dateSplit = dateString.split(" ");

        String yearCreation = accountCreationDateSplit[5];
        String yearDate = dateSplit[5];

        Integer yearDateInt = Integer.valueOf(yearDate);
        Integer yearCreationInt = Integer.valueOf(yearCreation);

        Integer difference = yearDateInt - yearCreationInt;

        return difference;

    }

}
