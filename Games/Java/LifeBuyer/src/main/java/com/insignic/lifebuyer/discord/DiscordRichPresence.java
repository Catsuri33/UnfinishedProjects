package com.insignic.lifebuyer.discord;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import com.insignic.lifebuyer.utils.Logger;

public class DiscordRichPresence {

    private static boolean running = true;
    private static String appId = "770365746718834708";

    public static void start(){

        Logger.info("Starting Discord RPC...");

        DiscordRPC discordRPC = DiscordRPC.INSTANCE;
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> Logger.info("Connected to " + user.username + "#" + user.discriminator + " Discord account !");
        discordRPC.Discord_Initialize(appId, handlers, true, "");
        update("LifeBuyer", "In main menu.", "lifebuyer_logo", "LifeBuyer", "", "");

        new Thread(() -> {

            while(running) {

                discordRPC.Discord_RunCallbacks();

                try {

                    Thread.sleep(2000);

                } catch (InterruptedException ignored) {}

            }

        }, "RPC-Callback-Handler").start();

    }

    public static void shutdown(){

        running = false;

        DiscordRPC discordRPC = DiscordRPC.INSTANCE;
        discordRPC.Discord_Shutdown();

    }

    public static void update(String firstLine, String secondLine, String bigImageKey, String bigImageText, String smallImageKey, String smallImageText){

        DiscordRPC discordRPC = DiscordRPC.INSTANCE;
        club.minnced.discord.rpc.DiscordRichPresence presence = new club.minnced.discord.rpc.DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        presence.details = firstLine;
        presence.state = secondLine;
        presence.largeImageKey = bigImageKey;
        presence.largeImageText = bigImageText;
        presence.smallImageKey = smallImageKey;
        presence.smallImageText = smallImageText;
        discordRPC.Discord_UpdatePresence(presence);

    }

}
