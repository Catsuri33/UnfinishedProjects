package com.insignic.network.database;

public interface DatabaseManager {

    DatabaseManager instance = new MongoDb();

    // InsignicAccounts
    // Users
    String getPassword(String username);
    void setPassword(long discordUserId, String password);

    boolean hasAccount(String username);
    String getNickname(String uuid);
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

    String getRank(String uuid);
    void setRank(String uuid, String rank);

    Integer getLevel(long discordUserId);
    void addLevel(long discordUserId, Integer amountLevel);
    void removeLevel(long discordUserId, Integer amountLevel);
    void setLevel(long discordUserId, Integer level);

    Integer getXP(String uuid);
    void addXP(String uuid, Integer amountXP);
    void removeXP(String uuid, Integer amountXP);
    void setXP(String uuid, Integer xp);

    Double getInsiCoins(String uuid);
    void addInsiCoins(String uuid, Double amountInsiCoins);
    void removeInsiCoins(String uuid, Double amountInsiCoins);
    void setInsiCoins(String uuid, Double insiCoins);

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

    String getCreationDate(long discordUserId);

    String getMinecraftAccountUUID(String nickname);
    void setMinecraftAccountUUID(String nickname, String uuid);

    // InsignicNetwork
    String getUsername(String uuid);
    void setUsername(String uuid, String username);

    // Statistics
    Integer getStatTotalPlayers();
    void setStatTotalPlayers(Integer number);
    void addStatTotalPlayers(Integer amount);

}
