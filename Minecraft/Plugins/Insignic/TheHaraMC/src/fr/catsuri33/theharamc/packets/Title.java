/*                              */
/*       TheHaraMC-UHC          */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 12/08/2019       */
/*    Updated: 12/08/2019       */
/*    Name: Title               */
/*                              */

package fr.catsuri33.theharamc.packets;

import net.minecraft.server.v1_9_R1.IChatBaseComponent;
import net.minecraft.server.v1_9_R1.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Title {

    public static void sendTitle(Player player, String title, String subtitle, int ticks){

        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \""+title+"\"}");
        IChatBaseComponent chatSubtitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \""+subtitle+"\"}");
        PacketPlayOutTitle p = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle p2 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatSubtitle);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p2);

    }

    public static void sendTime(Player player, int ticks){

        PacketPlayOutTitle p = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, 20, ticks, 20);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p);

    }

}