package org.example;

import org.example.model.City;
import org.example.dao.CityDaoImpl;
import org.example.model.Country;
import org.example.dao.CountryDaoImpl;
import org.example.model.Mayor;
import org.example.dao.MayorDaoImpl;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {

          MayorDaoImpl mayorDao = new MayorDaoImpl();
          CityDaoImpl cityDao = new CityDaoImpl();
          CountryDaoImpl countryDao = new CountryDaoImpl();

          mayorDao.mayorTable();
          cityDao.cityTable();
          countryDao.countryTable();

          MayorDaoImpl.addMayorValues("Bishkek","Mirbek","Nurmuhammedov",28);
          CityDaoImpl.addCityValues("Bishkek","182km2",500000,1);
          CountryDaoImpl.addCountryValues("Kyrgyzstan","Sadyr_Japarov",6000000,1);
          MayorDaoImpl.getAllMayors();
          CityDaoImpl.getAllCity();
          CountryDaoImpl.getAllCountry();




    }
}
