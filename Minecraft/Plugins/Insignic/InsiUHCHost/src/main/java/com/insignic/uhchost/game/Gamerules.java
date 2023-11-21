package com.insignic.uhchost.game;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;

public class Gamerules {

    public static void setGamerulesLobby(){

        Bukkit.getWorld("world").setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        Bukkit.getWorld("world").setTime(5000);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        Bukkit.getWorld("world").setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        Bukkit.getWorld("world").setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DISABLE_RAIDS, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_ENTITY_DROPS, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_FIRE_TICK, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_INSOMNIA, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_MOB_LOOT, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_MOB_SPAWNING, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_PATROL_SPAWNING, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_TRADER_SPAWNING, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DROWNING_DAMAGE, false);
        Bukkit.getWorld("world").setGameRule(GameRule.FALL_DAMAGE, false);
        Bukkit.getWorld("world").setGameRule(GameRule.FIRE_DAMAGE, false);
        Bukkit.getWorld("world").setGameRule(GameRule.MOB_GRIEFING, false);
        Bukkit.getWorld("world").setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);
        Bukkit.getWorld("world").setGameRule(GameRule.SPAWN_RADIUS, 0);
        Bukkit.getWorld("world").setGameRule(GameRule.NATURAL_REGENERATION, false);

    }

    public static void setGamerulesGame(){

        Bukkit.getWorld("world").setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
        Bukkit.getWorld("world").setTime(0);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        Bukkit.getWorld("world").setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        Bukkit.getWorld("world").setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DISABLE_RAIDS, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_ENTITY_DROPS, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_FIRE_TICK, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_INSOMNIA, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_MOB_LOOT, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_MOB_SPAWNING, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_PATROL_SPAWNING, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_TRADER_SPAWNING, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DROWNING_DAMAGE, true);
        Bukkit.getWorld("world").setGameRule(GameRule.FALL_DAMAGE, true);
        Bukkit.getWorld("world").setGameRule(GameRule.FIRE_DAMAGE, true);
        Bukkit.getWorld("world").setGameRule(GameRule.MOB_GRIEFING, true);
        Bukkit.getWorld("world").setGameRule(GameRule.SHOW_DEATH_MESSAGES, true);
        Bukkit.getWorld("world").setGameRule(GameRule.SPAWN_RADIUS, 0);
        Bukkit.getWorld("world").setGameRule(GameRule.NATURAL_REGENERATION, false);

    }

}
