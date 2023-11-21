package fr.catsuri33.fratospia.world.generation;

import fr.catsuri33.fratospia.init.BlocksInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OresGeneration {

    public static void generateOres(){

        for(Biome biome : ForgeRegistries.BIOMES){

            ConfiguredPlacement cpSilverOre = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 5, 5, 58));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksInit.silver_ore.getDefaultState(), 8)).withPlacement(cpSilverOre));

            ConfiguredPlacement cpSilverOreNether = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 5, 5, 256));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlocksInit.silver_ore_nether.getDefaultState(), 6)).withPlacement(cpSilverOreNether));

        }

    }

}
