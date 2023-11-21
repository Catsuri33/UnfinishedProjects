package com.insignicnetwork.bungeecord.mysql;

import com.insignicnetwork.bungeecord.divisions.DivisionList;
import net.md_5.bungee.api.ProxyServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PracticeMySQL {

    protected String table = "ctf";

    public static void createAccount(UUID uuid){

        if(!hasAccount(uuid)){

            try{

                PreparedStatement ps = PlayersMySQL.getConnection().prepareStatement("INSERT INTO practice (uuid, pseudo, elo, division_global) VALUES (?, ?, ?, ?)");
                ps.setString(1, uuid.toString());
                ps.setString(2, ProxyServer.getInstance().getPlayer(uuid).getName());
                ps.setString(3, "1000");
                ps.setString(4, "Platinum III");
                ps.execute();
                ps.close();

            } catch(SQLException e){

                e.printStackTrace();

            }

        }

    }

    public static boolean hasAccount(UUID uuid){

        boolean result = false;

        try{

            PreparedStatement ps = PlayersMySQL.getConnection().prepareStatement("SELECT elo FROM practice WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                result = true;

            }

            ps.close();

        } catch(SQLException e){

            e.printStackTrace();
            return result;

        }

        return result;

    }

    public static void setPlayerDivision(UUID uuid, String division){

        try{

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("UPDATE practice SET division_global = ? WHERE uuid = ?");
            preparedStatement.setString(1, division);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static DivisionList getPlayerDivision(UUID uuid){

        try{

            DivisionList division = DivisionList.DIRTI;

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("SELECT division_global FROM practice WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();

            if(results.next()){

                division = DivisionList.getByName(results.getString("division_global"));

            }

            preparedStatement.close();

            return division;

        } catch(SQLException e){

            e.printStackTrace();
            return DivisionList.DIRTI;

        }

    }

    public static void setPlayerElo(UUID uuid, int elo){

        try{

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("UPDATE practice SET elo=? WHERE uuid=?");
            preparedStatement.setFloat(1, elo);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void addPlayerElo(UUID uuid, float elo){

        try{

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("UPDATE practice SET elo = elo + ? WHERE uuid=?");
            preparedStatement.setFloat(1, elo);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void removePlayerElo(UUID uuid, int elo){

        try{

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("UPDATE practice SET elo = elo - ? WHERE uuid=?");
            preparedStatement.setFloat(1, elo);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static float getPlayerElo(UUID uuid){

        try{

            int elo;

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("SELECT elo FROM practice WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            elo = results.getInt("elo");

            preparedStatement.close();

            return elo;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

}
