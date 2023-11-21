package fr.catsuri33.cletials.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLServer {

    private Connection connection;
    public String host, database, username, password;
    public int port;

    public void mysqlServerSetup(){

        host = "www.db4free.net";
        port = 3306;
        database = "epic_giant";
        username = "username";
        password = "password";

        try{

            synchronized(this){

                if(getConnection() != null && !getConnection().isClosed()){

                    return;

                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection(DriverManager.getConnection("jdbc::mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password));

            }

        } catch(SQLException | ClassNotFoundException e){

            e.printStackTrace();

        }

    }

    public Connection getConnection(){

        return connection;

    }

    public void setConnection(Connection connection){

        this.connection = connection;

    }

}
