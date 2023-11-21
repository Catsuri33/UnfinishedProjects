package fr.epicgiant.hub.database.ranks;

import java.util.Arrays;

public enum RankUnit {
    ADMINISTRATOR("Administrator", 0, "§4§l[Administrator] §r§c"),
    SUPERVISOR("Supervisor", 1, "§c[Supervisor] "),
    DEVELOPER("Developer", 2, "§2[Developer] "),
    MODERATOR("Moderator", 3, "§1[Moderator] §f"),
    BUILDER("Builder", 4, "§b[Builder] §f"),
    HELPER("Helper", 5, "§9[Helper] §f"),
    YOUTUBER("Youtuber", 6, "§c[§fYoutuber§c] §f"),
    LEGEND("Legend", 7, "§l§6[§aLegend§6] §r§f"),
    EPICVIP("EpicVIP", 8, "§a[EpicVIP] §f"),
    VIPMORE("VIP+", 9, "§3[VIP+] §f"),
    VIP("VIP", 10, "§e[VIP] §f"),
    LITTLEVIP("LittleVIP", 11, "§d[LittleVIP] §f"),
    PLAYER("Player", 12, "§7");

    private String name;
    private int power;
    private String prefix;

    RankUnit(String name, int power, String prefix) {
        this.name = name;
        this.power = power;
        this.prefix = prefix;
    }

    public static RankUnit getByName(String name){
        return Arrays.stream(values()).filter(r -> r.getName().equalsIgnoreCase(name)).findAny().orElse(RankUnit.PLAYER);
    }

    public static RankUnit getByPower(int power){
        return Arrays.stream(values()).filter(r -> r.getPower() == power).findAny().orElse(RankUnit.PLAYER);
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getPrefix() {
        return prefix;
    }
}
