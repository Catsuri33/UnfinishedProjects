package fr.epicgiant.api.bukkit.lang;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LanguageBukkit {

    static LanguageBukkit instance;

    public void broadcastMessage(String french, String english){

        for(Player players : Bukkit.getOnlinePlayers()){

            if(LanguageManager.getInstance().isFrench(players.getUniqueId())){

                players.sendMessage(french);

            } else if(LanguageManager.getInstance().isEnglish(players.getUniqueId())){

                players.sendMessage(english);

            } else {

                players.sendMessage(french);

            }

        }

    }

    public static LanguageBukkit getInstance(){ return instance; }

}
