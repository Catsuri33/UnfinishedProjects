package com.epicgiant.hub;

import com.epicgiant.hub.utils.ItemStackUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public class EpicGiant extends JavaPlugin {

    public static ItemStack gamesItem = ItemStackUtils.itemStackBuilder(new ItemStack(Material.COMPASS, 1), "§a§lJeux", new ArrayList<>(Arrays.asList("§6§l> §r§eCliquez ici pour", "§eaccéder aux jeux !")));

    @Override
    public void onEnable() {

        super.onEnable();

    }

    @Override
    public void onDisable() {

        super.onDisable();

    }

}
