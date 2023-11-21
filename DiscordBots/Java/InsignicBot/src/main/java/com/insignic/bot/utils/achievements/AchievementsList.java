package com.insignic.bot.utils.achievements;

public enum AchievementsList {

    CREATE_INSIGNIC_ACCOUNT(1, "create_insignic_account"),
    INVITE_BOT_SERVER(2, "invite_bot_server");

    public static Integer achievementsNumber = 2;
    private String bddName;
    private Integer id;

    AchievementsList(Integer id, String bddName){

        this.bddName = bddName;
        this.id = id;

    }

    public String getBddName(){

        return bddName;

    }

    public Integer getId(){

        return id;

    }

}
