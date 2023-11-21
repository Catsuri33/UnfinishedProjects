package fr.catsuri33.uhc.scenarios.scenarios;

import fr.catsuri33.uhc.scenarios.Scenario;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class CutClean extends Scenario {
    public CutClean() {
        super("§eCut Clean", Arrays.asList("§7Cuit automatiquement les minérais", "et la nourriture."), Material.IRON_INGOT);
    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {
        ItemStack is = event.getEntity().getItemStack();
        if (is != null) {
            ItemStack replace = null;
            switch(is.getType()) {
                case IRON_ORE:
                    replace = new ItemStack(Material.IRON_INGOT);
                    break;
                case GOLD_ORE:
                    replace = new ItemStack(Material.GOLD_INGOT);
                    break;
                case COAL_ORE:
                    replace = new ItemStack(Material.COAL);
            }

            if (replace != null) {
                event.getEntity().setItemStack(replace);
            }

        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        EntityType entity = event.getEntityType();
        List<ItemStack> loots = event.getDrops();

        for(int i = loots.size() - 1; i >= 0; --i) {
            ItemStack is = (ItemStack)loots.get(i);
            if (is == null) {
                return;
            }

            switch(is.getType()) {
                case BEEF:
                    loots.remove(i);
                    loots.add(new ItemStack(Material.COOKED_BEEF));
                    break;
                case PORKCHOP:
                    loots.remove(i);
                    loots.add(new ItemStack(Material.COOKED_PORKCHOP));
                    break;
                case CHICKEN:
                    loots.remove(i);
                    loots.add(new ItemStack(Material.COOKED_CHICKEN));
                    break;
                case MUTTON:
                    loots.remove(i);
                    loots.add(new ItemStack(Material.COOKED_MUTTON));
                    break;
                case RABBIT:
                    loots.remove(i);
                    loots.add(new ItemStack(Material.COOKED_RABBIT));
                    break;
                case COD:
                    loots.remove(i);
                    loots.add(new ItemStack(Material.COOKED_COD));
                    break;
                case SALMON:
                    loots.remove(i);
                    loots.add(new ItemStack(Material.COOKED_SALMON));
                    break;
                case POTATO:
                    loots.remove(i);
                    loots.add(new ItemStack(Material.BAKED_POTATO));
            }
        }

    }
}

