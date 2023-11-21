package com.insignic.chomcraft.core;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class Discord {

    public static void start(){

        DiscordRPC lib = DiscordRPC.INSTANCE;
        String applicationId = "837261156274929686";
        String steamId = "";
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> System.out.println("Discord RPC ready !");
        lib.Discord_Initialize(applicationId, handlers, true, steamId);
        // in a worker thread
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler").start();

    }

    public static void updatePresence(String state, String details, String bigImageKey, String bigImageText, String smallImageKey, String smallImageText){

        DiscordRPC lib = DiscordRPC.INSTANCE;
        DiscordRichPresence presence = new DiscordRichPresence();

        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        presence.details = details;
        presence.state = state;
        presence.largeImageKey = bigImageKey;
        presence.largeImageText = bigImageText;
        presence.smallImageKey = smallImageKey;
        presence.smallImageText = smallImageText;

        lib.Discord_UpdatePresence(presence);

    }

}
