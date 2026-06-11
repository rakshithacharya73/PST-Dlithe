package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecting {

    public static Connection getConnect() {

        Connection con = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nitte2026_s",
                    "root",
                    "rakshith73");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}