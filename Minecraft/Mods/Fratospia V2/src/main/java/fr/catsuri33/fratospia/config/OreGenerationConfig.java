package fr.catsuri33.fratospia.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenerationConfig {

    public static ForgeConfigSpec.IntValue silver_veins;
    public static ForgeConfigSpec.BooleanValue generate_overworld;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client){

        server.comment("Ore Generation Config");

        silver_veins = server.comment("Maximum number of ore veins of Silver ore that can spawn in a chunk.").defineInRange("oregeneration.silver_veins", 50, 1, 1000000);
        generate_overworld = server.comment("Decide if you want to generate ores in the overworld.").define("oregeneration.generate_overworld", true);

    }

}
