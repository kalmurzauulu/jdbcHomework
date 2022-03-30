package org.example.country;

import java.sql.*;

public class CountryConfig {
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

    public static void countryTable (){
        String sql = "CREATE TABLE IF NOT EXISTS country (" +
                "id SERIAL PRIMARY KEY NOT NULL," +
                "    country_name VARCHAR(50)," +
                "    president VARCHAR (50)," +
                "    population INTEGER ," +
                "    capital_id INT REFERENCES city(id))";
        try (Connection connection = connection();
             Statement statement = connection.createStatement()
        ){
            statement.executeUpdate(sql);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void addCountryValues (String country_name,String president,int population,int capital_id){
        String sql ="INSERT INTO country(country_name,president,population,capital_id) VALUES (?,?,?,?)";
        try(Connection connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1,country_name);
            preparedStatement.setString(2,president);
            preparedStatement.setInt(3,population);
            preparedStatement.setInt(4,capital_id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void saveCountry(int id, String country_name, String president, int population, int capital_id) {
    }
}
