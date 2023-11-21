package com.insignicnetwork.bungeecord.servers;

import com.insignicnetwork.bungeecord.mysql.PlayersMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServersCommon {

    public String table = "servers";

    private String displayName;

    public ServersCommon(String displayName){

        this.displayName = displayName;

    }

    public String getDisplayName() {

        return displayName;

    }

    public int getState(){

        try{

            PreparedStatement ps = PlayersMySQL.getConnection().prepareStatement("SELECT state FROM " + table + " WHERE name = ?");
            ps.setString(1, displayName);
            ResultSet rs = ps.executeQuery();
            int state = 0;

            while(rs.next()){

                state = rs.getInt("state");

            }

            ps.close();

            return state;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public int getPort(){

        try{

            PreparedStatement ps = PlayersMySQL.getConnection().prepareStatement("SELECT port FROM " + table + " WHERE name = ?");
            ps.setString(1, displayName);
            ResultSet rs = ps.executeQuery();
            int port = 0;

            while(rs.next()){

                port = rs.getInt("port");

            }

            ps.close();

            return port;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public String getIP(){

        try{

            PreparedStatement ps = PlayersMySQL.getConnection().prepareStatement("SELECT ip FROM " + table + " WHERE name = ?");
            ps.setString(1, displayName);
            ResultSet rs = ps.executeQuery();
            String ip = "";

            while(rs.next()){

                ip = rs.getString("ip");

            }

            ps.close();

            return ip;

        } catch(SQLException e){

            e.printStackTrace();
            return "";

        }

    }

}
