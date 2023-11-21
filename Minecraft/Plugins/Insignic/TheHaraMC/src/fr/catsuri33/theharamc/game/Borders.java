package fr.catsuri33.theharamc.game;

import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;

public class Borders {

    public void decreaseBorder(){

        WorldBorder wb = Bukkit.getWorlds().get(0).getWorldBorder();
        Bukkit.getWorlds().get(0).getWorldBorder().setSize(wb.getSize() - 1);

    }

}
