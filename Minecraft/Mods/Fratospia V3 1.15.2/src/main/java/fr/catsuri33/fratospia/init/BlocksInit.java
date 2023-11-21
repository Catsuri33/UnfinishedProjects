package fr.catsuri33.fratospia.init;

import fr.catsuri33.fratospia.Fratospia;
import fr.catsuri33.fratospia.blocks.OakStool;
import fr.catsuri33.fratospia.groups.DecorationsGroupList;
import fr.catsuri33.fratospia.groups.MineralsGroupList;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Fratospia.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Fratospia.MODID)
public class BlocksInit {

    // Minerals Block
    public static final Block silver_block = null;

    // Ores
    public static final Block silver_ore = null;
    public static final Block silver_ore_nether = null;
    public static final Block silver_ore_end = null;

    // Decoration
    public static final Block oak_stool = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> e){

        // Minerals Block
        e.getRegistry().register(new OreBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)).setRegistryName("silver_block"));

        // Ores
        e.getRegistry().register(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("silver_ore"));
        e.getRegistry().register(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("silver_ore_nether"));
        e.getRegistry().register(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("silver_ore_end"));

        // Decoration
        e.getRegistry().register(new OakStool(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5f, 1.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName("oak_stool"));

    }

    @SubscribeEvent
    public static void registerBlocksItems(final RegistryEvent.Register<Item> e){

        // Minerals Block
        e.getRegistry().register(new BlockItem(silver_block, new Item.Properties().group(MineralsGroupList.instance)).setRegistryName("silver_block"));

        // Ores
        e.getRegistry().register(new BlockItem(silver_ore, new Item.Properties().group(MineralsGroupList.instance)).setRegistryName("silver_ore"));
        e.getRegistry().register(new BlockItem(silver_ore_nether, new Item.Properties().group(MineralsGroupList.instance)).setRegistryName("silver_ore_nether"));
        e.getRegistry().register(new BlockItem(silver_ore_end, new Item.Properties().group(MineralsGroupList.instance)).setRegistryName("silver_ore_end"));

        // Decoration
        e.getRegistry().register(new BlockItem(oak_stool, new Item.Properties().group(DecorationsGroupList.instance)).setRegistryName("oak_stool"));

    }

}
