package com.insignic.lifebuyer;

import com.insignic.lifebuyer.discord.DiscordRichPresence;
import com.insignic.lifebuyer.engine.Window;

public class Main {

    public static String projectName = "LifeBuyer";
    public static String projectVersion = "ALPHA";

    public static void main(String args[]){

        DiscordRichPresence.start();

        Window window = Window.get();
        window.run();

    }

}
