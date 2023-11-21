package fr.catsuri33.myopit.check.movement.speed;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Speed implements Listener {

    private Location from, to;
    private Double xDiff, yDiff, Zdiff;

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){

        Player p = e.getPlayer();

        this.from = e.getFrom();
        this.to = e.getTo();
        this.xDiff = (from.getX() > to.getX() ? from.getX() : to.getX()) - (from.getX() < to.getX() ? from.getX() : to.getX());

    }

}
