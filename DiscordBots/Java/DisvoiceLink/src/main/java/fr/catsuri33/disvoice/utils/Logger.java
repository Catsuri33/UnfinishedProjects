package fr.catsuri33.disvoice.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static DateTimeFormatter date = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static LocalDateTime actualDate = LocalDateTime.now();

    public static void success(String message){

        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(int message){

        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(long message){

        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(double message){

        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void success(boolean message){

        System.out.println(ConsoleColors.ANSI_GREEN + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(String message){

        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(int message){

        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(long message){

        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(double message){

        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void info(boolean message){

        System.out.println(ConsoleColors.ANSI_BLUE + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(String message){

        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(int message){

        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(long message){

        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(double message){

        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void warn(boolean message){

        System.out.println(ConsoleColors.ANSI_YELLOW + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(String message){

        System.out.println(ConsoleColors.ANSI_RED + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(int message){

        System.out.println(ConsoleColors.ANSI_RED + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(long message){

        System.out.println(ConsoleColors.ANSI_RED + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(double message){

        System.out.println(ConsoleColors.ANSI_RED + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

    public static void error(boolean message){

        System.out.println(ConsoleColors.ANSI_RED + "[ " + date.format(actualDate) + " ]" + "[ DisvoiceLink ] " + message + ConsoleColors.ANSI_WHITE);

    }

}
