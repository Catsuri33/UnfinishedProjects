package fr.catsuri33.fratospia.groups;

import fr.catsuri33.fratospia.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class FratospiaToolsItemGroup extends ItemGroup {

    public FratospiaToolsItemGroup(){

        super("fratospia_tools");

    }

    @Override
    public ItemStack createIcon(){

        return new ItemStack(ItemList.silver_pickaxe);

    }

}
