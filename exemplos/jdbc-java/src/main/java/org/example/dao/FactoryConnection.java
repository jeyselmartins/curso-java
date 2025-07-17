package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class FactoryConnection {
    private static String url = "jdbc:mysql://127.0.0.1:3306/aula1";
    private static String user = "root";
    private static String password = "";

    public static Connection createCon() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
}
