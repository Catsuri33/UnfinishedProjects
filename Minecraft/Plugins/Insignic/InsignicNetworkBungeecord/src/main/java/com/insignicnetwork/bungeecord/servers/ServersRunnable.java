package com.insignicnetwork.bungeecord.servers;

public class ServersRunnable implements Runnable {

    private ServersScanner scanner;

    @Override
    public void run() {

        if(scanner == null) scanner = new ServersScanner();
        scanner.checkServerPerCategory();

    }

}
