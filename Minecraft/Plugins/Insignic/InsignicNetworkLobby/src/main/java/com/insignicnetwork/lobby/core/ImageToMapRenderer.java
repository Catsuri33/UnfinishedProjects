package com.insignicnetwork.lobby.core;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.awt.image.BufferedImage;

public class ImageToMapRenderer extends MapRenderer {

    private boolean shouldRender;
    private BufferedImage bi;

    public ImageToMapRenderer(BufferedImage image){

        this.bi = image;
        this.shouldRender = true;

    }

    @Override
    public void render(MapView mapView, MapCanvas mapCanvas, Player player) {

        if(shouldRender){

            mapCanvas.drawImage(0, 0, bi);
            shouldRender = false;

        }

    }

    public void setShouldRender(boolean shouldRender) {

        this.shouldRender = shouldRender;

    }

    public void setImage(BufferedImage bi) {

        this.bi = bi;

    }

}
