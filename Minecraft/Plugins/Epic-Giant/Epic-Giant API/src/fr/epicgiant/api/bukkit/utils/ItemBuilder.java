package fr.epicgiant.api.bukkit.utils;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemBuilder {

    private ItemStack is;

    public ItemBuilder(Material material){

        this(material, 1);

    }

    public ItemBuilder(ItemStack is){

        this.is = is;

    }

    public ItemBuilder(Material material, int amount){

        is = new ItemStack(material, amount);

    }

    @SuppressWarnings("deprecation")
    public ItemBuilder(Material material, int amount, short meta){

        is = new ItemStack(material, amount, meta);

    }

    public ItemBuilder clone(){

        return new ItemBuilder(is);

    }

    @SuppressWarnings("deprecation")
    public ItemBuilder setDurability(short durability){

        is.setDurability(durability);
        return this;

    }

    public ItemBuilder setName(String name){

        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);
        return this;

    }

    public ItemBuilder addUnsafeEnchantment(Enchantment enchantment, int level){

        is.addUnsafeEnchantment(enchantment, level);
        return this;

    }

    public ItemBuilder removeEnchantment(Enchantment enchantment){

        is.removeEnchantment(enchantment);
        return this;

    }

    @SuppressWarnings("deprecation")
    public ItemBuilder setSkullOwner(String owner){

        try {
            SkullMeta im = (SkullMeta) is.getItemMeta();
            im.setOwner(owner);
            is.setItemMeta(im);
        } catch(ClassCastException e){
            e.printStackTrace();
        }
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level){

        ItemMeta im = is.getItemMeta();
        im.addEnchant(enchantment, level, true);
        is.setItemMeta(im);
        return this;

    }

    @SuppressWarnings("deprecation")
    public ItemBuilder setInfinityDurability(){

        is.setDurability(Short.MAX_VALUE);
        return this;

    }

    public ItemBuilder setLore(String lore){

        ItemMeta im = is.getItemMeta();
        im.setLore(Arrays.asList(lore));
        is.setItemMeta(im);
        return this;

    }

    @SuppressWarnings("deprecation")
    public ItemBuilder setClayColor(DyeColor color){

        if(!is.getType().equals(Material.CLAY))
            return this;
        this.is.setDurability(color.getDyeData());
        return this;

    }

    public ItemBuilder setLeatherArmorColor(Color color){

        try {
            LeatherArmorMeta lam = (LeatherArmorMeta) is.getItemMeta();
            lam.setColor(color);
            is.setItemMeta(lam);
        } catch(ClassCastException e){
            e.printStackTrace();
        }
        return this;
    }

    public ItemStack toItemStack(){

        return is;

    }

}
