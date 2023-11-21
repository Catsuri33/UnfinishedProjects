package fr.catsuri33.insiserveressential.config;

import fr.catsuri33.insiserveressential.InsiServerEssential;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    public FileConfiguration oauth2Configuration;
    public File oauth2File;
    public FileConfiguration homesConfiguration;
    public File homesFile;
    public FileConfiguration ranksConfiguration;
    public File ranksFile;

    public void setupConfigurations(){

        if(!InsiServerEssential.getInstance().getDataFolder().exists()){

            InsiServerEssential.getInstance().getDataFolder().mkdir();

        }

        oauth2File = new File(InsiServerEssential.getInstance().getDataFolder(), "2FA.yml");
        homesFile = new File(InsiServerEssential.getInstance().getDataFolder(), "homes.yml");
        ranksFile = new File(InsiServerEssential.getInstance().getDataFolder(), "ranks.yml");

        if(!oauth2File.exists()){

            try{

                oauth2File.createNewFile();

            } catch(IOException e){

                InsiServerEssential.getInstance().log(ChatColor.RED + "Error, could not create the 2FA.yml file !");

            }

        }

        if(!homesFile.exists()){

            try{

                homesFile.createNewFile();

            } catch(IOException e){

                InsiServerEssential.getInstance().log(ChatColor.RED + "Error, could not create the homes.yml file !");

            }

        }

        if(!ranksFile.exists()){

            try{

                ranksFile.createNewFile();

            } catch(IOException e){

                InsiServerEssential.getInstance().log(ChatColor.RED + "Error, could not create the ranks.yml file !");

            }

        }

        oauth2Configuration = YamlConfiguration.loadConfiguration(oauth2File);
        homesConfiguration = YamlConfiguration.loadConfiguration(homesFile);
        ranksConfiguration = YamlConfiguration.loadConfiguration(ranksFile);

    }

    public FileConfiguration get2FACodes(){

        return oauth2Configuration;

    }

    public void save2FACodes(){

        try {

            oauth2Configuration.save(oauth2File);

        } catch(IOException e){

            InsiServerEssential.getInstance().log(ChatColor.RED + "Error, could not save the 2FA.yml file !");

        }

    }

    public void reload2FACodes(){

        oauth2Configuration = YamlConfiguration.loadConfiguration(oauth2File);

    }

    public FileConfiguration getHomes(){

        return homesConfiguration;

    }

    public void saveHomes(){

        try {

            homesConfiguration.save(homesFile);

        } catch(IOException e){

            InsiServerEssential.getInstance().log(ChatColor.RED + "Error, could not save the homes.yml file !");

        }

    }

    public void reloadHomes(){

        homesConfiguration = YamlConfiguration.loadConfiguration(homesFile);

    }

    public FileConfiguration getRanks(){

        return ranksConfiguration;

    }

    public void saveRanks(){

        try {

            ranksConfiguration.save(ranksFile);

        } catch(IOException e){

            InsiServerEssential.getInstance().log(ChatColor.RED + "Error, could not save the ranks.yml file !");

        }

    }

    public void reloadRanks(){

        ranksConfiguration = YamlConfiguration.loadConfiguration(ranksFile);

    }

}
