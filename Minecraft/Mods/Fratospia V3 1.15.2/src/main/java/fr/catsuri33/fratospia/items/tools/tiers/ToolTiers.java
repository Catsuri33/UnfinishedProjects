package fr.catsuri33.fratospia.items.tools.tiers;

import fr.catsuri33.fratospia.init.ItemsInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ToolTiers implements IItemTier {

    SILVER(2, 500, 6.5f, 2.5f, 12, () -> {

        return Ingredient.fromItems(ItemsInit.silver_ingot);

    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyIn;
    private final float attackDamageIn;
    private final int enchantabilityIn;
    private final LazyValue<Ingredient> repairMaterialIn;

    private ToolTiers(int harvestLevel, int maxUses, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn){

        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiencyIn = efficiencyIn;
        this.attackDamageIn = attackDamageIn;
        this.enchantabilityIn = enchantabilityIn;
        this.repairMaterialIn = new LazyValue<>(repairMaterialIn);

    }

    @Override
    public int getMaxUses() {

        return this.maxUses;

    }

    @Override
    public float getEfficiency() {

        return this.efficiencyIn;

    }

    @Override
    public float getAttackDamage() {

        return this.attackDamageIn;

    }

    @Override
    public int getHarvestLevel() {

        return this.harvestLevel;

    }

    @Override
    public int getEnchantability() {

        return this.enchantabilityIn;

    }

    @Override
    public Ingredient getRepairMaterial() {

        return this.repairMaterialIn.getValue();

    }
}
