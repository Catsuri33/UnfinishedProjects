package fr.catsuri33.sc.world;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessagesManager {

    public static HashMap<Player, Player> messages = new HashMap<>();

    public static void setReplyTarget(Player sender, Player target){

        messages.put(sender, target);
        messages.put(target, sender);

    }

    public static Player getReplyTarget(Player sender){

        return messages.get(sender);

    }

}
