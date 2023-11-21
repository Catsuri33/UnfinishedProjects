package fr.catsuri33.insiserveressential.listeners;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        Player p = e.getPlayer();
        String message = e.getMessage();

        // 2FA
        if(InsiServerEssential.getInstance().authLocked.contains(p.getUniqueId())){

            try{

                Integer code = Integer.parseInt(message);

                if(InsiServerEssential.getInstance().playerInputCode(p, code)){

                    InsiServerEssential.getInstance().authLocked.remove(p.getUniqueId());

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        p.sendMessage("§bInsiServer§fEssential §6» §aCode correct, welcome on the server !");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        p.sendMessage("§bInsiServer§fEssential §6» §aCode correct, bienvenue sur le serveur !");

                    }

                } else {

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                        p.sendMessage("§bInsiServer§fEssential §6» §cIncorrect or expired code !");

                    }

                    if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                        p.sendMessage("§bInsiServer§fEssential §6» §cCode incorrect ou expiré !");

                    }

                }

            } catch(Exception ex){

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                    p.sendMessage("§bInsiServer§fEssential §6» §cIncorrect or expired code !");

                }

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                    p.sendMessage("§bInsiServer§fEssential §6» §cCode incorrect ou expiré !");

                }

            }

            e.setCancelled(true);

        }

    }

}
