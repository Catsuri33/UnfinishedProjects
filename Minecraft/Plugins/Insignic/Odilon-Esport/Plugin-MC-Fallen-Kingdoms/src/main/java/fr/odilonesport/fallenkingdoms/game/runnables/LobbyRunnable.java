package fr.odilonesport.fallenkingdoms.game.runnables;

import fr.odilonesport.fallenkingdoms.Main;
import fr.odilonesport.fallenkingdoms.game.guis.TeamGui;
import fr.odilonesport.fallenkingdoms.game.player.GamePlayer;
import fr.odilonesport.fallenkingdoms.game.scoreboards.LobbyBoard;
import fr.odilonesport.fallenkingdoms.utils.GameStates;
import fr.odilonesport.fallenkingdoms.utils.Gamerules;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;

public class LobbyRunnable extends BukkitRunnable {

    public static int timer = 31;
    public static boolean start = false;

    private int taskID;

    @Override
    public void run() {

        taskID = this.getTaskId();

        if(!GameStates.isState(GameStates.WAITING)){

            timer = 61;
            start = false;
            this.cancel();
            return;

        }

        timer--;
        setLevel();

        for(Player players : Bukkit.getOnlinePlayers()){

            LobbyBoard lobbyBoard = new LobbyBoard(players.getUniqueId());

            if(!lobbyBoard.hasID()){

                lobbyBoard.setID(taskID);

            }

            Main.getInstance().scoreboards.createLobbyBoard(players);

        }

        if(timer == 0){

            start = true;
            GameStates.setState(GameStates.GAME);

            Bukkit.broadcastMessage(Main.getInstance().prefix + "§aPartie lancée, bonne chance !");
            for(Player players : Bukkit.getOnlinePlayers()){

                players.playSound(players.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 1f);
                players.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);

                new GamePlayer(players.getName());

                String teamName = TeamGui.getPlayersTeam().get(players.getUniqueId()).toLowerCase();

                if(TeamGui.getPlayersTeam().get(players.getUniqueId()) != null){

                    if(Main.getInstance().getConfig().getConfigurationSection("game.teams." + teamName + ".base") == null){

                        players.sendMessage(Main.getInstance().prefix + "§cAucune base existante pour votre équipe !");
                        return;

                    }

                    Double xCoord = Main.getInstance().getConfig().getDouble("game.teams." + teamName + ".base.x");
                    Double yCoord = Main.getInstance().getConfig().getDouble("game.teams." + teamName + ".base.y");
                    Double zCoord = Main.getInstance().getConfig().getDouble("game.teams." + teamName + ".base.z");

                    players.teleport(new Location(Bukkit.getWorlds().get(0), xCoord, yCoord, zCoord, 90, 0));

                }

            }

            Gamerules.setGamerulesGame();
            Bukkit.getWorlds().get(0).setTime(0);

            new GameRunnable().runTaskTimer(Main.getInstance(), 0L, 20L);
            GameRunnable.start = true;

            this.cancel();

        }

        if((timer == 60) || (timer == 30) || (timer == 15) || (timer == 10) || (timer == 5) || (timer == 4) || (timer == 3) || (timer == 2) || (timer == 1)){

            Bukkit.broadcastMessage(Main.getInstance().prefix + "§6Démarrage de la partie dans §e" + timer + " " + getSeconds() + "§6.");

            for(Player players : Bukkit.getOnlinePlayers()){

                players.playSound(players.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10f, 1f);

            }

        }

    }

    private String getSeconds() {

        return timer == 1 ? "seconde" : "secondes";

    }

    private void setLevel(){

        for(Player players : Bukkit.getOnlinePlayers()){

            players.setLevel(timer);

        }

    }

}
