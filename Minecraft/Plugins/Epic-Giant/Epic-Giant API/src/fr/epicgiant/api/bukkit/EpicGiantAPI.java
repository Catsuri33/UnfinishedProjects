package fr.epicgiant.api.bukkit;

import fr.epicgiant.api.bukkit.lang.LanguageManager;
import fr.epicgiant.api.bukkit.mysql.GlobalPlayerInfosSQL;
import fr.epicgiant.api.bukkit.packets.TabManager;
import fr.epicgiant.api.bukkit.utils.ExplosionUtils;
import fr.epicgiant.api.bukkit.utils.MotdManager;
import fr.epicgiant.api.bukkit.utils.SQLConnector;
import fr.epicgiant.api.bukkit.utils.WorldUtils;

public class EpicGiantAPI {

    public static LanguageManager getLanguageSystem(){

        return LanguageManager.getInstance();

    }

    public static MotdManager getMotdSystem(){

        return MotdManager.getInstance();

    }

    public static GlobalPlayerInfosSQL getGlobalPlayerInfos(){

        return SQLConnector.player_infos;

    }

    public static TabManager getTabManager(){

        return TabManager.getInstance();

    }

    public static ExplosionUtils getExplosionSystem(){

        return ExplosionUtils.getInstance();

    }

    public static WorldUtils getWorldSystem(){

        return WorldUtils.getInstance();

    }

}
