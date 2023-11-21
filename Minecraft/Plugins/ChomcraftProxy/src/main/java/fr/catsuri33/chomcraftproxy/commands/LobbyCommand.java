package fr.catsuri33.chomcraftproxy.commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import fr.catsuri33.chomcraftproxy.Proxy;

public class LobbyCommand implements SimpleCommand {

    @Override
    public void execute(Invocation invocation) {

        CommandSource source = invocation.source();
        String[] args = invocation.arguments();

        if(source instanceof Player p){

            RegisteredServer lobbyServer = Proxy.getInstance().server.getServer("lobby01").get();
            p.createConnectionRequest(lobbyServer);

        }

    }

}
