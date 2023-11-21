package fr.catsuri33.uhcrun.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerCraftUpgrade implements Listener {

    @EventHandler
    public void onPlayerCraft(PrepareItemCraftEvent e){

        if(e.getInventory() instanceof CraftingInventory){

            CraftingInventory inventory = (CraftingInventory)e.getInventory();

            switch(inventory.getResult().getType()){

                case WOODEN_PICKAXE:

                    ItemStack isp = new ItemStack(Material.STONE_PICKAXE, 1);
                    ItemMeta imp = isp.getItemMeta();
                    imp.addEnchant(Enchantment.DIG_SPEED, 2, true);
                    imp.addEnchant(Enchantment.DURABILITY, 3, true);
                    isp.setItemMeta(imp);

                    inventory.setResult(isp);

                break;

                case WOODEN_AXE:

                    ItemStack isa = new ItemStack(Material.STONE_AXE, 1);
                    ItemMeta ima = isa.getItemMeta();
                    ima.addEnchant(Enchantment.DIG_SPEED, 2, true);
                    ima.addEnchant(Enchantment.DURABILITY, 3, true);
                    isa.setItemMeta(ima);

                    inventory.setResult(isa);

                break;

                case WOODEN_SHOVEL:

                    ItemStack iss = new ItemStack(Material.STONE_SHOVEL, 1);
                    ItemMeta ims = iss.getItemMeta();
                    ims.addEnchant(Enchantment.DIG_SPEED, 2, true);
                    ims.addEnchant(Enchantment.DURABILITY, 3, true);
                    iss.setItemMeta(ims);

                    inventory.setResult(iss);

                break;

                case WOODEN_HOE:

                    ItemStack ish = new ItemStack(Material.STONE_HOE, 1);
                    ItemMeta imh = ish.getItemMeta();
                    imh.addEnchant(Enchantment.DIG_SPEED, 2, true);
                    imh.addEnchant(Enchantment.DURABILITY, 3, true);
                    ish.setItemMeta(imh);

                    inventory.setResult(ish);

                break;

                default:
                break;

            }

        }

    }

}
