package fr.catsuri33.fratospia;

import fr.catsuri33.fratospia.config.Config;
import fr.catsuri33.fratospia.groups.FratospiaArmorsItemGroup;
import fr.catsuri33.fratospia.groups.FratospiaBiomesItemGroup;
import fr.catsuri33.fratospia.groups.FratospiaMineralsItemGroup;
import fr.catsuri33.fratospia.groups.FratospiaToolsItemGroup;
import fr.catsuri33.fratospia.lists.ArmorsMaterials;
import fr.catsuri33.fratospia.lists.BlockList;
import fr.catsuri33.fratospia.lists.ItemList;
import fr.catsuri33.fratospia.lists.ToolsMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Fratospia.MODID)
public class Fratospia {

    public static Fratospia instance;
    public static final String MODID = "fratospia";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup fratospia_minerals = new FratospiaMineralsItemGroup();
    public static final ItemGroup fratospia_tools = new FratospiaToolsItemGroup();
    public static final ItemGroup fratospia_armors = new FratospiaArmorsItemGroup();
    public static final ItemGroup fratospia_biomes = new FratospiaBiomesItemGroup();

    public Fratospia() {

        instance = this;

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config, "fratospia-server.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config, "fratospia-client.toml");

        Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("fratospia-server.toml").toString());
        Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("fratospia-client.toml").toString());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {

        //OresGeneration.setupOreGeneration();
        LOGGER.info("[ Fratospia ] Setup method registered !");

    }

    private void clientRegistries(final FMLClientSetupEvent event) {

        LOGGER.info("[ Fratospia ] Client method registered !");

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents{

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> e){

            e.getRegistry().registerAll(

                    // Items

                    ItemList.silver_ingot = new Item(new Item.Properties().group(fratospia_minerals)).setRegistryName(location("silver_ingot")),

                    // Tools

                    ItemList.silver_axe = new AxeItem(ToolsMaterials.silver_axe, -1.0f, -2.9f, new Item.Properties().group(fratospia_tools)).setRegistryName(location("silver_axe")),
                    ItemList.silver_pickaxe = new PickaxeItem(ToolsMaterials.silver_pickaxe, -1,-2.8f, new Item.Properties().group(fratospia_tools)).setRegistryName(location("silver_pickaxe")),
                    ItemList.silver_shovel = new ShovelItem(ToolsMaterials.silver_shovel, -1.0f,-3.0f, new Item.Properties().group(fratospia_tools)).setRegistryName(location("silver_shovel")),
                    ItemList.silver_sword = new SwordItem(ToolsMaterials.silver_sword, -1,-2.4f, new Item.Properties().group(fratospia_tools)).setRegistryName(location("silver_sword")),
                    ItemList.silver_hoe = new HoeItem(ToolsMaterials.silver_hoe,-0.5f, new Item.Properties().group(fratospia_tools)).setRegistryName(location("silver_hoe")),

                    // Armors

                    ItemList.silver_helmet = new ArmorItem(ArmorsMaterials.silver, EquipmentSlotType.HEAD, new Item.Properties().group(fratospia_armors)).setRegistryName(location("silver_helmet")),
                    ItemList.silver_chestplate = new ArmorItem(ArmorsMaterials.silver, EquipmentSlotType.CHEST, new Item.Properties().group(fratospia_armors)).setRegistryName(location("silver_chestplate")),
                    ItemList.silver_leggings = new ArmorItem(ArmorsMaterials.silver, EquipmentSlotType.LEGS, new Item.Properties().group(fratospia_armors)).setRegistryName(location("silver_leggings")),
                    ItemList.silver_boots = new ArmorItem(ArmorsMaterials.silver, EquipmentSlotType.FEET, new Item.Properties().group(fratospia_armors)).setRegistryName(location("silver_boots")),

                    // Blocks Items

                    ItemList.silver_block = new BlockItem(BlockList.silver_block, new Item.Properties().group(fratospia_minerals)).setRegistryName(location("silver_block")),
                    ItemList.silver_ore_overworld = new BlockItem(BlockList.silver_ore_overworld, new Item.Properties().group(fratospia_minerals)).setRegistryName(location("silver_ore_overworld")),
                    ItemList.silver_ore_nether = new BlockItem(BlockList.silver_ore_nether, new Item.Properties().group(fratospia_minerals)).setRegistryName(location("silver_ore_nether")),
                    ItemList.silver_ore_end = new BlockItem(BlockList.silver_ore_end, new Item.Properties().group(fratospia_minerals)).setRegistryName(location("silver_ore_end"))

            );

            LOGGER.info("[ Fratospia ] Items registered !");

        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> e){

            e.getRegistry().registerAll(

                    BlockList.silver_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("silver_block")),

                    BlockList.silver_ore_overworld = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("silver_ore_overworld")),
                    BlockList.silver_ore_nether = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("silver_ore_nether")),
                    BlockList.silver_ore_end = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("silver_ore_end"))

            );

            LOGGER.info("[ Fratospia ] Blocks registered !");

        }

        private static ResourceLocation location(String name){

            return new ResourceLocation(MODID, name);

        }

    }

}

