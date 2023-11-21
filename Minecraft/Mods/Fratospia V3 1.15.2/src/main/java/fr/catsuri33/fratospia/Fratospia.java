package fr.catsuri33.fratospia;

import fr.catsuri33.fratospia.world.generation.OresGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("fratospia")
public class Fratospia {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "fratospia";
    public static Fratospia instance;

    public Fratospia() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        instance = this;

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent e) {

        LOGGER.info("[ Fratospia ] Setup started...");

    }

    private void doClientStuff(final FMLClientSetupEvent e){



    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent e){

        LOGGER.info("[ Fratospia ] Generating ores !");
        OresGeneration.generateOres();

    }

    @SubscribeEvent
    public static void loadComplete(FMLLoadCompleteEvent e){



    }

}
