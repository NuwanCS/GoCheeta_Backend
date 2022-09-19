package com.nuwan.gocheeta.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nuwan
 */
public class DatabaseConnection {

    private static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            String url = "jdbc:mysql://localhost:3306/gocheeta?autoReconnect=true&useSSL=false";
            String user = "root";
            String pass = "root";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

}
