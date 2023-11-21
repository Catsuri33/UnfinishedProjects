package fr.catsuri33.fratospia.items.tools.tiers;

import fr.catsuri33.fratospia.Fratospia;
import fr.catsuri33.fratospia.init.ItemsInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ArmorTiers implements IArmorMaterial {

    SILVER(Fratospia.MODID + ":silver", 18, new int[]{ 2, 6, 7, 2 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> {

        return Ingredient.fromItems(ItemsInit.silver_ingot);

    });

    private static final int[] maxDamageArray = new int[] { 13, 15, 16, 11 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;

    private ArmorTiers(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughnessIn, Supplier<Ingredient> repairMaterialSupplier) {

        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = toughnessIn;
        this.repairMaterial = new LazyValue<>(repairMaterialSupplier);

    }


    @Override
    public int getDurability(EquipmentSlotType slotIn) {

        return this.maxDamageArray[slotIn.getIndex()] * this.maxDamageFactor;

    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {

        return this.damageReductionAmountArray[slotIn.getIndex()];

    }

    @Override
    public int getEnchantability() {

        return this.enchantability;

    }

    @Override
    public SoundEvent getSoundEvent() {

        return this.soundEvent;

    }

    @Override
    public Ingredient getRepairMaterial() {

        return this.repairMaterial.getValue();

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {

        return this.name;

    }

    @Override
    public float getToughness() {

        return this.toughness;

    }
}
