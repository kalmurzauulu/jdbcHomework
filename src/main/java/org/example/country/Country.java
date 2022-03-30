package org.example.country;

public class Country {
    int id;
    String country_name;
    String president;
    int population;
    int capital_id;

    public Country() {
    }

    public Country(int id, String country_name, String president, int population, int capital_id) {
        this.id = id;
        this.country_name = country_name;
        this.president = president;
        this.population = population;
        this.capital_id = capital_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCapital_id() {
        return capital_id;
    }

    public void setCapital_id(int capital_id) {
        this.capital_id = capital_id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country_name='" + country_name + '\'' +
                ", president='" + president + '\'' +
                ", population=" + population +
                ", capital_id=" + capital_id +
                '}';
    }
}