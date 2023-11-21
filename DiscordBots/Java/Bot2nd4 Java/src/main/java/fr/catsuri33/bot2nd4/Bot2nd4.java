package fr.catsuri33.bot2nd4;

import fr.catsuri33.bot2nd4.commands.MuteCommand;
import fr.catsuri33.bot2nd4.utils.LogColors;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot2nd4 {

    private static JDA jda;
    public static String prefix = "!";

    public static void main(String args[]){

        try{

            jda = new JDABuilder(AccountType.BOT).setToken("TOKEN").build();

        } catch(LoginException e){

            e.printStackTrace();

        }

        registerListeners();

        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        changeGame.start();

        log(LogColors.ANSI_GREEN + "[ Bot2nd4 ] Connected and ready !");

    }

    private static void registerListeners(){

        jda.addEventListener(new MuteCommand());

    }

    public static void log(String message){

        System.out.println(message);

    }

    private static Thread changeGame = new Thread("Change Game Thread"){

        public void run(){

            while(true){

                jda.getPresence().setActivity(Activity.playing("surveiller !"));

                try{

                    Thread.sleep(1000 * 10);

                } catch(InterruptedException e){

                    e.printStackTrace();

                }

                jda.getPresence().setActivity(Activity.playing("travaillez !"));

                try{

                    Thread.sleep(1000 * 10);

                } catch(InterruptedException e){

                    e.printStackTrace();

                }

            }

        }

    };

}
