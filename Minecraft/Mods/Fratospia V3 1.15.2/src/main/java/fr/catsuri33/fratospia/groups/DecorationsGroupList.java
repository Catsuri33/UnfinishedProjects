package fr.catsuri33.fratospia.groups;

import fr.catsuri33.fratospia.init.BlocksInit;
import fr.catsuri33.fratospia.init.ItemsInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class DecorationsGroupList extends ItemGroup {

    public static final DecorationsGroupList instance = new DecorationsGroupList(ItemGroup.GROUPS.length, "decorations");

    private DecorationsGroupList(int index, String label){

        super(index, label);

    }

    @Override
    public ItemStack createIcon(){

        return new ItemStack(BlocksInit.oak_stool);

    }

}
