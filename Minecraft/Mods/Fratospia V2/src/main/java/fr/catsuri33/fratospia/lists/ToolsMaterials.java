package fr.catsuri33.fratospia.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolsMaterials implements IItemTier {

    silver_axe(9.5f, 9.0f, 800, 3, 25, ItemList.silver_ingot),
    silver_pickaxe(4.5f, 9.0f, 800, 3, 25, ItemList.silver_ingot),
    silver_shovel(5.0f, 9.0f, 800, 3, 25, ItemList.silver_ingot),
    silver_sword(6.5f, 9.0f, 800, 3, 25, ItemList.silver_ingot),
    silver_hoe(1.0f, 9.0f, 800, 3, 25, ItemList.silver_ingot);

    private float attackDamage, efficiency;
    private int durability, harvestLevel, enchantability;
    private Item repairMaterial;

    ToolsMaterials(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial){

        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;

    }

    @Override
    public float getAttackDamage() {

        return this.attackDamage;

    }

    @Override
    public float getEfficiency() {

        return this.efficiency;

    }

    @Override
    public int getEnchantability() {

        return this.enchantability;

    }

    @Override
    public int getHarvestLevel() {

        return this.harvestLevel;

    }

    @Override
    public int getMaxUses() {

        return this.durability;

    }

    @Override
    public Ingredient getRepairMaterial() {

        return Ingredient.fromItems(this.repairMaterial);

    }
}
