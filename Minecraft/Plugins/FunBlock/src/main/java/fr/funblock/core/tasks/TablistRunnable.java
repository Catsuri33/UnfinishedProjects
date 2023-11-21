package fr.funblock.core.tasks;

import fr.funblock.FunBlock;
import net.minecraft.server.v1_12_R1.ChatComponentText;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;

public class TablistRunnable {

    private static int title = 0;

    public static void run(){

        new BukkitRunnable(){

            @Override
            public void run() {

                PacketPlayOutPlayerListHeaderFooter p = new PacketPlayOutPlayerListHeaderFooter();

                try{

                    Field a = p.getClass().getDeclaredField("a");
                    a.setAccessible(true);
                    Field b = p.getClass().getDeclaredField("b");
                    b.setAccessible(true);

                    String spaceTablist = "";

                    if(title == 0){

                        spaceTablist = "§r§f-------------------------------§r";

                    }

                    if(title == 1){

                        spaceTablist = "§e§l-§f------------------------------§f";

                    }

                    if(title == 2){

                        spaceTablist = "§f-§e§l-§f-----------------------------§f";

                    }

                    if(title == 3){

                        spaceTablist = "§f--§e§l-§f----------------------------§f";

                    }

                    if(title == 4){

                        spaceTablist = "§f---§e§l-§f---------------------------§f";

                    }

                    if(title == 5){

                        spaceTablist = "§f----§e§l-§f--------------------------§f";

                    }

                    if(title == 6){

                        spaceTablist = "§f-----§e§l-§f-------------------------§f";

                    }

                    if(title == 7){

                        spaceTablist = "§f------§e§l-§f------------------------§f";

                    }

                    if(title == 8){

                        spaceTablist = "§f-------§e§l-§f-----------------------§f";

                    }

                    if(title == 9){

                        spaceTablist = "§f--------§e§l-§f----------------------§f";

                    }

                    if(title == 10){

                        spaceTablist = "§f---------§e§l-§f---------------------§f";

                    }

                    if(title == 11){

                        spaceTablist = "§f----------§e§l-§f--------------------§f";

                    }

                    if(title == 12){

                        spaceTablist = "§f-----------§e§l-§f-------------------§f";

                    }

                    if(title == 13){

                        spaceTablist = "§f------------§e§l-§f------------------§f";

                    }

                    if(title == 14){

                        spaceTablist = "§f-------------§e§l-§f-----------------§f";

                    }

                    if(title == 15){

                        spaceTablist = "§f--------------§e§l-§f----------------§f";

                    }

                    if(title == 16){

                        spaceTablist = "§f---------------§e§l-§f---------------§f";

                    }

                    if(title == 17){

                        spaceTablist = "§f----------------§e§l-§f--------------§f";

                    }

                    if(title == 18){

                        spaceTablist = "§f-----------------§e§l-§f-------------§f";

                    }

                    if(title == 19){

                        spaceTablist = "§f------------------§e§l-§f------------§f";

                    }

                    if(title == 20){

                        spaceTablist = "§f-------------------§e§l-§f-----------§f";

                    }

                    if(title == 21){

                        spaceTablist = "§f--------------------§e§l-§f----------§f";

                    }

                    if(title == 22){

                        spaceTablist = "§f---------------------§e§l-§f---------§f";

                    }

                    if(title == 23){

                        spaceTablist = "§f----------------------§e§l-§f--------§f";

                    }

                    if(title == 24){

                        spaceTablist = "§f-----------------------§e§l-§f-------§f";

                    }

                    if(title == 25){

                        spaceTablist = "§f------------------------§e§l-§f------§f";

                    }

                    if(title == 26){

                        spaceTablist = "§f-------------------------§e§l-§f-----§f";

                    }

                    if(title == 27){

                        spaceTablist = "§f--------------------------§e§l-§f----§f";

                    }

                    if(title == 28){

                        spaceTablist = "§f---------------------------§e§l-§f---§f";

                    }

                    if(title == 29){

                        spaceTablist = "§f----------------------------§e§l-§f--§f";

                    }

                    if(title == 30){

                        spaceTablist = "§f-----------------------------§e§l-§f-§f";

                    }

                    if(title == 31){

                        spaceTablist = "§f------------------------------§e§l-§f";
                        title = 0;

                    }

                    String headerLine1 = FunBlock.getInstance().getConfig().getString("options.tablist.header.line1");
                    String headerLine2 = FunBlock.getInstance().getConfig().getString("options.tablist.header.line2");
                    String footerLine1 = FunBlock.getInstance().getConfig().getString("options.tablist.footer.line1");
                    String footerLine2 = FunBlock.getInstance().getConfig().getString("options.tablist.footer.line2");

                    String headerLine1Color = headerLine1.replace("&", "§");
                    String headerLine2Color = headerLine2.replace("&", "§");
                    String footerLine1Color = footerLine1.replace("&", "§");
                    String footerLine2Color = footerLine2.replace("&", "§");

                    String headerLine1PlayerCount = headerLine1Color.replace("%players-count%", Integer.toString(Bukkit.getOnlinePlayers().size()));
                    String headerLine2PlayerCount = headerLine2Color.replace("%players-count%", Integer.toString(Bukkit.getOnlinePlayers().size()));
                    String footerLine1PlayerCount = footerLine1Color.replace("%players-count%", Integer.toString(Bukkit.getOnlinePlayers().size()));
                    String footerLine2PlayerCount = footerLine2Color.replace("%players-count%", Integer.toString(Bukkit.getOnlinePlayers().size()));

                    String headerLine1PlayerMax = headerLine1PlayerCount.replace("%players-max%", Integer.toString(Bukkit.getMaxPlayers()));
                    String headerLine2PlayerMax = headerLine2PlayerCount.replace("%players-max%", Integer.toString(Bukkit.getMaxPlayers()));
                    String footerLine1PlayerMax = footerLine1PlayerCount.replace("%players-max%", Integer.toString(Bukkit.getMaxPlayers()));
                    String footerLine2PlayerMax = footerLine2PlayerCount.replace("%players-max%", Integer.toString(Bukkit.getMaxPlayers()));

                    Object header1 = new ChatComponentText(spaceTablist + "\n" + headerLine1PlayerMax + "\n" + headerLine2PlayerMax + "\n" + spaceTablist);
                    Object footer1 = new ChatComponentText(spaceTablist + "\n" + footerLine1PlayerMax + "\n" + footerLine2PlayerMax);

                    title++;

                    a.set(p, new ChatComponentText(""));
                    b.set(p, new ChatComponentText(""));

                    a.set(p, header1);
                    b.set(p, footer1);

                    if(Bukkit.getOnlinePlayers().size() == 0) return;

                    for(Player players : Bukkit.getOnlinePlayers()){

                        ((CraftPlayer)players).getHandle().playerConnection.sendPacket(p);

                    }

                } catch(NoSuchFieldException | IllegalAccessException e) {

                    e.printStackTrace();

                }

            }

        }.runTaskTimer(FunBlock.getInstance(), 10, 10);

    }

}
