package fr.odilonesport.fallenkingdoms.game.runnables;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.guis.TeamGui;
import fr.odilonesport.fallenkingdoms.game.scoreboards.GameBoard;
import fr.odilonesport.fallenkingdoms.utils.ArrowTarget;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameRunnable extends BukkitRunnable {

    public static int timer = 0;
    public static int days = 1;
    public static boolean start = false;
    public static Integer nextState = 0;

    private int taskID;

    @Override
    public void run() {

        taskID = this.getTaskId();
        timer++;

        for(Player players : Bukkit.getOnlinePlayers()){

            GameBoard gameBoard = new GameBoard(players.getUniqueId());

            if(!gameBoard.hasID()){

                gameBoard.setID(taskID);

            }

            Object[] timersFields = Main.getInstance().getConfig().getConfigurationSection("game.timers").getKeys(false).toArray();

            if(nextState != -1){

                if(Main.getInstance().getConfig().getInt("game.timers." + timersFields[nextState]) == days){

                    Main.getInstance().scoreboards.setState(nextState);

                }

            }

            Main.getInstance().scoreboards.createGameBoard(players);

        }

        //if(timer == 1200){
        if(timer == 30){

            timer = 0;
            days = days + 1;

            Bukkit.broadcastMessage(Main.getInstance().prefix + "§aJour §e" + days + "§a.");

        }

        for(Player players : Bukkit.getOnlinePlayers()){

            if(players.getWorld().getEnvironment().equals(World.Environment.NORMAL)){

                String teamName = TeamGui.getPlayersTeam().get(players.getUniqueId()).toLowerCase();
                double distance = players.getLocation().distance(Main.getInstance().basesRegions.get(teamName).getMiddle());
                players.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§7Votre base: §f" + (int) distance + "m " + ArrowTarget.getArrowColor(distance) + ArrowTarget.calculateArrow(players, Main.getInstance().basesRegions.get(teamName).getMiddle())));
                return;

            }

        }

    }

}
