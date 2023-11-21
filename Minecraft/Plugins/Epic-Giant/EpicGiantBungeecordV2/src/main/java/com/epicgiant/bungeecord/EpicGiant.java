package com.epicgiant.bungeecord;

import com.epicgiant.bungeecord.listeners.ProxyPing;
import net.md_5.bungee.api.plugin.Plugin;

public class EpicGiant extends Plugin {

    public void onEnable(){

        getProxy().getPluginManager().registerListener(this, new ProxyPing());

    }

    public void onDisable(){



    }

}
