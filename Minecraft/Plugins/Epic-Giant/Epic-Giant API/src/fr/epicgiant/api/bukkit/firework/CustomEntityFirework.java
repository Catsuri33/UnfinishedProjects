package fr.epicgiant.api.bukkit.firework;

import net.minecraft.server.v1_14_R1.*;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Collection;

public class CustomEntityFirework extends EntityFireworks {

    Collection<? extends Player> players;
    boolean gone;

    public CustomEntityFirework(World world, EntityTypes<? extends EntityFireworks> entitytypes, final Collection<? extends Player> collection){

        super(entitytypes, world);
        this.players = null;
        this.gone = false;
        this.players = collection;
        this.a(new float[] { 0.25f, 0.25f });

    }

    public void die(){

        if(this.gone){
            return;
        }
        if(!this.world.isClientSide){
            this.gone = true;
            if(this.players != null && this.players.size() > 0){
                for(Player players : this.players){
                    ((CraftPlayer) players).getHandle().playerConnection.sendPacket((Packet)new PacketPlayOutEntityStatus((Entity)this, (byte) 17));
                }
                this.die();
                return;
            }
            this.world.broadcastEntityEffect((Entity)this, (byte) 17);
            this.die();
        }

    }

    public static void spawn(Location location, FireworkEffect effect, EntityTypes<? extends EntityFireworks> entitytypes, final Collection<? extends Player> collection){

        try {
            CustomEntityFirework firework = new CustomEntityFirework((World)((CraftWorld)location.getWorld()).getHandle(), entitytypes, collection);
            FireworkMeta meta = ((Firework)firework.getBukkitEntity()).getFireworkMeta();
            meta.addEffect(effect);
            ((Firework)firework.getBukkitEntity()).setFireworkMeta(meta);
            firework.setPosition(location.getX(), location.getY(), location.getZ());
            if(((CraftWorld)location.getWorld()).getHandle().addEntity((Entity)firework)){
                firework.setInvisible(true);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
