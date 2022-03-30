package org.example.city;

import java.sql.*;

public class CityConfig {
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

    public static void cityTable (){
        String sql = "CREATE TABLE IF NOT EXISTS city (" +
                "id SERIAL PRIMARY KEY NOT NULL," +
                "    city_name VARCHAR(50)," +
                "    area VARCHAR (50)," +
                "    population INTEGER ," +
                "    mayor_id INT REFERENCES mayor(id))";
        try (Connection connection = connection();
             Statement statement = connection.createStatement()
        ){
            statement.executeUpdate(sql);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void addCityValues (String city_name,String area,int population,int mayor_id){
        String sql ="INSERT INTO city(city_name,area,population,mayor_id) VALUES (?,?,?,?)";
        try(Connection connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1,city_name);
            preparedStatement.setString(2,area);
            preparedStatement.setInt(3,population);
            preparedStatement.setInt(4,mayor_id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
