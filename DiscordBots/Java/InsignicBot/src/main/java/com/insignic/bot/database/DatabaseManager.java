package com.insignic.bot.database;

public interface DatabaseManager {

    DatabaseManager instance = new MongoDb();

    String getGuildName(long guildId);
    void setGuildName(long guildId, String newName);

    String getPrefix(long guildId);
    void setPrefix(long guildId, String newPrefix);

    String getIdChannelNews(long guildId);
    void setIdChannelNews(long guildId, String channelId);

    String getIdChannelWelcome(long guildId);
    void setIdChannelWelcome(long guildId, String channelId);

    // InsignicAccounts
    // Users
    String getPassword(long discordUserId);
    void setPassword(long discordUserId, String password);

    String getNickname(long discordUserId);
    void setNickname(long discordUserId, String password);

    String getFirstName(long discordUserId);
    void setFirstName(long discordUserId, String firstName);

    String getLastName(long discordUserId);
    void setLastName(long discordUserId, String lastName);

    String getEmail(long discordUserId);
    void setEmail(long discordUserId, String email);

    String getEmailState(long discordUserId);
    void setEmailState(long discordUserId, Integer state);

    String getEmailCode(long discordUserId);
    void setEmailCode(long discordUserId, String code);

    String getRank(long discordUserId);
    void setRank(long discordUserId, String rank);

    Integer getLevel(long discordUserId);
    void addLevel(long discordUserId, Integer amountLevel);
    void removeLevel(long discordUserId, Integer amountLevel);
    void setLevel(long discordUserId, Integer level);

    Integer getXP(long discordUserId);
    void addXP(long discordUserId, Integer amountXP);
    void removeXP(long discordUserId, Integer amountXP);
    void setXP(long discordUserId, Integer xp);

    Double getInsiCoins(long discordUserId);
    void addInsiCoins(long discordUserId, Double amountInsiCoins);
    void removeInsiCoins(long discordUserId, Double amountInsiCoins);
    void setInsiCoins(long discordUserId, Double insiCoins);

    Integer getAccountState(long discordUserId);
    void setAccountState(long discordUserId, Integer state);

    Long getBanTime(long discordUserId);
    void setBanTime(long discordUserId, Long time);

    String getBanReason(long discordUserId);
    void setBanReason(long discordUserId, String reason);

    String getBanAuthor(long discordUserId);
    void setBanAuthor(long discordUserId, String author);

    Integer getBanTotal(long discordUserId);
    void addBanTotal(long discordUserId, Integer banAmount);
    void removeBanTotal(long discordUserId, Integer banAmount);
    void setBanTotal(long discordUserId, Integer number);

    String getState(long discordUserId);
    void setState(long discordUserId, String state);

    String getActivity(long discordUserId);
    void setActivity(long discordUserId, String state);

    String getCreationDate(long discordUserId);

    // Badges
    String getBadges(long discordUserId);
    void addBadges(long discordUserId, String badge);
    void removeBadges(long discordUserId, String badge);
    void setBadges(long discordUserId, String badge);

    // Achievements
    Boolean getAchievementState(long discordUserId, String achievementName);
    void setAchievementState(long discordUserId, String achievementName, boolean state);

}
