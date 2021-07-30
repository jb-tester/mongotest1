package com.mytests.spring.springData.mongo.test1.data;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/13/2017.
 * Project: mongotest1
 * *******************************
 */
public class Summary {
    String name;
    int adult;

    @Override
    public String toString() {
        return "Summary: " +
                "name='" + name + '\'' +
                ", adult=" + adult +
                ' ';
    }

    public Summary(String name, int adult) {
        this.name = name;
        this.adult = adult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }
}
