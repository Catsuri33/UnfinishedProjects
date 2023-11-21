package com.insignicnetwork.bungeecord.divisions;


import java.util.Arrays;

public enum DivisionList {

    INSIGNIC("Insignic", "§6I§en§6s§ei§6g§en§6i§ec "),
    INFERIUMIII("Inferium III", "§5Inferium III "),
    INFERIUMII("Inferium II", "§5Inferium II "),
    INFERIUMI("Inferium I", "§5Inferium I "),
    GOLDIII("Gold III", "§eOr III "),
    GOLDII("Gold II", "§eOr II "),
    GOLDI("Gold I", "§eOr I "),
    SILVERIII("Silver III", "§7Argent III "),
    SILVERII("Silver II", "§7Argent II "),
    SILVERI("Silver I", "§7Argent I "),
    PLATINUMIII("Platinum III", "§8Platine III "),
    PLATINUMII("Platinum II", "§8Platine II "),
    PLATINUMI("Platinum I", "§8Platine I "),
    BRONZEIII("Bronze III", "§6Bronze III "),
    BRONZEII("Bronze II", "§6Bronze II "),
    BRONZEI("Bronze I", "§6Bronze I "),
    DIRTIII("Dirt III", "§2Terre III "),
    DIRTII("Dirt II", "§2Terre II "),
    DIRTI("Dirt I", "§2Terre I ");

    private String name;
    private String prefix;

    DivisionList(String name, String prefix){

        this.name = name;
        this.prefix = prefix;

    }

    public static DivisionList getByName(String name){

        return Arrays.stream(values()).filter(r -> r.getName().equalsIgnoreCase(name)).findAny().orElse(DivisionList.DIRTI);

    }

    public String getName() {

        return name;

    }

    public String getPrefix() {

        return prefix;

    }

}
