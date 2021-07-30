package com.mytests.spring.springData.mongo.test1.data;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/13/2017.
 * Project: mongotest1
 * *******************************
 */
public class Summary {
    String name;
    int years;

    @Override
    public String toString() {
        return "Summary: " +
                "name='" + name + '\'' +
                ", years=" + years +
                ' ';
    }

    public Summary(String name, int years) {
        this.name = name;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
