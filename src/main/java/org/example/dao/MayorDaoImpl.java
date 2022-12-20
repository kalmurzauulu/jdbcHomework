package org.example.dao;

import org.example.model.Mayor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.Util.connection;

public class MayorDaoImpl {
    static Mayor mayor = new Mayor();
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

    public static void addMayorValues(String city_name, String name, String surname, int age){
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

    public static List<Mayor> getAllMayors() {
        List<Mayor> mayorsList =new ArrayList<>();
        String SQL = "SELECT * FROM mayor";
        try {
            Connection connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                mayor.setId(resultSet.getInt("id"));
                mayor.setCity(resultSet.getString("city_name"));
                mayor.setName(resultSet.getString("name"));
                mayor.setSurname(resultSet.getString("surname"));
                mayor.setAge(resultSet.getByte("age"));

                mayorsList.add(mayor);
                System.out.println(mayorsList);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mayorsList;
    }
}
