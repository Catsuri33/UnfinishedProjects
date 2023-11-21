package com.insignic.lifebuyer.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static LocalDateTime localDate;
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static String formattedDate;

    public static void info(String message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.blue + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void info(Integer message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.blue + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void info(Long message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.blue + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void info(Double message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.blue + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void info(Float message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.blue + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void info(Boolean message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.blue + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void error(String message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.red + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void error(Integer message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.red + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void error(Long message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.red + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void error(Double message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.red + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void error(Float message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.red + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

    public static void error(Boolean message){

        localDate = LocalDateTime.now();
        formattedDate = localDate.format(dateFormat);
        System.out.println(ConsoleColors.red + "[" + formattedDate + "]" + "[LifeBuyer]" + " " + message);

    }

}
