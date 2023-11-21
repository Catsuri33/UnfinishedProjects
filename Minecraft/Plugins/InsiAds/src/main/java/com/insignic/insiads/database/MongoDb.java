package com.insignic.insiads.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;

public class MongoDb implements DatabaseManager {

    private static final String uriDbInsignicAds = "URI";
    public static final ConnectionString dbInsignicAdsConnString = new ConnectionString(uriDbInsignicAds);
    public static final MongoClientSettings dbInsignicAdsSettings = MongoClientSettings.builder().applyConnectionString(dbInsignicAdsConnString).retryWrites(true).build();
    public static final MongoClient mongoClientInsignicAds = MongoClients.create(dbInsignicAdsSettings);
    public static final MongoDatabase mongoDatabaseInsignicAds = mongoClientInsignicAds.getDatabase("InsignicAds");

    public static final MongoCollection insignicAdsCollection = mongoDatabaseInsignicAds.getCollection("insignic_ads");
    public static final MongoCollection serversCollection = mongoDatabaseInsignicAds.getCollection("servers");
    public static final MongoCollection adCampaignsCollection = mongoDatabaseInsignicAds.getCollection("ad_campaigns");

    public MongoDb(){



    }

    @Override
    public Double getTotalMoney(){

        Document found = (Document) insignicAdsCollection.find(new Document("insignic", "insignic")).first();

        if(found != null){

            return Double.valueOf(found.get("total_money").toString());

        }

        return 0.00;

    }

    @Override
    public void setTotalMoney(Double amount){

        Document found = (Document) insignicAdsCollection.find(new Document("insignic", "insignic")).first();

        if(found != null){

            Bson updateValue = new Document("total_money", amount);
            Bson updateOperation = new Document("$set", updateValue);

            insignicAdsCollection.updateOne(found, updateOperation);

        }

    }

    @Override
    public Double getAvaibleMoney(){

        Document found = (Document) insignicAdsCollection.find(new Document("insignic", "insignic")).first();

        if(found != null){

            return Double.valueOf(found.get("money_avaible").toString());

        }

        return 0.00;

    }

    @Override
    public void setAvaibleMoney(Double amount){

        Document found = (Document) insignicAdsCollection.find(new Document("insignic", "insignic")).first();

        if(found != null){

            Bson updateValue = new Document("money_avaible", amount);
            Bson updateOperation = new Document("$set", updateValue);

            insignicAdsCollection.updateOne(found, updateOperation);

        }

    }

    @Override
    public Double getPayMoney(){

        Document found = (Document) insignicAdsCollection.find(new Document("insignic", "insignic")).first();

        if(found != null){

            return Double.valueOf(found.get("money_pay").toString());

        }

        return 0.00;

    }

    @Override
    public void setPayMoney(Double amount){

        Document found = (Document) insignicAdsCollection.find(new Document("insignic", "insignic")).first();

        if(found != null){

            Bson updateValue = new Document("money_pay", amount);
            Bson updateOperation = new Document("$set", updateValue);

            insignicAdsCollection.updateOne(found, updateOperation);

        }

    }

    @Override
    public Boolean isServerCreated(String serverID) {

        Document foundServer = (Document) serversCollection.find(new Document("server_id", serverID)).first();

        if(foundServer != null){

            return true;

        }

        return false;

    }

    @Override
    public void createServer(String serverID){

        Document foundServerID = (Document) serversCollection.find(new Document("server_id", serverID)).first();

        if(foundServerID == null) {

            Document newServer = new Document("id", serversCollection.countDocuments() + 1);
            newServer.append("server_id", serverID);
            newServer.append("owner_uuid", "");
            newServer.append("state", "offline");
            newServer.append("rate", 0.2);
            newServer.append("money", 0);

            serversCollection.insertOne(newServer);

        }

    }

    @Override
    public void changeServerState(String serverID, String state){

        Document foundServerID = (Document) serversCollection.find(new Document("server_id", serverID)).first();

        if(foundServerID != null) {

            Bson updateValue = new Document("state", state);
            Bson updateOperation = new Document("$set", updateValue);

            serversCollection.updateOne(foundServerID, updateOperation);

        }

    }

    @Override
    public void setOwnerUUID(String serverID, String ownerUUID){

        Document foundServerID = (Document) serversCollection.find(new Document("server_id", serverID)).first();

        if(foundServerID != null) {

            Bson updateValue = new Document("owner_uuid", ownerUUID);
            Bson updateOperation = new Document("$set", updateValue);

            serversCollection.updateOne(foundServerID, updateOperation);

        }

    }

    @Override
    public String getOwnerUUID(String serverID) {

        Document foundServerID = (Document) serversCollection.find(new Document("server_id", serverID)).first();

        if(foundServerID != null){

            return foundServerID.get("owner_uuid").toString();

        }

        return "";

    }

    public void setServerMoney(String serverID, Double moneyAmount){

        Document foundServerID = (Document) serversCollection.find(new Document("server_id", serverID)).first();

        if(foundServerID != null) {

            Bson updateValue = new Document("money", moneyAmount);
            Bson updateOperation = new Document("$set", updateValue);

            serversCollection.updateOne(foundServerID, updateOperation);

        }

    }

