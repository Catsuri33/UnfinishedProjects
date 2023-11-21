package fr.catsuri33.fratospia.groups;

import fr.catsuri33.fratospia.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class FratospiaArmorsItemGroup extends ItemGroup {

    public FratospiaArmorsItemGroup(){

        super("fratospia_armors");

    }

    @Override
    public ItemStack createIcon(){

        return new ItemStack(ItemList.silver_chestplate);

    }

}
