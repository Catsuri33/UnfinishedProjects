package fr.catsuri33.insifactions.config;

import fr.catsuri33.insifactions.InsiFactions;
import fr.catsuri33.insifactions.utils.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    public FileConfiguration minesConfiguration;
    public File minesFile;
    public FileConfiguration playersConfiguration;
    public File playersFile;
    public FileConfiguration ranksConfiguration;
    public File ranksFile;
    public FileConfiguration factionsConfiguration;
    public File factionsFile;
    public FileConfiguration maintenanceConfiguration;
    public File maintenanceFile;

    public void setupConfigurations(){

        if(!InsiFactions.getInstance().getDataFolder().exists()){

            InsiFactions.getInstance().getDataFolder().mkdir();

        }

        minesFile = new File(InsiFactions.getInstance().getDataFolder(), "mines.yml");
        playersFile = new File(InsiFactions.getInstance().getDataFolder(), "players.yml");
        ranksFile = new File(InsiFactions.getInstance().getDataFolder(), "ranks.yml");
        factionsFile = new File(InsiFactions.getInstance().getDataFolder(), "factions.yml");
        maintenanceFile = new File(InsiFactions.getInstance().getDataFolder(), "maintenance.yml");

        if(!minesFile.exists()){

            try{

                minesFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the mines.yml file !");

            }

        }

        if(!playersFile.exists()){

            try{

                playersFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the players.yml file !");

            }

        }

        if(!ranksFile.exists()){

            try{

                ranksFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the ranks.yml file !");

            }

        }

        if(!factionsFile.exists()){

            try{

                factionsFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the factions.yml file !");

            }

        }

        if(!minesFile.exists()){

            try{

                minesFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the maintenance.yml file !");

            }

        }

        minesConfiguration = YamlConfiguration.loadConfiguration(minesFile);
        playersConfiguration = YamlConfiguration.loadConfiguration(playersFile);
        ranksConfiguration = YamlConfiguration.loadConfiguration(ranksFile);
        factionsConfiguration = YamlConfiguration.loadConfiguration(factionsFile);
        maintenanceConfiguration = YamlConfiguration.loadConfiguration(maintenanceFile);

    }

    public FileConfiguration getMinesConfiguration(){

        return minesConfiguration;

    }

    public void saveMinesConfiguration(){

        try {

            minesConfiguration.save(minesFile);

        } catch(IOException e){

            Logger.error("Error, could not save the mines.yml file !");

        }

    }

    public void reloadMinesConfiguration(){

        minesConfiguration = YamlConfiguration.loadConfiguration(minesFile);

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

    public FileConfiguration getFactionsConfig(){

        return factionsConfiguration;

    }

    public void saveFactionsConfig(){

        try {

            factionsConfiguration.save(factionsFile);

        } catch(IOException e){

            Logger.error("Error, could not save the factions.yml file !");

        }

    }

    public void reloadFactionsConfig(){

        factionsConfiguration = YamlConfiguration.loadConfiguration(factionsFile);

    }

    public FileConfiguration getMaintenanceConfig(){

        return maintenanceConfiguration;

    }

    public void saveMaintenanceConfig(){

        try {

            maintenanceConfiguration.save(maintenanceFile);

        } catch(IOException e){

            Logger.error("Error, could not save the maintenance.yml file !");

        }

    }

    public void reloadMaintenanceConfig(){

        maintenanceConfiguration = YamlConfiguration.loadConfiguration(maintenanceFile);

    }

}
