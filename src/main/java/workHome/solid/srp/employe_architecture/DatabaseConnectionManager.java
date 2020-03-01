package main.java.workHome.solid.srp.employe_architecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private Connection connection;

    private static DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
    private DatabaseConnectionManager(){

}
    public void connect() throws SQLException {
    connection = DriverManager.getConnection("Database URL");
        System.out.println("Connection to DB established");
    }
    public Connection getConnection(){
        return connection;
    }
    public void discinnect() throws SQLException {
        connection.close();
        System.out.println("Disonnect from DB");
    }
}
