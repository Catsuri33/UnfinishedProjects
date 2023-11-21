package fr.catsuri33.chomcraftproxy;

import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandMeta;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import fr.catsuri33.chomcraftproxy.commands.LobbyCommand;
import fr.catsuri33.chomcraftproxy.commands.SendPlayerCommand;
import fr.catsuri33.chomcraftproxy.listeners.PlayerChat;
import fr.catsuri33.chomcraftproxy.listeners.PlayerJoin;
import fr.catsuri33.chomcraftproxy.listeners.PlayerQuit;
import org.slf4j.Logger;

@Plugin(id = "chomcraftproxy", name = "ChomcraftProxy", version = "1.0.0", url = "", description = "Plugin for the proxy of Chomcraft.", authors = {"Catsuri33"})
public class Proxy {

    public static Proxy INSTANCE;
    public final ProxyServer server;
    public final Logger logger;

    @Inject
    public Proxy(ProxyServer server, Logger logger) {

        INSTANCE = this;

        this.server = server;
        this.logger = logger;

        logger.info("Proxy plugin started !");

    }

    @Subscribe
    public void onInitialize(ProxyInitializeEvent event) {

        server.getEventManager().register(this, new PlayerChat());
        server.getEventManager().register(this, new PlayerJoin());
        server.getEventManager().register(this, new PlayerQuit());

        CommandMeta metaSP = server.getCommandManager().metaBuilder("sp")
                .aliases("sendplayer")
                .build();
        CommandMeta metaLobby = server.getCommandManager().metaBuilder("lobby")
                .aliases("hub")
                .build();

        server.getCommandManager().register(metaSP, new SendPlayerCommand());
        server.getCommandManager().register(metaLobby, new LobbyCommand());

    }

    public static Proxy getInstance(){

        return INSTANCE;

    }

}