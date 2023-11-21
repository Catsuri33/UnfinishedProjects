package fr.odilonesport.fallenkingdoms.utils;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;

public class Gamerules {

    public static void setGamerulesLobby(){

        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DISABLE_RAIDS, true);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_INSOMNIA, true);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_MOB_SPAWNING, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_PATROL_SPAWNING, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_TRADER_SPAWNING, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.KEEP_INVENTORY, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.MOB_GRIEFING, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);

    }

    public static void setGamerulesGame(){

        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, true);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DISABLE_RAIDS, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_INSOMNIA, true);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_MOB_SPAWNING, true);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_PATROL_SPAWNING, true);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_TRADER_SPAWNING, true);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.DO_WEATHER_CYCLE, true);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.KEEP_INVENTORY, false);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.MOB_GRIEFING, true);
        Bukkit.getWorlds().get(0).setGameRule(GameRule.SHOW_DEATH_MESSAGES, true);

    }

}
