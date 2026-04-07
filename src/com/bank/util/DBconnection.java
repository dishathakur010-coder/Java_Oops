package com.bank.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    static String url = "jdbc:mysql://localhost:3306/banking_system";
    static String user = "root";
    static String password = "your_password";
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
