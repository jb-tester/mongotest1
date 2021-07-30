package com.mytests.spring.springData.mongo.test1.data;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/14/2017.
 * Project: mongotest1
 * *******************************
 */
@Document(collection = "shops")
public class Shop {

    Store store;
    String name;
    String sells;
    Point location;

    public Shop(String name, String sells, Point location, Store store) {
        this.name = name;
        this.sells = sells;
        this.location = location;
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSells() {
        return sells;
    }

    public void setSells(String sells) {
        this.sells = sells;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Shop: " + name;
    }
}
