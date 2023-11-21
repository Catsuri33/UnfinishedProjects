package com.insignicnetwork.lobby.mysql;

import com.insignicnetwork.lobby.Lobby;
import com.insignicnetwork.lobby.mysql.ranks.RanksList;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.sql.*;
import java.util.UUID;

public class PlayersMySQL {

    private String url, host, database, username, password;
    private static Connection connection;

    public PlayersMySQL(String url, String host, String database, String username, String password){

        this.url = url;
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;

    }

    public static Connection getConnection() {

        return connection;

    }

    public static void openConnection() throws SQLException, ClassNotFoundException {

        if (connection != null && !connection.isClosed()) {

            return;

        }

    }

    public void connect(){

        if(!isConnected()){

            try{

                connection = DriverManager.getConnection(this.url + this.host + "/" + this.database + "?autoReconnect=true", this.username, this.password);
                Lobby.getInstance().log(ChatColor.GREEN + "Connected to the database !");
                return;

            } catch(SQLException e){

                e.printStackTrace();

            }

        }

    }

    public void disconnect(){

        if(isConnected()){

            try{

                connection.close();
                Lobby.getInstance().log(ChatColor.RED + "Disconnected from the database !");
                return;

            } catch(SQLException e){

                e.printStackTrace();

            }

        }

    }

    public boolean isConnected(){

        try{

            if((connection == null) || (connection.isClosed())){

                return false;

            }

            return true;

        } catch(SQLException e){

            e.printStackTrace();

        }

        return false;

    }

    public void createAccount(UUID uuid){

        if(!hasAccount(uuid)){

            try{

                PreparedStatement ps = connection.prepareStatement("INSERT INTO players (uuid, pseudo, rank, guild, coins, insicoins, level, xp, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, uuid.toString());
                ps.setString(2, Bukkit.getPlayer(uuid).getName());
                ps.setString(3, "Player");
                ps.setString(4, "");
                ps.setFloat(5, 0.00f);
                ps.setFloat(6, 0.00f);
                ps.setFloat(7, 1);
                ps.setFloat(8, 0);
                ps.setString(9, "");
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

            PreparedStatement ps = connection.prepareStatement("SELECT coins FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                result = true;

            }

            result = false;

            ps.close();

        } catch(SQLException e){

            e.printStackTrace();
            return result;

        }

        return result;

    }

    public void setPlayerRank(UUID uuid, String rank){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET rank=? WHERE uuid=?");
            preparedStatement.setString(1, rank);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    // Old Method
    //public static String getPlayerRank(UUID uuid){

        //try{

            //String rank;

            //PreparedStatement preparedStatement = connection.prepareStatement("SELECT rank FROM players WHERE uuid = ?");
            //preparedStatement.setString(1, uuid.toString());

            //ResultSet results = preparedStatement.executeQuery();

            //rank = results.getString("rank");

            //preparedStatement.close();

            //return rank;

        //} catch(SQLException e){

            //e.printStackTrace();
            //return "Player";

        //}

    //}

    public static RanksList getPlayerRank(UUID uuid){

        try{

            RanksList rank = RanksList.PLAYER;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT rank FROM players WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();

            if(results.next()){

                rank = RanksList.getByName(results.getString("rank"));

            }

            preparedStatement.close();

            return rank;

        } catch(SQLException e){

            e.printStackTrace();
            return RanksList.PLAYER;

        }

    }

    public void setPlayerGuild(UUID uuid, String guild){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET guild=? WHERE uuid=?");
            preparedStatement.setString(1, guild);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static String getPlayerGuild(UUID uuid){

        try{

            String guild;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT guild FROM players WHERE uuid = ?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            guild = results.getString("guild");

            preparedStatement.close();

            return guild;

        } catch(SQLException e){

            e.printStackTrace();
            return "";

        }

    }

    public void setPlayerCoins(UUID uuid, float coins){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET coins=? WHERE uuid=?");
            preparedStatement.setFloat(1, coins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void addPlayerCoins(UUID uuid, float coins){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET coins = coins + ? WHERE uuid=?");
            preparedStatement.setFloat(1, coins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void removePlayerCoins(UUID uuid, float coins){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET coins= coins - ? WHERE uuid=?");
            preparedStatement.setFloat(1, coins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static float getPlayerCoins(UUID uuid){

        try{

            float coins;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT coins FROM players WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            coins = results.getFloat("coins");

            preparedStatement.close();

            return coins;

        } catch(SQLException e){

            e.printStackTrace();
            return 0.00f;

        }

    }

    public void setPlayerInsiCoins(UUID uuid, float insiCoins){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET insicoins=? WHERE uuid=?");
            preparedStatement.setFloat(1, insiCoins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void addPlayerInsiCoins(UUID uuid, float insiCoins){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET insicoins= insicoins + ? WHERE uuid=?");
            preparedStatement.setFloat(1, insiCoins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void removePlayerInsiCoins(UUID uuid, float insiCoins){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET insicoins= insicoins - ? WHERE uuid=?");
            preparedStatement.setFloat(1, insiCoins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static float getPlayerInsiCoins(UUID uuid){

        try{

            float insiCoins;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT insicoins FROM players WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            insiCoins = results.getFloat("insicoins");

            preparedStatement.close();

            return insiCoins;

        } catch(SQLException e){

            e.printStackTrace();
            return 0.00f;

        }

    }

    public void setPlayerLevel(UUID uuid, int level){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET level=? WHERE uuid=?");
            preparedStatement.setInt(1, level);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void addPlayerLevel(UUID uuid, int level){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET level= level + ? WHERE uuid=?");
            preparedStatement.setInt(1, level);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void removePlayerLevel(UUID uuid, int level){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET level= level - ? WHERE uuid=?");
            preparedStatement.setInt(1, level);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getPlayerLevel(UUID uuid){

        try{

            int level;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT level FROM players WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            level = results.getInt("level");

            preparedStatement.close();

            return level;

        } catch(SQLException e){

            e.printStackTrace();
            return 1;

        }

    }

    public void setPlayerXP(UUID uuid, int xp){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET xp=? WHERE uuid=?");
            preparedStatement.setInt(1, xp);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void addPlayerXP(UUID uuid, int xp){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET xp= xp + ? WHERE uuid=?");
            preparedStatement.setInt(1, xp);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void removePlayerXP(UUID uuid, int xp){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET xp= xp - ? WHERE uuid=?");
            preparedStatement.setInt(1, xp);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getPlayerXP(UUID uuid){

        try{

            int xp;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT xp FROM players WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            xp = results.getInt("xp");

            preparedStatement.close();

            return xp;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public static void setPlayerPassword(UUID uuid, String password){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET password=? WHERE uuid=?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static String getPlayerPassword(UUID uuid){

        try{

            String password;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM players WHERE uuid = ?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            password = results.getString("password");

            preparedStatement.close();

            return password;

        } catch(SQLException e){

            e.printStackTrace();
            return "";

        }

    }

    public static void setPlayerState(UUID uuid, int state){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET state = ? WHERE uuid = ?");
            preparedStatement.setInt(1, state);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getPlayerState(UUID uuid){

        try{

            int state;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT state FROM players WHERE uuid=?");
            preparedStatement.setString(1, uuid.toString());

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            state = results.getInt("state");

            preparedStatement.close();

            return state;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

}
