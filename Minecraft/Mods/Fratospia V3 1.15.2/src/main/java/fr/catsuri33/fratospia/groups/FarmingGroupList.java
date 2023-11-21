package fr.catsuri33.fratospia.groups;

import fr.catsuri33.fratospia.init.ItemsInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class FarmingGroupList extends ItemGroup {

    public static final FarmingGroupList instance = new FarmingGroupList(ItemGroup.GROUPS.length, "farming");

    private FarmingGroupList(int index, String label){

        super(index, label);

    }

    @Override
    public ItemStack createIcon(){

        return new ItemStack(ItemsInit.tomato);

    }

}
