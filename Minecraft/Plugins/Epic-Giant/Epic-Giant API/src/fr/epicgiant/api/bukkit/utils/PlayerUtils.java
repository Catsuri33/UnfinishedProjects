package fr.epicgiant.api.bukkit.utils;

import fr.epicgiant.api.bukkit.EpicGiantBukkitAPI;
import net.minecraft.server.v1_14_R1.EntityPlayer;
import net.minecraft.server.v1_14_R1.PacketPlayInClientCommand;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.UUID;

public class PlayerUtils {

    public static void kill(Player p){
        p.setHealth(0.0D);
    }

    public static void damage(Player p, double damage){
        p.damage(damage);
    }

    @SuppressWarnings("deprecation")
    public static void setMaxHealth(Player p, double value){
        p.setMaxHealth(value);
    }

    public static void heal(Player p){
        p.setHealth(20.0D);
    }

    public static void heal(Player p, double value){
        int d = (int) p.getHealth();
        d += value;
        p.setHealth(d);
    }

    public static void feed(Player p){
        p.setFoodLevel(20);
    }

    public static void feed(Player p, int value){
        int d = p.getFoodLevel();
        d += value;
        p.setFoodLevel(d);
    }

    public static void starve(Player p){
        p.setFoodLevel(0);
    }

    public static void starve(Player p, int value){
        int d = p.getFoodLevel();
        d += value;
        p.setFoodLevel(d);
    }

    public static UUID getUUID(Player p){
        return p.getUniqueId();
    }

    public static void setGamemode(Player p, GameMode gamemode) {
        p.setGameMode(gamemode);
    }

    public static void addPotionEffect(Player p, PotionEffectType potionEffect, int time, int level){
        p.addPotionEffect(new PotionEffect(potionEffect, time * 20, level));
    }

    public static void removePotionEffect(Player p, PotionEffectType potionEffect){
        p.removePotionEffect(potionEffect);
    }

    public static void removeAllPotionEffect(Player p){
        for(PotionEffect pet : p.getActivePotionEffects()){
            p.removePotionEffect(pet.getType());
        }
    }

    public static void kick(Player p, String reason){
        p.kickPlayer(reason);
    }

    public static void teleport(Player player, Object object){
        if((object instanceof Player)){
            Player p = (Player) object;
            player.teleport(p);
        } else if(object instanceof Location){
            Location loc = (Location) object;
            player.teleport(loc);
        } else if(object instanceof Entity){
            Entity ent = (Entity) object;
            player.teleport(ent);
        } else if(object instanceof LivingEntity){
            LivingEntity lent = (LivingEntity) object;
            player.teleport(lent);
        }
    }

    public static void burn(Player p, int ticks){
        p.setFireTicks(ticks);
    }

    public static void extinguish(Player p){
        p.setFireTicks(0);
    }

    @SuppressWarnings("deprecation")
    public static void unlockAward(Player p, Achievement achievement){
        p.awardAchievement(achievement);
    }

    public static Inventory getInventory(Player p){
        return p.getInventory();
    }

    public static void addItemToInventory(Player p, ItemStack itemStack){
        p.getInventory().addItem(new ItemStack[]{itemStack});
    }

    public static Boolean inventoryContain(Player p, Material material){
        if(p.getInventory().contains(material)){
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    public static Boolean inventoryContain(Player p, Material material, int amount){
        if(p.getInventory().contains(material, amount)){
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    public int getInventorySize(Player p){
        return p.getInventory().getSize();
    }

    public boolean inventoryHasEmptySlot(Player p){
        ItemStack[] arrayOfItemStack;
        int j = (arrayOfItemStack = p.getInventory().getContents()).length;
        for(int i = 0; i < j; i++){
            ItemStack items = arrayOfItemStack[i];
            if(items == null){
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(false);
    }

    public static void clearInventory(Player p){
        p.getInventory().clear();
    }

    public static Integer getLevel(Player p){
        return Integer.valueOf(p.getLevel());
    }

    public static void setVelocity(Player p, double x, double y, double z){
        p.setVelocity(new Vector(x, y, z));
    }

    public static Integer getPing(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Integer.valueOf(ep.ping);
    }

    public static Boolean isSprinting(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isSprinting());
    }

    public static Boolean isSneaking(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isSneaking());
    }

    public static Boolean isSpectator(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isSpectator());
    }

    public static Boolean isCreative(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isCreative());
    }

    public static Boolean isCreativeAndOP(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isCreativeAndOp());
    }

    public static Boolean isInvulnerable(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isInvulnerable());
    }

    public static Boolean isInvisible(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isInvisible());
    }

    public static Boolean isInWater(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isInWater());
    }

    public static Boolean isInWaterOrRain(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isInWaterOrRain());
    }

    public static Boolean isSleeping(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isSleeping());
    }

    public static Boolean isSwimming(Player p){
        CraftPlayer cp = (CraftPlayer) p;
        EntityPlayer ep = cp.getHandle();
        return Boolean.valueOf(ep.isSwimming());
    }

    public static void sendForceRespawn(Player p, int ticks){

        String playerName = p.getName();
        Bukkit.getScheduler().runTaskLater(EpicGiantBukkitAPI.getInstance(), new Runnable() {
            @Override
            public void run() {

                Player player = Bukkit.getPlayer(playerName);
                if(player == null || !player.isDead() || player.isOnline()){ }
                PacketPlayInClientCommand packet = new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN);
                EntityPlayer ep = ((CraftPlayer)player).getHandle();
                if(ep.playerConnection != null && !ep.playerConnection.isDisconnected()){
                    ep.playerConnection.a(packet);
                }

            }
        }, (long) ticks);

    }

}
