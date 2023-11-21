package fr.catsuri33.insiac.mysql;

import org.bukkit.Bukkit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayersMySQL {

    protected String table = "players";

    public static void createAccount(UUID uuid, String server){

        if(!hasAccount(uuid, server)){

            try{

                PreparedStatement ps = ServersMySQL.getConnection().prepareStatement("INSERT INTO players (uuid, pseudo, server, sanctions_total, sanctions_bans, sanctions_mutes, sanctions_warns, ban_end, ban_reason) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, uuid.toString());
                ps.setString(2, Bukkit.getPlayer(uuid).getName());
                ps.setString(3, server);
                ps.setInt(4, 0);
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.setInt(8, 0);
                ps.setString(9, "");
                ps.execute();
                ps.close();

            } catch(SQLException e){

                e.printStackTrace();

            }

        }

    }

    public static boolean hasAccount(UUID uuid, String server){

        boolean result = false;

        try{

            PreparedStatement ps = ServersMySQL.getConnection().prepareStatement("SELECT server FROM players WHERE uuid=? AND server=?");
            ps.setString(1, uuid.toString());
            ps.setString(2, server);
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

    public static String getName(UUID uuid, String server){

        try{

            String name = "";

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("SELECT * FROM players WHERE uuid=? AND server=?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            name = results.getString("pseudo");

            preparedStatement.close();

            return name;

        } catch(SQLException e){

            e.printStackTrace();
            return "";

        }

    }

    public static UUID getUUID(String name, String server){

        try{

            String uuid = "";

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("SELECT * FROM players WHERE pseudo=? AND server=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            uuid = results.getString("uuid");

            preparedStatement.close();

            return UUID.fromString(uuid);

        } catch(SQLException e){

            //e.printStackTrace();
            return null;

        }

    }

    public static String getServer(UUID uuid, String server){

        try{

            String serverName = "";

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("SELECT * FROM players WHERE uuid=? AND server=?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            serverName = results.getString("server");

            preparedStatement.close();

            return serverName;

        } catch(SQLException e){

            e.printStackTrace();
            return "";

        }

    }

    public static int getSanctionsTotal(UUID uuid, String server){

        try{

            int sanctionsTotal = 0;

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("SELECT * FROM players WHERE uuid=? AND server=?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            sanctionsTotal = results.getInt("sanctions_total");

            preparedStatement.close();

            return sanctionsTotal;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public static void setSanctionsTotal(UUID uuid, String server,  int total){

        try{

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("UPDATE players SET sanctions_total=? WHERE uuid=? AND server=?");
            preparedStatement.setInt(1, total);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.setString(3, server);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getSanctionsBans(UUID uuid, String server){

        try{

            int sanctionsBans = 0;

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("SELECT * FROM players WHERE uuid=? AND server=?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            sanctionsBans = results.getInt("sanctions_bans");

            preparedStatement.close();

            return sanctionsBans;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public static void setSanctionsBans(UUID uuid, String server, int total){

        try{

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("UPDATE players SET sanctions_bans=? WHERE uuid=? AND server=?");
            preparedStatement.setInt(1, total);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.setString(3, server);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getSanctionsMutes(UUID uuid, String server){

        try{

            int sanctionsMutes = 0;

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("SELECT * FROM players WHERE uuid=? AND server=?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            sanctionsMutes = results.getInt("sanctions_mutes");

            preparedStatement.close();

            return sanctionsMutes;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public static void setSanctionsMutes(UUID uuid, int total){

        try{

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("UPDATE players SET sanctions_mutes=? WHERE uuid=?");
            preparedStatement.setInt(1, total);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static int getSanctionsWarns(UUID uuid, String server){

        try{

            int sanctionsWarns = 0;

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("SELECT * FROM players WHERE uuid=? AND server=?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            sanctionsWarns = results.getInt("sanctions_warns");

            preparedStatement.close();

            return sanctionsWarns;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public static void setSanctionsWarns(UUID uuid, int total){

        try{

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("UPDATE players SET sanctions_warns=? WHERE uuid=?");
            preparedStatement.setInt(1, total);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

}
