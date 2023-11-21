package fr.odilonesport.fallenkingdoms.game.guis;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.utils.BannerColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class TeamGui implements Listener {

    private final Inventory inv;
    private static final Map<UUID, String> playersTeam = new HashMap<>();

    public TeamGui(Player p) {

        if(playersTeam.containsKey(p.getUniqueId())){

            inv = Bukkit.createInventory(null, 9, "§8Sélection: §e" + playersTeam.get(p.getUniqueId()));

        } else {

            inv = Bukkit.createInventory(null, 9, "§8Sélection: §eChoisir");

        }

        initializeItems();

    }

    public void initializeItems() {

        Object[] teamFields = Main.getInstance().getConfig().getConfigurationSection("game.teams").getKeys(false).toArray();

        for(Object key : teamFields){

            String teamName = key.toString().substring(0, 1).toUpperCase() + key.toString().substring(1);
            String teamColor = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("game.teams." + key + ".color"));

            inv.addItem(createGuiItem(BannerColor.getBanner(teamColor), teamColor + teamName, "§fRejoindre l'équipe " + teamColor + teamName + "§f."));

        }

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

    public static Map<UUID, String> getPlayersTeam() {

        return playersTeam;

    }

}
