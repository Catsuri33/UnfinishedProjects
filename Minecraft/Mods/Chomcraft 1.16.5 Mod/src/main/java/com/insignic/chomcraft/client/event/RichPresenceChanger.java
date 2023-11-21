package com.insignic.chomcraft.client.event;

import com.insignic.chomcraft.Chomcraft;
import com.insignic.chomcraft.core.Discord;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Chomcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RichPresenceChanger {

    public static void onPlayerJoinWorld(EntityJoinWorldEvent e){

        if(e.getEntity() instanceof PlayerEntity){

            PlayerEntity player = (PlayerEntity) e.getEntity();

            if(player == Minecraft.getInstance().player){

                if(e.getWorld().isClientSide()){

                    Discord.updatePresence("Joue en solo.", "Minecraft 1.16.5", "chomcraft_logo", "Chomcraft Saison 1", "", "");

                } else {

                    Discord.updatePresence("Joue en multijoueur.", "Minecraft 1.16.5", "chomcraft_logo", "Chomcraft Saison 1", "", "");

                }

            }

        }

    }

    public static void onPlayerQuitWorld(EntityLeaveWorldEvent e){

        if(e.getEntity() instanceof PlayerEntity){

            PlayerEntity player = (PlayerEntity) e.getEntity();

            Chomcraft.LOGGER.error("PLAYER QUIT WORLD");

            if(player == Minecraft.getInstance().player){

                Chomcraft.LOGGER.error("UPDATE RPC");
                Discord.updatePresence("", "Minecraft 1.16.5", "chomcraft_logo", "Chomcraft Saison 1", "", "");

            }

        }

    }

}
