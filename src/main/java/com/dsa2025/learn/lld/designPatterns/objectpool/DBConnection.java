package com.dsa2025.learn.lld.designPatterns.objectpool;

import java.sql.Connection;
import java.sql.DriverManager;

// Resource
public class DBConnection {

    private Connection mysqlConnection;

    public DBConnection() {
        try {
            mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password");
            // Add proper JDBC driver and URL
        } catch (Exception e) {
            e.printStackTrace(); // Better than silent catch
        }
    }

    public Connection getConnection() {
        return mysqlConnection;
    }

}
