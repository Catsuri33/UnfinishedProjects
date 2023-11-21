/*                              */
/*       Catsuri33API           */
/*                              */
/*    Author: Catsuri33         */
/*    Created: 07/08/2019       */
/*    Updated: 07/08/2019       */
/*    Name: PlayerUtils         */
/*                              */

package fr.catsuri33.api.utils;

import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;

public class PlayerUtils {

    public static void getPlayerName(Player player){

        player.getName();

    }

    public static void setPlayerDisplayName(Player player, String name){

        player.setDisplayName(name);

    }

    public static void getPlayerDisplayName(Player player){

        player.getDisplayName();

    }

    public static void playerIsOnline(Player player){

        player.isOnline();

    }

    public static void playerIsOP(Player player){

        player.isOp();

    }

    public static void playerHasPermission(Player player, String permission){

        player.hasPermission(permission);

    }

    public static void playerHasPlayedBefore(Player player){

        player.hasPlayedBefore();

    }

    public static void getPlayerAdress(Player player){

        player.getAddress();

    }

    public static void getPlayerClientViewDistance(Player player){

        player.getClientViewDistance();

    }

    public static void getPlayerAdvancementProgress(Player player, Advancement advancement){

        player.getAdvancementProgress(advancement);

    }

    public static void getPlayerXP(Player player){

        player.getExp();

    }

    public static void getPlayerFlySpeed(Player player){

        player.getFlySpeed();

    }

    public static void getPlayerFoodLevel(Player player){

        player.getFoodLevel();

    }

    public static void getPlayerHealthScale(Player player){

        player.getHealthScale();

    }

    public static void getPlayerHealth(Player player){

        player.getHealth();

    }

    public static void getPlayerLevel(Player player){

        player.getLevel();

    }

    public static void getPlayerSaturation(Player player){

        player.getSaturation();

    }

    public static void getPlayerScoreboard(Player player){

        player.getScoreboard();

    }

    public static void getPlayerSpectatorTarget(Player player){

        player.getSpectatorTarget();

    }

    public static void getPlayerTotalXP(Player player){

        player.getTotalExperience();

    }

    public static void getPlayerWalkSpeed(Player player){

        player.getWalkSpeed();

    }

    public static void givePlayerXP(Player player, int xp){

        player.giveExp(xp);

    }

    public static void givePlayerXPLevel(Player player, int level){

        player.giveExpLevels(level);

    }

    public static void playerIsFlying(Player player){

        player.isFlying();

    }

    public static void playerIsSleeping(Player player){

        player.isSleeping();

    }

    public static void playerIsSneaking(Player player){

        player.isSneaking();

    }

    public static void playerIsSprinting(Player player){

        player.isSprinting();

    }

    public static void kickPlayer(Player player, String reason){

        player.kickPlayer(reason);

    }

    public static void resetPlayerTitle(Player player){

        player.resetTitle();

    }

    public static void savePlayerData(Player player){

        player.saveData();

    }

    public static void setPlayerFlySpeed(Player player, float flySpeed){

        player.setFlySpeed(flySpeed);

    }

    public static void setPlayerFoodLevel(Player player, int foodLevel){

        player.setFoodLevel(foodLevel);

    }

}
