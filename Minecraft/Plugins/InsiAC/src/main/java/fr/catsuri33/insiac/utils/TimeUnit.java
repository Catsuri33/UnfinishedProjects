package fr.catsuri33.insiac.utils;

import java.util.HashMap;

public enum TimeUnit {

    SECOND("Second(s)", "s", 1),
    MINUTE("Minute(s)", "min", 60),
    HOUR("Hour(s)", "h", 60 * 60),
    DAY("Day(s)", "d", 60 * 60 * 24),
    MONTH("Month(s)", "m", 60 * 60 * 24 * 30),
    YEAR("Year(s)", "y", 60 * 60 * 24 * 30 * 12);

    private String name;
    private String shortcut;
    private long timeInSeconds;

    private static HashMap<String, TimeUnit> idShortcut = new HashMap<>();

    private TimeUnit(String name, String shortcut, long timeInSeconds){

        this.name = name;
        this.shortcut = shortcut;
        this.timeInSeconds = timeInSeconds;

    }

    static {

        for(TimeUnit units : values()){

            idShortcut.put(units.shortcut, units);

        }

    }

    public static TimeUnit getFromShortcut(String shortcut){

        return idShortcut.get(shortcut);

    }

    public String getName() {

        return name;

    }

    public String getShortcut() {

        return shortcut;

    }

    public long getTimeInSeconds() {

        return timeInSeconds;

    }

    public static boolean existFromShortcut(String shortcut){

        return idShortcut.containsKey(shortcut);

    }

}