    public Double getServerMoney(String serverID){

        Document foundServerID = (Document) serversCollection.find(new Document("server_id", serverID)).first();

        if(foundServerID != null){

            return Double.valueOf(foundServerID.get("money").toString());

        }

        return 0.00;

    }

    @Override
    public Boolean isCampaignAvaible(){

        Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("state", "avaible")).first();

        if(foundAdCampaign != null){

            return true;

        }

        return false;

    }

    @Override
    public Integer getTotalAdCampaignAvaible(){

        Integer nbCampaigns = 0;

        for(int i = 1; i < adCampaignsCollection.countDocuments() + 1; i++){

            Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("id", i)).first();

            if(foundAdCampaign != null){

                nbCampaigns = nbCampaigns + 1;

            }

        }

        return nbCampaigns;

    }

    @Override
    public String getAdCampaignAvaible(){

        Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("state", "avaible")).first();

        if(foundAdCampaign != null){

            return foundAdCampaign.get("name").toString();

        }

        return "";

    }

    @Override
    public String getRandomAdCampaignAvaible(){

        AggregateIterable foundRandom = adCampaignsCollection.aggregate(Arrays.asList(Aggregates.sample(1)));
        Document foundRandomAdCampaign = (Document) foundRandom.first();

        if(foundRandomAdCampaign != null){

            if(!foundRandomAdCampaign.get("state").toString().equals("avaible")){

                while(!foundRandomAdCampaign.get("state").toString().equals("avaible")){

                    foundRandom = adCampaignsCollection.aggregate(Arrays.asList(Aggregates.sample(1)));
                    foundRandomAdCampaign = (Document) foundRandom.first();

                }

                return foundRandomAdCampaign.get("name").toString();

            } else {

                return foundRandomAdCampaign.get("name").toString();

            }

        }

        return "";

    }

    @Override
    public String getAdCampaignState(String adCampaignName){

        Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("name", adCampaignName)).first();

        if(foundAdCampaign != null){

            return foundAdCampaign.get("state").toString();

        }

        return "";

    }

    @Override
    public void setAdCampaignState(String adCampaignName, String state){

        Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("name", adCampaignName)).first();

        if(foundAdCampaign != null){

            Bson updateValue = new Document("state", state);
            Bson updateOperation = new Document("$set", updateValue);

            adCampaignsCollection.updateOne(foundAdCampaign, updateOperation);

        }

    }

    @Override
    public String getAdCampaignMessage(String adCampaignName){

        Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("name", adCampaignName)).first();

        if(foundAdCampaign != null){

            return foundAdCampaign.get("message").toString();

        }

        return "";

    }

    @Override
    public Integer getAdCampaignViewsTo(String adCampaignName){

        Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("name", adCampaignName)).first();

        if(foundAdCampaign != null){

            return Integer.valueOf(foundAdCampaign.get("views_to").toString());

        }

        return 0;

    }

    @Override
    public void setAdCampaignViewsTo(Integer viewsToAmount, String adCampaignName){

        Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("name", adCampaignName)).first();

        if(foundAdCampaign != null){

            Bson updateValue = new Document("views_to", viewsToAmount);
            Bson updateOperation = new Document("$set", updateValue);

            adCampaignsCollection.updateOne(foundAdCampaign, updateOperation);

        }

    }

    @Override
    public Integer getAdCampaignViews(String adCampaignName){

        Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("name", adCampaignName)).first();

        if(foundAdCampaign != null){

            return Integer.valueOf(foundAdCampaign.get("views").toString());

        }

        return 0;

    }

    @Override
    public void setAdCampaignViews(Integer viewsAmount, String adCampaignName){

        Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("name", adCampaignName)).first();

        if(foundAdCampaign != null){

            Bson updateValue = new Document("views", viewsAmount);
            Bson updateOperation = new Document("$set", updateValue);

            adCampaignsCollection.updateOne(foundAdCampaign, updateOperation);

        }

    }

    @Override
    public Double getAdCampaignPrice(String adCampaignName){

        Document foundAdCampaign = (Document) adCampaignsCollection.find(new Document("name", adCampaignName)).first();

        if(foundAdCampaign != null){

            return Double.valueOf(foundAdCampaign.get("price").toString());

        }

        return 0.00;

    }

    @Override
    public void setRate(String serverID, Float rate){

        Document foundServerID = (Document) serversCollection.find(new Document("server_id", serverID)).first();

        if(foundServerID != null){

            Bson updateValue = new Document("rate", rate);
            Bson updateOperation = new Document("$set", updateValue);

            adCampaignsCollection.updateOne(foundServerID, updateOperation);

        }

    }

    @Override
    public Float getRate(String serverID){

        Document foundServerID = (Document) serversCollection.find(new Document("server_id", serverID)).first();

        if(foundServerID != null){

            return Float.valueOf(foundServerID.get("rate").toString());

        }

        return 0.0f;

    }

}
