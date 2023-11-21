package com.insignic.bot.utils;

import java.util.HashMap;

public enum TimeUtils {

    SECOND("Seconds", "sec", 1),
    MINUTE("Minutes", "min", 60),
    HOUR("Hours", "h", 3600),
    DAY("Days", "d", 86400),
    MONTH("Months", "m", 2592000),
    YEAR("Years", "y", 31104000);

    private String unitName;
    private String unitShortcut;
    private long unitSeconds;
    private static HashMap<String, TimeUtils> idShortcut = new HashMap<>();

    TimeUtils(String unitName, String unitShortcut, long unitSeconds){

        this.unitName = unitName;
        this.unitShortcut = unitShortcut;
        this.unitSeconds = unitSeconds;

    }

    static {

        for(TimeUtils units : values()){

            idShortcut.put(units.unitShortcut, units);

        }

    }

    public static TimeUtils getFromShortcut(String unitShortcut){

        return idShortcut.get(unitShortcut);

    }

    public String getUnitName() {

        return unitName;

    }

    public String getUnitShortcut() {

        return unitShortcut;

    }

    public long getUnitSeconds() {

        return unitSeconds;

    }

}
