package com.insignicnetwork.lobbyctf.mysql.ranks;

import java.util.Arrays;

public enum RanksList {

    ADMINISTRATOR("Administrator", "§cADMIN "),
    RESPONSABLE("Responsable", "§6RESP "),
    MODERATOR("Moderator", "§9MOD "),
    HELPER("Helper", "§3HELP "),
    BUILDER("Builder", "§2BUILD "),
    COMMUNITY_MANAGER("Community-Manager", "§eCM "),
    FRIEND("Friend", "§bFRIEND "),
    PLAYER("Player", "§7");

    private String name;
    private String prefix;

    RanksList(String name, String prefix){

        this.name = name;
        this.prefix = prefix;

    }

    public static RanksList getByName(String name){

        return Arrays.stream(values()).filter(r -> r.getName().equalsIgnoreCase(name)).findAny().orElse(RanksList.PLAYER);

    }

    public String getName() {

        return name;

    }

    public String getPrefix() {

        return prefix;

    }

}
