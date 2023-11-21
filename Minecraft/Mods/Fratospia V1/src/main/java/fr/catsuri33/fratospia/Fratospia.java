package fr.catsuri33.fratospia;

import fr.catsuri33.fratospia.groups.FratospiaMineralsItemGroup;
import fr.catsuri33.fratospia.lists.BlockList;
import fr.catsuri33.fratospia.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Fratospia.MODID)
public class Fratospia {

    public static Fratospia instance;
    public static final String MODID = "fratospia";
    private static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup fratospia_minerals = new FratospiaMineralsItemGroup();

    public Fratospia() {

        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {

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

                    // Blocks Items

                    ItemList.silver_block = new BlockItem(BlockList.silver_block, new Item.Properties().group(fratospia_minerals)).setRegistryName(location("silver_block"))

            );

            LOGGER.info("[ Fratospia ] Items registered !");

        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> e){

            e.getRegistry().registerAll(

                    BlockList.silver_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("silver_block"))

            );

            LOGGER.info("[ Fratospia ] Items registered !");

        }

        private static ResourceLocation location(String name){

            return new ResourceLocation(MODID, name);

        }

    }

}

