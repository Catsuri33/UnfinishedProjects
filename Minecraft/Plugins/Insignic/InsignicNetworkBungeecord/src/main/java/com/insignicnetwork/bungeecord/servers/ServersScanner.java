package com.insignicnetwork.bungeecord.servers;

import com.insignicnetwork.bungeecord.Bungeecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

public class ServersScanner {

    private Random random;
    public List<String> serversList = new ArrayList<>();

    public ServersScanner(){

        random = new Random();

    }

    public void checkServerPerCategory(){

        Map<ServersType, List<Servers>> servers = Bungeecord.instance.servers.values().stream().collect(Collectors.groupingBy(Servers::getType));

        for(Entry<ServersType, List<Servers>> entry : servers.entrySet()){

            ServersType type = entry.getKey();
            List<Servers> serversByType = entry.getValue();
            List<Servers> serversOnline = serversByType.stream().filter(srv -> srv.common.getState() > 0).collect(Collectors.toList());

            if(serversOnline.size() > type.getLimit()) continue;

            int filedServers = 0;
            for(Servers server : serversOnline){

                if(server.info.getPlayers().size() > 0) filedServers++;

            }

            if(filedServers == serversOnline.size() || serversOnline.size() == 0){

                List<Servers> serversOffline = serversByType.stream().filter(srv -> srv.common.getState() != 1).collect(Collectors.toList());
                serversOffline.get(random.nextInt(serversOffline.size())).start();

            }

        }

    }

}
