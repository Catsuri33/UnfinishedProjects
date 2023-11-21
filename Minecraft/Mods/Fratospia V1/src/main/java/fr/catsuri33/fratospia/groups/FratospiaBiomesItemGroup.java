package fr.catsuri33.fratospia.groups;

import fr.catsuri33.fratospia.lists.ItemList;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class FratospiaBiomesItemGroup extends ItemGroup {

    public FratospiaBiomesItemGroup(){

        super("fratospia_biomes");

    }

    @Override
    public ItemStack createIcon(){

        return new ItemStack(ItemList.silver_ingot);

    }

}
