package com.mytests.spring.springData.mongo.test1.data;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/14/2017.
 * Project: mongotest1
 * *******************************
 */
public class Address {
    String country;
    String city;
    String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    int building;

    public Address(String country, String city, String street, int building) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Address: " +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building=" + building +
                ' ';
    }
}
