package fr.epicgiant.api.bukkit.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.WorldCreator;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;

import java.io.*;

public class WorldUtils {

    static WorldUtils instance;
    public static WorldUtils getInstance(){ return instance; }

    public void copyFolder(File src, File destination) throws IOException {

        if(src.isDirectory()){
            if(!destination.exists()){
                destination.mkdir();
            }
            String files[] = src.list();
            for(String file : files){
                File srcF = new File(src, file);
                File destF = new File(destination, file);
                copyFolder(srcF, destF);
            }
        } else {
            InputStream is = new FileInputStream(src);
            OutputStream os = new FileOutputStream(destination);
            byte[] buffer = new byte[1024];
            int length;
            while((length = is.read(buffer)) > 0){
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        }

    }

    public boolean deleteWorldPath(File path){

        if(path.exists()){
            File files[] = path.listFiles();
            for(int i = 0; i < files.length; i++){
                if(files[i].isDirectory()){
                    deleteWorldPath(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return (path.delete());
    }

    public static void setWorldSize(int size){

        for(World world : Bukkit.getWorlds()){
            WorldBorder wb = world.getWorldBorder();
            wb.setCenter(0, 0);
            wb.setSize(size);
        }

    }

    public static void setWorldSize(String world, int size){

        World worldName = Bukkit.getServer().getWorld(world);
        WorldBorder wb = worldName.getWorldBorder();
        wb.setCenter(0, 0);
        wb.setSize(size);

    }

    public void deleteWorld(String worldName){

        World world = Bukkit.getWorld(worldName);
        File f = new File(worldName);
        if(f == null || world == null)return;
        Bukkit.unloadWorld(worldName, false);
        try {
            FileUtils.deleteDirectory(f);
        } catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void createWorld(WorldCreator creator){

        Bukkit.createWorld(creator);

    }

}
