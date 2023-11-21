package fr.catsuri33.fk.listeners.item;

import fr.catsuri33.fk.Main;
import fr.catsuri33.fk.game.guis.KitsGui;
import fr.catsuri33.fk.utils.GameStates;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if(GameStates.isState(GameStates.WAITING) && !p.getGameMode().equals(GameMode.CREATIVE)){

            e.setCancelled(true);

        }

        if(e.getView().getTitle().equals("§8Sélection: §eChoisir") || e.getView().getTitle().equals("§8Sélection: §e" + KitsGui.getPlayersKit().get(p.getUniqueId()))){

            if(e.getSlot() == 0){

                if(KitsGui.getPlayersKit().containsKey(p.getUniqueId())){

                    KitsGui.getPlayersKit().remove(p.getUniqueId());

                }

                KitsGui.getPlayersKit().put(p.getUniqueId(), "Guerrier");
                p.sendMessage(Main.prefix + "§6Votre kit : §eGuerrier");
                p.getOpenInventory().close();

            }

            if(e.getSlot() == 1){

                if(KitsGui.getPlayersKit().containsKey(p.getUniqueId())){

                    KitsGui.getPlayersKit().remove(p.getUniqueId());

                }

                KitsGui.getPlayersKit().put(p.getUniqueId(), "Mineur");
                p.sendMessage(Main.prefix + "§6Votre kit : §eMineur");
                p.getOpenInventory().close();

            }

            if(e.getSlot() == 2){

                if(KitsGui.getPlayersKit().containsKey(p.getUniqueId())){

                    KitsGui.getPlayersKit().remove(p.getUniqueId());

                }

                KitsGui.getPlayersKit().put(p.getUniqueId(), "Farmer");
                p.sendMessage(Main.prefix + "§6Votre kit : §eFarmer");
                p.getOpenInventory().close();

            }

            if(e.getSlot() == 3){

                if(KitsGui.getPlayersKit().containsKey(p.getUniqueId())){

                    KitsGui.getPlayersKit().remove(p.getUniqueId());

                }

                KitsGui.getPlayersKit().put(p.getUniqueId(), "");
                p.sendMessage(Main.prefix + "§6Votre kit : §e");
                p.getOpenInventory().close();

            }

            if(e.getSlot() == 4){

                if(KitsGui.getPlayersKit().containsKey(p.getUniqueId())){

                    KitsGui.getPlayersKit().remove(p.getUniqueId());

                }

                KitsGui.getPlayersKit().put(p.getUniqueId(), "Archer");
                p.sendMessage(Main.prefix + "§6Votre kit : §eArcher");
                p.getOpenInventory().close();

            }

            if(e.getSlot() == 5){

                if(KitsGui.getPlayersKit().containsKey(p.getUniqueId())){

                    KitsGui.getPlayersKit().remove(p.getUniqueId());

                }

                KitsGui.getPlayersKit().put(p.getUniqueId(), "Alchimiste");
                p.sendMessage(Main.prefix + "§6Votre kit : §eAlchimiste");
                p.getOpenInventory().close();

            }

            if(e.getSlot() == 6){

                if(KitsGui.getPlayersKit().containsKey(p.getUniqueId())){

                    KitsGui.getPlayersKit().remove(p.getUniqueId());

                }

                KitsGui.getPlayersKit().put(p.getUniqueId(), "Enchanteur");
                p.sendMessage(Main.prefix + "§6Votre kit : §eEnchanteur");
                p.getOpenInventory().close();

            }

        }

    }

}
