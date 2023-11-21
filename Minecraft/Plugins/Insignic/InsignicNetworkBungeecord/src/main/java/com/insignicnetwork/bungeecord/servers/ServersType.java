package com.insignicnetwork.bungeecord.servers;

public enum ServersType {

    LOBBY("Lobby", 25565, 5);

    private String name;
    private int port;
    private int limit;

    private ServersType(String name, int port, int limit){

        this.name = name;
        this.port = port;
        this.limit = limit;

    }

    public String getName() {

        return name;

    }

    public int getPort() {

        return port;

    }

    public int getLimit() {

        return limit;

    }

}
