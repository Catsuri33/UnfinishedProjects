package fr.epicgiant.core.listeners;

import fr.epicgiant.core.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTD implements Listener {

    @EventHandler
    public void onServerListPing(ServerListPingEvent e){

        if(Main.Maintenance){

            e.setMotd("§r                §6§lEpic-Giant §r§8[§a1.8§8-§a1.14§8]\n §e≣ §cThe server is in maintenance : §6§l@GiantEpic §r§e≣");

        } else {

            e.setMotd("§r                §6§lEpic-Giant §r§8[§a1.8§8-§a1.14§8]\n §e≣ §bSummer Sales §c-50% §8- §eNew Game §6§lGoldenRush §e! §r§e≣");

        }

    }

}
