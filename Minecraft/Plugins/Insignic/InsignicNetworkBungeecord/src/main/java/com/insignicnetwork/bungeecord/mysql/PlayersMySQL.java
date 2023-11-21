package com.insignicnetwork.bungeecord.mysql;

import com.insignicnetwork.bungeecord.Bungeecord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;

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
                Bungeecord.getInstance().log(ChatColor.GREEN + "Connected to the database !");
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
                Bungeecord.getInstance().log(ChatColor.RED + "Disconnected from the database !");
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
                ps.setString(2, ProxyServer.getInstance().getPlayer(uuid).getName());
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

        try{

            PreparedStatement ps = connection.prepareStatement("SELECT coins FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            float coins = 0;

            while(rs.next()){

                return true;

            }

            return false;

        } catch(SQLException e){

            e.printStackTrace();

        }

        return false;

    }

    public void setPlayerRank(UUID uuid, String rank){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET rank=? WHERE uuid=?");
                preparedStatement.setString(1, rank);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static String getPlayerRank(UUID uuid){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getString("rank");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return "Player";
    }

    public void setPlayerGuild(UUID uuid, String guild){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET guild=? WHERE uuid=?");
                preparedStatement.setString(1, guild);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static String getPlayerGuild(UUID uuid){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getString("guild");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return "";
    }

    public void setPlayerCoins(UUID uuid, float coins){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET coins=? WHERE uuid=?");
                preparedStatement.setFloat(1, coins);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void addPlayerCoins(UUID uuid, float coins){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET coins= coins + ? WHERE uuid=?");
                preparedStatement.setFloat(1, coins);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void removePlayerCoins(UUID uuid, float coins){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET coins= coins - ? WHERE uuid=?");
                preparedStatement.setFloat(1, coins);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static float getPlayerCoins(UUID uuid){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getFloat("coins");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return 0.00f;
    }

    public void setPlayerInsiCoins(UUID uuid, float insiCoins){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET insicoins=? WHERE uuid=?");
                preparedStatement.setFloat(1, insiCoins);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void addPlayerInsiCoins(UUID uuid, float insiCoins){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET insicoins= insicoins + ? WHERE uuid=?");
                preparedStatement.setFloat(1, insiCoins);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void removePlayerInsiCoins(UUID uuid, float insiCoins){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET insicoins= insicoins - ? WHERE uuid=?");
                preparedStatement.setFloat(1, insiCoins);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static float getPlayerInsiCoins(UUID uuid){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getFloat("insicoins");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return 0.00f;
    }

    public void setPlayerLevel(UUID uuid, int level){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET level=? WHERE uuid=?");
                preparedStatement.setInt(1, level);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void addPlayerLevel(UUID uuid, int level){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET level= level + ? WHERE uuid=?");
                preparedStatement.setInt(1, level);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void removePlayerLevel(UUID uuid, int level){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET level= level - ? WHERE uuid=?");
                preparedStatement.setInt(1, level);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public int getPlayerLevel(UUID uuid){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getInt("level");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return 1;
    }

    public void setPlayerXP(UUID uuid, int xp){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET xp=? WHERE uuid=?");
                preparedStatement.setInt(1, xp);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void addPlayerXP(UUID uuid, int xp){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET xp= xp + ? WHERE uuid=?");
                preparedStatement.setInt(1, xp);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public void removePlayerXP(UUID uuid, int xp){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET xp= xp - ? WHERE uuid=?");
                preparedStatement.setInt(1, xp);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public int getPlayerXP(UUID uuid){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getInt("xp");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return 0;
    }

    public static void setPlayerPassword(UUID uuid, String password){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET password=? WHERE uuid=?");
                preparedStatement.setString(1, password);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static String getPlayerPassword(UUID uuid){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getString("password");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return "";
    }

    public static void setPlayerState(UUID uuid, int state){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET state=? WHERE uuid=?");
                preparedStatement.setInt(1, state);
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getPlayerState(UUID uuid){

        try{

            if(hasAccount(uuid)){

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid=?");
                preparedStatement.setString(1, uuid.toString());

                ResultSet results = preparedStatement.executeQuery();
                results.next();

                return results.getInt("state");

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return 0;
    }

}
