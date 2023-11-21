package fr.catsuri33.insifactions.permissions;

import fr.catsuri33.insifactions.InsiFactions;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.UUID;

public class PermissionsManager {

    public static void setupPermissions(Player p){

        PermissionAttachment attachment = p.addAttachment(InsiFactions.getInstance());
        InsiFactions.getInstance().playerPerms.put(p.getUniqueId(), attachment);
        setPermission(p.getUniqueId());

    }

    public static void setPermission(UUID uuid){

        PermissionAttachment attachment = InsiFactions.getInstance().playerPerms.get(uuid);
        ConfigurationSection ranksSection = InsiFactions.configManager.getRanksConfig().getConfigurationSection("ranks");

        for(String ranks : ranksSection.getKeys(false)){

            for(String permission : InsiFactions.configManager.getRanksConfig().getStringList("ranks." + ranks + ".permissions")){

                attachment.setPermission(permission, true);

            }

        }

    }

}
