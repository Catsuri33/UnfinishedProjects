package fr.funblock.config;

import fr.funblock.FunBlock;
import fr.funblock.utils.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    public FileConfiguration playersConfiguration;
    public File playersFile;
    public FileConfiguration headsConfiguration;
    public File headsFile;
    public FileConfiguration ranksConfiguration;
    public File ranksFile;

    public void setupConfigurations(){

        if(!FunBlock.getInstance().getDataFolder().exists()){

            FunBlock.getInstance().getDataFolder().mkdir();

        }

        playersFile = new File(FunBlock.getInstance().getDataFolder(), "players.yml");
        headsFile = new File(FunBlock.getInstance().getDataFolder(), "heads.yml");
        ranksFile = new File(FunBlock.getInstance().getDataFolder(), "ranks.yml");

        if(!playersFile.exists()){

            try{

                playersFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the players.yml file !");

            }

        }

        if(!headsFile.exists()){

            try{

                headsFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the heads.yml file !");

            }

        }

        if(!ranksFile.exists()){

            try{

                ranksFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the ranks.yml file !");

            }

        }

        playersConfiguration = YamlConfiguration.loadConfiguration(playersFile);
        headsConfiguration = YamlConfiguration.loadConfiguration(headsFile);
        ranksConfiguration = YamlConfiguration.loadConfiguration(ranksFile);

    }

    public FileConfiguration getPlayersConfig(){

        return playersConfiguration;

    }

    public void savePlayersConfig(){

        try {

            playersConfiguration.save(playersFile);

        } catch(IOException e){

            Logger.error("Error, could not save the players.yml file !");

        }

    }

    public void reloadPlayerConfig(){

        playersConfiguration = YamlConfiguration.loadConfiguration(playersFile);

    }

    public FileConfiguration getHeadsConfig(){

        return headsConfiguration;

    }

    public void saveHeadsConfig(){

        try {

            headsConfiguration.save(headsFile);

        } catch(IOException e){

            Logger.error("Error, could not save the heads.yml file !");

        }

    }

    public void reloadHeadsConfig(){

        headsConfiguration = YamlConfiguration.loadConfiguration(headsFile);

    }

    public FileConfiguration getRanksConfig(){

        return ranksConfiguration;

    }

    public void saveRanksConfig(){

        try {

            ranksConfiguration.save(ranksFile);

        } catch(IOException e){

            Logger.error("Error, could not save the ranks.yml file !");

        }

    }

    public void reloadRanksConfig(){

        ranksConfiguration = YamlConfiguration.loadConfiguration(ranksFile);

    }

}
