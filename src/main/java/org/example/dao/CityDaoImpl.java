package org.example.dao;

import org.example.model.City;
import org.example.model.Mayor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.Util.connection;

public class CityDaoImpl {

   static City city = new City();
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

    public static List<City> getAllCity() {
        List<City> cityList =new ArrayList<>();
        String SQL = "SELECT * FROM city";
        try {
            Connection connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                city.setId((int) resultSet.getLong("id"));
                city.setCity_name(resultSet.getString("city_name"));
                city.setArea(resultSet.getString("area"));
                city.setPopulation(resultSet.getInt("population"));
                city.setMayor_id(resultSet.getInt("mayor_id"));


                cityList.add(city);
                System.out.println(cityList);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cityList;
    }

}
