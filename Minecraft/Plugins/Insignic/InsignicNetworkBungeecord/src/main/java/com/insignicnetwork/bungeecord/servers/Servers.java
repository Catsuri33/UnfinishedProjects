package com.insignicnetwork.bungeecord.servers;

import com.insignicnetwork.bungeecord.Bungeecord;
import net.md_5.bungee.api.config.ServerInfo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Servers {

    public ServersType type;
    public ServersCommon common;
    public ServerInfo info;

    public Servers(ServersType type, ServersCommon common, ServerInfo info){

        this.type = type;
        this.common = common;
        this.info = info;

    }

    public ServersType getType() {

        return type;

    }

    public void start(){

        String startPath = Bungeecord.instance.path.get(type)[1].replace("%id%", getID());

        ProcessBuilder pb = new ProcessBuilder("sh", "start.sh");

        try{

            System.out.println("Starting server: " + startPath);

            pb.directory(new File(startPath));
            Process process = pb.start();

            process.waitFor();

        } catch(IOException | InterruptedException e){

            e.printStackTrace();

        }

    }

    public void stop(){

        Runtime runtime = Runtime.getRuntime();

        try{

            Process process = runtime.exec("screen -X -S " + common.getDisplayName() + getID() + " stuff \"stop\\n\"");
            process.waitFor();

        } catch(IOException | InterruptedException e){

            e.printStackTrace();

        }

    }

    public String getID(){

        String id = "";
        List<Character> number = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        for(char cha : common.getDisplayName().toCharArray()){

            if(number.contains(cha)) id += new String(new char[] { cha });

        }

        return id;

    }

}
