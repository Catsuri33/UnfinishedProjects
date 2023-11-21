package com.insignic.network.listeners;

import com.insignic.network.database.DatabaseManager;
import com.insignic.network.database.MongoDb;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        MongoCollection playersCollection = MongoDb.mongoDatabaseInsignicNetwork.getCollection("players");
        Document foundUUID = (Document) playersCollection.find(new Document("uuid", p.getUniqueId().toString())).first();

        if(foundUUID == null){

            Document newUser = new Document("id", playersCollection.countDocuments() + 1);
            newUser.append("uuid", p.getUniqueId().toString());
            newUser.append("username", p.getName());

            playersCollection.insertOne(newUser);

            DatabaseManager.instance.addStatTotalPlayers(1);

        }

        if(DatabaseManager.instance.getNickname(p.getUniqueId().toString()) != null){

            if(DatabaseManager.instance.getRank(p.getUniqueId().toString()).equals("CEO")){

                p.setPlayerListName("§c[Admin] " + p.getName());

            }

            if(DatabaseManager.instance.getRank(p.getUniqueId().toString()).equals("Moderator")){

                p.setPlayerListName("§9[Moderator] " + p.getName());

            }

        } else {

            p.setPlayerListName("§7[Player] " + p.getName());

        }

        p.getActivePotionEffects().clear();
        p.resetPlayerTime();
        p.resetPlayerWeather();
        p.setHealth(20.0);
        p.setFoodLevel(20);
        p.setGameMode(GameMode.SURVIVAL);
        e.setJoinMessage(null);

    }

}
