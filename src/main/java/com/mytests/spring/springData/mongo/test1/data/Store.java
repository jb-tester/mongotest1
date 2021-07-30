package com.mytests.spring.springData.mongo.test1.data;

import org.springframework.data.geo.Point;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/14/2017.
 * Project: mongotest1
 * *******************************
 */
public class Store {
    Point location;
    int capacity;

    public Store(Point location, int capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
