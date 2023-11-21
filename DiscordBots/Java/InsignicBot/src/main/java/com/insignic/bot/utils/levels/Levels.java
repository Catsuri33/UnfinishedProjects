package com.insignic.bot.utils.levels;

public enum Levels {

    LEVEL_1(1,200),
    LEVEL_2(2,400),
    LEVEL_3(3,600),
    LEVEL_4(4,800),
    LEVEL_5(5,1000),
    LEVEL_6(6,1200),
    LEVEL_7(7,1400),
    LEVEL_8(8,1600),
    LEVEL_9(9,1800),
    LEVEL_10(10,2000);

    private Integer level;
    private Integer xpNeeded;

    Levels(Integer level, Integer xpNeeded){

        this.level = level;
        this.xpNeeded = xpNeeded;

    }

    public static Integer getXPNeeded(Integer level){

        Levels levelValue = Levels.valueOf("LEVEL_" +  (level + 1));

        return levelValue.xpNeeded;

    }

}
