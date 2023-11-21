package fr.catsuri33.sc.config;

import fr.catsuri33.sc.Main;
import fr.catsuri33.sc.utils.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    public FileConfiguration serverConfiguration;
    public File serverFile;
    public FileConfiguration playersConfiguration;
    public File playersFile;

    public void setupConfigurations(){

        if(!Main.getInstance().getDataFolder().exists()){

            Main.getInstance().getDataFolder().mkdir();

        }

        serverFile = new File(Main.getInstance().getDataFolder(), "server.yml");
        playersFile = new File(Main.getInstance().getDataFolder(), "players.yml");

        if(!serverFile.exists()){

            try{

                serverFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the server.yml file !");

            }

        }

        if(!playersFile.exists()){

            try{

                playersFile.createNewFile();

            } catch(IOException e){

                Logger.error("Error, could not create the players.yml file !");

            }

        }

        serverConfiguration = YamlConfiguration.loadConfiguration(serverFile);
        playersConfiguration = YamlConfiguration.loadConfiguration(playersFile);

    }

    public FileConfiguration getServerConfiguration(){

        return serverConfiguration;

    }

    public void saveServerConfiguration(){

        try {

            serverConfiguration.save(serverFile);

        } catch(IOException e){

            Logger.error("Error, could not save the server.yml file !");

        }

    }

    public void reloadServerConfiguration(){

        serverConfiguration = YamlConfiguration.loadConfiguration(serverFile);

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

}
