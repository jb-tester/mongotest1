package com.mytests.spring.springData.mongo.test1.data;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/14/2017.
 * Project: mongotest1
 * *******************************
 */
@Document("shops.store")
public class Store {
    @Field(name = "location")
    Point location;
    @Field(name = "capacity")
    int size;

    public Store(Point location, int size) {
        this.location = location;
        this.size = size;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
