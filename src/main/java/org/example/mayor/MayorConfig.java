package org.example.mayor;

import java.sql.*;

public class MayorConfig {
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

    public static void mayorTable (){
        String sql = "CREATE TABLE IF NOT EXISTS mayor (" +
                "id SERIAL PRIMARY KEY NOT NULL," +
                "    city_name VARCHAR(50)," +
                "    name VARCHAR(50)," +
                "    surname VARCHAR(50)," +
                "    age INT NOT NULL)";
        try (Connection connection = connection();
          Statement statement = connection.createStatement()
             ){
        statement.executeUpdate(sql);

        }catch (SQLException e){
         System.out.println(e.getMessage());
        }
    }

    public static void addMayorValues (String city_name,String name,String surname,int age){
        String sql ="INSERT INTO mayor(city_name,name,surname,age) VALUES (?,?,?,?)";
        try(Connection connection = connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1,city_name);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,surname);
            preparedStatement.setInt(4,age);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }







}
