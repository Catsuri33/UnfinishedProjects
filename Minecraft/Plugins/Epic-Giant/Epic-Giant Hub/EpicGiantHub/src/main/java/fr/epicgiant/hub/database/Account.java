package fr.epicgiant.hub.database;

import fr.epicgiant.hub.EpicGiantHub;
import fr.epicgiant.hub.database.ranks.RankUnit;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class Account {
    private static final String TABLE = "accounts";
    private Player player;
    private String uuid;

    public Account(Player player) {
        this.player = player;
        uuid = player.getUniqueId().toString();
    }

    public Player getPlayer() {
        return player;
    }

    public static Account getAccount(Player player){
        return EpicGiantHub.getInstance().getAccounts().stream().filter(a -> a.getPlayer() == player).findFirst().get();
    }

    public void setup(){
        EpicGiantHub.getInstance().getAccounts().add(this);
        EpicGiantHub.getInstance().getMYSQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(!rs.next()){
                    EpicGiantHub.getInstance().getMYSQL().update("INSERT INTO " + TABLE + " (uuid, pseudo, grade, grade_end, coins, level, xp) VALUES ('" + uuid + "', '" + player.getName() + "', '" + RankUnit.PLAYER.getName() + "', '-1', '0', '0', '0')");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        if(rankIsExceeded()){
            setRank(RankUnit.PLAYER);
        }
    }

    public void delete(){
        EpicGiantHub.getInstance().getAccounts().remove(this);
    }

    public RankUnit getRank(){
        return (RankUnit) EpicGiantHub.getInstance().getMYSQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return RankUnit.getByName(rs.getString("grade"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return RankUnit.PLAYER;
        });
    }

    public boolean hasTempRank(){
        return (boolean) EpicGiantHub.getInstance().getMYSQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return rs.getLong("grade_end") != -1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        });
    }

    public boolean rankIsExceeded(){
        return (boolean) EpicGiantHub.getInstance().getMYSQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return rs.getLong("grade_end") != -1 && rs.getLong("grade_end") < System.currentTimeMillis();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        });
    }

    public void setRank(RankUnit rank){
        EpicGiantHub.getInstance().getMYSQL().update("UPDATE " + TABLE + " SET grade='" + rank.getName() + "', grade_end='-1' WHERE uuid='" + uuid + "'");
    }

    public void setRank(RankUnit rank, long endInSeconds){
        EpicGiantHub.getInstance().getMYSQL().update("UPDATE " + TABLE + " SET grade='" + rank.getName() + "', grade_end='" + (endInSeconds * 1000 + System.currentTimeMillis()) + "' WHERE uuid='" + uuid + "'");
    }

    /* Coins System */
    public long getCoins(){

        return (long) EpicGiantHub.getInstance().getMYSQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return rs.getLong("coins");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        });

    }

    public void setCoins(long coins){

        EpicGiantHub.getInstance().getMYSQL().update("UPDATE " + TABLE + " SET coins='" + coins + "' WHERE uuid='" + uuid + "'");

    }

    public void addCoins(long coins){

        setCoins(getCoins() + coins);

    }

    public void removeCoins(long coins){

        setCoins(getCoins() < coins ? 0 : getCoins() - coins);

    }

    /* XPCommand System */
    public long getXP(){

        return (long) EpicGiantHub.getInstance().getMYSQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return rs.getLong("xp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        });

    }

    public void setXP(long xp){

        EpicGiantHub.getInstance().getMYSQL().update("UPDATE " + TABLE + " SET xp='" + xp + "' WHERE uuid='" + uuid + "'");

    }

    public void addXP(long xp){

        setXP(getCoins() + xp);

    }

    public void removeXP(long xp){

        setXP(getXP() < xp ? 0 : getXP() - xp);

    }

    /* Level System */
    public long getLevel(){

        return (long) EpicGiantHub.getInstance().getMYSQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return rs.getLong("level");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        });

    }

    public void setLevel(long level){

        EpicGiantHub.getInstance().getMYSQL().update("UPDATE " + TABLE + " SET level='" + level + "' WHERE uuid='" + uuid + "'");

    }

    public void addLevel(long level){

        setLevel(getLevel() + level);

    }

    public void removeLevel(long level){

        setLevel(getLevel() < level ? 0 : getLevel() - level);

    }

}
