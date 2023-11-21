package fr.catsuri33.insiuhc.utils;

import fr.catsuri33.insiuhc.InsiUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateChecker {

    private InsiUHC instance;
    private int resourceID;

    public UpdateChecker(InsiUHC instance, int resourceID){

        this.instance = instance;
        this.resourceID = resourceID;

    }

    public void getLatestVersion(Consumer<String> consumer) {

        Bukkit.getScheduler().runTaskAsynchronously(this.instance, () -> {

            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceID).openStream(); Scanner scanner = new Scanner(inputStream)) {

                if (scanner.hasNext()) {

                    consumer.accept(scanner.next());

                }

            } catch (IOException exception) {

                this.instance.log(ChatColor.RED + "Cannot look for updates: " + exception.getMessage());

            }

        });
    }

}
