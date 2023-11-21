package fr.epicgiant.api.bungeecord;

import fr.epicgiant.api.bungeecord.listeners.ServerSwitch;
import net.md_5.bungee.api.plugin.Plugin;

public class EpicGiantBungeecordAPI extends Plugin {

    @Override
    public void onEnable(){

        getProxy().getPluginManager().registerListener(this, new ServerSwitch());

    }

}
