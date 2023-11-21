package com.insignicnetwork.essentials.managers;

import com.insignicnetwork.essentials.Essentials;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerManager {

    private Player p;
    private ItemStack[] items = new ItemStack[41];

    public PlayerManager(Player p){

        this.p = p;

    }

    public void init(){

        Essentials.getInstance().players.put(p.getUniqueId(), this);

    }

    public void destroy(){

        Essentials.getInstance().players.remove(p.getUniqueId(), this);

    }

    public static PlayerManager getFromPlayer(Player p){

        return Essentials.getInstance().players.get(p.getUniqueId());

    }

    public ItemStack[] getItems() {

        return items;

    }

    public void saveInventory(){

        for(int slot = 0; slot < 36; slot++){

            ItemStack item = p.getInventory().getItem(slot);
            if(item != null){

                items[slot] = item;

            }

        }

        items[36] = p.getInventory().getHelmet();
        items[37] = p.getInventory().getChestplate();
        items[38] = p.getInventory().getLeggings();
        items[39] = p.getInventory().getBoots();
        items[40] = p.getInventory().getItemInOffHand();

    }

    public void giveInventory(){

        p.getInventory().clear();

        for(int slot = 0; slot < 36; slot++){

            ItemStack item = items[slot];
            if(item != null){

                p.getInventory().setItem(slot, item);

            }

        }

        p.getInventory().setHelmet(items[36]);
        p.getInventory().setChestplate(items[37]);
        p.getInventory().setLeggings(items[38]);
        p.getInventory().setBoots(items[39]);
        p.getInventory().setItemInOffHand(items[40]);

    }

}
