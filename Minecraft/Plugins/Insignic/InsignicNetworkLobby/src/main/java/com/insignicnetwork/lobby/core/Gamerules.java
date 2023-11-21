package com.insignicnetwork.lobby.core;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;

public class Gamerules {

    public static void setGamerules(){

        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        Bukkit.getWorld("InsignicNetwork Hub").setTime(5000);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DISABLE_RAIDS, true);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DO_ENTITY_DROPS, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DO_FIRE_TICK, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DO_INSOMNIA, true);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DO_MOB_LOOT, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DO_MOB_SPAWNING, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DO_PATROL_SPAWNING, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DO_TRADER_SPAWNING, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.DROWNING_DAMAGE, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.FALL_DAMAGE, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.FIRE_DAMAGE, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.MOB_GRIEFING, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);
        Bukkit.getWorld("InsignicNetwork Hub").setGameRule(GameRule.SPAWN_RADIUS, 0);

    }

}
