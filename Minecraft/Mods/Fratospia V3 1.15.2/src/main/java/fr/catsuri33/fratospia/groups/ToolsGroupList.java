package fr.catsuri33.fratospia.groups;

import fr.catsuri33.fratospia.init.ItemsInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ToolsGroupList extends ItemGroup {

    public static final ToolsGroupList instance = new ToolsGroupList(ItemGroup.GROUPS.length, "tools");

    private ToolsGroupList(int index, String label){

        super(index, label);

    }

    @Override
    public ItemStack createIcon(){

        return new ItemStack(ItemsInit.silver_pickaxe);

    }

}
