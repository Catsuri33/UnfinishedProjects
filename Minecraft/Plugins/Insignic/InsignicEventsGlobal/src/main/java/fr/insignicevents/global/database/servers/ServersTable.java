package fr.insignicevents.global.database.servers;

import fr.insignicevents.global.Global;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServersTable {

    public static void setupServerTable(){

        try{

            PreparedStatement preparedStatement = Global.getInstance().getConnection().prepareStatement("SELECT * FROM servers");

            ResultSet results = preparedStatement.executeQuery();

            results.next();

            PreparedStatement insertStatement = Global.getInstance().getConnection().prepareStatement("INSERT INTO servers (maintenance) VALUE (?)");
            insertStatement.setString(1, "false");
            insertStatement.executeUpdate();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static void setMaintenanceState(String state){

        try{

            PreparedStatement preparedStatement = Global.getInstance().getConnection().prepareStatement("UPDATE servers SET maintenance=?");
            preparedStatement.setString(1, state);
            preparedStatement.executeUpdate();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static String getMaintenanceState(){

        try{

            PreparedStatement preparedStatement = Global.getInstance().getConnection().prepareStatement("SELECT * FROM servers");

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            return results.getString("maintenance");

        } catch(SQLException e){

            e.printStackTrace();

        }

        return "false";
    }

}
