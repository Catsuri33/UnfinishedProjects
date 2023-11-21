package fr.catsuri33.fk.game.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KitsGui implements Listener {

    private final Inventory inv;
    private static final Map<UUID, String> playersKit = new HashMap<>();

    public KitsGui(Player p) {

        if(playersKit.containsKey(p.getUniqueId())){

            inv = Bukkit.createInventory(null, 9, "§8Sélection: §e" + playersKit.get(p.getUniqueId()));

        } else {

            inv = Bukkit.createInventory(null, 9, "§8Sélection: §eChoisir");

        }

        initializeItems();

    }

    public void initializeItems() {

        inv.addItem(createGuiItem(Material.STONE_SWORD, "§fGuerrier", "Obtenez en début de partie :", "- 1 plastron en cuir", "- Une épée en pierre §cusée"));
        inv.addItem(createGuiItem(Material.STONE_PICKAXE, "§fMineur", "Obtenez en début de partie :", "- Une pioche en pierre §defficacité I", "- Une pioche en fer §cusée"));
        inv.addItem(createGuiItem(Material.BONE, "§fFarmer", "Obtenez en début de partie :", "- 16 Bone Meals"));
        inv.addItem(createGuiItem(Material.FEATHER, "§fFarmer", "Obtenez en début de partie :", "- 16 Bone Meals"));
        inv.addItem(createGuiItem(Material.BOW, "§fArcher", "Obtenez en début de partie :", "- 16 Bone Meals"));
        inv.addItem(createGuiItem(Material.BREWING_STAND, "§fAlchimiste", "Obtenez en début de partie :", "- 16 Bone Meals"));
        inv.addItem(createGuiItem(Material.EXPERIENCE_BOTTLE, "§fEnchanteur", "Obtenez en début de partie :", "- 16 Bone Meals"));

    }

    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {

        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;

    }

    public void openInventory(final HumanEntity ent) {

        ent.openInventory(inv);

    }

    public Inventory getInventory() {

        return inv;

    }

    public static Map<UUID, String> getPlayersKit() {

        return playersKit;

    }

}
