/*                              */
/*       TheHaraMC-UHC          */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 12/08/2019       */
/*    Updated: 12/08/2019       */
/*    Name: Actionbar           */
/*                              */

package fr.catsuri33.theharamc.packets;

import net.minecraft.server.v1_9_R1.IChatBaseComponent;
import net.minecraft.server.v1_9_R1.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Actionbar {

    public static void sendActionbar(Player player, String message){

        IChatBaseComponent actionbarTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \""+message+"\"}");
        PacketPlayOutChat  p = new PacketPlayOutChat(actionbarTitle, (byte) 2);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p);

    }

}
