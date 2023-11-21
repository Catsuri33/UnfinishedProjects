package fr.catsuri33.insiuhc.config;

import fr.catsuri33.insiuhc.InsiUHC;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    public FileConfiguration hostConfiguration;
    public File hostFile;

    public void setupConfigurations(){

        if(!InsiUHC.getInstance().getDataFolder().exists()){

            InsiUHC.getInstance().getDataFolder().mkdir();

        }

        hostFile = new File(InsiUHC.getInstance().getDataFolder(), "host.yml");

        if(!hostFile.exists()){

            try{

                hostFile.createNewFile();

            } catch(IOException e){

                InsiUHC.getInstance().log(ChatColor.RED + "Error, could not create the host.yml file !");

            }

        }

        hostConfiguration = YamlConfiguration.loadConfiguration(hostFile);

    }

    public FileConfiguration getHost(){

        return hostConfiguration;

    }

    public void saveHost(){

        try {

            hostConfiguration.save(hostFile);

        } catch(IOException e){

            InsiUHC.getInstance().log(ChatColor.RED + "Error, could not save the host.yml file !");

        }

    }

    public void reloadHost(){

        hostConfiguration = YamlConfiguration.loadConfiguration(hostFile);

    }

}
