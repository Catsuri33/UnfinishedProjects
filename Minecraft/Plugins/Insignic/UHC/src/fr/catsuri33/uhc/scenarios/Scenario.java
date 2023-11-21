package fr.catsuri33.uhc.scenarios;

import java.util.List;

import fr.catsuri33.uhc.UHC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;

public abstract class Scenario implements Listener {
    private String name;
    private List<String> description;
    private Material type;

    public Scenario(String name, List<String> description, Material type) {
        this.name = name;
        this.description = description;
        this.type = type;
        Bukkit.getPluginManager().registerEvents(this, UHC.getInstance());
    }

    public String getName() {
        return this.name;
    }

    public List<String> getDescritpion() {
        return this.description;
    }

    public Material getType() {
        return this.type;
    }
}
