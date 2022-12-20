package org.example.model;

public class City {
    int id;
    String city_name;
    String area;
    int population;
    int mayor_id;

    public City() {
    }

    public City(int id, String city_name, String area, int population, int mayor_id) {
        this.id = id;
        this.city_name = city_name;
        this.area = area;
        this.population = population;
        this.mayor_id = mayor_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getMayor_id() {
        return mayor_id;
    }

    public void setMayor_id(int mayor_id) {
        this.mayor_id = mayor_id;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city_name='" + city_name + '\'' +
                ", area='" + area + '\'' +
                ", population=" + population +
                ", mayor_id=" + mayor_id +
                '}';
    }
}
