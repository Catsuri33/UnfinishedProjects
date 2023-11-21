package fr.catsuri33.insiserveressential.listeners;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import fr.catsuri33.insiserveressential.InsiServerEssential;
import fr.catsuri33.insiserveressential.lang.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        int playersOnline = Bukkit.getServer().getOnlinePlayers().size();
        String playersOnlineString = Integer.toString(playersOnline);
        int playersMax = Bukkit.getServer().getMaxPlayers();
        String playersMaxString = Integer.toString(playersMax);

        String messageStartColor = InsiServerEssential.getInstance().getConfig().getString("server.events.join.join-message");
        String messageEndColor = ChatColor.translateAlternateColorCodes('&', messageStartColor);

        String messageWithPlayer = messageEndColor.replace("%player%", p.getName());
        String messageWithPlayersOnline = messageWithPlayer.replace("%players%", playersOnlineString);
        String messageWithPlayersMax = messageWithPlayersOnline.replace("%players-max%", playersMaxString);

        e.setJoinMessage(messageWithPlayersMax);

        // Health Under Name
        if(InsiServerEssential.getInstance().getConfig().getString("server.player-health").equalsIgnoreCase("true")){

            ScoreboardManager sm = Bukkit.getScoreboardManager();
            Scoreboard s = sm.getNewScoreboard();
            Objective health = s.registerNewObjective("showhealth", Criterias.HEALTH, "Health");

            health.setDisplaySlot(DisplaySlot.BELOW_NAME);
            health.setDisplayName("§4❤");

        }

        // 2FA
        if(InsiServerEssential.getInstance().getConfig().getString("server.events.join.2FA").equalsIgnoreCase("true")){

            if(!InsiServerEssential.getInstance().configManager.get2FACodes().contains("authcodes." + p.getUniqueId())){

                GoogleAuthenticator gauth = new GoogleAuthenticator();
                GoogleAuthenticatorKey gauthKey = gauth.createCredentials();

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                    p.sendMessage("§bInsiServer§fEssential §6» §aYour GoogleAuthenticator code is §e" + gauthKey.getKey() + " §a! §c(Enter it in the GoogleAuthenticator application before leaving the server !)");

                }

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                    p.sendMessage("§bInsiServer§fEssential §6» §aVotre code GoogleAuthenticator est §e" + gauthKey.getKey() + " §a! §c(Entrez le dans l'application GoogleAuthenticator avant de quitter le serveur !)");

                }

                InsiServerEssential.getInstance().configManager.get2FACodes().set("authcodes." + p.getUniqueId(), gauthKey.getKey());
                InsiServerEssential.getInstance().configManager.save2FACodes();

            } else {

                InsiServerEssential.getInstance().authLocked.add(p.getUniqueId());

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("en")) {

                    p.sendMessage(Messages.PREFIX.getMessage() + Messages.LOGIN_2FA_EN.getMessage());

                }

                if (InsiServerEssential.getInstance().getConfig().getString("plugin.language").equalsIgnoreCase("fr")) {

                    p.sendMessage(Messages.PREFIX.getMessage() + Messages.LOGIN_2FA_FR.getMessage());

                }

            }

        }

    }

}
