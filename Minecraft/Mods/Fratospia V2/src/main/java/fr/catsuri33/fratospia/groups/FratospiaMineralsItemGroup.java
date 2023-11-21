package fr.catsuri33.fratospia.groups;

import fr.catsuri33.fratospia.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class FratospiaMineralsItemGroup extends ItemGroup {

    public FratospiaMineralsItemGroup(){

        super("fratospia_minerals");

    }

    @Override
    public ItemStack createIcon(){

        return new ItemStack(ItemList.silver_ingot);

    }

}
