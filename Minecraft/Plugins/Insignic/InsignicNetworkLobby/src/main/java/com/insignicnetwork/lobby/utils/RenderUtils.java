package com.insignicnetwork.lobby.utils;

import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import java.util.Iterator;

public class RenderUtils {

    public static MapView resetRenderers(MapView mapView){

        final Iterator<MapRenderer> i = mapView.getRenderers().iterator();

        while(i.hasNext()){

            mapView.removeRenderer(i.next());

        }

        return mapView;

    }

}
