package fr.catsuri33.fratospia.groups;

import fr.catsuri33.fratospia.init.ItemsInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MineralsGroupList extends ItemGroup {

    public static final MineralsGroupList instance = new MineralsGroupList(ItemGroup.GROUPS.length, "minerals");

    private MineralsGroupList(int index, String label){

        super(index, label);

    }

    @Override
    public ItemStack createIcon(){

        return new ItemStack(ItemsInit.silver_ingot);

    }

}
