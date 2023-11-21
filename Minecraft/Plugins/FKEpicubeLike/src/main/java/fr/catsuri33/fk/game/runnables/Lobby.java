package fr.catsuri33.fk.game.runnables;

import fr.catsuri33.fk.Main;
import fr.catsuri33.fk.game.scoreboards.LobbyBoard;
import fr.catsuri33.fk.utils.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Lobby extends BukkitRunnable {

    public int timer = 121;
    public int count = 0;
    public static boolean start = false;

    private int taskID;

    @Override
    public void run() {

        taskID = this.getTaskId();

        Main.getInstance().lobbyRunnableTimer = timer;

        if(!GameStates.isState(GameStates.WAITING)){

            timer = 121;
            start = false;
            this.cancel();
            return;

        }

        if(Bukkit.getOnlinePlayers().size() < 1){

            Bukkit.broadcastMessage(Main.prefix + "§cIl n'y a pas assez de joueurs pour lancer la partie !");
            timer = 121;
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

            if(count == 1){

                count = 0;

            }

            switch(count){

                case 0:
                    Main.getInstance().scoreboards.createLobbyBoard(players);
                    break;

            }

        }

        count++;

        if(timer == 0){

            start = true;
            GameStates.setState(GameStates.GAME);

            for(Player player : Bukkit.getOnlinePlayers()){

                LobbyBoard lobbyBoard = new LobbyBoard(player.getUniqueId());
                lobbyBoard.stop();

            }

            this.cancel();

        }

        if((timer == 120) || (timer == 90) || (timer == 60) || (timer == 30) || (timer == 15) || (timer == 10) || (timer == 5) || (timer == 4) || (timer == 3) || (timer == 2) || (timer == 1)){

            Bukkit.broadcastMessage(Main.prefix + "§6Démarrage de la partie dans §e" + timer + " " + getSeconds() + "§6.");

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
