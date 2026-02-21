package com.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ems_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Saniya@14";

    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Database connected successfully");
        } catch (Exception e) {
           // System.out.println("Database connection failed");
            e.printStackTrace();
        }
        return con;

    }
}
