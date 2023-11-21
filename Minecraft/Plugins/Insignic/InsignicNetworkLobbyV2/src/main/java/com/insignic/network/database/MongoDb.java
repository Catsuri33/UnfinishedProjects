package com.insignic.network.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDb implements DatabaseManager {

    private static final String uriDbInsignicnetwork = "URI";
    public static final ConnectionString dbInsignicNetworkConnString = new ConnectionString(uriDbInsignicnetwork);
    public static final MongoClientSettings dbInsignicNetworkSettings = MongoClientSettings.builder().applyConnectionString(dbInsignicNetworkConnString).retryWrites(true).build();
    public static final MongoClient mongoClientInsignicNetwork = MongoClients.create(dbInsignicNetworkSettings);
    public static final MongoDatabase mongoDatabaseInsignicNetwork = mongoClientInsignicNetwork.getDatabase("Database01");

    private static final String uriDbInsignicAccounts = "URI";
    public static final ConnectionString dbInsignicAccountsConnString = new ConnectionString(uriDbInsignicAccounts);
    public static final MongoClientSettings dbInsignicAccountsSettings = MongoClientSettings.builder().applyConnectionString(dbInsignicAccountsConnString).retryWrites(true).build();
    public static final MongoClient mongoClientInsignicAccounts = MongoClients.create(dbInsignicAccountsSettings);
    public static final MongoDatabase mongoDatabaseInsignicAccounts = mongoClientInsignicAccounts.getDatabase("InsignicAccounts");

    public MongoDb(){



    }

    // InsignicAccounts
    @Override
    public boolean hasAccount(String username) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundNickname = (Document) collection.find(new Document("nickname", String.valueOf(username))).first();

        if(foundNickname != null){

            return true;

        }

        return false;

    }

    @Override
    public String getNickname(String uuid) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundMinecraftUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundMinecraftUUID != null){

            return foundMinecraftUUID.get("nickname").toString();

        }

        return null;

    }

    @Override
    public void setNickname(long discordUserId, String nickname) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("nickname", nickname);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getPassword(String username) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundNickname = (Document) collection.find(new Document("nickname", String.valueOf(username))).first();

        if(foundNickname != null){

            return foundNickname.get("password").toString();

        }

        return "";

    }

    @Override
    public void setPassword(long discordUserId, String password) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("password", password);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getEmail(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("email").toString();

        }

        return "";

    }

    @Override
    public void setEmail(long discordUserId, String email) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("email", email);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getEmailState(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("email_state").toString();

        }

        return "";

    }

    @Override
    public void setEmailState(long discordUserId, Integer state) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("email_state", state);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getEmailCode(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("email_code").toString();

        }

        return "";

    }

    @Override
    public void setEmailCode(long discordUserId, String code) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("email_code", code);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getFirstName(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("first_name").toString();

        }

        return null;

    }

    @Override
    public void setFirstName(long discordUserId, String firstName) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("first_name", firstName);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getLastName(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("last_name").toString();

        }

        return null;

    }

    @Override
    public void setLastName(long discordUserId, String lastName) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("last_name", lastName);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getCreationDate(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("creation_date").toString();

        }

        return null;

    }

    @Override
    public String getRank(String uuid) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            return foundUUID.get("rank").toString();

        }

        return null;

    }

    @Override
    public void setRank(String uuid, String rank) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            Bson updateValue = new Document("rank", rank);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUUID, updateOperation);

        }

    }

    @Override
    public Integer getLevel(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return Integer.valueOf(foundDiscordId.get("level").toString());

        }

        return null;

    }

    @Override
    public void addLevel(long discordUserId, Integer amountLevel) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("level", DatabaseManager.instance.getLevel(discordUserId) + amountLevel);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public void removeLevel(long discordUserId, Integer amountLevel) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("level", DatabaseManager.instance.getLevel(discordUserId) - amountLevel);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public void setLevel(long discordUserId, Integer level) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("level", level);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public Integer getXP(String uuid) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            return Integer.valueOf(foundUUID.get("xp").toString());

        }

        return null;

    }

    @Override
    public void addXP(String uuid, Integer amountXP) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            Bson updateValue = new Document("xp", DatabaseManager.instance.getXP(uuid) + amountXP);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUUID, updateOperation);

        }

    }

    @Override
    public void removeXP(String uuid, Integer amountXP) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            Bson updateValue = new Document("xp", DatabaseManager.instance.getXP(uuid) - amountXP);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUUID, updateOperation);

        }

    }

    @Override
    public void setXP(String uuid, Integer xp) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            Bson updateValue = new Document("xp", xp);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUUID, updateOperation);

        }

    }

    @Override
    public Double getInsiCoins(String uuid) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            return Double.valueOf(foundUUID.get("insicoins").toString());

        }

        return null;

    }

    @Override
    public void addInsiCoins(String uuid, Double amountInsiCoins) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            Bson updateValue = new Document("insicoins", DatabaseManager.instance.getInsiCoins(uuid) + amountInsiCoins);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUUID, updateOperation);

        }

    }

    @Override
    public void removeInsiCoins(String uuid, Double amountInsiCoins) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            Bson updateValue = new Document("insicoins", DatabaseManager.instance.getInsiCoins(uuid) - amountInsiCoins);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUUID, updateOperation);

        }

    }

    @Override
    public void setInsiCoins(String uuid, Double insiCoins) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundUUID = (Document) collection.find(new Document("minecraft_uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            Bson updateValue = new Document("insicoins", insiCoins);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUUID, updateOperation);

        }

    }

    @Override
    public Integer getAccountState(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return Integer.valueOf(foundDiscordId.get("account_state").toString());

        }

        return null;

    }

    @Override
    public void setAccountState(long discordUserId, Integer state) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("account_state", state);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public Long getBanTime(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return Long.valueOf(foundDiscordId.get("ban_time").toString());

        }

        return null;

    }

    @Override
    public void setBanTime(long discordUserId, Long time) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("ban_time", time);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getBanAuthor(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("ban_author").toString();

        }

        return null;

    }

    @Override
    public void setBanAuthor(long discordUserId, String author) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("ban_author", author);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getBanReason(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("ban_reason").toString();

        }

        return null;

    }

    @Override
    public void setBanReason(long discordUserId, String reason) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("ban_reason", reason);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public Integer getBanTotal(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return Integer.valueOf(foundDiscordId.get("ban_total").toString());

        }

        return null;

    }

    @Override
    public void addBanTotal(long discordUserId, Integer banAmount) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("ban_total", DatabaseManager.instance.getBanTotal(discordUserId) + banAmount);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public void removeBanTotal(long discordUserId, Integer banAmount) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("ban_total", DatabaseManager.instance.getBanTotal(discordUserId) - banAmount);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public void setBanTotal(long discordUserId, Integer number) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("ban_total", number);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getMinecraftAccountUUID(String nickname) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundNickname = (Document) collection.find(new Document("nickname", String.valueOf(nickname))).first();

        if(foundNickname != null){

            return foundNickname.get("minecraft_uuid").toString();

        }

        return null;

    }

    @Override
    public void setMinecraftAccountUUID(String nickname, String uuid) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundNickname = (Document) collection.find(new Document("nickname", String.valueOf(nickname))).first();

        if(foundNickname != null){

            Bson updateValue = new Document("minecraft_uuid", uuid);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundNickname, updateOperation);

        }

    }

    // InsignicNetwork
    @Override
    public String getUsername(String uuid) {

        MongoCollection collection = mongoDatabaseInsignicNetwork.getCollection("players");

        Document foundUUID = (Document) collection.find(new Document("uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            return foundUUID.get("username").toString();

        }

        return null;

    }

    @Override
    public void setUsername(String uuid, String username) {

        MongoCollection collection = mongoDatabaseInsignicNetwork.getCollection("players");

        Document foundUUID = (Document) collection.find(new Document("uuid", String.valueOf(uuid))).first();

        if(foundUUID != null){

            Bson updateValue = new Document("username", username);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUUID, updateOperation);

        }

    }

    // Statistics
    @Override
    public Integer getStatTotalPlayers() {

        MongoCollection collection = mongoDatabaseInsignicNetwork.getCollection("statistics");

        Document foundStat = (Document) collection.find(new Document("stat_name", "server_global")).first();

        if(foundStat != null){

            return Integer.valueOf(foundStat.get("total_players").toString());

        }

        return 0;

    }

    @Override
    public void setStatTotalPlayers(Integer number) {

        MongoCollection collection = mongoDatabaseInsignicNetwork.getCollection("statistics");

        Document foundStat = (Document) collection.find(new Document("stat_name", "server_global")).first();

        if(foundStat != null){

            Bson updateValue = new Document("total_players", number);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundStat, updateOperation);

        }

    }

    @Override
    public void addStatTotalPlayers(Integer amount) {

        MongoCollection collection = mongoDatabaseInsignicNetwork.getCollection("statistics");

        Document foundStat = (Document) collection.find(new Document("stat_name", "server_global")).first();

        if(foundStat != null){

            Bson updateValue = new Document("total_players", DatabaseManager.instance.getStatTotalPlayers() + amount);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundStat, updateOperation);

        }

    }

}
