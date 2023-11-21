package com.insignic.uhchost.config;

import com.insignic.uhchost.UHCHost;
import com.insignic.uhchost.utils.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    public FileConfiguration settingsConfiguration;
    public File settingsFile;

    public void setupConfigurations(){

        if(!UHCHost.getInstance().getDataFolder().exists()){

            UHCHost.getInstance().getDataFolder().mkdir();

        }

        settingsFile = new File(UHCHost.getInstance().getDataFolder(), "settings.yml");

        if(!settingsFile.exists()){

            try{

                settingsFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the settings.yml file !");

            }

        }

        settingsConfiguration = YamlConfiguration.loadConfiguration(settingsFile);

    }

    public FileConfiguration getSettingsConfiguration(){

        return settingsConfiguration;

    }

    public void saveSettingsConfiguration(){

        try {

            settingsConfiguration.save(settingsFile);

        } catch(IOException e){

            Logger.error("Error, could not save the settings.yml file !");

        }

    }

    public void reloadSettingsConfiguration(){

        settingsConfiguration = YamlConfiguration.loadConfiguration(settingsFile);

    }

}
