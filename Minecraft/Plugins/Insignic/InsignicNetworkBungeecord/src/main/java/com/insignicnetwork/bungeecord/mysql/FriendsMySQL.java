package com.insignicnetwork.bungeecord.mysql;

import net.md_5.bungee.api.ProxyServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class FriendsMySQL {

    protected String table = "players_friends";

    public void addFriend(UUID playerUUID, UUID targetUUID){

        try{

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("INSERT INTO " + table + " (uuid, pseudo, uuid_friend, pseudo_friend) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, playerUUID.toString());
            preparedStatement.setString(2, ProxyServer.getInstance().getPlayer(playerUUID).getName());
            preparedStatement.setString(3, targetUUID.toString());
            preparedStatement.setString(4, ProxyServer.getInstance().getPlayer(targetUUID).getName());
            preparedStatement.execute();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void removeFriend(String player, String friend){

        try{

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("DELETE FROM " + table + " WHERE " + "pseudo = ? " + "AND pseudo_friend = ?");
            preparedStatement.setString(1, player);
            preparedStatement.setString(2, friend);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public List<String> getFriendlist(String pseudo){

        List<String> friendList = new ArrayList<>();

        try{

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("SELECT pseudo_friend FROM " + table + " WHERE pseudo = ?");
            preparedStatement.setString(1, pseudo);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                friendList.add(rs.getString("pseudo_friend"));

            }

            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();
            return friendList;

        }

        return friendList;

    }

    public boolean isFriendWith(String player, String friend){

        if(getFriendlist(player).contains(friend)){

            return true;

        }

        return false;

    }

    public Integer getFriendsCount(String pseudo){

        Integer count = 0;

        try{

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("SELECT pseudo_friend FROM " + table + " WHERE pseudo = ?");
            preparedStatement.setString(1, pseudo);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                count++;

            }

            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();
            return count;

        }

        return count;

    }

    public int getAllowRequest(String pseudo){

        try{

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("SELECT friend_requests FROM players WHERE pseudo = ?");
            preparedStatement.setString(1, pseudo);
            int state = 0;

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){

                state = rs.getInt("friend_requests");

            }

            preparedStatement.close();

            return state;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public void setAllowRequests(String pseudo, int state){

        try{

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("UPDATE players SET friend_requests = ? WHERE pseudo = ?");
            preparedStatement.setInt(1, state);
            preparedStatement.setString(2, pseudo);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

}
