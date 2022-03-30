package org.example;

import org.example.city.City;
import org.example.city.CityConfig;
import org.example.country.Country;
import org.example.country.CountryConfig;
import org.example.mayor.Mayor;
import org.example.mayor.MayorConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {
        MayorConfig.connection();
        MayorConfig.mayorTable();
        MayorConfig.addMayorValues("Bishkek","Mirbek","Nurmuhammedov",28);
        Mayor mayor1 = new Mayor(1,"Bishkek","Mirbek","Nurmuhammedov",28);
        MayorConfig.addMayorValues("Tashkent","Nurbek","Abylov",23);
        Mayor mayor2 = new Mayor(2,"Tashkent","Nurbek","Abylov",23);
        MayorConfig.addMayorValues("Ashgabad","Sherbek","Alymov",25);
        Mayor mayor3 = new Mayor(3,"Ashgabad","Sherbek","Alymov",25);
        MayorConfig.addMayorValues("Ankara","Tashmyrza","Nurmyrza_uulu",21);
        Mayor mayor4 = new Mayor(4,"Ankara","Tashmyrza","Nurmyrza_uulu",21);
        MayorConfig.addMayorValues("Astana","Bekmyrza","Sadyr_uulu",31);
        Mayor mayor5 = new Mayor(5,"Astana","Bekmyrza","Sadyr_uulu",31);

        CityConfig.connection();
        CityConfig.cityTable();

        CityConfig.addCityValues("Bishkek","182km2",500000,1);
        City city1 = new City(1,"Bishkek","182km2",500000,1);
        CityConfig.addCityValues("Tashkent","160km2",1000000,2);
        City city2 = new City(2,"Tashkent","160km2",1000000,2);
        CityConfig.addCityValues("Ashgabad","250km2",1000500,3);
        City city3 = new City(3,"Ashgabad","250km2",1000500,3);
        CityConfig.addCityValues("Ankara","300km2",3000000,4);
        City city4 = new City(4,"Ankara","300km2",3000000,4);
        CityConfig.addCityValues("Astana","200km2",1000000,5);
        City city5 = new City(5,"Astana","200km2",1000000,5);


        CountryConfig countryConfig = new CountryConfig();
        CountryConfig.countryTable();

        countryConfig.connection();



        CountryConfig.addCountryValues("Kyrgyzstan","Sadyr_Japarov",6000000,1);
        Country country1 = new Country(1,"Kyrgyzstan","Sadyr_Japarov",6000000,1);
        CountryConfig.addCountryValues("Qazakistan","Tokaev Joomart",16000000,5);
        Country country2 = new Country(2,"Qazakistan","Tokaev Joomart",16000000,5);
        CountryConfig.addCountryValues("Turkey","Erjep_Erdagan",82000000,4);
        Country country3 = new Country(3,"Turkey","Erjep_Erdagan",82000000,4);
        CountryConfig.addCountryValues("Uzbekistan","Shevket_Mirzaev",35000000,2);
        Country country4 = new Country(4,"Uzbekistan","Shevket_Mirzaev",35000000,2);
        CountryConfig.addCountryValues("Turkmenistan","Sardar_Berdimuhammedov",6000000,3);
        Country country5 = new Country(5,"Turkmenistan","Sardar_Berdimuhammedov",6000000,3);


        ArrayList<Country> countryList = new ArrayList<>();
        countryList.add(country1);
        countryList.add(country2);
        countryList.add(country3);
        countryList.add(country4);
        countryList.add(country5);
        System.out.println(countryList);
        ArrayList<Mayor> mayorList = new ArrayList<>();
        mayorList.add(mayor1);
        mayorList.add(mayor2);
        mayorList.add(mayor3);
        mayorList.add(mayor4);
        mayorList.add(mayor5);
        System.out.println(mayorList);
        ArrayList<City> cityList = new ArrayList<>();
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        cityList.add(city4);
        cityList.add(city5);
        System.out.println(cityList);


    }

}
