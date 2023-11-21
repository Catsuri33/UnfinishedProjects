package com.insignic.bot.events.command.commands.insignic;

import com.insignic.bot.database.DatabaseManager;
import com.insignic.bot.database.MongoDb;
import com.insignic.bot.utils.BadgesManager;
import com.insignic.bot.utils.EncryptPassword;
import com.insignic.bot.utils.Logger;
import com.insignic.bot.utils.XPPercentageBar;
import com.insignic.bot.utils.levels.Levels;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class AccountCommand extends ListenerAdapter {

    private static HashMap<User, Integer> userInRegister = new HashMap<>();
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date date = new Date();

    @Override
    public void onMessageReceived(MessageReceivedEvent e){

        JDA jda = e.getJDA();
        MessageChannel channel = e.getChannel();
        User self = jda.getSelfUser();
        User user = e.getAuthor();
        Message message = e.getMessage();
        String raw = e.getMessage().getContentRaw();

        if(message.isFromGuild()){

            Long guildId = e.getGuild().getIdLong();
            Guild guild = e.getGuild();

            if(raw.equalsIgnoreCase(DatabaseManager.instance.getPrefix(guildId) + "account")){

                if(DatabaseManager.instance.getNickname(user.getIdLong()) != null){

                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setTitle("Account");
                    embedBuilder.setThumbnail("https://eu.ui-avatars.com/api/?background=3498db&color=fff&color=ffffff&length=1&name=" + DatabaseManager.instance.getNickname(user.getIdLong()));
                    embedBuilder.setColor(new Color(52, 152, 219));

                    if(!DatabaseManager.instance.getBadges(user.getIdLong()).equals("")){

                        embedBuilder.addField(BadgesManager.getBadges(user.getIdLong()), "", false);

                    }

                    embedBuilder.addField("Nickname", DatabaseManager.instance.getNickname(user.getIdLong()), false);
                    if(DatabaseManager.instance.getEmailState(user.getIdLong()).equalsIgnoreCase("1")){

                        embedBuilder.addField("Email", DatabaseManager.instance.getEmail(user.getIdLong()) + " *(Verified)*", false);

                    } else {

                        embedBuilder.addField("Email", DatabaseManager.instance.getEmail(user.getIdLong()), false);

                    }
                    embedBuilder.addField("Rank", DatabaseManager.instance.getRank(user.getIdLong()), false);
                    embedBuilder.addField("InsiCoins", String.valueOf(DatabaseManager.instance.getInsiCoins(user.getIdLong())), false);
                    embedBuilder.addField("Level", String.valueOf(DatabaseManager.instance.getLevel(user.getIdLong())), false);
                    embedBuilder.addField("XP", String.valueOf(DatabaseManager.instance.getXP(user.getIdLong()) + " - " + (DatabaseManager.instance.getXP(user.getIdLong()) * 100) / Levels.getXPNeeded(DatabaseManager.instance.getLevel(user.getIdLong())) + "%" + "\n\n**Level " + DatabaseManager.instance.getLevel(user.getIdLong()) + "** [" + XPPercentageBar.setXPBar(DatabaseManager.instance.getXP(user.getIdLong()), Levels.getXPNeeded(DatabaseManager.instance.getLevel(user.getIdLong()))) + "] **Level " + (DatabaseManager.instance.getLevel(user.getIdLong()) + 1) + "**"), false);
                    embedBuilder.addField("Account Creation Date", DatabaseManager.instance.getCreationDate(user.getIdLong()), false);

                    if(DatabaseManager.instance.getState(user.getIdLong()).equals("online")){

                        embedBuilder.setFooter("Online - " + DatabaseManager.instance.getActivity(user.getIdLong()), "https://eu.ui-avatars.com/api/?background=27ae60&color=fff&color=ffffff&length=1&name=");

                    } else {

                        embedBuilder.setFooter("Offline", "https://eu.ui-avatars.com/api/?background=e74c3c&color=fff&color=ffffff&length=1&name=");

                    }

                    channel.sendMessage(embedBuilder.build()).queue();

                    return;

                } else {

                    channel.sendMessage("Error, you don't have an InsignicAccounts account ! To get started type `" + DatabaseManager.instance.getPrefix(guildId) + "account create` !").queue();
                    return;

                }

            }

            if(raw.equalsIgnoreCase(DatabaseManager.instance.getPrefix(guildId) + "account create")){

                if(!userInRegister.containsKey(user)){

                    MongoCollection collection = MongoDb.mongoDatabaseInsignicAccounts.getCollection("users");
                    Document foundDiscordId = (Document) collection.find(new Document("discord_id", user.getId())).first();

                    if(foundDiscordId == null){

                        channel.sendMessage(user.getAsMention() + ", please check you private messages to continue your registration.").queue();
                        userInRegister.put(user, 1);
                        user.openPrivateChannel().queue(privateChannel -> {

                            privateChannel.sendMessage("__**InsignicAccounts Registration**__\n\nWelcome to the creation of your InsignicAccounts account.\n(Type `cancel` at any time to cancel the creation)\n").queue();
                            privateChannel.sendMessage("**Enter your nickname:**").queue();

                        });

                    } else {

                        channel.sendMessage("Error, you already have an InsignicAccounts linked with your Discord account !").queue();
                        return;

                    }

                } else {

                    channel.sendMessage("Error, you are already registering !").queue();
                    return;

                }

            }

            if(raw.equalsIgnoreCase("account edit")){

                channel.sendMessage("Error, the command is `" + DatabaseManager.instance.getPrefix(guildId) + "account edit <username | first_name | last_name | password>` !").queue();
                return;

            }

            if(raw.equalsIgnoreCase(DatabaseManager.instance.getPrefix(guildId) + "account edit username")){

                if(DatabaseManager.instance.getNickname(user.getIdLong()) != null){

                    channel.sendMessage(user.getAsMention() + ", please check you private messages to edit your username.").queue();
                    user.openPrivateChannel().queue(privateChannel -> {

                        privateChannel.sendMessage("__**InsignicAccounts Registration**__\n\nWelcome to the creation of your InsignicAccounts account.\n(Type `cancel` at any time to cancel the creation)\n").queue();
                        privateChannel.sendMessage("**Enter your nickname:**").queue();

                    });

                } else {

                    channel.sendMessage("Error, you don't have an InsignicAccounts account ! To get started type `" + DatabaseManager.instance.getPrefix(guildId) + "account create` !").queue();
                    return;

                }

            }

        }

        if(channel.getType().equals(ChannelType.PRIVATE)){

            if(!message.getAuthor().equals(self)){

                if(userInRegister.containsKey(user)){

                    MongoCollection usersCollection = MongoDb.mongoDatabaseInsignicAccounts.getCollection("users");
                    MongoCollection badgesCollection = MongoDb.mongoDatabaseInsignicAccounts.getCollection("badges");

                    if(raw.equalsIgnoreCase("cancel") && userInRegister.containsValue(1)){

                        userInRegister.remove(user);

                        channel.sendMessage("You have cancelled your registration !").queue();
                        return;

                    }

                    if(raw.equalsIgnoreCase("cancel")){

                        Document foundDiscordId = (Document) usersCollection.find(new Document("discord_id", user.getId())).first();
                        if(foundDiscordId != null){

                            usersCollection.deleteOne(Filters.eq("discord_id", user.getId()));

                        }

                        userInRegister.remove(user);

                        channel.sendMessage("You have cancelled your registration !").queue();
                        return;

                    }

                    if(userInRegister.containsValue(1)){

                        Document foundDiscordId = (Document) usersCollection.find(new Document("discord_id", user.getId())).first();

                        if(foundDiscordId == null){

                            Document newUser = new Document("id", usersCollection.countDocuments() + 1);
                            newUser.append("nickname", raw);
                            newUser.append("first_name", "");
                            newUser.append("last_name", "");
                            newUser.append("email", "");
                            newUser.append("email_state", -1);
                            newUser.append("email_code", -1);
                            newUser.append("password", "");
                            newUser.append("rank", "User");
                            newUser.append("level", 0);
                            newUser.append("xp", 0);
                            newUser.append("insicoins", 0.0f);
                            newUser.append("discord_id", user.getId());
                            newUser.append("account_state", 0);
                            newUser.append("ban_time", -1L);
                            newUser.append("ban_reason", "");
                            newUser.append("ban_author", "");
                            newUser.append("ban_total", 0);
                            newUser.append("creation_date", date);
                            newUser.append("minecraft_uuid", "");

                            usersCollection.insertOne(newUser);

                            Document newUserBadges = new Document("id", badgesCollection.countDocuments() + 1);
                            newUserBadges.append("nickname", raw);
                            newUserBadges.append("badges", "");

                            badgesCollection.insertOne(newUserBadges);

                            channel.sendMessage("You have set your nickname to: **" + raw + "**.").queue();

                            userInRegister.replace(user, 1, 2);

                            channel.sendMessage("**Enter your First Name:**\n(If you don't want to share this information, type `skip`, however some account features will be blocked !").queue();
                            return;

                        } else {

                            channel.sendMessage("Error, an account with your Discord id already exist !").queue();
                            return;

                        }

                    }

                    if(raw.equalsIgnoreCase("skip") && userInRegister.containsValue(2)){

                        userInRegister.replace(user, 2, 3);

                        channel.sendMessage("You have skipped this field !").queue();
                        channel.sendMessage("**Enter your Last Name:**\n(If you don't want to share this information, type `skip`, however some account features will be blocked !)").queue();
                        return;

                    }

                    if(userInRegister.containsValue(2)){

                        Document foundDiscordId = (Document) usersCollection.find(new Document("discord_id", user.getId())).first();

                        if(foundDiscordId != null){

                            Bson updateValue = new Document("first_name", raw);
                            Bson updateOperation = new Document("$set", updateValue);

                            usersCollection.updateOne(foundDiscordId, updateOperation);

                            channel.sendMessage("You have set your first name to: **" + raw + "**.").queue();
                            channel.sendMessage("**Enter your Last Name:**\n(If you don't want to share this information, type `skip`, however some account features will be blocked !)").queue();

                            userInRegister.replace(user, 2, 3);
                            return;

                        } else {

                            channel.sendMessage("Error in the system !").queue();
                            return;

                        }

                    }

                    if(raw.equalsIgnoreCase("skip") && userInRegister.containsValue(3)){

                        userInRegister.replace(user, 3, 4);

                        channel.sendMessage("You have skipped this field !").queue();
                        channel.sendMessage("**Enter your Email:**\n").queue();
                        return;

                    }

                    if(userInRegister.containsValue(3)){

                        Document foundDiscordId = (Document) usersCollection.find(new Document("discord_id", user.getId())).first();

                        if(foundDiscordId != null){

                            Bson updateValue = new Document("last_name", raw);
                            Bson updateOperation = new Document("$set", updateValue);

                            usersCollection.updateOne(foundDiscordId, updateOperation);

                            channel.sendMessage("You have set your last name to: **" + raw + "**.").queue();
                            channel.sendMessage("**Enter your Email:**\n").queue();

                            userInRegister.replace(user, 3, 4);
                            return;

                        } else {

                            channel.sendMessage("Error in the system !").queue();
                            return;

                        }

                    }

                    if(userInRegister.containsValue(4)){

                        Document foundDiscordId = (Document) usersCollection.find(new Document("discord_id", user.getId())).first();

                        if(foundDiscordId != null){

                            if(raw.contains("@")){

                                Document foundEmail = (Document) usersCollection.find(new Document("email", raw)).first();

                                if(foundEmail == null){

                                    Bson updateValue = new Document("email", raw);
                                    Bson updateOperation = new Document("$set", updateValue);

                                    usersCollection.updateOne(foundDiscordId, updateOperation);

                                    channel.sendMessage("You have set your email to: **" + raw + "**.").queue();
                                    channel.sendMessage("**Enter your Password:**\n").queue();

                                    userInRegister.replace(user, 4, 5);
                                    return;

                                } else {

                                    channel.sendMessage("Error, an account with your email already exist !").queue();
                                    return;

                                }

                            } else {

                                channel.sendMessage("Error, the email entered is not valid !").queue();
                                return;

                            }

                        } else {

                            channel.sendMessage("Error in the system !").queue();
                            return;

                        }

                    }

                    if(userInRegister.containsValue(5)){

                        Document foundDiscordId = (Document) usersCollection.find(new Document("discord_id", user.getId())).first();

                        if(foundDiscordId != null){

                            String encryptedPassword = EncryptPassword.encryptString(raw);

                            DatabaseManager.instance.setPassword(user.getIdLong(), encryptedPassword);

                            channel.sendMessage("**Re-Enter your Password:**\n").queue();

                            userInRegister.replace(user, 5, 6);
                            return;

                        } else {

                            channel.sendMessage("Error in the system !").queue();
                            return;

                        }

                    }

                    if(userInRegister.containsValue(6)){

                        Document foundDiscordId = (Document) usersCollection.find(new Document("discord_id", user.getId())).first();

                        if(foundDiscordId != null){

                            String encryptedPassword = EncryptPassword.encryptString(raw);

                            if(encryptedPassword.equals(DatabaseManager.instance.getPassword(user.getIdLong()))){

                                channel.sendMessage("You have set a password.").queue();
                                channel.sendMessage("**Congratulations, you have completed your registration ! Welcome among us !**\n(If you want you can verify your email by typing `i!everify` in a server.)").queue();

                                Logger.info("[ ACCOUNT ] Created account for '" + user.getName() + "' with name '" + DatabaseManager.instance.getNickname(user.getIdLong()) + "' !");

                                userInRegister.remove(user);
                                return;

                            } else {

                                channel.sendMessage("Error, the passwords doesn't match !").queue();
                                return;

                            }

                        } else {

                            channel.sendMessage("Error in the system !").queue();
                            return;

                        }

                    }

                }

            }

        }

    }

}
