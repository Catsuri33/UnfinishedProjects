package fr.epicgiant.api.bukkit.lang;

import fr.epicgiant.api.bukkit.utils.SQLConnector;

import java.util.UUID;

public class LanguageManager {

    static final LanguageManager instance = new LanguageManager();
    public static LanguageManager getInstance(){ return instance; }

    public void setLanguage(UUID uuid, Lang language){

        SQLConnector.player_infos.setLanguage(uuid, language.getLanguage());

    }

    public Lang getLanguage(UUID uuid){

        return Lang.getByName(SQLConnector.player_infos.getLanguage(uuid));

    }

    public Boolean isFrench(UUID uuid){

        return this.getLanguage(uuid) == Lang.FRENCH;

    }

    public Boolean isEnglish(UUID uuid){

        return this.getLanguage(uuid) == Lang.ENGLISH;

    }

    public String returnStringPlayerLanguage(UUID uuid, String french, String english){

        if(isFrench(uuid)) return french;
        else if(isEnglish(uuid)) return english;
        return french;

    }

    public String getLanguageName(UUID uuid){

        if(isFrench(uuid)) return Lang.FRENCH.getName();
        if(isFrench(uuid)) return Lang.ENGLISH.getName();
        return Lang.FRENCH.getName();

    }

    public void broadcastMessage(String french, String english){

        LanguageBukkit.getInstance().broadcastMessage(french, english);

    }

}
