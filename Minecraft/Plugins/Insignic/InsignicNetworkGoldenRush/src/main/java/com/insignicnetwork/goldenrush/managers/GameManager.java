package com.insignicnetwork.goldenrush.managers;

import com.insignicnetwork.goldenrush.game.GameStates;
import com.insignicnetwork.goldenrush.utils.Title;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GameManager {

    public GameManager(){



    }

    public void loadGame(Player p) {

        GameStates.setState(GameStates.GAME_MINE);

        if (GameStates.isState(GameStates.GAME_MINE)) {

            new Title("§6GoldenRush", "§eDébut de la §aphase de minage §e!").send(p, 2, 5, 2);
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);

            ItemStack goldPickaxe = new ItemStack(Material.GOLDEN_PICKAXE, 1);
            ItemMeta goldPickaxeMeta = goldPickaxe.getItemMeta();
            goldPickaxeMeta.setUnbreakable(true);
            goldPickaxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            goldPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 4, true);
            goldPickaxe.setItemMeta(goldPickaxeMeta);

            p.getInventory().setItem(0, goldPickaxe);

        }

    }

    public void loadShop(Player p){

        GameStates.setState(GameStates.GAME_SHOP);

        if(GameStates.isState(GameStates.GAME_SHOP)){

            p.getInventory().remove(Material.GOLDEN_PICKAXE);

            new Title("§6GoldenRush", "§eDébut de la §aphase d'achat §e!").send(p, 2, 5, 2);
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
            p.teleport(new Location(p.getWorld(), -9.5, 4, 8.5, 90, 0));

        }

    }

    public void loadPvp(Player p){

        GameStates.setState(GameStates.GAME_PVP);

        if(GameStates.isState(GameStates.GAME_PVP)){

            new Title("§6GoldenRush", "§eDébut de la §aphase de combat §e!").send(p, 2, 5, 2);
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);

        }

    }

}
