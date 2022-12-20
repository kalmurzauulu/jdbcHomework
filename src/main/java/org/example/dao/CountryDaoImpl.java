package org.example.dao;

import org.example.model.City;
import org.example.model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.Util.connection;

public class CountryDaoImpl {
    static Country country = new Country();
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

    public static List<Country> getAllCountry() {
        List<Country> countryList =new ArrayList<>();
        String SQL = "SELECT * FROM country";
        try {
            Connection connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                country.setId(resultSet.getInt("id"));
                country.setCountry_name(resultSet.getString("country_name"));
                country.setPresident(resultSet.getString("president"));
                country.setPopulation(resultSet.getInt("population"));
                country.setCapital_id(resultSet.getInt("capital_id"));
                countryList.add(country);
                System.out.println(countryList);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return countryList;
    }


}
