package com.insignic.calculator.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final Date date = new Date();

    public static void success(String message){

        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(int message){

        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(long message){

        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(double message){

        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(boolean message){

        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(String message){

        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(int message){

        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(long message){

        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(double message){

        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(boolean message){

        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(String message){

        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(int message){

        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(long message){

        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(double message){

        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(boolean message){

        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(String message){

        System.out.println(ConsoleColors.ANSI_RED + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(int message){

        System.out.println(ConsoleColors.ANSI_RED + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(long message){

        System.out.println(ConsoleColors.ANSI_RED + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(double message){

        System.out.println(ConsoleColors.ANSI_RED + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(boolean message){

        System.out.println(ConsoleColors.ANSI_RED + "[ " + dateFormat.format(date) + " ]" + "[ InsignicCalculator ] " + message + ConsoleColors.ANSI_WHITE);

    }

}


