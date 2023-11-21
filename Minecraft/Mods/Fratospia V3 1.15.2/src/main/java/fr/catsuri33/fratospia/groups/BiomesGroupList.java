package fr.catsuri33.fratospia.groups;

import fr.catsuri33.fratospia.init.ItemsInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class BiomesGroupList extends ItemGroup {

    public static final BiomesGroupList instance = new BiomesGroupList(ItemGroup.GROUPS.length, "biomes");

    private BiomesGroupList(int index, String label){

        super(index, label);

    }

    @Override
    public ItemStack createIcon(){

        return new ItemStack(Items.OAK_WOOD);

    }

}
