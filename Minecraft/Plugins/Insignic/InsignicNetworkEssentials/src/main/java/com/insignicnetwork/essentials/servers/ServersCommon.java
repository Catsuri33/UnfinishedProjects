package com.insignicnetwork.essentials.servers;

import com.insignicnetwork.essentials.mysql.PlayersMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServersCommon {

    public String table = "servers";

    private String displayName;

    public ServersCommon(String displayName){

        this.displayName = displayName;

    }

    public void loadServer(String ip, int port){

        try{

            PreparedStatement ps = PlayersMySQL.getConnection().prepareStatement("SELECT state FROM " + table + " WHERE name = ?");
            ps.setString(1, displayName);
            ResultSet rs = ps.executeQuery();

            if(!rs.next()){

                ps.close();
                ps = PlayersMySQL.getConnection().prepareStatement("INSERT INTO " + table + " (name, state, port, ip) VALUES (?, ?, ?, ?)");
                ps.setString(1, displayName);
                ps.setInt(2, 1);
                ps.setInt(3, port);
                ps.setString(4, ip);
                ps.execute();
                ps.close();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void setState(int state){

        try{

            PreparedStatement ps = PlayersMySQL.getConnection().prepareStatement("UPDATE " + table + " SET state = ? WHERE name = ?");
            ps.setInt(1, state);
            ps.setString(2, displayName);
            ps.executeUpdate();
            ps.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

}
