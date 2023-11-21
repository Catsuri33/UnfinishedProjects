package fr.epicgiant.core.infos;

import fr.epicgiant.core.Main;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerInfos {

    private Main main = Main.getInstance();

    public void update(Player player){

        try {
            PreparedStatement sts = Main.getInstance().mysql.getConnection().prepareStatement("SELECT player_name FROM player_infos WHERE player_uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();

            if(rs.next()){
                PreparedStatement update = Main.getInstance().mysql.getConnection().prepareStatement("UPDATE player_infos SET player_name=? WHERE player_uuid=?");
                update.setString(1, player.getName());
                update.setString(2, player.getUniqueId().toString());
                update.executeUpdate();
                update.close();

                System.out.println("Update : " + player.getName() + ", " + player.getUniqueId().toString());
            } else {
                PreparedStatement insert = Main.getInstance().mysql.getConnection().prepareStatement("INSERT INTO player_infos (player_uuid, player_name) VALUES (?, ?)");
                insert.setString(1, player.getUniqueId().toString());
                insert.setString(2, player.getName());
                insert.executeUpdate();
                insert.close();

                System.out.println("Insertion : " + player.getName() + ", " + player.getUniqueId().toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exist(String playerName){

        try {
            PreparedStatement sts = Main.getInstance().mysql.getConnection().prepareStatement("SELECT * FROM player_infos WHERE player_name=?");
            sts.setString(1, playerName);
            ResultSet rs = sts.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public UUID getUUID(String playerName){

        try {
            PreparedStatement sts = Main.getInstance().mysql.getConnection().prepareStatement("SELECT player_uuid FROM player_infos WHERE player_name=?");
            sts.setString(1, playerName);
            ResultSet rs = sts.executeQuery();

            if(rs.next()){
                return UUID.fromString(rs.getString("player_uuid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("Error, the player does not have information in the table");
    }

}
