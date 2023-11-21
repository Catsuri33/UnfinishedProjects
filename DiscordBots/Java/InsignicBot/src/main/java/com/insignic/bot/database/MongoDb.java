package com.insignic.bot.database;

import com.insignic.bot.config.ConfigManager;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDb implements DatabaseManager {

    private static final String uriDbInsignicBot = "URI";
    public static final ConnectionString dbInsignicBotConnString = new ConnectionString(uriDbInsignicBot);
    public static final MongoClientSettings dbInsignicBotSettings = MongoClientSettings.builder().applyConnectionString(dbInsignicBotConnString).retryWrites(true).build();
    public static final MongoClient mongoClientInsignicBot = MongoClients.create(dbInsignicBotSettings);
    public static final MongoDatabase mongoDatabaseInsignicBot = mongoClientInsignicBot.getDatabase("InsignicBot");

    private static final String uriDbInsignicAccounts = "URI";
    public static final ConnectionString dbInsignicAccountsConnString = new ConnectionString(uriDbInsignicAccounts);
    public static final MongoClientSettings dbInsignicAccountsSettings = MongoClientSettings.builder().applyConnectionString(dbInsignicAccountsConnString).retryWrites(true).build();
    public static final MongoClient mongoClientInsignicAccounts = MongoClients.create(dbInsignicAccountsSettings);
    public static final MongoDatabase mongoDatabaseInsignicAccounts = mongoClientInsignicAccounts.getDatabase("InsignicAccounts");

    public MongoDb(){



    }

    @Override
    public String getGuildName(long guildId) {

        MongoCollection collection = mongoDatabaseInsignicBot.getCollection("guild_settings");

        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(foundGuild != null){

            return foundGuild.get("guild_name").toString();

        }

        return "";

    }

    @Override
    public void setGuildName(long guildId, String newName) {

        MongoCollection collection = mongoDatabaseInsignicBot.getCollection("guild_settings");

        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(foundGuild != null){

            Bson updateValue = new Document("guild_name", newName);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundGuild, updateOperation);

        }

    }

    @Override
    public String getPrefix(long guildId) {

        MongoCollection collection = mongoDatabaseInsignicBot.getCollection("guild_settings");

        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(foundGuild != null){

            return foundGuild.get("prefix").toString();

        }

        return ConfigManager.get("PREFIX");

    }

    @Override
    public void setPrefix(long guildId, String newPrefix) {

        MongoCollection collection = mongoDatabaseInsignicBot.getCollection("guild_settings");

        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(foundGuild != null){

            Bson updateValue = new Document("prefix", newPrefix);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundGuild, updateOperation);

        }

    }

    @Override
    public String getIdChannelNews(long guildId) {

        MongoCollection collection = mongoDatabaseInsignicBot.getCollection("guild_settings");

        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(foundGuild != null){

            return foundGuild.get("id_channel_news").toString();

        }

        return "";

    }

    @Override
    public void setIdChannelNews(long guildId, String channelId) {

        MongoCollection collection = mongoDatabaseInsignicBot.getCollection("guild_settings");

        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(foundGuild != null){

            Bson updateValue = new Document("id_channel_news", String.valueOf(channelId));
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundGuild, updateOperation);

        }

    }

    @Override
    public String getIdChannelWelcome(long guildId) {

        MongoCollection collection = mongoDatabaseInsignicBot.getCollection("guild_settings");

        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(foundGuild != null){

            return foundGuild.get("id_channel_welcome").toString();

        }

        return "";

    }

    @Override
    public void setIdChannelWelcome(long guildId, String channelId) {

        MongoCollection collection = mongoDatabaseInsignicBot.getCollection("guild_settings");

        Document foundGuild = (Document) collection.find(new Document("guild_id", String.valueOf(guildId))).first();

        if(foundGuild != null){

            Bson updateValue = new Document("id_channel_welcome", String.valueOf(channelId));
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundGuild, updateOperation);

        }

    }

    // InsignicAccounts
    @Override
    public String getNickname(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("nickname").toString();

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
    public String getPassword(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("password").toString();

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
    public String getRank(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("rank").toString();

        }

        return null;

    }

    @Override
    public void setRank(long discordUserId, String rank) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("rank", rank);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

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
    public Integer getXP(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return Integer.valueOf(foundDiscordId.get("xp").toString());

        }

        return null;

    }

    @Override
    public void addXP(long discordUserId, Integer amountXP) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("xp", DatabaseManager.instance.getXP(discordUserId) + amountXP);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public void removeXP(long discordUserId, Integer amountXP) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("xp", DatabaseManager.instance.getXP(discordUserId) - amountXP);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public void setXP(long discordUserId, Integer xp) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("xp", xp);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public Double getInsiCoins(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return Double.valueOf(foundDiscordId.get("insicoins").toString());

        }

        return null;

    }

    @Override
    public void addInsiCoins(long discordUserId, Double amountInsiCoins) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("insicoins", DatabaseManager.instance.getInsiCoins(discordUserId) + amountInsiCoins);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public void removeInsiCoins(long discordUserId, Double amountInsiCoins) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("insicoins", DatabaseManager.instance.getInsiCoins(discordUserId) - amountInsiCoins);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public void setInsiCoins(long discordUserId, Double insiCoins) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("insicoins", insiCoins);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

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
    public String getState(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("state").toString();

        }

        return null;

    }

    @Override
    public void setState(long discordUserId, String state) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("state", state);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    @Override
    public String getActivity(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            return foundDiscordId.get("activity").toString();

        }

        return null;

    }

    @Override
    public void setActivity(long discordUserId, String activity) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("users");

        Document foundDiscordId = (Document) collection.find(new Document("discord_id", String.valueOf(discordUserId))).first();

        if(foundDiscordId != null){

            Bson updateValue = new Document("activity", activity);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundDiscordId, updateOperation);

        }

    }

    // Badges
    @Override
    public String getBadges(long discordUserId) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("badges");

        Document foundUsername = (Document) collection.find(new Document("nickname", DatabaseManager.instance.getNickname(discordUserId))).first();

        if(foundUsername != null){

            return String.valueOf(foundUsername.get("badges").toString());

        }

        return null;

    }

    @Override
    public void addBadges(long discordUserId, String badge) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("badges");

        Document foundUsername = (Document) collection.find(new Document("nickname", DatabaseManager.instance.getNickname(discordUserId))).first();

        if(foundUsername != null){

            Bson updateValue = new Document("badges", DatabaseManager.instance.getBadges(discordUserId) + "-" + badge);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUsername, updateOperation);

        }

    }

    @Override
    public void removeBadges(long discordUserId, String badge) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("badges");

        Document foundUsername = (Document) collection.find(new Document("nickname", DatabaseManager.instance.getNickname(discordUserId))).first();

        if(foundUsername != null){

            Bson updateValue = new Document("badges", DatabaseManager.instance.getBadges(discordUserId).replace(badge, ""));
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUsername, updateOperation);

        }

    }

    @Override
    public void setBadges(long discordUserId, String badge) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("badges");

        Document foundUsername = (Document) collection.find(new Document("nickname", DatabaseManager.instance.getNickname(discordUserId))).first();

        if(foundUsername != null){

            Bson updateValue = new Document("badges", badge);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUsername, updateOperation);

        }

    }

    // Achievements
    @Override
    public Boolean getAchievementState(long discordUserId, String achievementName) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("achievements");

        Document foundUsername = (Document) collection.find(new Document("nickname", DatabaseManager.instance.getNickname(discordUserId))).first();

        if(foundUsername != null){

            return Boolean.valueOf(foundUsername.get(achievementName).toString());

        }

        return null;

    }

    @Override
    public void setAchievementState(long discordUserId, String achievementName, boolean state) {

        MongoCollection collection = mongoDatabaseInsignicAccounts.getCollection("achievements");

        Document foundUsername = (Document) collection.find(new Document("nickname", DatabaseManager.instance.getNickname(discordUserId))).first();

        if(foundUsername != null){

            Bson updateValue = new Document(achievementName, state);
            Bson updateOperation = new Document("$set", updateValue);

            collection.updateOne(foundUsername, updateOperation);

        }

    }

}
