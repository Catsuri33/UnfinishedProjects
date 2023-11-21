package com.insignicnetwork.lobby.core.tasks;

import com.insignicnetwork.lobby.Lobby;
import com.insignicnetwork.lobby.core.ImageToMapRenderer;
import com.insignicnetwork.lobby.utils.ImageUtils;
import com.insignicnetwork.lobby.utils.RenderUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class RenderImage extends BukkitRunnable {

    private Player p;
    private String path;

    public RenderImage(Player p, String path){

        this.p = p;
        this.path = path;

    }

    @Override
    public void run(){

        try{

            final ArrayList<Short> mapsID = new ArrayList<>();
            final BufferedImage bi = ImageUtils.getImage(path);
            final int rows = bi.getHeight() / 128;
            final int cols = bi.getWidth() / 128;

            MapView mv;

            for(int i = 0; i < rows; i++){

                for(int j = 0; j < cols; j++){

                    mv = Bukkit.createMap(p.getWorld());
                    mv = RenderUtils.resetRenderers(mv);
                    mv.setScale(MapView.Scale.FARTHEST);
                    mv.setUnlimitedTracking(false);
                    mv.getRenderers().clear();
                    mv.addRenderer(new ImageToMapRenderer(bi.getSubimage(j * 128, i * 128, 128, 128)));

                    mapsID.add((short) mv.getId());

                }

            }

            for(short id : mapsID){

                p.getInventory().addItem(new ItemStack(Material.MAP, 1, id));

            }

        } catch(IOException e){

            Lobby.getInstance().log("L'image ne peut pas être chargée : " + path);
            Lobby.getInstance().log(e.getMessage());

        }

    }

}
