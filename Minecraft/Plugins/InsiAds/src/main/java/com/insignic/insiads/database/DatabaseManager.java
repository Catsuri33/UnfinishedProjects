package com.insignic.insiads.database;

public interface DatabaseManager {

    DatabaseManager instance = new MongoDb();

    Double getTotalMoney();
    void setTotalMoney(Double amount);
    Double getAvaibleMoney();
    void setAvaibleMoney(Double amount);
    Double getPayMoney();
    void setPayMoney(Double amount);

    Boolean isServerCreated(String serverID);
    void createServer(String serverID);
    void changeServerState(String serverID, String state);
    void setOwnerUUID(String serverID, String ownerUUID);
    String getOwnerUUID(String serverID);
    void setServerMoney(String serverID, Double moneyAmount);
    Double getServerMoney(String serverID);

    Boolean isCampaignAvaible();
    Integer getTotalAdCampaignAvaible();
    String getAdCampaignAvaible();
    String getRandomAdCampaignAvaible();
    String getAdCampaignState(String adCampaignName);
    void setAdCampaignState(String adCampaignName, String state);
    String getAdCampaignMessage(String adCampaignName);
    void setAdCampaignViewsTo(Integer viewsToAmount, String adCampaignName);
    Integer getAdCampaignViewsTo(String adCampaignName);
    void setAdCampaignViews(Integer viewsAmount, String adCampaignName);
    Integer getAdCampaignViews(String adCampaignName);
    Double getAdCampaignPrice(String adCampaignName);
    void setRate(String serverID, Float rate);
    Float getRate(String serverID);

}
