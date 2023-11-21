package fr.catsuri33.fratospia.init;

import fr.catsuri33.fratospia.Fratospia;
import fr.catsuri33.fratospia.groups.FarmingGroupList;
import fr.catsuri33.fratospia.groups.MineralsGroupList;
import fr.catsuri33.fratospia.groups.ToolsGroupList;
import fr.catsuri33.fratospia.items.tools.tiers.ArmorTiers;
import fr.catsuri33.fratospia.items.tools.tiers.ToolTiers;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Fratospia.MODID, bus = Bus.MOD)
@ObjectHolder(Fratospia.MODID)
public class ItemsInit {

    // Ingots
    public static final Item silver_ingot = null;

    // Food
    public static final Item tomato = null;
    public static final Item red_chili_pepper = null;
    public static final Item green_chili_pepper = null;
    public static final Item chili_pepper_salad = null;

    // Tools
    public static final Item silver_sword = null;
    public static final Item silver_axe = null;
    public static final Item silver_pickaxe = null;
    public static final Item silver_shovel = null;
    public static final Item silver_hoe = null;

    // Armors
    public static final Item silver_helmet = null;
    public static final Item silver_chestplate = null;
    public static final Item silver_leggings = null;
    public static final Item silver_boots = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> e){

        // Ingots
        e.getRegistry().register(new Item(new Item.Properties().group(MineralsGroupList.instance)).setRegistryName("silver_ingot"));

        // Food
        e.getRegistry().register(new Item(new Item.Properties().group(FarmingGroupList.instance).food(new Food.Builder().hunger(4).saturation(0.8f).build())).setRegistryName("tomato"));
        e.getRegistry().register(new Item(new Item.Properties().group(FarmingGroupList.instance).food(new Food.Builder().hunger(2).saturation(0.4f).build())).setRegistryName("red_chili_pepper"));
        e.getRegistry().register(new Item(new Item.Properties().group(FarmingGroupList.instance).food(new Food.Builder().hunger(2).saturation(0.4f).build())).setRegistryName("green_chili_pepper"));
        e.getRegistry().register(new Item(new Item.Properties().group(FarmingGroupList.instance).food(new Food.Builder().hunger(6).saturation(0.8f).effect(new EffectInstance(Effects.FIRE_RESISTANCE, 200, 0), 1.0f).build())).setRegistryName("chili_pepper_salad"));

        // Tools
        e.getRegistry().register(new SwordItem(ToolTiers.SILVER, 3, -2.4f, new Item.Properties().group(ToolsGroupList.instance)).setRegistryName("silver_sword"));
        e.getRegistry().register(new AxeItem(ToolTiers.SILVER, 6.0f, -3.1f, new Item.Properties().group(ToolsGroupList.instance)).setRegistryName("silver_axe"));
        e.getRegistry().register(new PickaxeItem(ToolTiers.SILVER, 1, -2.8f, new Item.Properties().group(ToolsGroupList.instance)).setRegistryName("silver_pickaxe"));
        e.getRegistry().register(new ShovelItem(ToolTiers.SILVER, 1.5f, -3.0f, new Item.Properties().group(ToolsGroupList.instance)).setRegistryName("silver_shovel"));
        e.getRegistry().register(new HoeItem(ToolTiers.SILVER, -1.0f, new Item.Properties().group(ToolsGroupList.instance)).setRegistryName("silver_hoe"));

        // Armors
        e.getRegistry().register(new ArmorItem(ArmorTiers.SILVER, EquipmentSlotType.HEAD, new Item.Properties().group(ToolsGroupList.instance)).setRegistryName("silver_helmet"));
        e.getRegistry().register(new ArmorItem(ArmorTiers.SILVER, EquipmentSlotType.CHEST, new Item.Properties().group(ToolsGroupList.instance)).setRegistryName("silver_chestplate"));
        e.getRegistry().register(new ArmorItem(ArmorTiers.SILVER, EquipmentSlotType.LEGS, new Item.Properties().group(ToolsGroupList.instance)).setRegistryName("silver_leggings"));
        e.getRegistry().register(new ArmorItem(ArmorTiers.SILVER, EquipmentSlotType.FEET, new Item.Properties().group(ToolsGroupList.instance)).setRegistryName("silver_boots"));
    }

}
