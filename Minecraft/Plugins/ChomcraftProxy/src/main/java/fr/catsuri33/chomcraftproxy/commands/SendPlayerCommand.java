package fr.catsuri33.chomcraftproxy.commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import fr.catsuri33.chomcraftproxy.Proxy;
import net.kyori.adventure.text.Component;

public class SendPlayerCommand implements SimpleCommand {

    @Override
    public void execute(Invocation invocation) {

        CommandSource source = invocation.source();
        String[] args = invocation.arguments();

        if(args.length < 2){

            source.sendMessage(Component.text("§cError, the command is §e/sp <Player> <Server Name> §c!"));

        }

        String target = args[0];
        String serverName = args[1];

        if(Proxy.getInstance().server.getPlayer(target).isPresent()){

            Player playerTarget = Proxy.getInstance().server.getPlayer(target).get();

            if(Proxy.getInstance().server.getServer(serverName).isPresent()){

                RegisteredServer targetServer = Proxy.getInstance().server.getServer(serverName).get();
                playerTarget.createConnectionRequest(targetServer);

            } else {

                source.sendMessage(Component.text("§cError, the targeted server doesn't exist !"));

            }

        } else {

            source.sendMessage(Component.text("§cError, the player is not online !"));

        }

    }

    @Override
    public boolean hasPermission(final Invocation invocation) {

        return invocation.source().hasPermission("proxy.sp");

    }

}
