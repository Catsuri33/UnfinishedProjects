package fr.catsuri33.fratospia.lists;

import fr.catsuri33.fratospia.Fratospia;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorsMaterials implements IArmorMaterial {

    silver("silver", 400, new int[]{2, 5, 7, 2}, 25, ItemList.silver_ingot, "item.armor.equip_iron", 0.0f);

    private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
    private String name, equipSound;
    private int durability, enchantability;
    private int[] damageReductionAmount;
    private Item repairItem;
    private float toughness;

    ArmorsMaterials(String name, int durability, int[] damageReductionAmount, int enchantability, Item repairItem, String equipSound, float toughness){

        this.name = name;
        this.durability = durability;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantability = enchantability;
        this.repairItem = repairItem;
        this.equipSound = equipSound;
        this.toughness = toughness;

    }

    public int getDamageReductionAmount(EquipmentSlotType slot) {

        return this.damageReductionAmount[slot.getIndex()];

    }

    public int getDurability(EquipmentSlotType slot) {

        return max_damage_array[slot.getIndex()] * this.durability;

    }

    @Override
    public int getEnchantability() {

        return this.enchantability;

    }

    @Override
    public String getName() {

        return Fratospia.MODID + ":" + this.name;

    }

    @Override
    public Ingredient getRepairMaterial() {

        return Ingredient.fromItems(this.repairItem);

    }

    @Override
    public SoundEvent getSoundEvent() {

        return new SoundEvent(new ResourceLocation(equipSound));

    }

    @Override
    public float getToughness() {

        return this.toughness;

    }

}
