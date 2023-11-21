package com.insignicnetwork.essentials.mysql;

import com.insignicnetwork.essentials.core.divisions.DivisionList;
import org.bukkit.Bukkit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CTFMySQL {

    protected String table = "ctf";

    public static void createAccount(UUID uuid){

        if(!hasAccount(uuid)){

            try{

                PreparedStatement ps = PlayersMySQL.getConnection().prepareStatement("INSERT INTO ctf (uuid, pseudo, elo, division) VALUES (?, ?, ?, ?)");
                ps.setString(1, uuid.toString());
                ps.setString(2, Bukkit.getPlayer(uuid).getName());
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

            PreparedStatement ps = PlayersMySQL.getConnection().prepareStatement("SELECT elo FROM ctf WHERE uuid=?");
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

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("UPDATE ctf SET division=? WHERE uuid=?");
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

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("SELECT division FROM ctf WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();

            if(results.next()){

                division = DivisionList.getByName(results.getString("division"));

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

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("UPDATE ctf SET elo=? WHERE uuid=?");
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

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("UPDATE ctf SET elo = elo + ? WHERE uuid=?");
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

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("UPDATE elo SET elo = elo - ? WHERE uuid=?");
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

            PreparedStatement preparedStatement = PlayersMySQL.getConnection().prepareStatement("SELECT elo FROM ctf WHERE uuid=?");
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
