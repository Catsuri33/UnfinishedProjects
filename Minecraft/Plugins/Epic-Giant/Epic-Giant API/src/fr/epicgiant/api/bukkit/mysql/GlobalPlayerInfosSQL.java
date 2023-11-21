package fr.epicgiant.api.bukkit.mysql;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.UUID;

public class GlobalPlayerInfosSQL {

    private String url_base;
    private String host;
    private String database;
    private String username;
    private String password;
    private String table;
    private Connection connection;

    public GlobalPlayerInfosSQL(String url_base, String host, String database, String username, String password, String table){

        this.url_base = url_base;
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        this.table = table;

    }

    public void connection(){

        if(!isConnected()){

            try {

                this.connection = DriverManager.getConnection(this.url_base + this.host + "/" + this.database);

            } catch(SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public void disconnection(){

        if(isConnected()){

            try {
                this.connection.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public boolean isConnected(){

        try {
            if((this.connection == null || (this.connection.isClosed() || (this.connection.isValid(5))))){
                return false;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Connection getConnection(){

        return this.connection;

    }

    public void createAccount(UUID uuid){

        try {
            PreparedStatement sts = getConnection().prepareStatement("SELECT pseudo FROM " + this.table + " WHERE UUID = ?");
            sts.setString(1, uuid.toString());
            ResultSet rs = sts.executeQuery();
            if(!rs.next()){
                sts.close();
                PreparedStatement sts2 = getConnection().prepareStatement("INSERT INTO " + this.table + " (uuid, pseudo, rank, coins, xp, level, language) VALUES (?, ?, ?, ?, ?, ?)");
                sts2.setString(1, uuid.toString());
                sts2.setString(2, Bukkit.getPlayer(uuid).getName());
                sts2.setString(3, "Joueur");
                sts2.setString(4, "0");
                sts2.setString(5, "0");
                sts2.setString(6, "0");
                sts2.setString(7, "fr");
                sts2.executeUpdate();
                sts2.close();
            }
            updatePlayerName(Bukkit.getPlayer(uuid));
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void updatePlayerName(Player p){

        try {
            PreparedStatement sts = getConnection().prepareStatement("SELECT pseudo FROM " + this.table + " WHERE uuid = ?");
            sts.setString(1, p.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();
            if(!rs.next()){
                return;
            }
            if(!rs.getString("pseudo").equals(p.getName())){
                sts.close();
                PreparedStatement sts2 = getConnection().prepareStatement("UPDATE " + this.table + " SET pseudo = ? WHERE uuid = ?");
                sts.setString(1, p.getName());
                sts2.setString(2, p.getUniqueId().toString());
                sts2.executeUpdate();
                sts2.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void setLanguage(UUID uuid, String language){

        try {
            PreparedStatement sts = getConnection().prepareStatement("UPDATE " + this.table + " SET language = ? WHERE uuid = ?");
            sts.setString(1, language);
            sts.setString(2, uuid.toString());
            sts.executeUpdate();
            sts.close();
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    public String getLanguage(UUID uuid){

        String language = null;
        try {
            PreparedStatement sts = getConnection().prepareStatement("SELECT language FROM " + this.table + " WHERE uuid = ?");
            sts.setString(1, uuid.toString());
            ResultSet rs = sts.executeQuery();
            if(!rs.next()){
                return language;
            }
            language = rs.getString("language");
            sts.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return language;
    }

}
