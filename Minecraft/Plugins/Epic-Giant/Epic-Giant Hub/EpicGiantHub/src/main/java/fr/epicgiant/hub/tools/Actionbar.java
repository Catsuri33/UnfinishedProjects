package fr.epicgiant.hub.tools;

import net.minecraft.server.v1_14_R1.IChatBaseComponent;
import net.minecraft.server.v1_14_R1.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Actionbar {

    public static void sendActionbar(Player player, String message){

        IChatBaseComponent actionbarTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \""+message+"\"}");
        PacketPlayOutTitle p = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.ACTIONBAR, actionbarTitle);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p);

    }

}
