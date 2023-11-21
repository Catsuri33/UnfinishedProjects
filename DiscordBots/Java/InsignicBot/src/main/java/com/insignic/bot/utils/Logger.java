package com.insignic.bot.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static DateTimeFormatter date = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static LocalDateTime actualDate;

    public static void success(String message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(int message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(long message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(double message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(boolean message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(String message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(int message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(long message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(double message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(boolean message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(String message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(int message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(long message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(double message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(boolean message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(String message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_RED + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(int message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_RED + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(long message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_RED + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(double message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_RED + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(boolean message){

        actualDate = LocalDateTime.now();
        System.out.println(ConsoleColors.ANSI_RED + "[ " + date.format(actualDate) + " ]" + "[ InsignicBot ] " + message + ConsoleColors.ANSI_WHITE);

    }

}
