package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String url = "jdbc:postgresql://localhost:5432/postgres";
    public static final String user = "postgres";
    public static final String password = "Jashtykketty";
    public static Connection connection() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url,user,password);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connect;
    }
}
