package fr.catsuri33.uhc.game;

public enum Gamerules {

    DAY_LIGHT_CYCLE("doDayLightCycle"),
    WEATHER_CYCLE("doWeatherCycle"),
    MOB_SPAWNING("doMobSpawning"),
    MOB_GRIEFING("mobGriefing"),
    NATURAL_REGENERATION("naturalRegeneration");

    private String name;

    Gamerules(String name){

        this.name = name;

    }

    public String getName(){

        return name;

    }

}
