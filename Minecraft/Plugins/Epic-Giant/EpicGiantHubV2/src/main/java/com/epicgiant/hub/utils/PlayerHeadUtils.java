package com.epicgiant.hub.utils;

import net.minecraft.server.v1_14_R1.NBTTagCompound;
import net.minecraft.server.v1_14_R1.NBTTagList;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class PlayerHeadUtils {

    public static ItemStack skullTextureBuilder(String skullTexture) {

        net.minecraft.server.v1_14_R1.ItemStack itemStack = CraftItemStack.asNMSCopy(new ItemStack(Material.PLAYER_HEAD, 1));

        NBTTagCompound tag;

        if (itemStack.hasTag()) {

            tag = itemStack.getTag();

        } else {

            tag = new NBTTagCompound();

        }

        NBTTagCompound skullOwner = new NBTTagCompound();
        NBTTagCompound properties = new NBTTagCompound();
        NBTTagList textures = new NBTTagList();
        NBTTagCompound texture = new NBTTagCompound();

        texture.setString("Value", skullTexture);
        textures.add(texture);
        properties.set("textures", textures);
        skullOwner.set("Properties", properties);
        tag.set("SkullOwner", skullOwner);

        itemStack.setTag(tag);

        return CraftItemStack.asBukkitCopy(itemStack);
    }

}
