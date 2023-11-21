package fr.catsuri33.insiac.mysql;

import fr.catsuri33.insiac.InsiAC;
import fr.catsuri33.insiac.utils.Logger;

import java.sql.*;
import java.util.UUID;

public class ServersMySQL {

    private String url, host, database, username, password;
    private static Connection connection;

    public ServersMySQL(String url, String host, String database, String username, String password){

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
                Logger.success("Connected to the database !");
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
                Logger.success("Disconnected from the database !");
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

    public void addServer(String server, String password){

        if(!hasAccount(server)){

            try{

                PreparedStatement ps = connection.prepareStatement("INSERT INTO servers (name, password, state, sanctions_total, sanctions_bans, sanctions_mutes, sanctions_warns) VALUES (?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, server);
                ps.setString(2, password);
                ps.setString(3, "Offline");
                ps.setInt(4, 0);
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.execute();
                ps.close();

            } catch(SQLException e){

                e.printStackTrace();

            }

        }

    }

    public static boolean hasAccount(String server){

        boolean result = false;

        try{

            PreparedStatement ps = connection.prepareStatement("SELECT name FROM servers WHERE name=?");
            ps.setString(1, server);
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

    public static boolean isPasswordCorrect(String server){

        boolean result = false;
        String password = InsiAC.getInstance().getConfig().getString("server-password");

        if(password.equals(getServerPassword(server))){

            result = true;

        }

        return result;

    }

    public static String getServerName(String server){

        try{

            String serverName = "";

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM servers WHERE name=?");
            preparedStatement.setString(1, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            serverName = results.getString("name");

            preparedStatement.close();

            return serverName;

        } catch(SQLException e){

            e.printStackTrace();
            return "";

        }

    }

    public static String getServerPassword(String server){

        try{

            String password = "";

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM servers WHERE name=?");
            preparedStatement.setString(1, server);

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

    public static String getServerState(String server){

        try{

            String state = "Offline";

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT state FROM servers WHERE name=?");
            preparedStatement.setString(1, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            state = results.getString("state");

            preparedStatement.close();

            return state;

        } catch(SQLException e){

            e.printStackTrace();
            return "Offline";

        }

    }

    public static void setServerState(String server, String state){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE servers SET state=? WHERE name=?");
            preparedStatement.setString(1, state);
            preparedStatement.setString(2, server);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getServerSanctionsTotal(String server){

        try{

            int sanctions_total = 0;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT sanctions_total FROM servers WHERE name=?");
            preparedStatement.setString(1, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            sanctions_total = results.getInt("sanctions_total");

            preparedStatement.close();

            return sanctions_total;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public static void setServerSanctionsTotal(String server, int total){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE servers SET sanctions_total=? WHERE name=?");
            preparedStatement.setInt(1, total);
            preparedStatement.setString(2, server);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getServerSanctionsBans(String server){

        try{

            int sanctions_bans = 0;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT sanctions_bans FROM servers WHERE name=?");
            preparedStatement.setString(1, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            sanctions_bans = results.getInt("sanctions_bans");

            preparedStatement.close();

            return sanctions_bans;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public static void setServerSanctionsBans(String server, int total){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE servers SET sanctions_bans=? WHERE name=?");
            preparedStatement.setInt(1, total);
            preparedStatement.setString(2, server);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getServerSanctionsMutes(String server){

        try{

            int sanctions_mutes = 0;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT sanctions_mutes FROM servers WHERE name=?");
            preparedStatement.setString(1, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            sanctions_mutes = results.getInt("sanctions_mutes");

            preparedStatement.close();

            return sanctions_mutes;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public static void setServerSanctionsMutes(String server, int total){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE servers SET sanctions_mutes=? WHERE name=?");
            preparedStatement.setInt(1, total);
            preparedStatement.setString(2, server);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getServerSanctionsWarns(String server){

        try{

            int sanctions_warns = 0;

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT sanctions_warns FROM servers WHERE name=?");
            preparedStatement.setString(1, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            sanctions_warns = results.getInt("sanctions_warns");

            preparedStatement.close();

            return sanctions_warns;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public static void setServerSanctionsWarns(String server, int total){

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE servers SET sanctions_warns=? WHERE name=?");
            preparedStatement.setInt(1, total);
            preparedStatement.setString(2, server);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

}
