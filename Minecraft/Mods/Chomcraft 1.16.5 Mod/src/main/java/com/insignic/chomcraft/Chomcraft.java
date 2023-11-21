package com.insignic.chomcraft;

import com.insignic.chomcraft.client.event.RichPresenceChanger;
import com.insignic.chomcraft.core.Discord;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Chomcraft.MOD_ID)
public class Chomcraft {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "chomcraft";

    public Chomcraft(){

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);

        Discord.start();
        Discord.updatePresence("", "Minecraft 1.16.5", "chomcraft_logo", "Chomcraft Saison 1", "", "");

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(RichPresenceChanger::onPlayerJoinWorld);
        MinecraftForge.EVENT_BUS.addListener(RichPresenceChanger::onPlayerQuitWorld);

    }

    private void setup(final FMLCommonSetupEvent e){



    }

    private void clientSetup(final FMLClientSetupEvent e){



    }

}
