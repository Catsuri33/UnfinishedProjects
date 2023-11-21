package com.insignicnetwork.bungeecord.servers;

public enum ServersState {

    ONLINE(1),
    OFFLINE(0);

    public int state;

    private ServersState(int state){

        this.state = state;

    }

}
