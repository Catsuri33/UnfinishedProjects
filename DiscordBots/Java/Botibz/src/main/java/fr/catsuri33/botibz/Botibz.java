package fr.catsuri33.botibz;

import fr.catsuri33.botibz.generate.GeneratedInit;
import net.dv8tion.jda.api.JDA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Botibz {

    private static JDA jda;

    public static void main(String args[]){

        DateFormat format = new SimpleDateFormat("[yyyy-MM-dd] [hh:mm:ss a]");
        Date date = new Date();

        int timeDone = 0;

        timeDone++;

        System.out.println(format.format(date) + " [ Botibz ] Initializing...");

        GeneratedInit.generateOnInit();

        System.out.println(format.format(date) + " [ Botibz ] Done in " + timeDone + " seconds !");

    }

}
