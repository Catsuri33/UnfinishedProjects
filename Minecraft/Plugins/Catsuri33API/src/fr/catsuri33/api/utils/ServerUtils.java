/*                              */
/*       Catsuri33API           */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 07/08/2019       */
/*    Updated: 07/08/2019       */
/*    Name: ServerUtils         */
/*                              */

package fr.catsuri33.api.utils;

import org.bukkit.Server;

public class ServerUtils {

    public static void serverShutdown(Server server){

        server.shutdown();

    }

    public static void serverBanIP(Server server, String ip){

        server.banIP(ip);

    }

    public static void serverBroadcast(Server server, String message, String permission){

        server.broadcast(message, permission);

    }

    public static void serverBroadcastMessage(Server server, String message){

        server.broadcastMessage(message);

    }

}
