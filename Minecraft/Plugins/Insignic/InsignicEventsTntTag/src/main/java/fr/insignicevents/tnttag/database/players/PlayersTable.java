package fr.insignicevents.tnttag.database.players;

import fr.insignicevents.tnttag.TntTag;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayersTable {

    public static boolean playerExists(UUID uuid){

        try{

            PreparedStatement preparedStatement = TntTag.getInstance().getConnection().prepareStatement("SELECT * FROM players WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();

            if(results.next()){

                return true;

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return false;

    }

    public static void createPlayer(UUID uuid, Player p){

        try{

            PreparedStatement preparedStatement = TntTag.getInstance().getConnection().prepareStatement("SELECT * FROM players WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();

            results.next();

            if(!playerExists(uuid)){

                PreparedStatement insertStatement = TntTag.getInstance().getConnection().prepareStatement("INSERT INTO players (uuid, pseudo, team, points, coins) VALUE (?,?,?,?,?)");
                insertStatement.setString(1, uuid.toString());
                insertStatement.setString(2, p.getName());
                insertStatement.setString(3, "");
                insertStatement.setString(4, "0");
                insertStatement.setString(5, "0");
                insertStatement.executeUpdate();



            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static void setPlayerPoints(UUID uuid, int points){

        try{

            if(playerExists(uuid)){

                PreparedStatement preparedStatement = TntTag.getInstance().getConnection().prepareStatement("UPDATE players SET points=? WHERE uuid=?");
                preparedStatement.setInt(1, points);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getPlayerPoints(UUID uuid){

        try{

            if(playerExists(uuid)){

                PreparedStatement preparedStatement = TntTag.getInstance().getConnection().prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getInt("points");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return 0;
    }

    public static void setPlayerTeam(UUID uuid, String team){

        try{

            if(playerExists(uuid)){

                PreparedStatement preparedStatement = TntTag.getInstance().getConnection().prepareStatement("UPDATE players SET team=? WHERE uuid=?");
                preparedStatement.setString(1, team);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static String getPlayerTeam(UUID uuid){

        try{

            if(playerExists(uuid)){

                PreparedStatement preparedStatement = TntTag.getInstance().getConnection().prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getString("team");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return "N/A";

    }

    public static void setPlayerCoins(UUID uuid, int coins){

        try{

            if(playerExists(uuid)){

                PreparedStatement preparedStatement = TntTag.getInstance().getConnection().prepareStatement("UPDATE players SET coins=? WHERE uuid=?");
                preparedStatement.setInt(1, coins);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getPlayerCoins(UUID uuid){

        try{

            if(playerExists(uuid)){

                PreparedStatement preparedStatement = TntTag.getInstance().getConnection().prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getInt("coins");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return 0;
    }

}
