package com.insignic.bot;

import com.insignic.bot.config.ConfigManager;
import com.insignic.bot.database.MongoDb;
import com.insignic.bot.events.listeners.*;
import com.insignic.bot.events.command.commands.insignic.AccountCommand;
import com.insignic.bot.events.listeners.reactions.*;
import com.insignic.bot.tasks.RichPresenceTask;
import com.insignic.bot.utils.ConsoleColors;
import com.insignic.bot.utils.EncryptPassword;
import com.insignic.bot.utils.Logger;
import com.insignic.bot.utils.SendEmail;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.discordbots.api.client.DiscordBotListAPI;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.security.auth.login.LoginException;
import java.util.*;

public class InsignicBot {

    private static InsignicBot instance;
    private static JDABuilder jdaBuilder;

    public static boolean activateTopGG = false;

    public static String prefix = ConfigManager.get("PREFIX");
    public static JDA jda;
    public static List<GatewayIntent> gatewayIntents = new ArrayList<>();
    public static Session session;
    public static DiscordBotListAPI topGGApi;
    public static HashMap<Member, Long> messageRewardsMap = new HashMap<>();

    public static void main(String args[]) {

        Logger.info("Starting the bot...");
        long timeStart = System.currentTimeMillis();

        MongoDb mongoDB = new MongoDb();
        Logger.info(ConsoleColors.ANSI_CYAN + "[ INFO ][ DATABASE ]" + ConsoleColors.ANSI_BLUE + " Connected to the database '" + MongoDb.mongoDatabaseInsignicBot.getName() + "' !");
        Logger.info(ConsoleColors.ANSI_CYAN + "[ INFO ][ DATABASE ]" + ConsoleColors.ANSI_BLUE + " Connected to the database '" + MongoDb.mongoDatabaseInsignicAccounts.getName() + "' !");

        gatewayIntents.add(GatewayIntent.GUILD_MEMBERS);
        gatewayIntents.add(GatewayIntent.GUILD_MESSAGES);
        gatewayIntents.add(GatewayIntent.GUILD_VOICE_STATES);

        jdaBuilder = JDABuilder.createDefault(ConfigManager.get("TOKEN"));

        jdaBuilder.enableIntents(gatewayIntents);
        jdaBuilder.enableCache(CacheFlag.VOICE_STATE);

        registerCommands();

        try {

            jda = jdaBuilder.build();

        } catch (LoginException e) {

            Logger.error("An error has occurred !");
            e.printStackTrace();

        }

        try{

            jda.awaitReady();

        } catch(InterruptedException e){

            e.printStackTrace();

        }

        registerSchedulers();

        // Mail Server
        Properties properties = System.getProperties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        session = Session.getDefaultInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(SendEmail.emailFrom, SendEmail.passwordEmailFrom);

            }

        });

        // Top.gg Discord Bot List
        if(activateTopGG){

            topGGApi = new DiscordBotListAPI.Builder()
                    .token("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjU2NjMwNjQxODk1MzU1MTg4NSIsImJvdCI6dHJ1ZSwiaWF0IjoxNjA1NDY2NjA2fQ.m88gHMUNG1vfphuPUNTjrHh1Ns_jSG0K6_COhgYljNM")
                    .botId(jda.getSelfUser().getId())
                    .build();

        }

        long timeEnd = System.currentTimeMillis() - timeStart;
        Logger.success("Bot started in " + timeEnd + "ms !");

    }

    public static InsignicBot getInstance(){

        return instance;

    }

    private static void registerCommands(){

        // Events
        BotJoinGuild botJoinGuild = new BotJoinGuild();
        jdaBuilder.addEventListeners(botJoinGuild);

        BotQuitGuild botQuitGuild = new BotQuitGuild();
        jdaBuilder.addEventListeners(botQuitGuild);

        GuildMemberJoin guildMemberJoin = new GuildMemberJoin();
        jdaBuilder.addEventListeners(guildMemberJoin);

        GuildMemberLeave guildMemberLeave = new GuildMemberLeave();
        jdaBuilder.addEventListeners(guildMemberLeave);

        MessageRewards messageRewards = new MessageRewards();
        jdaBuilder.addEventListeners(messageRewards);

        // Reactions
        InsignicRoleReactions roleReactions = new InsignicRoleReactions();
        jdaBuilder.addEventListeners(roleReactions);

        Catsuri33RoleReactions roleCatsuri33Reactions = new Catsuri33RoleReactions();
        jdaBuilder.addEventListeners(roleCatsuri33Reactions);

        Noucheca_OWRoleReactions roleNouchecaReactions = new Noucheca_OWRoleReactions();
        jdaBuilder.addEventListeners(roleNouchecaReactions);

        PremiereQuatreRoleReactions rolePreQuatreReactions = new PremiereQuatreRoleReactions();
        jdaBuilder.addEventListeners(rolePreQuatreReactions);

        PremiereDeuxRoleReactions rolePreDeuxReactions = new PremiereDeuxRoleReactions();
        jdaBuilder.addEventListeners(rolePreDeuxReactions);

        // Commands
        Shutdown shutdown = new Shutdown();
        jdaBuilder.addEventListeners(shutdown);

        AccountCommand accountCommand = new AccountCommand();
        jdaBuilder.addEventListeners(accountCommand);

    }

    private static void registerSchedulers(){

        RichPresenceTask richPresenceTask = new RichPresenceTask();
        Timer timer = new Timer();
        timer.schedule(richPresenceTask, 0, 1000);

    }

}
