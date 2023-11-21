package com.insignic.engine;

import com.insignic.Window;
import com.insignic.engine.discord.DiscordRichPresence;

public class Main {

    public static String projectName = "LifeBuyer";
    public static String projectVersion = "ALPHA";

    public static void main(String args[]){

        DiscordRichPresence.start();

        Window window = Window.get();
        window.run();

    }

}
