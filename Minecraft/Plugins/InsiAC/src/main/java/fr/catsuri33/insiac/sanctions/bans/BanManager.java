package fr.catsuri33.insiac.sanctions.bans;

import fr.catsuri33.insiac.InsiAC;
import fr.catsuri33.insiac.mysql.PlayersMySQL;
import fr.catsuri33.insiac.mysql.ServersMySQL;
import fr.catsuri33.insiac.utils.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BanManager {

    public static void ban(UUID uuid, String server, long endInSeconds, String reason){

        if(isBanned(uuid)) return;

        long endInMillis = endInSeconds * 1000;
        long end = endInMillis + System.currentTimeMillis();

        if(endInSeconds == -1){

            end = -1;

        }

        try{

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("UPDATE players SET ban_end=? WHERE uuid=? AND server=?");
            preparedStatement.setLong(1, end);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.setString(3, server);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

        PlayersMySQL.setSanctionsBans(uuid, InsiAC.getInstance().getConfig().getString("server-name"), PlayersMySQL.getSanctionsBans(uuid, InsiAC.getInstance().getConfig().getString("server-name")) + 1);
        PlayersMySQL.setSanctionsTotal(uuid, InsiAC.getInstance().getConfig().getString("server-name"), PlayersMySQL.getSanctionsTotal(uuid, InsiAC.getInstance().getConfig().getString("server-name")) + 1);

        ServersMySQL.setServerSanctionsBans(InsiAC.getInstance().getConfig().getString("server-name"), ServersMySQL.getServerSanctionsBans(InsiAC.getInstance().getConfig().getString("server-name")) + 1);
        ServersMySQL.setServerSanctionsTotal(InsiAC.getInstance().getConfig().getString("server-name"), ServersMySQL.getServerSanctionsTotal(InsiAC.getInstance().getConfig().getString("server-name")) + 1);

        setReason(uuid, InsiAC.getInstance().getConfig().getString("server-name"), reason);

        if(Bukkit.getPlayer(uuid) != null){

            Player target = Bukkit.getPlayer(uuid);
            target.kickPlayer("§6§lInsiAC\n\n§r§cYou have been banned !\n§6Reason: §r§c" + reason + "\n§6Time Left: §c" + getTimeLeft(uuid, server));

        }

    }

    public static void unban(UUID uuid, String server){

        if(!isBanned(uuid)) return;

        try{

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("UPDATE players SET ban_end=? WHERE uuid=? AND server=?");
            preparedStatement.setLong(1, 0);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.setString(3, server);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

    public static boolean isBanned(UUID uuid){

        boolean result = false;

        try{

            PreparedStatement ps = ServersMySQL.getConnection().prepareStatement("SELECT * FROM players WHERE uuid=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();

            if(getEnd(uuid, InsiAC.getInstance().getConfig().getString("server-name")) == 0){

                return false;

            } else {

                result = true;

            }

            ps.close();

        } catch(SQLException e){

            e.printStackTrace();
            return result;

        }

        return result;

    }

    public static void checkDuration(UUID uuid, String server){

        if(!isBanned(uuid)) return;

        if(getEnd(uuid, server) == -1) return;

        if(getEnd(uuid, server) < System.currentTimeMillis()){

            unban(uuid, server);

        }

    }

    public static long getEnd(UUID uuid, String server){

        try{

            long end = 0;

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("SELECT * FROM players WHERE uuid=? AND server=?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            end = results.getLong("ban_end");

            preparedStatement.close();

            return end;

        } catch(SQLException e){

            e.printStackTrace();
            return 0;

        }

    }

    public static String getTimeLeft(UUID uuid, String server){

        if(!isBanned(uuid)) return "";

        if(getEnd(uuid, server) == -1){

            return "§cPermanent";

        }

        long timeLeft = (getEnd(uuid, server) - System.currentTimeMillis()) / 1000;
        int years = 0;
        int months = 0;
        int days = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        while(timeLeft >= TimeUnit.YEAR.getTimeInSeconds()){

            years++;
            timeLeft -= TimeUnit.YEAR.getTimeInSeconds();

        }

        while(timeLeft >= TimeUnit.MONTH.getTimeInSeconds()){

            months++;
            timeLeft -= TimeUnit.MONTH.getTimeInSeconds();

        }

        while(timeLeft >= TimeUnit.DAY.getTimeInSeconds()){

            days++;
            timeLeft -= TimeUnit.DAY.getTimeInSeconds();

        }

        while(timeLeft >= TimeUnit.HOUR.getTimeInSeconds()){

            hours++;
            timeLeft -= TimeUnit.HOUR.getTimeInSeconds();

        }

        while(timeLeft >= TimeUnit.MINUTE.getTimeInSeconds()){

            minutes++;
            timeLeft -= TimeUnit.MINUTE.getTimeInSeconds();

        }

        while(timeLeft >= TimeUnit.SECOND.getTimeInSeconds()){

            seconds++;
            timeLeft -= TimeUnit.SECOND.getTimeInSeconds();

        }

        return years + " " + TimeUnit.YEAR.getName() + ", " + months + " " + TimeUnit.MONTH.getName() + ", " + days + " " + TimeUnit.DAY.getName() + ", " + hours + " " + TimeUnit.HOUR.getName() + ", " + minutes + " " + TimeUnit.MINUTE.getName() + ", " + seconds + " " + TimeUnit.SECOND.getName();

    }

    public static String getReason(UUID uuid, String server){

        try{

            String reason = "";

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("SELECT * FROM players WHERE uuid=? AND server=?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, server);

            ResultSet results = preparedStatement.executeQuery();
            results.next();

            reason = results.getString("ban_reason");

            preparedStatement.close();

            return reason;

        } catch(SQLException e){

            e.printStackTrace();
            return "";

        }

    }

    public static void setReason(UUID uuid, String server, String reason){

        try{

            PreparedStatement preparedStatement = ServersMySQL.getConnection().prepareStatement("UPDATE players SET ban_reason=? WHERE uuid=? AND server=?");
            preparedStatement.setString(1, reason);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.setString(3, server);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();

        }

    }

}
