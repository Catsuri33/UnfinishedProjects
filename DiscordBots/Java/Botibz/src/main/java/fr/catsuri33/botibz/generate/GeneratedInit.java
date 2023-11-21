package fr.catsuri33.botibz.generate;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneratedInit {

    public static void generateOnInit(){

        DateFormat format = new SimpleDateFormat("[yyyy-MM-dd] [hh:mm:ss a]");
        Date date = new Date();

        /**
         * Generate the config folder
         */
        File configFolder = new File("./configs");
        if (!configFolder.exists()) {

            if (configFolder.mkdir()) {

                System.out.println(format.format(date) + " [ Botibz ] Creating the 'configs' folder...");

            } else {

                System.out.println(format.format(date) + " [ Botibz ] Failed to create 'configs' folder !");

            }
        }

        /**
         * Generate the plugins folder
         */
        File pluginsFolder = new File("./plugins");
        if (!pluginsFolder.exists()) {

            if (pluginsFolder.mkdir()) {

                System.out.println(format.format(date) + " [ Botibz ] Creating the 'plugins' folder...");

            } else {

                System.out.println(format.format(date) + " [ Botibz ] Failed to create 'plugins' folder !");

            }
        }

        /**
         * Generate the bots.yml file
         */
        File fileConfigBots = new File("./configs/bots.yml");
        if (!fileConfigBots.exists()) {

            try {

                System.out.println(format.format(date) + " [ Botibz ] Creating the 'bots.yml' file...");
                fileConfigBots.createNewFile();

                PrintWriter pw = new PrintWriter(fileConfigBots);
                pw.println("bots:");
                pw.close();

            } catch(IOException e) {

                System.out.println(format.format(date) + " [ Botibz ] Failed to create 'bots.yml' file !");
                e.printStackTrace();

            }

        }

    }

}
